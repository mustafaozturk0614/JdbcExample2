package com.bilgeadam.repository;

import com.bilgeadam.entity.Futbolcu;
import com.bilgeadam.entity.Takim;
import com.bilgeadam.utility.ConnectionProvider;
import com.bilgeadam.utility.ICrud;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TakimRepository implements ICrud<Takim> {

    String sql;
    ConnectionProvider connectionProvider;

    public TakimRepository(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    @Override
    public void save(Takim takim) {
        sql="insert into takim (isim) values(?)";
        connectionProvider.openConnection();
        try {
            PreparedStatement preparedStatement=connectionProvider.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,takim.getIsim());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Takım olusturulamadı");
        }finally {
            connectionProvider.closeConnection();
        }
    }

    @Override
    public void update(Takim takim) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public List<Takim> findAll() {
        return null;
    }

    @Override
    public Optional<Takim> findById(long id) {
        return Optional.empty();
    }

//    public List<Futbolcu> findAllFutbolcuByTakimId(Long takimId){
//
//
//
//    }
}
