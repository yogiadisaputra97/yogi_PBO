package warnet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ControllerAkun {
    ViewAkun viewAkunn;
    ModelAkun modelAkunn;
    
    public ControllerAkun(ViewAkun viewAkun, ModelAkun modelAkun) {
        this.viewAkunn = viewAkun;
        this.modelAkunn = modelAkun;
        
        if (modelAkunn.getJumlahData()!=0) {
            String data[][] = modelAkunn.readData();
            viewAkunn.tabel.setModel((new JTable(data, viewAkunn.namaKolom)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Data Akun Kosong");
        }
        
        viewAkunn.btnBeli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    int id = Integer.parseInt(viewAkunn.getId());
                    ViewTransaksi viewTransaksi = new ViewTransaksi();
                    ModelTransaksi modelTransaksi = new ModelTransaksi(id);
                    ControllerTransaksi controllerTransaksi = new ControllerTransaksi(viewTransaksi, modelTransaksi);
                } catch(NumberFormatException nfexception) {
                    JOptionPane.showMessageDialog(null, "Input tidak boleh kosong");
                }
            }
        });
        
        viewAkunn.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String username = viewAkunn.getUsername();
                    String password = viewAkunn.getPassword();
                    modelAkunn.tambahData(username, password);

                    String data[][] = modelAkunn.readData();
                    viewAkunn.tabel.setModel((new JTable(data, viewAkunn.namaKolom)).getModel());
                } catch(NumberFormatException nfexception) {
                    JOptionPane.showMessageDialog(null, "Input tidak boleh kosong");
                }
            }
        });
        
        viewAkunn.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    int id = Integer.parseInt(viewAkunn.getId());
                    String username = viewAkunn.getUsername();
                    String password = viewAkunn.getPassword();

                    int input = JOptionPane.showConfirmDialog(null,
                            "Update akun dengan ID " + id + "?", "Pilih", JOptionPane.YES_NO_OPTION);

                    if (input == 0) {
                        modelAkunn.updateData(id, username, password);

                        String data[][] = modelAkunn.readData();
                        viewAkunn.tabel.setModel((new JTable(data, viewAkunn.namaKolom)).getModel());
                    }
                } catch(NumberFormatException nfexception) {
                    JOptionPane.showMessageDialog(null, "Input tidak boleh kosong");
                }
            }
        });
        
        viewAkunn.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    int id = Integer.parseInt(viewAkunn.getId());

                    int input = JOptionPane.showConfirmDialog(null,
                            "Hapus akun dengan ID " + id + "?", "Pilih", JOptionPane.YES_NO_OPTION);

                    if (input == 0) {
                        modelAkunn.deleteData(id);

                        String data[][] = modelAkunn.readData();
                        viewAkunn.tabel.setModel((new JTable(data, viewAkunn.namaKolom)).getModel());
                    }
                } catch(NumberFormatException nfexception) {
                    JOptionPane.showMessageDialog(null, "Input tidak boleh kosong");
                }
            }
        });
        
        viewAkunn.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = viewAkunn.tabel.getSelectedRow();

                String id = viewAkunn.tabel.getValueAt(baris, 0).toString();
                String username = viewAkunn.tabel.getValueAt(baris, 1).toString();
                String password = viewAkunn.tabel.getValueAt(baris, 2).toString();
                
                viewAkunn.tfId.setText(id);
                viewAkunn.tfUsername.setText(username);
                viewAkunn.tfPassword.setText(password);
            }
        });
        
         viewAkunn.btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                viewAkunn.tfId.setText("");
                viewAkunn.tfUsername.setText("");
                viewAkunn.tfPassword.setText("");
            }
        });
        
    }
    
}
