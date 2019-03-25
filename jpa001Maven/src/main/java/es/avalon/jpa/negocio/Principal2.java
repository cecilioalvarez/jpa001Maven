package es.avalon.jpa.negocio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal2 {
	public static void main(String[] arg) {

		//Libro yo = new Libro("Java JPA", "Pedro", 250);
		
		//Conecta con la base de datos y nos posiciona en un inico
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadLibros");
		
		//Gestiona todas las consultas a la base de datos
		EntityManager em = emf.createEntityManager();
		Libro l2 = em.find(Libro.class, "Java JPA");
		l2.setPaginas(500);
		
		
		try {
			em.getTransaction().begin();
			em.merge(l2);
			em.getTransaction().commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			em.close();
		}
	}
}
