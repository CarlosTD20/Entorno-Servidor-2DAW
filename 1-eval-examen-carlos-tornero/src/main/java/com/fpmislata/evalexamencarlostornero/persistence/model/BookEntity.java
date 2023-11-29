package com.fpmislata.evalexamencarlostornero.persistence.model;

import com.fpmislata.evalexamencarlostornero.persistence.dao.AuthorDAO;
import com.fpmislata.evalexamencarlostornero.persistence.dao.PublisherDAO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Connection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
    private int id;
    private String isbn;
    private String title;
    private String synopsis;
    private PublisherEntity publisherEntity;
    private List<AuthorEntity> authorEntities;


    public BookEntity(String isbn, String title, String synopsis) {
        this.isbn = isbn;
        this.title = title;
        this.synopsis = synopsis;
    }

    public PublisherEntity getPublisherEntity(Connection connection, PublisherDAO publisherDAO) {
        if (this.publisherEntity == null){
            this.publisherEntity = publisherDAO.findByBookId(connection,this.id).orElse(null);
        }
        return this.publisherEntity;
    }

    public List<AuthorEntity> getAuthorEntities(Connection connection, AuthorDAO authorDAO) {
        if (this.authorEntities == null){
            this.authorEntities = authorDAO.findByBookId(connection,this.id);
        }
        return this.authorEntities;
    }
}
