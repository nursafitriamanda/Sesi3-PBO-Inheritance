/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas;

/**
 *
 * @author Lenovo
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Mahasiswa> mahasiswas = new ArrayList<>();

       
        System.out.println("Masukkan jumlah mahasiswa: ");
        int jumlahMahasiswa = scanner.nextInt();
        scanner.nextLine(); // consume newline
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("Masukkan NIM mahasiswa ke-" + (i + 1) + ": ");
            String nim = scanner.nextLine();
            System.out.println("Masukkan nama mahasiswa ke-" + (i + 1) + ": ");
            String nama = scanner.nextLine();
            System.out.println("Masukkan nilai mahasiswa ke-" + (i + 1) + ": ");
            int nilai = scanner.nextInt();
            scanner.nextLine(); // consume newline
            mahasiswas.add(new Mahasiswa(nim, nama, nilai));
        }

        
        System.out.println("=========================================================================");
        for (Mahasiswa mahasiswa : mahasiswas) {
            System.out.println("NIM : " + mahasiswa.nim);
            System.out.println("Nama: " + mahasiswa.nama);
            System.out.println("Nilai : " + mahasiswa.nilai);
            System.out.println("Grade: " + mahasiswa.getGrade());
            System.out.println("=========================================================================");
        }

        
        int jumlahLulus = 0;
        int jumlahTidakLulus = 0;
        int[] jumlahGrade = new int[5]; // A, B, C, D, E
        int totalNilai = 0;

        for (Mahasiswa mahasiswa : mahasiswas) {
            totalNilai += mahasiswa.nilai;
            String grade = mahasiswa.getGrade();
            if (!grade.equals("D") && !grade.equals("E")) {
                jumlahLulus++;
            } else {
                jumlahTidakLulus++;
            }
            if (grade.equals("A")) {
                jumlahGrade[0]++;
            } else if (grade.equals("B")) {
                jumlahGrade[1]++;
            } else if (grade.equals("C")) {
                jumlahGrade[2]++;
            } else if (grade.equals("D")) {
                jumlahGrade[3]++;
            } else {
                jumlahGrade[4]++;
            }
        }

        
        System.out.println("Jumlah Mahasiswa : " + jumlahMahasiswa);
        System.out.println("Jumlah Mahasiswa yang Lulus : " + jumlahLulus + " yaitu " + getMahasiswaByLulus(mahasiswas));
        System.out.println("Jumlah Mahasiswa yang Tidak Lulus: " + jumlahTidakLulus + " yaitu " + getMahasiswaByTidakLulus(mahasiswas));

        
        char grade = 'A';
        for (int i = 0; i < jumlahGrade.length; i++) {
            if (jumlahGrade[i] > 0) {
                System.out.println("Jumlah Mahasiswa dengan Nilai " + grade + " = " + jumlahGrade[i] + " yaitu " + getMahasiswaByGrade(mahasiswas, String.valueOf(grade)));
            }
            grade++;
        }

        // rata-rata 
        System.out.print("Rata-rata nilai mahasiswa adalah:");
        for (Mahasiswa mahasiswa : mahasiswas) {
            System.out.print(mahasiswa.nilai + "+");
        }
        System.out.println("/" + jumlahMahasiswa + " = " + (double) totalNilai / jumlahMahasiswa);
    }
    
    
    private static String getMahasiswaByGrade(List<Mahasiswa> mahasiswas, String grade) {
        StringBuilder result = new StringBuilder();
        for (Mahasiswa m : mahasiswas) {
            if (m.getGrade().equals(grade)) {
                result.append(m.nama).append(", ");
            }
        }
        if (result.length() > 0) {
            result.delete(result.length() - 2, result.length());
        }
        return result.toString();
    }

   
    private static String getMahasiswaByLulus(List<Mahasiswa> mahasiswas) {
        StringBuilder result = new StringBuilder();
        for (Mahasiswa m : mahasiswas) {
            if (!m.getGrade().equals("D") && !m.getGrade().equals("E")) {
                result.append(m.nama).append(", ");
            }
        }
        if (result.length() > 0) {
            result.delete(result.length() - 2, result.length());
        }
        return result.toString();
    }

    
    private static String getMahasiswaByTidakLulus(List<Mahasiswa> mahasiswas) {
        StringBuilder result = new StringBuilder();
        for (Mahasiswa m : mahasiswas) {
            if (m.getGrade().equals("D") || m.getGrade().equals("E")) {
                result.append(m.nama).append(", ");
            }
        }
        if (result.length() > 0) {
            result.delete(result.length() - 2, result.length());
        }
        return result.toString();
    }
}
