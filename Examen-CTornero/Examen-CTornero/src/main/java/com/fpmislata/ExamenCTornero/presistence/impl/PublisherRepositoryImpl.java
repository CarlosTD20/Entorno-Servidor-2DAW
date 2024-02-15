package com.fpmislata.ExamenCTornero.presistence.impl;

import com.fpmislata.ExamenCTornero.domain.entity.Publisher;
import com.fpmislata.ExamenCTornero.domain.repository.PublisherRepository;
import com.fpmislata.ExamenCTornero.mapper.PublisherMapper;
import com.fpmislata.ExamenCTornero.presistence.dao.PublisherDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PublisherRepositoryImpl implements PublisherRepository {

    @Autowired
    PublisherDAO publisherDAO;

    @Override
    public Optional<Publisher> findByID(int id) {
        Publisher publisher = PublisherMapper.mapper.toPublisher(publisherDAO.findById(id).get());
        return Optional.ofNullable(publisher);
    }
}
