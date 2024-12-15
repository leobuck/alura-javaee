package br.com.alura.jpa.teste;

import br.com.alura.jpa.modelo.Conta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CriaContaComSaldo {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Juliano");
		conta.setNumero(1235);
		conta.setAgencia(1);
		conta.setSaldo(500.0);
		
		em.getTransaction().begin();
		
		em.persist(conta);

		em.getTransaction().commit();
	}
}
