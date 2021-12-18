package com.courses.assignment.citizen.model.entityManager;

import com.courses.assignment.citizen.model.entities.Account;
import lombok.NoArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@NoArgsConstructor
public class AccountManager {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Account> getAll() {
        return entityManager.createQuery("select acc from Account acc",Account.class).getResultList();
    }

    public Account getById(int id) {
        return entityManager.find(Account.class, id);
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
