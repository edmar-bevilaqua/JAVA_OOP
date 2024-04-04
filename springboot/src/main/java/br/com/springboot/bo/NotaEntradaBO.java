package br.com.springboot.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.dao.CRUD;
import br.com.springboot.dao.NotaEntradaDAO;
import br.com.springboot.model.NotaEntrada;

@Service
public class NotaEntradaBO implements CRUD<NotaEntrada, Long>{
	
	@Autowired
	private NotaEntradaDAO dao;

	@Override
	public NotaEntrada pesquisaPeloID(Long id) {
		return dao.pesquisaPeloID(id);
	}

	@Override
	public List<NotaEntrada> lista() {
		return dao.lista();
	}

	@Override
	public void insere(NotaEntrada notaEntrada) {
		dao.insere(notaEntrada);		
	}

	@Override
	public void atualiza(NotaEntrada notaEntrada) {
		dao.atualiza(notaEntrada);
	}

	@Override
	public void remove(NotaEntrada notaEntrada) {
		dao.remove(notaEntrada);
	}

	
	
}
