package com.example.jpasample.repository;

import com.example.jpasample.domain.Comment;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//Crud interface 에서 가져오는 모든 기능을 사용하고 싶지 않을때
//@RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)
//MyRepository 를 상속받으며 위 어노테이션은 사용하지 않는다
public interface CommetRepository extends MyRepository<Comment, Long> {

    @Query(value = "SELECT c FROM Comment As c", nativeQuery = true) //정의된 쿼리를 보고 생성
    List<Comment> findByTitleContains(String keyword); //메서드 이름을 분석해서 쿼리생성
}
