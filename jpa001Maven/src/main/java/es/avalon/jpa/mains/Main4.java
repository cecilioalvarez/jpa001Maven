package es.avalon.jpa.mains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.jpa.negocio.Libro;

public class Main4 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("UnidadLibros");
	
		EntityManager em = emf.createEntityManager();
		
		Capitulo c = new Capitulo("helopo", 1230, new Libro("holas"));
		
		try {
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
			
		} catch (Exception e) {

			e.printStackTrace();
		}finally {
			em.close();
		}

	}
}
