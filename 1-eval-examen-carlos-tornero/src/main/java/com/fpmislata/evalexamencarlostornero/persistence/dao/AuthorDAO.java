package com.fpmislata.evalexamencarlostornero.persistence.dao;

import com.fpmislata.evalexamencarlostornero.db.DBUtil;
import com.fpmislata.evalexamencarlostornero.domain.entity.Author;
import com.fpmislata.evalexamencarlostornero.mapper.AuthorMapper;
import com.fpmislata.evalexamencarlostornero.persistence.model.AuthorEntity;
import com.fpmislata.evalexamencarlostornero.persistence.model.BookEntity;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorDAO {

    public List<AuthorEntity> findByBookId(Connection connection, int id){
        final String SQL ="select a.* from authors a inner join books_authors ba where a.id=ba.author_id and ba.book_id=?";
        List<AuthorEntity> authorEntities = new ArrayList<>();
        try {
            ResultSet resultSet = DBUtil.select(connection,SQL,List.of(id));
            while (resultSet.next()){
                authorEntities.add(AuthorMapper.mapper.toAuthorEntity(resultSet));
            }
            return authorEntities;
        } catch (SQLException e){
            throw new RuntimeException();
        }
    }
}
