package warnet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewTransaksi extends JFrame {
    JLabel lPaket = new JLabel("Paket");
    JLabel lJumlah = new JLabel("Jumlah Paket");
    JLabel lBayar = new JLabel("Total Harga");
    JLabel lDurasi = new JLabel("Total Durasi");
    
    String paket[] = {"Paket 1","Paket 2","Paket 3"};
    JComboBox cbPaket = new JComboBox(paket);
    SpinnerModel jumlah = new SpinnerNumberModel(1,1,10,1);
    JSpinner sJumlah = new JSpinner(jumlah);
    JTextField tfBayar = new JTextField();
    JTextField tfDurasi = new JTextField();
    
    JButton btnBeli = new JButton("Beli Paket");
    JButton btnClear = new JButton("Clear");
    
    JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    Object namaKolom[] = {"ID Transaksi","Paket", "Jumlah", "Total Harga", "Total Durasi"};
    
    public ViewTransaksi() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Daftar Transaksi");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(600, 380);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 400, 300);
        
        add(lPaket);
        lPaket.setBounds(440, 20, 90, 20);
        add(cbPaket);
        cbPaket.setBounds(440, 40, 120, 20);
        
        add(lJumlah);
        lJumlah.setBounds(440, 60, 90, 20);
        add(sJumlah);
        sJumlah.setBounds(440, 80, 120, 20);
        
        add(lDurasi);
        lDurasi.setBounds(440, 100, 90, 20);
        add(tfDurasi);
        tfDurasi.setBounds(440, 120, 120, 20);
        tfDurasi.setEditable(false);
        
        add(lBayar);
        lBayar.setBounds(440, 140, 90, 20);
        add(tfBayar);
        tfBayar.setBounds(440, 160, 120, 20);
        tfBayar.setEditable(false);
        
        add(btnBeli);
        btnBeli.setBounds(440, 250, 120, 20);
        
        add(btnClear);
        btnClear.setBounds(440, 280, 70, 20);
    }
    
    public String getPaket(){
        return cbPaket.getSelectedItem().toString();
    }
    
    public String getJumlah(){
        return sJumlah.getValue().toString();
    }
    
    public String getBayar(){
        return tfBayar.getText();
    }
    
    public String getDurasi(){
        return tfDurasi.getText();
    }
}
