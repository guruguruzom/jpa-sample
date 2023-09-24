package com.example.jpasample;

import com.example.jpasample.domain.Post;
import com.example.jpasample.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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

        //When
        Page<Post> page = postRepository.findAll(PageRequest.of(0,10));
        assertThat(page.getTotalElements()).isEqualTo(1); //전체 페이지
        assertThat(page.getNumber()).isEqualTo(0); //현재 페이지 넘버
        assertThat(page.getSize()).isEqualTo(10); //크기가 얼마나 되는지
        assertThat(page.getNumberOfElements()).isEqualTo(1);

        //When
        postRepository.findByTitleContains("title", PageRequest.of(0,10));

        assertThat(page.getTotalElements()).isEqualTo(1);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.getSize()).isEqualTo(10);
        assertThat(page.getNumberOfElements()).isEqualTo(1);

        long springCount = postRepository.countByTitleContains("title");

        assertThat(springCount).isEqualTo(1);
    }
}