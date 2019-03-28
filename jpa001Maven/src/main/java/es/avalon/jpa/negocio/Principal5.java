package es.avalon.jpa.negocio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal5 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("UnidadLibros");
		EntityManager em = emf.createEntityManager();
		
		Libro libroJava=em.find(Libro.class, "Java");
		
		for(Capitulo c:libroJava.getCapitulos()) {
			
			System.out.println(c.getTitulo());
			System.out.println(c.getPaginas());
		}
		
	}

}
