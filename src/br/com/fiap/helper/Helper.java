package br.com.fiap.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.entity.Cantor;

public class Helper {
	private EntityManager em;

	public Helper(EntityManager em){
		this.em = em;
	}

	public void salvar(Cantor cantor) throws Exception { 
		try {
			em.getTransaction().begin(); 
			em.persist(cantor); 
			em.getTransaction().commit();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Cantor> listarCantor(){
		Query query = em.createQuery("select c from Cantor c"); 
		return query.getResultList();
	}

	public Cantor buscarCantor(int id){
		Query query = em.createQuery("select c from Cantor f where id = :id");
		query.setParameter("id", id); 
		Cantor c = (Cantor) query.getSingleResult(); 
		return c;
	}

}