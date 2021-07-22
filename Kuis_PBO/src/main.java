
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Butterfly com
 */
public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            int pilih;

                System.out.println("\nFORM PENDAFTARAN PT.UDIN");
                System.out.println("1. Android Development");
                System.out.println("2. Web Development");
                System.out.print("Pilih Jenis Form : ");

                pilih = input.nextInt();
               
                switch (pilih){
                    case 1:
                        pendaftaran(Pendaftaran.PILIH_ANDROID);
                        break;
                    case 2:
                        pendaftaran(Pendaftaran.PILIH_WEB);
                        break;

                    default:
                        System.out.println("Opsi tidak ada");
                }
        }
    }
    
    private static void pendaftaran(String pilihan) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("\nFORM PENDAFTARAN");
            
            System.out.print("\nInput NIK : "); String nik = input.next();
            System.out.print("Input Nama : ");
            input = new Scanner(System.in); String nama = input.nextLine();

            System.out.print("Input Nilai Tes Tulis : "); float tulis = input.nextFloat();
            System.out.print("Input Nilai Tes Coding : "); float coding = input.nextFloat();
            System.out.print("Input Nilai Tes Wawancara : "); float wawancara = input.nextFloat();

            Pendaftaran calon = new Pendaftaran(nama,nik,tulis,coding,wawancara,pilihan);
            menu(calon);
        } catch (InputMismatchException e){
            System.err.println(e.getMessage() + ", tidak boleh huruf\n");
        }
    }
    
    private static void menu(Pendaftaran calon){
        Scanner input = new Scanner(System.in);
        do{
            try {
                System.out.println("Menu");
                System.out.println("1. Edit");
                System.out.println("2. Tampil");
                System.out.println("3. Exit");
                System.out.print("Pilih :");
                int menu = input.nextInt();
                switch (menu){
                    case 1:
                        edit(calon);
                        break;
                    case 2:
                        calon.hasil();
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Opsi tidak ada");
                }

            } catch(InputMismatchException e){
                System.err.println(e.getMessage() + ", tidak boleh huruf\n");
            }
        }while(true);
    }
    private static void edit(Pendaftaran calon) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("\nFORM EDIT");

            System.out.print("Input Nilai Tes Tulis : "); float tulis = input.nextFloat();
            System.out.print("Input Nilai Tes Coding : "); float coding = input.nextFloat();
            System.out.print("Input Nilai Tes Wawancara : "); float wawancara = input.nextFloat();

            calon.setTulis(tulis);
            calon.setCoding(coding);
            calon.setWawancara(wawancara);
        } catch (InputMismatchException e){
            System.err.println(e.getMessage() + ", tidak boleh huruf\n");
        }
    }
}
