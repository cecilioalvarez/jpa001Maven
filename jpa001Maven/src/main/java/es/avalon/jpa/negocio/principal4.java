//package es.avalon.jpa.negocio;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//public class principal4 {
//
//	public static void main(String[] args) {
//		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadLibros");
//
//		EntityManager em = emf.createEntityManager();
//		
//		Libro l = em.find(Libro.class, "java");
//		System.out.println(l.getTitulo());
//		System.out.println(l.getAutor());
//		System.out.println(l.getPaginas());
//		
//		l.setPaginas(800);
//		em.getTransaction().begin();
//		em.merge(l);
//		em.getTransaction().commit();
//
//	}
//
//}
