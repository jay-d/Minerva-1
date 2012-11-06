package Connection;

import java.util.List;

import org.hibernate.Session;

import tables.MainCategory;
import tables.SubCategory;
import tables.User;

public class TestQuery {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<SubCategory> list = CategoryCon.getSubCategories(2);
		
		System.out.println("");
		for (int i=0; i<list.size(); i++) {
				System.out.println(list.get(i).getName());		
		}
		
//		List<MainCategory> list = CategoryCon.getMainCategories();
//		
//		System.out.println("");
//		for (int i=0; i<list.size(); i++) {
//				System.out.println(list.get(i).getName());		
//		}


	}

	public static List<User> getListOfUsersInDatabase() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		List<User> users = session.createQuery("from User").list();
		session.getTransaction().commit();  


		return users;
	}

	public static List<MainCategory> getMainCategories() {


		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		List<MainCategory> result = session.createQuery("from MainCategory").list();

		session.getTransaction().commit();
		

		return result;

	}

}
