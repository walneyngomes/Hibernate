package br.co.bd2hibernet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppGeraTabelas {
	public static void main(String[] args) {
		SessionFactoryUtil factory =new SessionFactoryUtil();
		Session session = factory.openSession();
		
		try {
			// Instanciando um cliente
			Pessoa pessoa1 = new Pessoa("Adrino Santos", "90909");
			// Pessistencia
			session.getTransaction().begin();
			session.persist(pessoa1);
			session.getTransaction().commit();
			System.out.print("Cadastro finalizado");


		} finally {
			// Finaliza sessao
			session.close();
			factory.close();
		}


		}
	}


