package es.avalon.jpa.negocio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Capitulo {
	
	@Id
	private String titulo;
	private int paginas;
	//Defino una propiedad que es un objeto complejo utilizando compsocion
	//Utilizando composicion
	@ManyToOne
	@JoinColumn(name="libro_titulo")
	private Libro libro;
	
	public Capitulo(String titulo, int paginas, Libro l) {
		this.titulo = titulo;
		this.paginas = paginas;
		this.libro=l;
	}
	
	
	public Capitulo(String titulo, int paginas) {
		this.titulo = titulo;
		this.paginas = paginas;
	}


	public Capitulo(String titulo) {
		this.titulo=titulo;
	}

	public Capitulo() {
	}
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
	public Libro getLibro() {
		return libro;
	}
	
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Capitulo other = (Capitulo) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	
}
