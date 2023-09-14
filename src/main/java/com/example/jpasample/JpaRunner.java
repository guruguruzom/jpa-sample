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
//        Post post = new Post();
//        post.setTitle("String JPA");
//
//        Comment comment = new Comment();
//        comment.setComment("내용내용내용냉");
//        post.addComment(comment);
//
//        Comment comment1 = new Comment();
//        comment1.setComment("내용내용내용냉2");
//        post.addComment(comment1);

        Session session = entityManager.unwrap(Session.class);

        Post post = session.get(Post.class, 1l);
        System.out.println(post.getTitle());
        //session.save(post);
    }

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        Account account = new Account();
//
//        account.setUsername("namedddd");
//        account.setPassword("pass");
//
//        Study study = new Study();
//        study.setName("spring data jpa");
//        study.setOwner(account);
//
//        //영방향 관계에서 반드시 양쪽에 설정해주도록 한다.
//        account.addStudy(study);
//
//        try (Session session = entityManager.unwrap(Session.class)) {
//            session.save(account);
//            session.save(study);
//            //1차 캐시 상태
//
//            Account selectAccount = session.load(Account.class, account.getId());
//            //이 상태에선 select 쿼리문이 실행되지 않으며 객체에서 가져옴
//        }
//        //persistent 상태에서 종료된다면 detached상태로 변경됨
//        //트랜젝션이 끝나면 insert 쿼리문이 실행된다.
//    }
}
