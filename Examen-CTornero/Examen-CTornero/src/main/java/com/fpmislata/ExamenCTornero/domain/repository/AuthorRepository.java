package com.fpmislata.ExamenCTornero.domain.repository;

import com.fpmislata.ExamenCTornero.domain.entity.Author;

import java.util.Optional;

public interface AuthorRepository {
    public Optional<Author> findById(int id);
}
