package com.mazuz.repositories;


import com.mazuz.domain.Gifts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftsRepository extends CrudRepository<Gifts, String> {

    Gifts findByUrl(String url);
}


