package es.avalon.jpa.negocio;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Capitulo {

	@Id
	private String titulo;
	private int paginas;
	private String libroTitulo;
	
	
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
	public String getLibroTitulo() {
		return libroTitulo;
	}
	public void setLibroTitulo(String libroTitulo) {
		this.libroTitulo = libroTitulo;
	}
	public Capitulo(String titulo, int paginas, String libroTitulo) {
		super();
		this.titulo = titulo;
		this.paginas = paginas;
		this.libroTitulo = libroTitulo;
	}
	public Capitulo(String titulo) {
		super();
		this.titulo = titulo;
	}
	public Capitulo() {
		super();
	}
	
	
}
