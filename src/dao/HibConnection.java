package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibConnection {
	public static SessionFactory sf = null;

	static {
		try {
			Configuration cfg = new Configuration().configure("resources/hibernate.cfg.xml");
			sf = cfg.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SessionFactory getConnection() {
		return sf;
	}

}
