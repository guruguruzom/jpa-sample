package com.example.jpasample;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
class CommetRepositoryTest {

    @Autowired
    CommetRepository commetRepository;

    @Test
    public void crud(){
//        Comment comment = new Comment();
//        comment.setComment("hello comment");
//        commetRepository.save(comment);
//
//        List<Comment> all = commetRepository.findAll();
//
//        assertThat(all.size()).isEqualTo(1);

        Optional<Comment> byId = commetRepository.findById(100l);

        assertThat(byId).isEmpty();

        //값이없다면 예외
        Comment comment = byId.orElseThrow(IllegalAccessError::new);
        //값이 없다면 대입
        comment = byId.orElse(new Comment());

    }
}