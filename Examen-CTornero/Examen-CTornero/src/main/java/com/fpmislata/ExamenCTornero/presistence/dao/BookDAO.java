package com.fpmislata.ExamenCTornero.presistence.dao;

import com.fpmislata.ExamenCTornero.presistence.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDAO extends JpaRepository<BookEntity, Integer> {
    public BookEntity findByIsbn(String isbn);
    public List<BookEntity> findByPublisherEntityId(int id);
}
