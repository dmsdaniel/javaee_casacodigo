package org.casadocodigo.loja.beans;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.casadocodigo.loja.daos.LivroDao;
import org.casadocodigo.loja.entities.Livro;

@Model
public class LivroDetalheBean {
	@Inject
	private LivroDao dao;
	
	private Livro livro;
	
	private Integer id;
	
	public void carregaDetalhe() {
		this.livro = dao.buscarPorid(id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	
	
	
}
