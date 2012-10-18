//package Connection;
//
//import java.sql.*;
//
//import tables.*;
//
//public class ProfileCon {
//	private static String location1 = "jdbc:mysql://localhost/databaseeksempler_2011";
//	private static String location2 = "root";
//	private static String location3 = "KTBenb12";
//
//	// sjekker om epost er brukt tidligere en annen gang
//	public static void createUser(String email, int thirdPartId) {
//
//
//		SessionFactory sessionFactory = config.buildSessionFactory();
//		Session session = sessionFactory.getCurrentSession();
//		//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//
//		User user = new User();
//		user.setEmail(email);
//		user.setThirdPartId(thirdPartId);
//
//		session.save(user);
//		session.getTransaction().commit();
//
//	}
//
//	public Profile getProfile(int id) {
//
//
//		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//		Session session = sessionFactory.openSession();
//		//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//
//
//		Profile profile = (Profile) session.get(Profile.class, id);
//		session.getTransaction().commit();  // vet ikke om vi trenger den her
//		session.close();
//
//		return profile;
//
//	}
//
//	public boolean changeProfile(String id, String newFirstName, String newLastName, String newLocation, String newInformation) {
//
//		Profile profile = null;
//
//		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//		Session session = sessionFactory.openSession();
//		//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//
//		profile = (Profile) session.get(Profile.class, id);
//
//		if (newFirstName  != "" && newFirstName != null ) {
//			profile.setFirstName(newFirstName);
//		}
//		if (newLastName  != "" && newLastName != null ) {
//			profile.setLastName(newLastName);
//		}
//		if (newLocation  != "" && newLocation != null ) {
//			profile.setLocation(newLocation);
//		}
//		if (newInformation  != "" && newInformation != null ) {
//			profile.setInformation(newInformation);
//		}
//		//		if (newImage  != "" && newImage != null ) {
//		//			profile.setImage(newImage);
//		//		}
//
//		session.update(profile);
//
//		session.getTransaction().commit();  // vet ikke om vi trenger den her
//		session.close();
//
//		session.getTransaction().commit();
//		session.close();
//
//		return true;
//	}
//}
//
