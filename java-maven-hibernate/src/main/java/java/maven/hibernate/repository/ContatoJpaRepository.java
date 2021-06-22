package java.maven.hibernate.repository;

import java.maven.hibernate.model.Contato;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ContatoJpaRepository {
	private EntityManager entityManager ;
	
	public ContatoJpaRepository() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MY_PU");
		entityManager = factory.createEntityManager();
	}
	
	public void incluir(Contato contato) {
		entityManager.getTransaction().begin();
		entityManager.persist(contato);
		entityManager.getTransaction().commit();
		
	}
	
	public Contato buscar(Integer id) {
		return entityManager.find(Contato.class,id);
	}
	
	public List<Contato> listar() {
		
		Query query = entityManager.createQuery("SELECT e FROM Contato e");
		return query.getResultList();
	}
}
