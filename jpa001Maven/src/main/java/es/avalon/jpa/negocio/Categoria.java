package es.avalon.jpa.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Categoria {
	@Id
	private int id;
	private String nombre;
	@ManyToMany(mappedBy="categorias")
	private List<Libro> libros=new ArrayList<Libro>();
	
	public void addLibro(Libro libro) {
		libros.add(libro);
	}
	public void removeLibro(Libro libro) {
		libros.remove(libro);
	}

	public Categoria(int id) {
		super();
		this.id = id;
	}

	public Categoria() {
		super();
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

}
