package br.com.alura.jpa.teste;

import br.com.alura.jpa.modelo.Conta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AlteraSaldoDaConta {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta contaDoLeo = em.find(Conta.class, 1L);
		
		System.out.println("Conta do Leonardo: " + contaDoLeo.getTitular());
		
		em.getTransaction().begin();
		
		contaDoLeo.setSaldo(20.0);
		
		em.getTransaction().commit();
	}
}
