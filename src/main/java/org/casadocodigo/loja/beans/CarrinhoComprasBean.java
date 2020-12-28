package org.casadocodigo.loja.beans;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.casadocodigo.loja.daos.LivroDao;
import org.casadocodigo.loja.entities.Livro;
import org.casadocodigo.loja.models.CarrinhoCompras;
import org.casadocodigo.loja.models.CarrinhoItem;


@Model
public class CarrinhoComprasBean {
	
	@Inject
	private LivroDao livroDao;
	
	@Inject
	private CarrinhoCompras carrinho;
	
	public String  add(Integer id) {
		Livro livro = livroDao.buscarPorid(id);
		CarrinhoItem item = new CarrinhoItem(livro);
		carrinho.add(item);
		return "carrinho?faces-redirect=true";

	}
	
	public List<CarrinhoItem> getItens(){
		return carrinho.getItens();
	}

}
