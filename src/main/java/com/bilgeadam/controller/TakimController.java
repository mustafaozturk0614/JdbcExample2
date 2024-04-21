package com.bilgeadam.controller;

import com.bilgeadam.entity.Takim;
import com.bilgeadam.service.TakimService;
import com.bilgeadam.utility.ConnectionProvider;

public class TakimController {

    private TakimService takimService;

    public TakimController(ConnectionProvider connectionProvider) {
        this.takimService=new TakimService(connectionProvider);
    }

    public  void createTakim(Takim takim){
        takimService.save(takim);
    }


}
