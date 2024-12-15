package br.com.alura.jpa.teste;

import br.com.alura.jpa.modelo.Conta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CriaEAlteraConta {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Marcia");
		conta.setNumero(1236);
		conta.setAgencia(1);
		conta.setSaldo(100.0);
		
		em.getTransaction().begin();
		
		// Managed
		em.persist(conta);

		em.getTransaction().commit();
		
		em.close();
		
		System.out.println("Conta da Marcia: " + conta.getId() + " - " + conta.getTitular());
		
		EntityManager em2 = emf.createEntityManager();
		
		conta.setSaldo(500.0);
		
		em2.getTransaction().begin();
		
		// Detached
		em2.merge(conta);
		
		em2.getTransaction().commit();
	}
}
