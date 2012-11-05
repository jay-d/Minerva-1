package Connection;

import java.util.List;

import org.hibernate.Session;

import tables.User;

public class TestQuery {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<User> users = ProfileCon.getListOfUsersInDatabase();
		System.out.println("");
//		System.out.println(users.get(0).getEmail());
		
		for (int i=0; i<users.size(); i++) {
			if (users.get(i).getEmail().equals("andreasnesheim@gmail.com") && users.get(i).getEmail() != null) {
				//login stuff happens here
				System.out.println(users.get(i).getEmail());
			}
		}
		

	}
	
	public static List<User> getListOfUsersInDatabase() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		List<User> users = session.createQuery("from User").list();
		session.getTransaction().commit();  


		return users;
	}

}
