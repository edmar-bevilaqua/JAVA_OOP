package br.com.springboot.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.dao.CRUD;
import br.com.springboot.dao.ProdutoDAO;
import br.com.springboot.model.Produto;

@Service
public class ProdutoBO implements CRUD<Produto, Long>{
	
	@Autowired
	private ProdutoDAO dao;

	@Override
	public Produto pesquisaPeloID(Long id) {
		return dao.pesquisaPeloID(id);
	}

	@Override
	public List<Produto> lista() {
		return dao.lista();
	}

	@Override
	public void insere(Produto produto) {
		dao.insere(produto);
	}

	@Override
	public void atualiza(Produto produto) {
		dao.atualiza(produto);
	}

	@Override
	public void remove(Produto produto) {
		dao.remove(produto);
	}
	
	public void inativa(Produto produto) {
		produto.setAtivo(false);
		dao.atualiza(produto);
	}
}
