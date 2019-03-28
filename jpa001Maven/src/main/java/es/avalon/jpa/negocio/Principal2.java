package es.avalon.jpa.negocio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal2 {

	public static void main(String[] args) {

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("UnidadLibros");
		EntityManager em = emf.createEntityManager();
		
		Capitulo c=em.find(Capitulo.class,"Introduccion");
		c.setPaginas(50);
		
		try {
			em.getTransaction().begin();
			// em.persist(l2);
			em.merge(c);
			// em.remove(c);
			em.getTransaction().commit();
		} catch (Exception e) {

			e.printStackTrace();
		}finally {
			em.close();

		}
	}
}