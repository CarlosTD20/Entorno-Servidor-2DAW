package com.fpmislata.movies.db;

import com.fpmislata.movies.exception.DBConnectionException;
import com.fpmislata.movies.exception.SQLStatmentException;

import java.sql.*;
import java.util.List;

public class DBUtil {


    private static final String URL_CONNECTION = "jdbc:mariadb://localhost:3306/movies";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection(boolean autoCommit){
        try {
            Connection connection = DriverManager.getConnection(
                    URL_CONNECTION,
                    USERNAME,
                    PASSWORD
            );
            connection.setAutoCommit(autoCommit);
            return connection;
        } catch (SQLException e) {
            throw new DBConnectionException("Connection paramaters :\n\n" + getParameters() + "\nOriginal exception message: " + e.getMessage());
        }
    }

    private static String getParameters (){
        return String.format("url: %s\nUser: %s\nPassword: %s\n",
                URL_CONNECTION,
                USERNAME,
                PASSWORD
        );
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DBConnectionException("Can't close connection");
        }
    }

    public static ResultSet select(Connection connection, String sql, List<Object> values) {
        try {
            PreparedStatement preparedStatement = setParameters(connection, sql, values);
            return preparedStatement.executeQuery();
        } catch (Exception e) {
            throw new RuntimeException("Error executing sql statement: " + sql);
        }
    }

    public static int insert(Connection connection, String sql, List<Object> values) {
        try {
            PreparedStatement preparedStatement = setParameters(connection, sql, values);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()){
                return resultSet.getInt(1);
            } else {
                throw new RuntimeException("Cannot read last generated id");
            }
        } catch (SQLException e) {
            throw new SQLStatmentException("SQL: " + sql);
        }
    }


    public static int update(Connection connection, String sql, List<Object> values) {
        try {
            PreparedStatement preparedStatement = setParameters(connection, sql, values);
            int numRows = preparedStatement.executeUpdate();
            return numRows;
        } catch (SQLException e) {
            throw new SQLStatmentException("SQL: " + sql);
        }
    }

    private static PreparedStatement setParameters(Connection connection, String sql, List<Object> values){
        try {
            PreparedStatement preparedStatement =  connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            if(values != null) {
                for(int i=0;i<values.size();i++) {
                    Object value = values.get(i);
                    preparedStatement.setObject(i+1,value);
                }
            }
            return preparedStatement;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int delete(Connection connection, String sql, List<Object> values) {
        try {
            PreparedStatement preparedStatement = setParameters(connection, sql, values);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLStatmentException("SQL: " + sql);
        }
    }

    /*
    final static String DRIVER = "jdbc:mariadb";
    final static String URL = "localhost:3306";
    final static String DB = "movies";
    final static String USER = "root";
    final static String PASSWORD = "root";

    static String connectionString = String.format("%s://%s/%s?user=%s&password=%s", DRIVER, URL, DB, USER, PASSWORD);

    //Conectar a la bbdd.
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(connectionString);
        } catch (Exception e) {
            throw new RuntimeException("Error al conectar con la bbdd.");
        }
    }

    //Desconectar la bbdd.
    public static void closeConnection(Connection connection){
        try {
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException("Error al cerrar la bbdd.");
        }
    }

    //Metodo para realizar el select.
    public static ResultSet select(Connection connection, String sql, List<Object> values) {
        try {
            PreparedStatement preparedStatement = setParameters(connection, sql, values);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException("Ha fallado la consulta select.");
        }
    }

    //Insertar una nueva pelicula.
    public static boolean insert(Connection connection, String sql, List<Object> values) {
        try {
            PreparedStatement preparedStatement = setParameters(connection, sql, values);
            return (preparedStatement.executeUpdate()>0)?true:false;
        } catch (SQLException e) {
            throw new RuntimeException("No se ha podido insertar la película");
        }
    }

    //Actualizar una película
    public static int update(Connection connection, String sql, List<Object> values){
        try{
            PreparedStatement preparedStatement = setParameters(connection, sql, values);
            return preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException("No se ha podido actualizar la película");
        }
    }

    //ELiminar pelicula
    public static int delete(Connection connection, String sql, List<Object> values){
        try {
            PreparedStatement preparedStatement = setParameters(connection, sql, values);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("No se ha podido borrar la película");
        }
    }

    //Insertar parametros de la busqueda.
    private static PreparedStatement setParameters(Connection connection, String sql, List<Object> values){
        try {
            PreparedStatement preparedStatement =    connection.prepareStatement(sql);
            if(values != null) {
                for(int i=0;i<values.size();i++) {
                    Object value=values.get(i);
                    preparedStatement.setObject(i+1,value);
                }
            }
            return preparedStatement;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    */
}

