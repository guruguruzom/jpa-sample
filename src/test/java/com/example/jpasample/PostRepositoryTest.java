package com.example.jpasample;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest //data access layer 만 테스트 //다른 bean은 등록되지 않음
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    @Rollback(false)
    public void crudRepository() {
        //Given
        Post post = new Post();
        post.setTitle("title");

        //When
        assertThat(post.getId()).isNull();;
        Post newPost = postRepository.save(post);

        //Then
        assertThat(newPost.getId()).isNotNull();

        List<Post> posts = postRepository.findAll();
        assertThat(posts.size()).isEqualTo(1);
        assertThat(posts).contains(newPost);
    }
}