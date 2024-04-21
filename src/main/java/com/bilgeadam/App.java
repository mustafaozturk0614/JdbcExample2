package com.bilgeadam;

import com.bilgeadam.controller.FutbolcuController;
import com.bilgeadam.controller.TakimController;
import com.bilgeadam.entity.Futbolcu;
import com.bilgeadam.entity.Takim;
import com.bilgeadam.repository.FutbolcuRepository;
import com.bilgeadam.utility.ConnectionProvider;

public class App {


    public static void main(String[] args) {
        ConnectionProvider connectionProvider=new ConnectionProvider("futbolApp");
      //  connectionProvider.openConnection();
       // connectionProvider.closeConnection();
        /// FUTBOLCU OLUSTURMA
        Futbolcu futbolcu=new Futbolcu("Aytuğ","orta saha",6,1500000,2L);
        FutbolcuController futbolcuController=new FutbolcuController(connectionProvider);
   //   futbolcuController.createFutbolcu(futbolcu);

        /// FUTBOLCULARI GETİR
//        try {
//            futbolcuController.getAll().forEach(System.out::println);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
        //// TEK BİR FUTBOLCU GETİR
//        try {
//            System.out.println( futbolcuController.getById(9L));  ;
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
        /// FUTBOLCU SİL
    //    futbolcuController.deleteById(8L);


//        FutbolcuRepository futbolcuRepository=new FutbolcuRepository(connectionProvider);
//        futbolcuRepository.save2(futbolcu);
       // futbolcuController.createFutbolcu(futbolcu);


        // FUTBOLCU GUNCELLE
      //  Futbolcu updateFutbolcu=new Futbolcu(10L,"Burhan","forvet",11,1000000,null);
    //    futbolcuController.updateFutbolcu2(updateFutbolcu);

        /// TAKIM OLUSTURMA
//        Takim takim1=new Takim("1. takim");
//        Takim takim2=new Takim("2. takim");
//        Takim takim3=new Takim("3. takim");
//        TakimController takimController=new TakimController(connectionProvider);
//         takimController.createTakim(takim1);
//         takimController.createTakim(takim2);
//         takimController.createTakim(takim3);

        // takim 1 in futbolcu listesini yazdıralım

     //   futbolcuController.findAllFutbolcuByTakimId(1L).forEach(System.out::println);
        futbolcuController.findAllFutbolcuByTakimIsım("2. takim").forEach(System.out::println);


    }
}
