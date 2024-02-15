package com.fpmislata.ExamenCTornero.presistence.impl;

import com.fpmislata.ExamenCTornero.domain.entity.Author;
import com.fpmislata.ExamenCTornero.domain.repository.AuthorRepository;
import com.fpmislata.ExamenCTornero.mapper.AuthorMapper;
import com.fpmislata.ExamenCTornero.presistence.dao.AuthorDAO;
import com.fpmislata.ExamenCTornero.presistence.model.AuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthorRepositoryImpl implements AuthorRepository {

    @Autowired
    AuthorDAO authorDAO;

    @Override
    public Optional<Author> findById(int id) {
        AuthorEntity author = authorDAO.findById(id).get();
        return Optional.ofNullable(AuthorMapper.mapper.toAuthor(author));
    }
}
