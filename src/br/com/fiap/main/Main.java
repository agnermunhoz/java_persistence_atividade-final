package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import java.util.List;

import br.com.fiap.entity.Album;
import br.com.fiap.entity.Cantor;
import br.com.fiap.entity.Musica;
import br.com.fiap.helper.Helper;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("atividade-final");
		EntityManager em = emf.createEntityManager();
		Helper dao = new Helper(em);
		
		Cantor cantor = new Cantor();
		cantor.setNome(inputDialog("Nome do Cantor"));
		cantor.setEstiloMusical(inputDialog("Estilo musical do Cantor"));
		
		Album album = new Album();
		album.setNome(inputDialog("Nome do Álbum"));
		album.setCantor(cantor);
		
		int i = 1;
		do{
			album.getMusicas().add(new Musica(i, inputDialog("Nome da "+i+"ª Música do Álbum"), album));
			i++;
		}while(JOptionPane.showConfirmDialog(null,"Continuar cadastrando músicas?","Cadastro de música",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
		
		try {
			dao.salvar(cantor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Cantor> cantores = dao.listarCantor();
		
		//cantores.forEach(c -> System.out.println(c));
		for(Cantor c: cantores){
			System.out.println(c);
			for(Album a: c.getAlbuns()){
				System.out.println(a);
				a.getMusicas().forEach(m -> System.out.println(m));
			}
			System.out.println();
		}
	}

	public static String inputDialog(String mensagem) {
		String resp = null;
		do {
			resp = JOptionPane.showInputDialog(mensagem);
		} while ((resp == null) || (resp.isEmpty()));
		return resp;
	}

	
}
