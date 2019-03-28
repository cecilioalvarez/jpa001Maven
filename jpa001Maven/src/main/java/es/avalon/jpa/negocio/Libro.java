package es.avalon.jpa.negocio;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Libro {
	
	@Id
	private String titulo;
	private String autor;
	private int paginas;
	
	// Se refiere a la propiedad libro de la clase capitulo
	@OneToMany(mappedBy="libro")
	private List<Capitulo> capitulos=new ArrayList<Capitulo>();

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
		
	public Libro(String titulo, String autor, int paginas) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.paginas = paginas;
	}
	public Libro(String titulo) {
		super();
		this.titulo = titulo;
	}
	public Libro() {
		super();
	}

	public void addCapitulo(Capitulo c) {
		capitulos.add(c);
	}

	public void removeCapitulo(Capitulo c) {
		capitulos.remove(c);
	}
	public List<Capitulo> getCapitulos() {
		return capitulos;
	}
	public void setCapitulos(List<Capitulo> capitulos) {
		this.capitulos = capitulos;
	}
}
