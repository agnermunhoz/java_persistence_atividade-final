package br.com.fiap.entity;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CANTOR")
public class Cantor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "IDCANTOR")
	private int id;
	@Column(name = "NOME", length=50)
	private String nome;
	@Column(name = "ESTILO_MUSICAL", length=30)
	private String estiloMusical;
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="cantor")
	private Set<Album> albuns = new LinkedHashSet<Album>();
	public Cantor() {
		super();
	}
	public Cantor(int id, String nome, String estiloMusical) {
		super();
		this.id = id;
		this.nome = nome;
		this.estiloMusical = estiloMusical;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEstiloMusical() {
		return estiloMusical;
	}
	public void setEstiloMusical(String estiloMusical) {
		this.estiloMusical = estiloMusical;
	}
	public Set<Album> getAlbuns() {
		return albuns;
	}
	public void setAlbuns(Set<Album> albuns) {
		this.albuns = albuns;
	}
	@Override
	public String toString() {
		return "Cantor [id=" + id + ", nome=" + nome + ", estiloMusical=" + estiloMusical + "]";
	}
	
	
}
