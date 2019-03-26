package es.avalon.jpa.negocio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal2 {

	public static void main(String[] args) {

		//Libro libro = new Libro("Java JPA", "juan", 200);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadLibros");
		
		EntityManager em = emf.createEntityManager();
		Libro l2=em.find(Libro.class,"Java JPA");
		l2.setPaginas(500);
		
		
		
		try {
			em.getTransaction().begin();
			em.remove(l2);
			em.getTransaction().commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			em.close();

		}
	}
}
