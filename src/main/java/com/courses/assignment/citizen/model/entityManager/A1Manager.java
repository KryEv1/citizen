package com.courses.assignment.citizen.model.entityManager;

import com.courses.assignment.citizen.model.entities.A1User;
import lombok.NoArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@NoArgsConstructor
public class A1Manager {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = emf.createEntityManager();

    public List<A1User> getAll() {

        List<A1User> a1Users = entityManager.createQuery("select a1 from A1User a1, Account ac", A1User.class).getResultList();
        return a1Users;
    }
}
