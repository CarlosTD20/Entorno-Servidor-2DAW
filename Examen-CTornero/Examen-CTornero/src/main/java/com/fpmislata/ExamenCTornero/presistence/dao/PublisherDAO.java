package com.fpmislata.ExamenCTornero.presistence.dao;

import com.fpmislata.ExamenCTornero.presistence.model.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherDAO extends JpaRepository<PublisherEntity, Integer> {
}
