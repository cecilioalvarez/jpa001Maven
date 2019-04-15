package es.avalon.jpa.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Categoria {

	@Id
	private int id;
	private String nombre;
	
	//@ManyToMany(mappedBy="categorias")
	
	@ManyToMany(fetch = FetchType.EAGER, 
			mappedBy = "categorias")
	private List<Libro> libros = new ArrayList<Libro>();
	
	
	public Categoria() {
		super();
	}

	public Categoria(int id) {
		super();
		this.id = id;
	}

	public Categoria(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Categoria other = (Categoria) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public void addLibro(Libro l) {
		libros.add(l);
	}
	
	public void removeLibro(Libro l) {
		libros.remove(l);
	}
	
}
