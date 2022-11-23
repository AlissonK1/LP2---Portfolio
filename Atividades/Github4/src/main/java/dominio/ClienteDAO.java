package dominio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClienteDAO {

	private static ClienteDAO instance;
	protected EntityManager em;

	public static ClienteDAO getInstance() {
		if (instance == null) {
			instance = new ClienteDAO();
		}

		return instance;
	}

	private ClienteDAO() {
		em = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("exemplo-jpa");
		if (em == null) {
			em = factory.createEntityManager();
		}

		return em;
	}

	public Cliente getById(final int id) {
		return em.find(Cliente.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> findAll() {
		return em.createQuery("FROM " + Cliente.class.getName()).getResultList();
	}

	public void inserir(Cliente cliente) {
		try {
			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public void alterar(int id, int esc, String dado) {
		try {
			Cliente cliente = em.find(Cliente.class, id);

			em.getTransaction().begin();
			if (esc == 1) {
				cliente.setNome(dado);
			}else {
				cliente.setEmail(dado);
			}
			em.getTransaction().commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public void remover(Cliente cliente) {
		try {
			em.getTransaction().begin();
			cliente = em.find(Cliente.class, cliente.getId());
			em.remove(cliente);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}
}
