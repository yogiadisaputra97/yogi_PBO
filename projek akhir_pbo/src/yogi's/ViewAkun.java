package warnet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewAkun extends JFrame {
    JLabel lId = new JLabel("ID Akun");
    JLabel lUsername = new JLabel("Username");
    JLabel lPassword = new JLabel("Password");
    
    JTextField tfId = new JTextField();
    JTextField tfUsername = new JTextField();
    JTextField tfPassword = new JTextField();
    
    JButton btnBeli = new JButton("Beli Paket");
    JButton btnTambah = new JButton("Tambah Akun");
    JButton btnUpdate = new JButton("Update Akun");
    JButton btnDelete = new JButton("Delete Akun");
    JButton btnClear = new JButton("Clear");
    
    JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    Object namaKolom[] = {"ID Akun","Username", "Password"};
    
    public ViewAkun() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Daftar Akun");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(600, 380);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 400, 300);
        
        add(lId);
        lId.setBounds(440, 20, 90, 20);
        add(tfId);
        tfId.setBounds(440, 40, 120, 20);
        tfId.setEditable(false);
        
        add(lUsername);
        lUsername.setBounds(440, 60, 90, 20);
        add(tfUsername);
        tfUsername.setBounds(440, 80, 120, 20);
        
        add(lPassword);
        lPassword.setBounds(440, 100, 90, 20);
        add(tfPassword);
        tfPassword.setBounds(440, 120, 120, 20);
        
        add(btnBeli);
        btnBeli.setBounds(440, 150, 120, 20);
        
        add(btnTambah);
        btnTambah.setBounds(440, 190, 120, 20);
        
        add(btnUpdate);
        btnUpdate.setBounds(440, 220, 120, 20);
        
        add(btnDelete);
        btnDelete.setBounds(440, 250, 120, 20);
        
        add(btnClear);
        btnClear.setBounds(440, 280, 70, 20);
    }
    
    public String getId(){
        return tfId.getText();
    }
    
    public String getUsername(){
        return tfUsername.getText();
    }
    
    public String getPassword(){
        return tfPassword.getText();
    }
}
