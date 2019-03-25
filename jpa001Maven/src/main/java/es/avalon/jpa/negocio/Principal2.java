package es.avalon.jpa.negocio;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal2 {

	public static void main(String[] args) {
	
			 
	
			 EntityManagerFactory emf =Persistence.createEntityManagerFactory("UnidadLibros");
			 
			 EntityManager em = emf.createEntityManager();
			 
			 //find: filtra
			 Libro l2=em.find(Libro.class, "Java JPA");
			 
			 l2.setPaginas(500);
			 
			 
			 try {
			 em.getTransaction().begin();
			 //merge: update
			// em.merge(l2);
			 
			 //remove: delete
			 em.remove(l2);
			 
			 em.getTransaction().commit();
			 } catch (Exception e) {
			 
			 e.printStackTrace();
			 }finally {
			 em.close();
			 
			 }
			 
			
	}

}
