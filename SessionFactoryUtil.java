package br.co.bd2hibernet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {

	static SessionFactory registry = null;

	public Session openSession() {
		return registry.openSession();
	}

	public void closeSession() {
		registry.close();
	}

	private static Configuration config() {
		Configuration config = new Configuration().configure();
		return config;
	}

	public static SessionFactory criarSessionFactory() throws Exception {
		SessionFactory session = null;

		if (registry == null) {
			try {
				registry = config().buildSessionFactory();

			} catch (Exception e) {
				e.printStackTrace();
				RegistryFactoryDestroy();
			}

		}
		return session;
	}

	private static void RegistryFactoryDestroy() throws Exception {
		final StandardServiceRegistry registry1 = new StandardServiceRegistryBuilder().configure().build();
		try {
			registry = new MetadataSources(registry1).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			// The registry would be destroyed by the SessionFactory, but we had trouble
			// building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy(registry1);
		}
	}

	public static void destroySessionFactoty() throws Exception {
		RegistryFactoryDestroy();
	}

}
