package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MUSICA")
public class Musica implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TRILHA")
	private int trilha;
	@Column(name = "NOME", length = 50)
	private String nome;
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="IDALBUM") 
	private Album album;
	
	public Musica() {
		super();
	}

	public Musica(int trilha, String nome, Album album) {
		super();
		this.trilha = trilha;
		this.nome = nome;
		this.album = album;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTrilha() {
		return trilha;
	}

	public void setTrilha(int trilha) {
		this.trilha = trilha;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	@Override
	public String toString() {
		return "Musica [trilha=" + trilha + ", nome=" + nome + "]";
	}

}
