package com.github.gcestaro.repositories;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.github.gcestaro.models.Rune;

public interface RuneRepository extends MongoRepository<Rune, UUID> {

}
