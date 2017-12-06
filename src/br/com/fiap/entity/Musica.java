package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "MUSICA")
public class Musica implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MusicaPK musicaPk;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY) 
	@MapsId("idAlbum")
	@JoinColumn(name="IDALBUM") 
	private Album album;
	@Column(name = "NOME", length = 50)
	private String nome;
	
	public Musica() {
		super();
	}

	public Musica(MusicaPK musicaPk, Album album, String nome) {
		super();
		this.musicaPk = musicaPk;
		this.album = album;
		this.nome = nome;
	}

	public MusicaPK getMusicaPk() {
		return musicaPk;
	}

	public void setMusicaPk(MusicaPK musicaPk) {
		this.musicaPk = musicaPk;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	@Override
	public String toString() {
		return "Musica [trilha=" + musicaPk.getTrilha() + ", nome=" + nome + "]";
	}

}
