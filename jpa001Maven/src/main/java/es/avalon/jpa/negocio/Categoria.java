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
	// EL MAPPED BY VA A LIBRO.java
	@ManyToMany(mappedBy = "categorias")
	private List<Libro> libros=new ArrayList<Libro>();
	
	private void addLibro(Libro l) {
		this.libros.add(l);
	}
	
	private void removeLibro(Libro l) {
		this.libros.remove(l);
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
	
	public List<Libro> getLibros() {
		return libros;
	}
	
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public Categoria(int id) {
		super();
		this.id = id;
	}
	
	public Categoria(int id, String nombre) {
		super();
		this.nombre = nombre;
		this.id = id;
	}
	
	public Categoria() {}
	
	
}
