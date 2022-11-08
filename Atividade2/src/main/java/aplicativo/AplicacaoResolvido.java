package aplicativo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Jogo;

public class AplicacaoResolvido {

	public static void main(String[] args) {
		
				EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistence");
				
				
				EntityManager em = emFactory.createEntityManager();

				
				List<Jogo> listaJogo = em.createQuery("FROM Jogo j join fetch j.estudio", Jogo.class).getResultList();
				System.out.println(listaJogo);
	}

}
