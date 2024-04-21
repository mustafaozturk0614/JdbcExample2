package com.bilgeadam.service;

import com.bilgeadam.entity.Takim;
import com.bilgeadam.repository.TakimRepository;
import com.bilgeadam.utility.ConnectionProvider;
import com.bilgeadam.utility.ICrud;

import java.util.List;
import java.util.Optional;

public class TakimService implements ICrud<Takim> {


    private TakimRepository takimRepository;

    public TakimService(ConnectionProvider connectionProvider) {
        this.takimRepository=new TakimRepository(connectionProvider);
    }

    @Override
    public void save(Takim takim) {
         takimRepository.save(takim);
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
}
