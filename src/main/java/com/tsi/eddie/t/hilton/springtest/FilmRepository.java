package com.tsi.eddie.t.hilton.springtest;

import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Actor,Integer> {

}