package es.avalon.jpa.negocio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {
	public static void main(String[] arg) {

		Libro yo = new Libro("Java JPA", "Pedro", 250);
		
		//Conecta con la base de datos y nos posiciona en un inico
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadLibros");
		
		//Gestiona todas las consultas a la base de datos
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(yo); //Instancia un objeto (introduce un libro en Database)
			em.getTransaction().commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			em.close();
		}
	}
}
