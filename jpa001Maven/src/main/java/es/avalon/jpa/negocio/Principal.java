package es.avalon.jpa.negocio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {

	public static void main(String[] args) {

		Libro libro = new Libro("Java JPA", "juan", 200);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadLibros");
		
		EntityManager em = emf.createEntityManager();
		
		
		
		try {
			em.getTransaction().begin();
			em.persist(libro);
			em.getTransaction().commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			em.close();

		}
	}
}
