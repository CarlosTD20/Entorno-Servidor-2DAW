package com.fpmislata.ExamenCTornero.mapper;

import com.fpmislata.ExamenCTornero.controller.model.publisher.PublisherWeb;
import com.fpmislata.ExamenCTornero.domain.entity.Publisher;
import com.fpmislata.ExamenCTornero.presistence.model.PublisherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    PublisherMapper mapper = Mappers.getMapper(PublisherMapper.class);

    PublisherEntity toPublisherEntity(Publisher publisher);
    PublisherWeb toPublisherListWeb(Publisher publisher);
    Publisher toPublisher(PublisherEntity publisherEntity);
}
