package com.bilgeadam.service;

import com.bilgeadam.entity.Futbolcu;
import com.bilgeadam.repository.FutbolcuRepository;
import com.bilgeadam.utility.ConnectionProvider;
import com.bilgeadam.utility.ICrud;

import java.util.List;
import java.util.Optional;

public class FutbolcuService implements ICrud<Futbolcu> {


    FutbolcuRepository futbolcuRepository;

    public FutbolcuService(ConnectionProvider connectionProvider) {
        this.futbolcuRepository = new FutbolcuRepository(connectionProvider);
    }

    @Override
    public void save(Futbolcu futbolcu) {
        futbolcuRepository.save(futbolcu);
    }

    @Override
    public void update(Futbolcu futbolcu) {
        futbolcuRepository.update(futbolcu);
    }

    @Override
    public void deleteById(long id) {
        futbolcuRepository.deleteById(id);
    }

    @Override
    public List<Futbolcu> findAll() {
        List<Futbolcu> futbolcuList=futbolcuRepository.findAll();

        if (futbolcuList.isEmpty()){
            throw  new RuntimeException("Herhangi bir veri bulunamadı");
        }

        return futbolcuList;
    }

    @Override
    public Optional<Futbolcu> findById(long id) {
        return futbolcuRepository.findById(id);
    }


    public Futbolcu getById(long id) {
     return futbolcuRepository.findById(id).orElseThrow(()->new RuntimeException("futbolcu bulunamadı"));
    }

    public void update2(Futbolcu futbolcu) {
        futbolcuRepository.update2(futbolcu);
    }

    public List<Futbolcu> findAllFutbolcuByTakimId(Long takimId){
        return  futbolcuRepository.findAllFutbolcuByTakimId(takimId);
    }
    public List<Futbolcu> findAllFutbolcuByTakimIsım(String isim){
        return  futbolcuRepository.findAllFutbolcuByTakimIsım(isim);
    }
}
