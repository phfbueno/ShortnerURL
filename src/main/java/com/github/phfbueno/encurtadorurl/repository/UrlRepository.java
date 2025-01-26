package com.github.phfbueno.encurtadorurl.repository;

import com.github.phfbueno.encurtadorurl.Entity.Url;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<Url, String> {

}
