package br.com.fiap.entity;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "ALBUM")
public class Album implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "IDALBUM")
	private int id;
	@Column(name = "NOME", length = 50)
	private String nome;
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="IDCANTOR") 
	private Cantor cantor;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="album") 
	private Set<Musica> musicas = new LinkedHashSet<Musica>();
	
	public Album() {
		super();
	}
	public Album(int id, String nome, Cantor cantor) {
		super();
		this.id = id;
		this.nome = nome;
		this.cantor = cantor;
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
	public Cantor getCantor() {
		return cantor;
	}
	public void setCantor(Cantor cantor) {
		this.cantor = cantor;
	}
	public Set<Musica> getMusicas() {
		return musicas;
	}
	public void setMusicas(Set<Musica> musicas) {
		this.musicas = musicas;
	}
	@Override
	public String toString() {
		return "Album [id=" + id + ", nome=" + nome + "]";
	}

}
