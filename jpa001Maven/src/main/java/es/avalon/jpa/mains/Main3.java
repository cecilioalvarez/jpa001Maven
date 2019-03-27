package es.avalon.jpa.mains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.avalon.jpa.negocio.Libro;

public class Main3 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("UnidadLibros");
	
		EntityManager em = emf.createEntityManager();
		
		Libro l2 = em.find(Libro.class, "Java JPA");
		l2.setPaginas(500);
		
		try {
			em.getTransaction().begin();
			em.remove(l2);
			em.getTransaction().commit();
			
		} catch (Exception e) {

			e.printStackTrace();
		}finally {
			em.close();
		}

	}
}
