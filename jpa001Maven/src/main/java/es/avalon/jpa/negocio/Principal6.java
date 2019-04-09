package es.avalon.jpa.negocio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Principal6 {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadPersistencia");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Capitulo> query = em.createQuery("Select c from Capitulo c", Capitulo.class);
		
		for(Capitulo c : query.getResultList()) {
			
			System.out.println(c.getTitulo());
		};
	}

}
