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
	@Pattern(regexp="^[A-Z a-z]{1,30}$")
	private String titulo;
	@Pattern(regexp="^[A-Z a-z]{1,30}$")
	private String autor;
	private int paginas;
	
	// se refiere a la propiedad libro de la clase capitulo
	
	@OneToMany(mappedBy="libro")
	@JsonIgnore
	private transient List<Capitulo> capitulos= new ArrayList<Capitulo>();
	
	@ManyToMany
	@JoinTable(name="categorialibro",joinColumns=@JoinColumn(name="Libro_titulo"),
	inverseJoinColumns=@JoinColumn(name="Categoria_id"))
	@JsonIgnore
	private List<Categoria> categorias=new ArrayList<Categoria>();
	
	public void addCategoria(Categoria c) {
		
		categorias.add(c);
	}
	
	public void removeCategoria(Categoria c) {
		
		categorias.remove(c);
	}
	
	public List<Capitulo> getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(List<Capitulo> capitulos) {
		this.capitulos = capitulos;
	}

	
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public void addCapitulo(Capitulo c) {
		
		this.capitulos.add(c);
	}
	
	public void  removeCapitulo(Capitulo c) {
		
		this.capitulos.remove(c);
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
	public void setPaginas(int pagina) {
		this.paginas = pagina;
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
	public Libro() {
		super();
	}
	public Libro(String titulo) {
		super();
		this.titulo = titulo;
	}
	public Libro(String titulo, String autor, int pagina) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.paginas = pagina;
	}



	
}
