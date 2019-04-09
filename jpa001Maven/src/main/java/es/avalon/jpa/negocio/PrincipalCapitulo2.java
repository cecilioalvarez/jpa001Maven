package es.avalon.jpa.negocio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PrincipalCapitulo2 {
	
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadPersistencia");
		EntityManager em = emf.createEntityManager();
		Capitulo capitulo = em.find(Capitulo.class , "Titulo01");
		capitulo.setPaginas(500);
		
		try {
			
			em.getTransaction().begin();
			em.remove(capitulo);
			em.getTransaction().commit();
			
		} catch (Exception e) {

			e.printStackTrace();
			
		} finally {
			
			em.close();
		}
		
	}

}
