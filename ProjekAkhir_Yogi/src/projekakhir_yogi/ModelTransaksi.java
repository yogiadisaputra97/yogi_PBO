package warnet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModelTransaksi {
    
    static final String DB_URL = "jdbc:mysql://localhost/warnet";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;
    int id;
    
    public ModelTransaksi(int id) {
        this.id = id;
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
            
            String data[][] = new String[getJumlahData()][5];
            
            String query = "Select id_transaksi, paket, jumlah, total_bayar, total_durasi from transaksi WHERE id_akun = " + id; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("id_transaksi");
                data[jmlData][1] = resultSet.getString("paket");                
                data[jmlData][2] = resultSet.getString("jumlah");
                data[jmlData][3] = resultSet.getString("total_bayar");
                data[jmlData][4] = resultSet.getString("total_durasi");
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
            String query = "Select * from transaksi WHERE id_akun = " + id;
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
    
    public void tambahData(String paket, int jumlah, int bayar, int durasi) {
        try {
            String query = "INSERT INTO transaksi(id_akun, paket, jumlah, total_bayar, total_durasi) VALUES("+id+",'"+paket+"',"+jumlah+","+bayar+","+durasi+")";
            
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
}
