package com.example.jpasample.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


@NoRepositoryBean
public interface MyRepository <T, Id extends Serializable> extends Repository<T, Id> {
    //null 값이 될수 없다
    //<E extends T> E save(@NonNull E Entity);
    <E extends T> E save(E Entity);

    List<T> findAll();

    //null이 될 수도 있다
    @Nullable
    <E extends T>Optional<E> findById(Id id);
}
