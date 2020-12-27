package org.casadocodigo.loja.daos;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.casadocodigo.loja.entities.Livro;

@Stateful
public class LivroDao {
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
    private EntityManager manager;
    
    public void salvar(Livro livro) {
    	manager.persist(livro);
    }

	public List<Livro> listar() {
		String jpql = "select distinct(l) from Livro l join fetch l.autores" ;
		return manager.createQuery(jpql,Livro.class).getResultList();
	}

	public List<Livro> ultimosLancamentos() {
		String jpql ="Select l from Livro l order by l.dataPublicacao desc";
		return manager.createQuery(jpql, Livro.class)
				.setMaxResults(5)
				.getResultList();
				
	}
	public List<Livro> demaisLivros() {
		String jpql ="Select l from Livro l order by l.dataPublicacao desc";
		return manager.createQuery(jpql, Livro.class)
				.setFirstResult(5)
				.getResultList();
				
	}

	public Livro buscarPorid(Integer id) {
		return manager.find(Livro.class, id);
//		String jpql ="Select l from Livro l join fetch l.autores where l.id = :idLivro";
//		return manager.createQuery(jpql, Livro.class)
//				.setParameter("idLivro", id)
//				.getSingleResult();

	}
}