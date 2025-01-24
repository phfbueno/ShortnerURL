package com.github.phfbueno.EncurtadorURL.repository;

import com.github.phfbueno.EncurtadorURL.Entity.Url;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<Url, String> {

}
