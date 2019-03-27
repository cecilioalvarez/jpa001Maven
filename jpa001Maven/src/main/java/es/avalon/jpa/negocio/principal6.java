//package es.avalon.jpa.negocio;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.TypedQuery;
//
//public class principal6 {
//
//	public static void main(String[] args) {
//	
//
//
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadLibros");
//
//		EntityManager em = emf.createEntityManager();
//		
//		//JPA Query Languaje: consulta tipada de un tipo de clase
//		TypedQuery<Capitulo> consulta = em.createQuery("select c from Capitulo c", Capitulo.class);
//		List<Capitulo> lista = consulta.getResultList();
//		
//		
//		for(Capitulo c: lista) {
//			
//			System.out.println(c.getTitulo());
//			
//		}
//	}
//
//}
