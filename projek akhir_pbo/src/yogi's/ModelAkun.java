package warnet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModelAkun {
    
    static final String DB_URL = "jdbc:mysql://localhost/warnet";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;
    
    public ModelAkun() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            statement = koneksi.createStatement();
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    
    public String[][] readData(){
        try{
            int jmlData = 0;
            
            String data[][] = new String[getJumlahData()][3];
            
            String query = "Select * from akun"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("id_akun");
                data[jmlData][1] = resultSet.getString("username");                
                data[jmlData][2] = resultSet.getString("password");
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public int getJumlahData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from akun";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public void tambahData(String username, String password) {
        int jmlData=0;
        try {
           String query = "Select * from akun WHERE username='" + username + "'";
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
            
            if (jmlData==0) {
                query = "INSERT INTO akun(username, password) VALUES('"+username+"','"+password+"')";
                
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Username "+username+" sudah ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void updateData(int id, String username, String password) {
        int jmlData=0;
        try {
           String query = "Select * from akun WHERE id_akun='" + id + "'";
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
            
            if (jmlData==1) {
                query = "UPDATE akun SET username='" + username + "', password='" + password + "' WHERE id_akun = " + id;
           
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Data dengan ID "+id+" Berhasil diupdate");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data dengan ID "+id+" tidak ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void deleteData (int id) {
        try{
            String query = "DELETE FROM akun WHERE id_akun = " + id;
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Akun dengan ID "+id+" berhasil Dihapus");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
    
}
