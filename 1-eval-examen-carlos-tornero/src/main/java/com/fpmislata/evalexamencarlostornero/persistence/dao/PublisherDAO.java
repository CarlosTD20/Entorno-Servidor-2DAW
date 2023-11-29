package com.fpmislata.evalexamencarlostornero.persistence.dao;

import com.fpmislata.evalexamencarlostornero.db.DBUtil;
import com.fpmislata.evalexamencarlostornero.mapper.PublisherMapper;
import com.fpmislata.evalexamencarlostornero.persistence.model.PublisherEntity;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class PublisherDAO {

    public Optional<PublisherEntity> findByBookId(Connection connection, int id){
        final String SQL="select p.* from publisher p inner join books b where p.id=b.id_publisher and b.id=?";
        try {
            ResultSet resultSet = DBUtil.select(connection,SQL, List.of(id));
            return Optional.ofNullable(resultSet.next()? PublisherMapper.mapper.toPublisherEntity(resultSet) : null);
        } catch (SQLException e){
            throw new RuntimeException();
        }
    }
}
