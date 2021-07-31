package finalProject.jpa.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("a");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Sach s1 = new Sach("Tac gia 1", "NXB1", "Sach1", 50, 50);
		
		DocGia dg1 = new DocGia("DocGia1", "Diachi1");
		
		entityManager.persist(s1);
		entityManager.persist(dg1);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
	}

}
