package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;

@Embeddable
public class MusicaPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="TRILHA")
	private int trilha;
	@JoinColumn(name="IDALBUM")
	private int idAlbum;
	
	public MusicaPK() {
		super();
	}

	public MusicaPK(int trilha) {
		super();
		this.trilha = trilha;
	}
	
	public MusicaPK(int trilha, int idAlbum) {
		super();
		this.trilha = trilha;
		this.idAlbum = idAlbum;
	}

	public int getTrilha() {
		return trilha;
	}

	public void setTrilha(int trilha) {
		this.trilha = trilha;
	}

	public int getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(int idAlbum) {
		this.idAlbum = idAlbum;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MusicaPK) {
			MusicaPK pk = (MusicaPK) obj;
			return ((this.getTrilha() == pk.getTrilha()) && 
					(this.getIdAlbum() == pk.getIdAlbum()));
		}
		return false;
	}

	@Override
	public int hashCode() {
		return super.hashCode() + this.getTrilha() + this.getIdAlbum();
	}
	
	
}
