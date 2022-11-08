package aplicativo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Jogo;

public class AplicacaoProblema {

	public static void main(String[] args) {
		
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Atividade2AlissonKauan");
		
		EntityManager em = emFactory.createEntityManager();

		
		List<Jogo> listaJogo = em.createQuery("FROM Jogo", Jogo.class).getResultList();
		System.out.println(listaJogo);

	}

}
