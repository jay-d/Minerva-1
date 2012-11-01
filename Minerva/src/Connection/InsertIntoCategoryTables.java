package Connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import tables.MainCategory;
import tables.SubCategory;

public class InsertIntoCategoryTables {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(MainCategory.class);
		config.addAnnotatedClass(SubCategory.class);
		config.configure("hibernate.cfg.xml");
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		
		//	WEB DEVELOPMENT
		MainCategory webDevelopment = new MainCategory();
		webDevelopment.setName("Web Development");
		
		SubCategory html = new SubCategory();
		html.setMainCategory(webDevelopment);
		html.setName("HTML");
		SubCategory css = new SubCategory();
		css.setMainCategory(webDevelopment);
		css.setName("Cascading Style Sheets");
		SubCategory javascript = new SubCategory();
		javascript.setMainCategory(webDevelopment);
		javascript.setName("JavaScript");
		SubCategory ajax = new SubCategory();
		ajax.setMainCategory(webDevelopment);
		ajax.setName("AJAX");
		SubCategory php = new SubCategory();
		php.setMainCategory(webDevelopment);
		php.setName("PHP: Hypertext Preprocessor");
		SubCategory jsp = new SubCategory();
		jsp.setMainCategory(webDevelopment);
		jsp.setName("JavaServer Pages");
		
		session.save(webDevelopment);
		session.save(html);
		session.save(css);
		session.save(javascript);
		session.save(ajax);
		session.save(php);
		session.save(jsp);
		
		
		//	OBJECT-ORIENTED PROGRAMMING
		MainCategory OOProgramming = new MainCategory();
		OOProgramming.setName("Object-Oriented Programming");
		
		SubCategory java = new SubCategory();
		java.setMainCategory(OOProgramming);
		java.setName("Java");
		SubCategory c = new SubCategory();
		c.setMainCategory(OOProgramming);
		c.setName("C");
		SubCategory cpp = new SubCategory();
		cpp.setMainCategory(OOProgramming);
		cpp.setName("C++");
		SubCategory cs = new SubCategory();
		cs.setMainCategory(OOProgramming);
		cs.setName("C#");
		SubCategory python = new SubCategory();
		python.setMainCategory(OOProgramming);
		python.setName("Python");
		SubCategory perl = new SubCategory();
		perl.setMainCategory(OOProgramming);
		perl.setName("Perl");
		
		session.save(OOProgramming);
		session.save(java);
		session.save(c);
		session.save(cpp);
		session.save(cs);
		session.save(python);
		session.save(perl);
		
		
		//	NETWORK
		MainCategory network = new MainCategory();
		network.setName("Network");
		
		SubCategory tcpip = new SubCategory();
		tcpip.setMainCategory(network);
		tcpip.setName("TCP/IP");
		SubCategory mserver = new SubCategory();
		mserver.setMainCategory(network);
		mserver.setName("Microsoft Server");
		SubCategory novell = new SubCategory();
		novell.setMainCategory(network);
		novell.setName("Novell NetWare");
		SubCategory linux = new SubCategory();
		linux.setMainCategory(network);
		linux.setName("Linux");
		SubCategory unix = new SubCategory();
		unix.setMainCategory(network);
		unix.setName("UNIX");
		SubCategory apache = new SubCategory();
		apache.setMainCategory(network);
		apache.setName("Apache HTTP Server");
		SubCategory tomcat = new SubCategory();
		tomcat.setMainCategory(network);
		tomcat.setName("Apache Tomcat");
		SubCategory mysqlServer = new SubCategory();
		mysqlServer.setMainCategory(network);
		mysqlServer.setName("MySQL Server");
		
		session.save(network);
		session.save(tcpip);
		session.save(mserver);
		session.save(novell);
		session.save(linux);
		session.save(unix);
		session.save(apache);
		session.save(tomcat);
		session.save(mysqlServer);
		
		
		//	DATABASE
		MainCategory database = new MainCategory();
		database.setName("Database Management");
		
		SubCategory odbc = new SubCategory();
		odbc.setMainCategory(database);
		odbc.setName("ODBC");
		SubCategory mysql = new SubCategory();
		mysql.setMainCategory(database);
		mysql.setName("MySQL");
		SubCategory oracle = new SubCategory();
		oracle.setMainCategory(database);
		oracle.setName("Oracle");
		SubCategory microsoftSQL = new SubCategory();
		microsoftSQL.setMainCategory(database);
		microsoftSQL.setName("Microsoft SQL Server");
		SubCategory postgreSQL = new SubCategory();
		postgreSQL.setMainCategory(database);
		postgreSQL.setName("PostgreSQL");
		
		session.save(database);
		session.save(odbc);
		session.save(mysql);
		session.save(oracle);
		session.save(microsoftSQL);
		session.save(postgreSQL);
		
		
		session.getTransaction().commit(); // saves here
	}
}
