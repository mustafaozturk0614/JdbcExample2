package com.bilgeadam.controller;

import com.bilgeadam.entity.Futbolcu;
import com.bilgeadam.service.FutbolcuService;
import com.bilgeadam.utility.ConnectionProvider;

import java.util.List;

public class FutbolcuController {

    private FutbolcuService futbolcuService;

    public FutbolcuController(ConnectionProvider connectionProvider) {
        this.futbolcuService= new FutbolcuService(connectionProvider);
    }


    public void  createFutbolcu(Futbolcu futbolcu){
        futbolcuService.save(futbolcu);
    }

    public List<Futbolcu> getAll(){
        return  futbolcuService.findAll();
    }

    public Futbolcu getById(Long id){
        return  futbolcuService.getById(id);
    }

    public void deleteById(long id){
        futbolcuService.deleteById(id);
    }

    public void  updateFutbolcu(Futbolcu futbolcu){
        futbolcuService.update(futbolcu);
    }
    public void  updateFutbolcu2(Futbolcu futbolcu){
        futbolcuService.update2(futbolcu);
    }
    public List<Futbolcu> findAllFutbolcuByTakimId(Long takimId){
        return  futbolcuService.findAllFutbolcuByTakimId(takimId);
    }

    public List<Futbolcu> findAllFutbolcuByTakimIsım(String isim){
        return  futbolcuService.findAllFutbolcuByTakimIsım(isim);
    }
}
