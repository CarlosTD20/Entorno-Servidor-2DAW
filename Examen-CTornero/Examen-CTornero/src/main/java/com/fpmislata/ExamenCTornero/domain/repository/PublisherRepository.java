package com.fpmislata.ExamenCTornero.domain.repository;

import com.fpmislata.ExamenCTornero.domain.entity.Publisher;

import java.util.Optional;

public interface PublisherRepository {
    public Optional<Publisher> findByID(int id);
}
