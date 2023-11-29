package com.fpmislata.evalexamencarlostornero.persistence.dao;

import com.fpmislata.evalexamencarlostornero.db.DBUtil;
import com.fpmislata.evalexamencarlostornero.mapper.BookMapper;
import com.fpmislata.evalexamencarlostornero.persistence.model.BookEntity;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {

    public List<BookEntity> findAllBooks (Connection connection){
        final String SQL = "SELECT * FROM  books";
        List<BookEntity> bookEntities = new ArrayList<>();
        try {
            ResultSet resultSet = DBUtil.select(connection,SQL,null);
            while (resultSet.next()){
                bookEntities.add(BookMapper.mapper.toBookEntity(resultSet));
            }
            return bookEntities;
        } catch (SQLException e){
            throw new RuntimeException();
        }
    }

    public Optional<BookEntity> findByIsbn(Connection connection, String isbn){
        final String SQL=" SELECT * FROM books WHERE isbn = ? ";
        try {
            ResultSet resultSet = DBUtil.select(connection,SQL, List.of(isbn));
            return Optional.ofNullable(resultSet.next()? BookMapper.mapper.toBookEntity(resultSet) : null);
        } catch (SQLException e){
            throw new RuntimeException();
        }
    }

}
