//package es.avalon.jpa.negocio;
//
//import javax.persistence.EntityManager;
//
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//public class Principal2 {
//
//	public static void main(String[] args) {
//	
//			 
//	updateLibro();
//			 deleteLibro();
//			 
//			
//	}
//	
//	private static void updateLibro() {
//		EntityManagerFactory emf =Persistence.createEntityManagerFactory("UnidadLibros");
//		 
//		 EntityManager em = emf.createEntityManager();
//		 
//		 //find: filtra
//		 Libro l2=em.find(Libro.class, "Java JPA");
//		 
//		 l2.setPaginas(500);
//		 
//		 
//		 try {
//		 em.getTransaction().begin();
//		 
//		 //merge: update
//		 em.merge(l2);
//		 
//		 em.getTransaction().commit();
//		 } catch (Exception e) {
//		 
//		 e.printStackTrace();
//		 }finally {
//		 em.close();
//		 
//		 }
//	}
//	
//
//	private static void deleteLibro() {
//		EntityManagerFactory emf =Persistence.createEntityManagerFactory("UnidadLibros");
//		 
//		 EntityManager em = emf.createEntityManager();
//		 
//		 //find: filtra
//		 Libro l2=em.find(Libro.class, "Java JPA");
//		 
//		 
//		 try {
//		 em.getTransaction().begin();
//	
//		 
//		 //remove: delete
//		 em.remove(l2);
//		 
//		 em.getTransaction().commit();
//		 } catch (Exception e) {
//		 
//		 e.printStackTrace();
//		 }finally {
//		 em.close();
//		 
//		 }
//	}
//	
//	private static void updateCapitulo() {
//		EntityManagerFactory emf =Persistence.createEntityManagerFactory("UnidadLibros");
//		 
//		 EntityManager em = emf.createEntityManager();
//		 
//		 //find: filtra
//		 Capitulo capitulo=em.find(Capitulo.class, "Capitulo_1");
//		 
//		 capitulo.setPaginas(500);
//		 
//		 
//		 try {
//		 em.getTransaction().begin();
//		 
//		 //merge: update
//		 em.merge(capitulo);
//		 
//		 em.getTransaction().commit();
//		 } catch (Exception e) {
//		 
//		 e.printStackTrace();
//		 }finally {
//		 em.close();
//		 
//		 }
//	}
//	
//
//	private static void deleteCapitulo() {
//		EntityManagerFactory emf =Persistence.createEntityManagerFactory("UnidadLibros");
//		 
//		 EntityManager em = emf.createEntityManager();
//		 
//		 //find: filtra
//		 Capitulo capitulo=em.find(Capitulo.class, "Capitulo_1");
//		 
//		 
//		 try {
//		 em.getTransaction().begin();
//	
//		 
//		 //remove: delete
//		 em.remove(capitulo);
//		 
//		 em.getTransaction().commit();
//		 } catch (Exception e) {
//		 
//		 e.printStackTrace();
//		 }finally {
//		 em.close();
//		 
//		 }
//	}
//
//}
