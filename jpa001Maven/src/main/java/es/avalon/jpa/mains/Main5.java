package es.avalon.jpa.mains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.jpa.negocio.Libro;

public class Main5 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("UnidadLibros");
	
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			Libro l2 = em.find(Libro.class, "holas");
			em.getTransaction().commit();
			
			for (Capitulo c : l2.getCapitulos()) {
				System.out.println(c.getNombre()+" "+c.getPaginas()+" "+c.getLibro().getTitulo());
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}finally {
			em.close();
		}
		
	}
	
}
