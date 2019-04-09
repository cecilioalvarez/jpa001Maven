package es.avalon.jpa.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

/*@SqlResultSetMapping(name="LibroMapping",
classes = {
 @ConstructorResult(targetClass = Libro.class,
   columns = {@ColumnResult(name="titulo"), @ColumnResult(name="autor")}
 )}
)*/

@Entity
@Component
public class Libro {

	@Id
	private String titulo;
	private String autor;
	private int paginas;
	
	@OneToMany(mappedBy="libro")
	private transient List<Capitulo> capitulos = new ArrayList<Capitulo>();

	public Libro() {
		super();
	}

	public Libro(String titulo) {
		super();
		this.titulo = titulo;
	}

	public Libro(String titulo, String autor) {
		super();
		this.titulo = titulo;
		this.autor = autor;
	}
	
	public Libro(String titulo, String autor, int paginas) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		paginas = this.getPaginas();
	}
	
	public Libro(String titulo, List<Capitulo> capitulos, String autor, int paginas) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.capitulos = capitulos;
		paginas = this.getPaginas();
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

	public void setPaginas() {
		this.paginas = this.getPaginas();
	}

	public int getPaginas() {
		
		this.paginas = 0;
		
		for(Capitulo c : this.capitulos) {
			
			this.paginas += c.getPaginas();
		}
		
		return paginas;
	}
	
	public List<Capitulo> getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(List<Capitulo> capitulos) {
		this.capitulos = capitulos;
	}

	public void addCapitulo(Capitulo c) {
		
		this.capitulos.add(c);
	}
	
	public void removeCapitulo(Capitulo c) {
		
		this.capitulos.remove(c);
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
	
	@PostLoad
	private void postLoad() {
		
	    this.paginas = this.getPaginas();
	}

	
}
