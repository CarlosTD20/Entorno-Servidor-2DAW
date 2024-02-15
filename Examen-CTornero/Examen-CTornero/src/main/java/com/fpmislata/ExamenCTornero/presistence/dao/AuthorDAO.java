package com.fpmislata.ExamenCTornero.presistence.dao;

import com.fpmislata.ExamenCTornero.presistence.model.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDAO extends JpaRepository<AuthorEntity, Integer> {
}
