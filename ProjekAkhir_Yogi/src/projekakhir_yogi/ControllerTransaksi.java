package warnet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ControllerTransaksi {
    ViewTransaksi viewTransaksii;
    ModelTransaksi modelTransaksii;
    
    public ControllerTransaksi(ViewTransaksi viewTransaksi, ModelTransaksi modelTransaksi) {
        this.viewTransaksii = viewTransaksi;
        this.modelTransaksii = modelTransaksi;
        
        setDurasiHarga();
        if (modelTransaksii.getJumlahData()!=0) {
            String data[][] = modelTransaksii.readData();
            viewTransaksii.tabel.setModel((new JTable(data, viewTransaksii.namaKolom)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Data Transaksi Kosong");
        }
        
        viewTransaksii.cbPaket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDurasiHarga();
            }
        });
        
        viewTransaksii.sJumlah.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                setDurasiHarga();
            }
        });
        
        viewTransaksii.btnBeli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String paket = viewTransaksii.getPaket();
                    int jumlah = Integer.parseInt(viewTransaksii.getJumlah());
                    int bayar = Integer.parseInt(viewTransaksii.getBayar());
                    int durasi = Integer.parseInt(viewTransaksii.getDurasi());
                    modelTransaksii.tambahData(paket, jumlah, bayar, durasi);

                    String data[][] = modelTransaksii.readData();
                    viewTransaksii.tabel.setModel((new JTable(data, viewTransaksii.namaKolom)).getModel());
                } catch(NumberFormatException nfexception) {
                    JOptionPane.showMessageDialog(null, "Input tidak boleh kosong");
                }
            }
        });
        
         viewTransaksii.btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                viewTransaksii.tfBayar.setText("");
                viewTransaksii.tfDurasi.setText("");
            }
        });
        
    }
    
    public void setDurasiHarga() {
        try {
            String paket = viewTransaksii.getPaket();
            int jumlah = Integer.parseInt(viewTransaksii.getJumlah());

            if(paket=="Paket 1") {
                viewTransaksii.tfBayar.setText(""+5000*jumlah);
                viewTransaksii.tfDurasi.setText(""+2*jumlah);
            }
            else if(paket=="Paket 2") {
                viewTransaksii.tfBayar.setText(""+8000*jumlah);
                viewTransaksii.tfDurasi.setText(""+3*jumlah);
            }
            else if(paket=="Paket 3") {
                viewTransaksii.tfBayar.setText(""+10000*jumlah);
                viewTransaksii.tfDurasi.setText(""+4*jumlah);
            }
        } catch(NumberFormatException nfexception) {
            JOptionPane.showMessageDialog(null, "Input tidak boleh kosong");
        }
   }
    
}
