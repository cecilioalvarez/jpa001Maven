package es.avalon.jpa.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import es.avalon.utilidades.persistencia.DBhelper;

public class Capitulo {
	private String titulo;
	private int paginas;
	private String Libro_Titulo;
	
	public Capitulo(String titulo, int paginas, String libro_Titulo) {
		super();
		this.titulo = titulo;
		this.paginas = paginas;
		Libro_Titulo = libro_Titulo;
	}
	
	public Capitulo(String titulo, String libro_Titulo) {
		super();
		this.titulo = titulo;
		Libro_Titulo = libro_Titulo;
	}
	
	public Capitulo() {
		super();
	}

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

	public String getLibro_Titulo() {
		return Libro_Titulo;
	}

	public void setLibro_Titulo(String libro_Titulo) {
		Libro_Titulo = libro_Titulo;
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
		Capitulo other = (Capitulo) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

}
