package Connection;

import java.sql.Connection;
import tables.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.hibernate.Session;

public class CategoryCon {
	

public List<MainCategory> getMainCategories() {
	
	
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();

    List<MainCategory> result = session.createQuery("from MainCategory").list();

    session.getTransaction().commit();
    session.close();

    return result;
		
	}

public List<SubCategory> getSubCategories(int mainCategory) {
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();

    List<SubCategory> result = session.createQuery("from SubCategory where").list();

    session.getTransaction().commit();
    session.close();

    return result;
}
}

