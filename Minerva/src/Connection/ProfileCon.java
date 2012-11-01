package Connection;

import java.sql.*;

import org.hibernate.Session;
import tables.*;

public class ProfileCon {
	

	// lager en user og en profli til brukeren
	// går forløpig utifra at hver profil bare har en bruker
	public static void createUser(String email, int thirdPartId) {

		Profile profile = createProfile("from user2", "LastName", "Location", "Information");

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		User user = new User();
		user.setEmail(email);
		user.setThirdPartId(thirdPartId);
		user.setProfile(profile);

		session.save(user);
		session.getTransaction().commit();

	}

	public Profile getProfile(int id) {


		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();


		Profile profile = (Profile) session.get(Profile.class, id);
		session.getTransaction().commit();  
		session.close();

		return profile;

	}

	public boolean changeProfile(String id, String newFirstName, String newLastName, String newLocation, String newInformation) {

		Profile profile = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		profile = (Profile) session.get(Profile.class, id);

		if (newFirstName  != "" && newFirstName != null ) {
			profile.setFirstName(newFirstName);
		}
		if (newLastName  != "" && newLastName != null ) {
			profile.setLastName(newLastName);
		}
		if (newLocation  != "" && newLocation != null ) {
			profile.setLocation(newLocation);
		}
		if (newInformation  != "" && newInformation != null ) {
			profile.setInformation(newInformation);
		}
		//		if (newImage  != "" && newImage != null ) {
		//			profile.setImage(newImage);
		//		}

		session.update(profile);

		session.getTransaction().commit(); 
		session.close();

	
		return true;
	}
	
	public static Profile createProfile(String FirstName, String LastName, String Location, String Information) {


		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Profile profile = new Profile();

		
			profile.setFirstName(FirstName);
			profile.setLastName(LastName);
			profile.setLocation(Location);
			profile.setInformation(Information);

		session.save(profile);

		session.getTransaction().commit();  

		return profile;
	}
} 

