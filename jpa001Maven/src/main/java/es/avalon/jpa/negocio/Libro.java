package es.avalon.jpa.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Libro implements Serializable{
	//se refiere a la propiedad libro de la clase capitulo -->private Libro libro;
	
	@Id
	@NotEmpty(message = "HOLA MUNDO")
	@Pattern(regexp="^[A-Za-z]{5,10}$")
	private String titulo;
	@NotEmpty
	@Pattern(regexp="^[A-Za-z]{5,10}$", message = "Introducir entre 5 y 10 caracteres")
	private String autor;
	@NotNull
	private int paginas;
	
	@JsonIgnore
	@OneToMany(mappedBy="libro")
	private List<Capitulo> capitulos = new ArrayList<Capitulo>(); 
	//private transient List<Capitulo> capitulos = new ArrayList<Capitulo>(); 
		//se utiliza para ajax gson jquery
	
	
	
	//EN QUE CLASE ESTOY EN LA DE LIBROS -->joinColumns = @JoinColumn(name = "libro_titulo") 
	//LA CLASE CONTRARIA ES CATEGORIAS --> inverseJoinColumns = @JoinColumn(name="categoria_id")
	@JsonIgnore
	@ManyToMany(cascade = {
		        CascadeType.PERSIST,
		        CascadeType.MERGE
		    })
	@JoinTable(
			name="CategoriaLibro",
			joinColumns = @JoinColumn(name = "libro_titulo"),
			inverseJoinColumns = @JoinColumn(name="categoria_id"))
	private List<Categoria> categorias = new ArrayList<Categoria>(); 
	
	public List<Capitulo> getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(List<Capitulo> capitulos) {
		this.capitulos = capitulos;
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

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
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

	
	public void addCapitulos(Capitulo c) {
		this.capitulos.add(c);
	}
	
	public void removeCapitulos(Capitulo c) {
		this.capitulos.add(c);
	}
	
	public void addCategoria(Categoria c) {
		this.categorias.add(c);
	}
	
	public void removeCategoria(Categoria c) {
		this.categorias.add(c);
	}
}
