package com.mazuz.repositories;

import com.mazuz.domain.Ordered;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedRepository extends CrudRepository<Ordered, String> {


}
