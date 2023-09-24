package com.example.jpasample.repository;

import com.example.jpasample.domain.Comment;
import com.example.jpasample.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//Crud interface 에서 가져오는 모든 기능을 사용하고 싶지 않을때
//@RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)
//MyRepository 를 상속받으며 위 어노테이션은 사용하지 않는다
public interface CommetRepository extends MyRepository<Comment, Long> {

    @Query(value = "SELECT c FROM Comment As c", nativeQuery = true) //정의된 쿼리를 보고 생성
    List<Comment> findByTitleContains(String keyword); //메서드 이름을 분석해서 쿼리생성


    Page<Comment> findByLikeGreaterThan(int likeCount); //like count가 파라미터 이상인 comment 가져오기
    Page<Comment> findByLikeGreaterThanAndPost(int likeCount, Post post); //and 값으로 추가 조건가능, //pageable 파라미터를 이용하여 페이징처리
    Page<Comment> findByLikeGreaterThanAndPost(int likeCount, Post post, Pageable pageable); //pageable 파라미터를 이용하여 페이징처리
    Page<Comment> findTop10ByLikeGreaterThanAndPostOrderByCreatedDesc(int likeCount, Post post, Pageable pageable); //create 기준 정렬 상위 10개만(paging이 있어서 상관없음)
    List<Comment> findTop10ByLikeGreaterThanAndPost(int likeCount, Post post, Sort sort); //정렬조건 추가(page를 사용하고 싶지 않을때 사용)
    //Slice<Comment>
    //Page<Comment>
}
