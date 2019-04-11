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

@Entity
public class Libro {

	@Id
	@NotEmpty //valida que el libro es correcto antes de insertar
	@Pattern(regexp="^[A-Za-z]{5,10}$")
	private String titulo;
	private String autor;
	private int pagina;
	@OneToMany(mappedBy="libro") 	// se refiere a la propiedad de la clase capitulo
	private List<Capitulo> capitulos = new ArrayList<Capitulo>(); //transient para que vaya en jquery JSON
	
	private List<Categoria> categorias = new ArrayList<Categoria>();
	
	@ManyToMany
	@JoinTable(
			name="CategoriaLibro",
			joinColumns = @JoinColumn(name ="Libro_titulo"),
			inverseJoinColumns = @JoinColumn(name = "Categoria_id"))
	public void addCategoria(Categoria cat) {
		categorias.add(cat);
	}
	public void removeCategoria(Categoria cat) {
		categorias.remove(cat);
	}
	
	public void addCapitulo(Capitulo c) {
		this.capitulos.add(c);
		}
	
	public List<Capitulo> getCapitulos() {
		return capitulos;
	}


	public void setCapitulos(List<Capitulo> capitulos) {
		this.capitulos = capitulos;
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

	public int getPagina() {
		return pagina;
	}

	public void setPagina(int paginas) {
		this.pagina = paginas;
	}

	public Libro(String titulo, String autor, int paginas) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.pagina = paginas;
	}

	public Libro() {
		super();
	}

	public Libro(String titulo) {
		super();
		this.titulo = titulo;
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

}
