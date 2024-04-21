package com.bilgeadam.utility;

import java.sql.*;

public class ConnectionProvider {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private final String dbName;
    private final String URL="jdbc:postgresql://localhost:5432/";
    private final String USERNAME="postgres";
    private final String PASSWORD="root";
   // private final String DRIVER_PATH="org.postgresql.Driver";


    public ConnectionProvider(String dbName) {
        this.dbName=dbName;
    }

    public  boolean openConnection(){
        try {
          //  Class.forName(DRIVER_PATH);
            connection= DriverManager.getConnection(URL.concat(dbName),USERNAME,PASSWORD);
            System.out.println("Bağlantı başarılı...");
            return  true;
        }  catch (SQLException e) {
            System.out.println("Bağlantı başarısız: "+e.toString());
            return  false;
        }
    }


    public void  closeConnection(){
        try {
              if (!connection.isClosed()){
                  connection.close();
                  System.out.println("Bağlantı sonlandırıldı...");
              }
        }catch (Exception e){
            System.out.println("Beklenmeyen bir hata olustu : "+ e.getMessage());
        }

    }

    public  int  executeUpdate(String sql){
        int count=0;
        openConnection();
        try {
           preparedStatement= connection.prepareStatement(sql);
          count  = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("kayıt sırasında hata olustu:"+ e.getMessage());
        }finally {
            closeConnection();
        }
        return count;
    }

    public Connection getConnection() {
        return connection;
    }
}
