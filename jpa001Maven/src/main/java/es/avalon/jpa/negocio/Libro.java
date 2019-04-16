package es.avalon.jpa.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Libro {
	
	@Id
	@NotEmpty
	@Pattern(regexp="^[A-Za-z]{3,10}$")
	private String titulo;
	private String autor;
	private int paginas;
	@JsonIgnore
	@OneToMany(mappedBy="libro")  //relacion entre Libro Capitulo
	//se refiere a la propiedad libro de la clase Capitulo
	private List<Capitulo> capitulos = new ArrayList<Capitulo>();  // transient para que tirara JSON no fuera circulares.
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			  name = "categoriaLibro", 
			  joinColumns = @JoinColumn(name = "Libro_titulo"), 
			  inverseJoinColumns = @JoinColumn(name = "Categoria_id"))
	private List<Categoria> categorias = new ArrayList<Categoria>();
	
	public void addCategoria(Categoria c) {
		categorias.add(c);
	}
	
	public void removeCategoria(Categoria c) {
		categorias.remove(c);
	}

	public void addCapitulo(Capitulo c) {
		this.capitulos.add(c);
	}
	
	public void removeCapitulo(Capitulo c) {
		this.capitulos.remove(c);
	}
	
	
	public List<Capitulo> getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(List<Capitulo> capitulos) {
		this.capitulos = capitulos;
	}

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
	
	public Libro() {
		super();
	}
	public Libro(String titulo) {
		super();
		this.titulo = titulo;
	}
	public Libro(String titulo, String autor, int paginas) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.paginas = paginas;
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
		Libro other = (Libro) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	

	
}
