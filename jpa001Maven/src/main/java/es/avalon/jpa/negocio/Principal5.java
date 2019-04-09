package es.avalon.jpa.negocio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal5 {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadPersistencia");
		EntityManager em = emf.createEntityManager();
		
		Libro libroHiper = em.find(Libro.class, "Hiperespacio");
		
		System.out.println("Capitulos de " + libroHiper.getTitulo()+": ");
		
		for(Capitulo c : libroHiper.getCapitulos()) {
			
			System.out.println(c.getTitulo());
			System.out.println(c.getPaginas());
			
		}
		
	}

}
