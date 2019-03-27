package es.avalon.jpa.mains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.avalon.jpa.negocio.Libro;

public class Main {

	public static void main(String[] args) {
		Libro yo = new Libro("JavaPA","Pedro",25);
		
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("UnidadLibros");
	
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(yo);
			em.getTransaction().commit();
		} catch (Exception e) {

			e.printStackTrace();
		}finally {
			em.close();
		}

	}
}
