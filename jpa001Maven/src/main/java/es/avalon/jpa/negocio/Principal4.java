package es.avalon.jpa.negocio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal4 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("UnidadLibros");
		EntityManager em = emf.createEntityManager();
		
		Libro l2=em.find(Libro.class, "Book");
		
		System.out.println(l2.getTitulo());
		System.out.println(l2.getPaginas());
		System.out.println(l2.getAutor());
		
		l2.setPaginas(800);
		
		em.getTransaction().begin();
		em.merge(l2);
		em.getTransaction().commit();
		
	}

}
