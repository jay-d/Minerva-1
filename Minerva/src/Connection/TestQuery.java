package Connection;

import java.util.List;

import org.hibernate.Session;

import tables.MainCategory;
import tables.User;

public class TestQuery {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<MainCategory> maincats = CategoryCon.getMainCategories();
		System.out.println("");
		//		System.out.println(users.get(0).getEmail());

		for (int i=0; i<maincats.size(); i++) {
			//	if (maincats.get(i).getEmail().equals("andreasnesheim@gmail.com") && users.get(i).getEmail() != null) {
				//login stuff happens here
				System.out.println(maincats.get(i).getName());
			
		}


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
