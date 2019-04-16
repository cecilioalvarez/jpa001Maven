package es.avalon.jpa.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Libros")
public class Libro {
	
	@Id
	@NotBlank
	@Pattern(regexp = "[A-Za-z]{2,10}$")
	private String titulo;
	private String autor;
	private int paginas;
	
	// Se refiere a la propieda libro de la clase capitulo
	@OneToMany(mappedBy="libro")
	@JsonIgnore
	private List<Capitulo> capitulos;
	
	@ManyToMany
	@JoinTable(name = "CategoriaLibro",
			joinColumns = @JoinColumn(name="libro_titulo"),
			inverseJoinColumns = @JoinColumn(name="categoria_id"))
	@JsonIgnore
	private List<Categoria> categorias = new ArrayList<Categoria>();
	
	public List<Capitulo> getCapitulos() {
		return capitulos;
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
	
	public Libro() {}
	
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
	
	public void addCategoria(Categoria c) {
		this.categorias.add(c);
	}
	
	public void removeCategoria(Categoria c) {
		this.categorias.remove(c);
	}
	
}
