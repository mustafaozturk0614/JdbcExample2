package com.bilgeadam.utility;

import com.bilgeadam.entity.Futbolcu;

import java.util.List;
import java.util.Optional;

public interface ICrud <T>{

    void  save(T t);
    void  update(T t);
    void  deleteById(long id);
    List<T> findAll();
    Optional<T>  findById(long id);
}
