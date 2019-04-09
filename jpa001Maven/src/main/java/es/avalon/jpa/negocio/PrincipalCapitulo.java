package es.avalon.jpa.negocio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PrincipalCapitulo {

	public static void main(String[] args) {
		
		Capitulo capitulo = new Capitulo("Titulo01", 200);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadPersistencia");
		EntityManager em = emf.createEntityManager();
		
		try {
			
			em.getTransaction().begin();
			em.persist(capitulo);
			em.getTransaction().commit();
			
		} catch (Exception e) {

			e.printStackTrace();
			
		} finally {
			
			em.close();
		}

	}

}
