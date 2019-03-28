package es.avalon.jpa.negocio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Principal6 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("UnidadLibros");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Capitulo> consulta=em.createQuery("Select c from Capitulo c", Capitulo.class);
		List<Capitulo> lista=consulta.getResultList();
		
		for(Capitulo c:lista) {
			
			System.out.println(c.getTitulo());
		
		}
		
	}

}
