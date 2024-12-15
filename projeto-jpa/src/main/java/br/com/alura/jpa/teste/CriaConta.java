package br.com.alura.jpa.teste;

import br.com.alura.jpa.modelo.Conta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CriaConta {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager(); 
		
		Conta conta = new Conta();
		conta.setTitular("Leonardo");
		conta.setNumero(1234);
		conta.setAgencia(1);
		
		em.getTransaction().begin();
		
		em.persist(conta);

		em.getTransaction().commit();
	}
}
