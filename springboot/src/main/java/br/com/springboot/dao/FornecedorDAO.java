package br.com.springboot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.springboot.model.Fornecedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class FornecedorDAO implements CRUD<Fornecedor, Long>{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Fornecedor pesquisaPeloID(Long id) {
		return entityManager.find(Fornecedor.class, id);
	}

	@Override
	public List<Fornecedor> lista() {
		Query query = entityManager.createQuery("Select c from Fornecedor c");
		return (List<Fornecedor>) query.getResultList();
	}

	@Override
	public void insere(Fornecedor fornecedor) {
		entityManager.persist(fornecedor);
	}

	@Override
	public void atualiza(Fornecedor fornecedor) {
		entityManager.merge(fornecedor);
	}

	@Override
	public void remove(Fornecedor fornecedor) {
		entityManager.remove(fornecedor);		
	}

}
