//package Connection;
//
//import java.sql.Connection;
//import tables.*;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.List;
//import org.hibernate.Session;
//
//public class MainCategoryCon {
//	
//	private static String location1 = "jdbc:mysql://localhost/databaseeksempler_2011";
//	private static String location2 = "root";
//	private static String location3 = "KTBenb12";
//
//public List<MainCategory> getMainCategories() {
//	
//	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//	Session session = sessionFactory.openSession();
//	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//    session.beginTransaction();
//
//    List<MainCategory> result = session.createQuery("from main_category").list();
//
//    session.getTransaction().commit();
//    session.close();
//
//    return result;
//		
//	}
//}
//hei
//aojda
