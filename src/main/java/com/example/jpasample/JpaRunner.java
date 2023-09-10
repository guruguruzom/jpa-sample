package com.example.jpasample;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//jpa에 사용되는 모든 bean들이 자동으로 등록된다
@Component
@Transactional
public class JpaRunner implements ApplicationRunner {
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();

        account.setUsername("namedddd");
        account.setPassword("pass");

        try (Session session = entityManager.unwrap(Session.class)) {
            session.save(account);
        }
        //entityManager.persist(account);
    }
}
