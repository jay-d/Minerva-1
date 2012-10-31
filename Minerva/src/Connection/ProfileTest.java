package Connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import tables.*;


public class ProfileTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Profile.class);
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		Profile daniel = new Profile();
		daniel.setFirstName("Daniel");
		daniel.setLastName("Jajevski");
		daniel.setInformation("blabla-informasjon!!!!!");
		daniel.setLocation("Stavanger");
		
		session.save(daniel); // doesn't save here
		
		session.getTransaction().commit(); // saves here
	}
}
