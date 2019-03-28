package es.avalon.jpa.negocio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal3 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("UnidadLibros");
		EntityManager em = emf.createEntityManager();
	}

}
