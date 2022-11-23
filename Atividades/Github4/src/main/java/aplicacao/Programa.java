package aplicacao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Cliente;
import dominio.ClienteDAO;

public class Programa {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		ClienteDAO teste = ClienteDAO.getInstance();

		Scanner scanner = new Scanner(System.in);
		// teste.inserir(new Cliente(null, "TesteInserir", "teste@gmail.com"));
		// teste.remover(new Cliente(4, null, null));
		// List<Cliente> clientes = teste.findAll();

		// for(Cliente c : clientes) {
		// System.out.println(c);
		// }

		int esc = 1;

		while (esc != 0) {
			System.out.println("Menu de Cliente: ");
			System.out.println("1 - Adicionar Cliente");
			System.out.println("2 - Remover Cliente");
			System.out.println("3 - Alterar Cliente");
			System.out.println("4 - Visualizar Clientes");
			System.out.println("0 - Sair");
			esc = scanner.nextInt();
			
			switch (esc) {
			case 0:
				break;

			case 1:
				scanner.nextLine();
				System.out.println("Digite um nome: ");
				String nome = scanner.nextLine();
				System.out.println("Digite um email: ");
				String email = scanner.nextLine();
				teste.inserir(new Cliente(null, nome, email));
				break;

			case 2:
				System.out.println("Digite o número do cliente: ");
				int id = scanner.nextInt();
				teste.remover(new Cliente(id, null, null));
				break;

			case 3:
				System.out.println("Digite o Id do cliente: ");
				int idAlt = scanner.nextInt();
				scanner.nextLine();
				System.out.println("1 - Alterar nome \n2 - Alterar email");
				int x = scanner.nextInt();
				scanner.nextLine();
				if (x == 1) {
					System.out.println("Digite o novo nome: ");
					String altera = scanner.nextLine();
					teste.alterar(idAlt, x, altera);
				} else {
					System.out.println("Digite o novo email: ");
					String altera = scanner.nextLine();
					teste.alterar(idAlt, x, altera);
				}
				break;

			case 4:
				for (Cliente c : teste.findAll()) {
					System.out.println(c);
				}
				break;
				
			default:
				break;
			}
		}

		System.out.println("Commit realizado!");
		em.close();
		emf.close();
	}

}
