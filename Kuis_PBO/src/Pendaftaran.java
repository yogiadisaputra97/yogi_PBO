/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Butterfly com
 */
public class Pendaftaran extends CalonPelamar implements Seleksi {
    public static final String PILIH_WEB = "Web";
    public static final String PILIH_ANDROID = "Android";
    
    private float tulis, coding, wawancara;
    private String pilihan;

    public Pendaftaran(String nama, String nik, float tulis, float coding, float wawancara, String pilihan) {
        super(nama, nik);
        this.tulis = tulis;
        this.coding = coding;
        this.wawancara = wawancara;
        this.pilihan = pilihan;
    }
    
    public Pendaftaran(String nama, String nik, String pilihan) {
        super(nama, nik);
        this.pilihan = pilihan;
    }

    public void setTulis(float tulis) {
        this.tulis = tulis;
    }

    public void setCoding(float coding) {
        this.coding = coding;
    }

    public void setWawancara(float wawancara) {
        this.wawancara = wawancara;
    }

    public void hasil() {
        float hasil = (pilihan.equals(PILIH_ANDROID))? hitungAndroid() : hitungWeb();

        System.out.printf("Nilai Akhir : %.1f\n", hasil);
        if (hasil >= 85){
            System.out.println("KETERANGAN : LOLOS\nSelamat kepada " + super.getNama() + " telah diterima sebagai " + pilihan + "\n");
        } else {
            System.out.println("KETERANGAN : GAGAL\nMohon maaf kepada " + super.getNama() + " telah ditolak sebagai " + pilihan + "\n");
        }
    }

    @Override
    public float hitungWeb() {
        return (0.4f*tulis + 0.35f*coding + 0.25f*wawancara);
    }

    @Override
    public float hitungAndroid() {
        return (0.2f*tulis + 0.5f*coding + 0.3f*wawancara);
    }
}