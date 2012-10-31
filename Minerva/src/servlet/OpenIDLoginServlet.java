package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.openid4java.association.AssociationException;
import org.openid4java.consumer.ConsumerException;
import org.openid4java.consumer.ConsumerManager;
import org.openid4java.consumer.VerificationResult;
import org.openid4java.discovery.DiscoveryException;
import org.openid4java.discovery.DiscoveryInformation;
import org.openid4java.discovery.Identifier;
import org.openid4java.message.AuthRequest;
import org.openid4java.message.AuthSuccess;
import org.openid4java.message.MessageException;
import org.openid4java.message.ParameterList;
import org.openid4java.message.ax.AxMessage;
import org.openid4java.message.ax.FetchRequest;
import org.openid4java.message.ax.FetchResponse;

/**
 * Servlet implementation class AttexConsumer
 */
public class OpenIDLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ConsumerManager manager = null;
	private String receivingUrl = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest httpRequest,
			HttpServletResponse httpResponse) throws ServletException,
			IOException {

		// Check if the POST is from the OP
		if (httpRequest.getParameter("is_id_res") != null && httpRequest.getParameter("is_id_res").equals("true")) {

			try {
				// Getting all parameters in request including AuthResponse
				ParameterList authResponseParams = new ParameterList(
						httpRequest.getParameterMap());

				// Previously discovered information
				DiscoveryInformation discovered = (DiscoveryInformation) httpRequest.getSession().getAttribute("openid-disc");

				// Verify return-to, discoveries, nonce & signature
				// Signature will be verified using the shared secrete
				VerificationResult verificationResult = manager.verify(receivingUrl.toString(), authResponseParams, discovered);

				Identifier verified = verificationResult.getVerifiedId();

				// Identifier will be NULL if verification failed
				if (verified != null) {
					AuthSuccess authSuccess = (AuthSuccess) verificationResult.getAuthResponse();

					String verifiedID = authSuccess.getIdentity();
					String email, firstname, lastname, country, language;

					// Trying to get email attribute using AX extension
					if (authSuccess.hasExtension(AxMessage.OPENID_NS_AX)) {
						FetchResponse fetchResp = (FetchResponse) authSuccess.getExtension(AxMessage.OPENID_NS_AX);

						email = fetchResp.getAttributeValue("email");
						firstname = fetchResp.getAttributeValue("firstname");
						lastname = fetchResp.getAttributeValue("lastname");
						country = fetchResp.getAttributeValue("country");
						language = fetchResp.getAttributeValue("language");

						// Sending results to index.jsp
						httpResponse.sendRedirect("out.jsp?openid=" + verifiedID
								+ "&email= " + email + "&firstname="
								+ firstname + "&lastname=" + lastname
								+ "&country=" + country + "&language="
								+ language);

					} else { // OP has not sent any attribute
						httpResponse.sendRedirect("out.jsp?email=Error");
					}

				}
			} catch (MessageException e) {
				e.printStackTrace();
			} catch (DiscoveryException e) {
				e.printStackTrace();
			} catch (AssociationException e) {
				e.printStackTrace();
			}

		} else { // not coming from the OP

			String claimed_id = httpRequest.getParameter("userid");

			if (claimed_id == null) { // if the user access the servlet directly

				httpResponse.sendRedirect("index.jsp");

			} else { // the index.jsp's form request, must place the authRequest

				try {
					// Smart consumer manager
					manager = new ConsumerManager();

					// Discovery on the user supplied ID
					List discoveries = manager.discover(claimed_id);

					// Associate with the OP and share a secrete
					DiscoveryInformation discovered = manager
							.associate(discoveries);

					// Keeping necessary parameters to verify the AuthResponse
					httpRequest.getSession().setAttribute("openid-disc",
							discovered);

					// To identify OP's HTTP POST from other POSTs
					receivingUrl = httpRequest.getRequestURL().toString()
							+ "?is_id_res=true";

					AuthRequest authReq = manager.authenticate(discovered,
							receivingUrl);

					// Getting emaill attribute using FetchRequest
					FetchRequest fetchRequest = FetchRequest
							.createFetchRequest();

					// addAttribute(attributeName, typeURI, isRequired)
					fetchRequest.addAttribute("email",
							"http://axschema.org/contact/email", true);
					fetchRequest.addAttribute("firstname",
							"http://axschema.org/namePerson/first", true);
					fetchRequest.addAttribute("lastname",
							"http://axschema.org/namePerson/last", true);
					fetchRequest.addAttribute("country",
							"http://axschema.org/contact/country/home", true);
					fetchRequest.addAttribute("language",
							"http://axschema.org/pref/language", true);

					// Adding the AX extension to the AuthRequest message
					authReq.addExtension(fetchRequest);

					// Redirecting the browser to the OP
					httpResponse.sendRedirect(authReq.getDestinationUrl(true));

				} catch (MessageException e) {
					e.printStackTrace();
				} catch (ConsumerException e) {
					e.printStackTrace();
				} catch (DiscoveryException e) {
					e.printStackTrace();
				}

			}
		}

	}

}
