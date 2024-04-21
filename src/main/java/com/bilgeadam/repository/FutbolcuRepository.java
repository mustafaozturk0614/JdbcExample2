package com.bilgeadam.repository;

import com.bilgeadam.entity.Futbolcu;
import com.bilgeadam.utility.ConnectionProvider;
import com.bilgeadam.utility.ICrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FutbolcuRepository implements ICrud<Futbolcu> {

    String sql;
    private ConnectionProvider connectionProvider;

    public FutbolcuRepository(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    @Override
    public void save(Futbolcu futbolcu) {
       sql="insert into futbolcu (ad,mevki,deger,forma_no,takim_id)  values ('"+
                    futbolcu.getAd()+"','"+
                    futbolcu.getMevki()+"',"+
                    futbolcu.getDeger()+","+
                    futbolcu.getFormaNo()+","+
                    futbolcu.getTakimId()+
                ")";
        System.out.println(sql);

        if(connectionProvider.executeUpdate(sql)>0){
            System.out.println(futbolcu.getAd()+ " adlı futbolcu başarı ile kayıt edildi");
        };
//        connectionProvider.openConnection();
//        try {
//            PreparedStatement preparedStatement= connectionProvider.getConnection().prepareStatement(sql);
//           preparedStatement.executeUpdate();
//            System.out.println(futbolcu.getAd()+ "adlı futbolcu basşarı ile kayıt edildi ");
//        } catch (SQLException e) {
//            System.out.println("kayıt sırasında hata olustu:"+ e.getMessage());
//        }finally {
//            connectionProvider.closeConnection();
//        }

    }
    public void save2(Futbolcu futbolcu) {
        sql="insert into futbolcu (ad,mevki,deger,forma_no)  values (?,?,?,?)";
        connectionProvider.openConnection();
        try {
            PreparedStatement preparedStatement=connectionProvider.getConnection().prepareStatement(sql);
           // preparedStatement.setString(1,"ad");
            preparedStatement.setString(1,futbolcu.getAd());
            preparedStatement.setString(2, futbolcu.getMevki());
            preparedStatement.setDouble(3,futbolcu.getDeger());
            preparedStatement.setInt(4,futbolcu.getFormaNo());
            preparedStatement.executeUpdate();
            System.out.println(futbolcu);
        } catch (SQLException e) {
                e.printStackTrace();
        }finally {
            connectionProvider.closeConnection();
        }

    }
    @Override
    public void update(Futbolcu futbolcu) {
        sql="update futbolcu set ad='"+futbolcu.getAd()+"',mevki='"+futbolcu.getMevki()+"', forma_no="+futbolcu.getFormaNo()+
                ",deger="+futbolcu.getDeger()+",takim_id="+futbolcu.getTakimId()+" where id="+futbolcu.getId();
        System.out.println(sql);
        connectionProvider.executeUpdate(sql);
    }

    public void update2(Futbolcu futbolcu) {
        sql="update futbolcu set ad=?,mevki=?,forma_no=? ,deger=? where id=?";
        connectionProvider.openConnection();
        try {
            PreparedStatement preparedStatement=connectionProvider.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,futbolcu.getAd());
            preparedStatement.setString(2,futbolcu.getMevki());
            preparedStatement.setInt(3,futbolcu.getFormaNo());
            preparedStatement.setDouble(4,futbolcu.getDeger());
        //    preparedStatement.setLong(5,futbolcu.getTakimId()==null?null: futbolcu.getTakimId());
            preparedStatement.setLong(5,futbolcu.getId());
            preparedStatement.executeUpdate();
            System.out.println("Güncelleme başarılı");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            connectionProvider.closeConnection();
        }
    }

    @Override
    public void deleteById(long id) {
   //     sql="delete from futbolcu where id="+id;

  //      int count=connectionProvider.executeUpdate(sql);

        sql="delete from futbolcu where id=?";
        connectionProvider.openConnection();
        try {
            PreparedStatement preparedStatement=connectionProvider.getConnection().prepareStatement(sql);
            preparedStatement.setLong(1,id);
        int count= preparedStatement.executeUpdate();
            if (count>0){
                System.out.println("Silme işlemi başarılı");
            }else{
                System.out.println("Herhangi bir veri silinemedi");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Futbolcu> findAll() {
     List<Futbolcu> futbolcuList=new ArrayList<>();
     sql="select * from futbolcu";
     connectionProvider.openConnection();
        ResultSet resultSet;
        try {
            PreparedStatement preparedStatement=connectionProvider.getConnection().prepareStatement(sql);
            getFutbolcuList(preparedStatement, futbolcuList);
        } catch (SQLException e) {
            System.out.println("bir hata olustu: "+e.getMessage());
        }finally {
            connectionProvider.closeConnection();
        }
        return futbolcuList;
    }

    private  void getFutbolcuList(PreparedStatement preparedStatement, List<Futbolcu> futbolcuList) throws SQLException {
        ResultSet resultSet;
        resultSet= preparedStatement.executeQuery();
        while (resultSet.next()){
            Long id=resultSet.getLong(1);
            String ad=resultSet.getString(2);
            String mevki=resultSet.getString("mevki");
            int formaNo=resultSet.getInt("forma_no");
            double deger=resultSet.getDouble("deger");
            Long takimId=resultSet.getLong("takim_id");
            futbolcuList.add(new Futbolcu(id,ad,mevki,formaNo,deger,takimId));
        }
    }

    @Override
    public Optional<Futbolcu> findById(long id) {
        Futbolcu futbolcu=null;
        sql="select * from futbolcu where id="+id;
        connectionProvider.openConnection();
        try {
            PreparedStatement preparedStatement=connectionProvider.getConnection().prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();
            Long futbolcuId=resultSet.getLong("id");
            String ad=resultSet.getString("ad");
            String mevki=resultSet.getString("mevki");
            int formaNo=resultSet.getInt("forma_no");
            double deger=resultSet.getDouble("deger");
            Long takimId=resultSet.getLong("takim_id");
           futbolcu= new Futbolcu(futbolcuId,ad,mevki,formaNo,deger,takimId);
        } catch (SQLException e) {
            System.out.println("bir hata olustu "+ e.getMessage());
        }finally {
            connectionProvider.closeConnection();
        }

        return Optional.ofNullable(futbolcu);
    }

    public List<Futbolcu> findAllFutbolcuByTakimId(Long takimId){
        sql= "select * from futbolcu where takim_id="+takimId;
        connectionProvider.openConnection();
        List<Futbolcu> futbolcuList=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connectionProvider.getConnection().prepareStatement(sql);
            getFutbolcuList(preparedStatement,futbolcuList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
            return  futbolcuList;
    }

    public List<Futbolcu> findAllFutbolcuByTakimIsım(String isim){

        sql= "select * from takim inner join futbolcu on futbolcu.takim_id=takim.id  where takim.isim='"+isim+"'";
        connectionProvider.openConnection();
        List<Futbolcu> futbolcuList=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connectionProvider.getConnection().prepareStatement(sql);
            getFutbolcuList(preparedStatement,futbolcuList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  futbolcuList;
    }
}
