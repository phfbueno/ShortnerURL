package com.github.phfbueno.encurtadorurl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.IndexOperations;

@Configuration
public class MongoConfig {

    private MongoTemplate mongoTemplate;

    public MongoConfig(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void createTTLIndex() {
        IndexOperations indexOperations = mongoTemplate.indexOps("url");

        indexOperations.ensureIndex(new Index()
                .on("timeExpires", org.springframework.data.domain.Sort.Direction.ASC)
                .expire(15)
        );
    }
}
