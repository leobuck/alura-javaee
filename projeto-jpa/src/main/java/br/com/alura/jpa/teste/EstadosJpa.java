package br.com.alura.jpa.teste;

import br.com.alura.jpa.modelo.Conta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EstadosJpa {

	public static void main(String[] args) {
		
		// Transient:
		// Existe na memória com informações, mas não tem Id e pode ser managed no futuro 
		Conta conta = new Conta();
		conta.setTitular("Eduarda");
		conta.setAgencia(2);
		conta.setNumero(1237);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		// Transient -> Managed
		// Managed: Sincronização automática com o banco de dados
		em.persist(conta);
		
		// Managed -> Removed
		// Removed: Removido do contexto JPA
		em.remove(conta);
		
		em.getTransaction().commit();
	}
}
