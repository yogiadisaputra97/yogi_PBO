import java.util.Scanner; // import scanner untuk inputannya

public class Biodata_biasa {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in); //object scanner baru
        
        String nama, nim, jenisKelamin, alamat, nope, def="Masukan "; //variabel
        
        System.out.println("|     Contoh Program Java BIODATA         |");
        System.out.println("===========================================");
        
        System.out.print(def + "Nama \t\t: " );
        nama = input.nextLine(); //memberikan nilai variabel dg menyimpan inputan dari user
        System.out.print(def + "NIM \t\t: " );
        nim = input.nextLine();
        System.out.print(def + "Jenis Kelamin \t: " );
        jenisKelamin = input.nextLine();
        System.out.print(def + "Alamat \t\t: " );
        alamat = input.nextLine();
        System.out.print(def + "Nomor Handphone\t: " );
        nope = input.nextLine();

        System.out.println("");
        
        // Tampilkan datanya 
        System.out.println("+------------------------------------------+");
        System.out.println("|          Data Biodata Mahasiswa          |");
        System.out.println("+------------------------------------------+");
        System.out.println("| Nama\t\t: " + nama);
        System.out.println("| NIM\t\t: " + nim);
        System.out.println("| Jenis Kelamin\t: " + jenisKelamin);
        System.out.println("| Alamat\t: " + alamat);
        System.out.println("| Nomor HP\t: " + nope);
        System.out.println("+------------------------------------------+");
    }
}