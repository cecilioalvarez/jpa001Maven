package es.avalon.jpa.negocio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PrincipalLibro2 {
	
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadPersistencia");
		EntityManager em = emf.createEntityManager();
		Libro libro = em.find(Libro.class , "Java JPA");
		
		try {
			
			em.getTransaction().begin();
			em.remove(libro);
			em.getTransaction().commit();
			
		} catch (Exception e) {

			e.printStackTrace();
			
		} finally {
			
			em.close();
		}
		
	}

}
