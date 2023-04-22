package br.inatel.labs.labjpa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service 
@Transactional 
public class NotaCompraService {
	
	@PersistenceContext
	private EntityManager em;
	
	public NotaCompra salvarNotaCompra(NotaCompra nc) {
		nc = em.merge(nc);
		return nc;
	}
	
	public NotaCompra buscarNotaCompraPeloId(Long id) {
		NotaCompra notaCompraEncontrado = em.find(NotaCompra.class, id);
		return notaCompraEncontrado;
	}
		
	public List<NotaCompra> listarNotaCompra() {
		//String sql = "SELECT * FROM NotaCompra";
		//jpql = Java Persistence Query Language
		String jpql = "SELECT nc FROM NotaCompra nc";
		List<NotaCompra> notaCompra = em.createQuery(jpql, NotaCompra.class).getResultList();
		//Podemos substituir por return em.createQuery("SELECT nc FROM NotaCompra nc", Fornecedor.class).getResultList())
		return notaCompra;
	}	
	
	public void remover(NotaCompra nc) {
		//Podemos substituior por em.remove(em.merge(f));
		nc = em.merge(nc);
		em.remove(nc);
	}	

	public NotaCompraItem salvarNotaCompraItem(NotaCompraItem item) {
		return em.merge(item);
	}	
	
	public NotaCompraItem buscarNotaCompraItemPeloId(Long id) {
		NotaCompraItem notaCompraItemEncontrado = em.find(NotaCompraItem.class, id);
		return notaCompraItemEncontrado;
	}
	
	public List<NotaCompraItem> listarNotaCompraItem() {
		return em.createQuery("SELECT nci FROM NotaCompraItem nci", NotaCompraItem.class).getResultList();
	}
	
	public NotaCompra buscarNotaCompraPeloIdComListaIntem(Long id) {
		NotaCompra notaCompra = em.find(NotaCompra.class, id);
		notaCompra.getListaNotaCompraItem().size();
		return notaCompra;
	}
	
}