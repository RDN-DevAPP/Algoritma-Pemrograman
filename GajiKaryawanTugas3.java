import java.util.Scanner;

public class GajiKaryawan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1. Deklarasi Array untuk Gaji Pokok dan Persentase Lembur
        // Gaji: Indeks 0 = Golongan A, Indeks 1 = Golongan B, Indeks 2 = Golongan C
        double[] arrayGaji = {5000000, 6500000, 9500000}; 
        
        // Persen Lembur: Indeks 0 = 1 Jam, Indeks 1 = 2 Jam, dst (>= 5 Jam di Indeks 4)
        int[] arrayPersenLembur = {30, 32, 34, 36, 38};

        // Variabel bantuan untuk output
        double gajiPokok = 0;
        double gajiLembur = 0;
        double totalPenghasilan = 0;

        // 2. Input Data Karyawan
        System.out.println("=== Program Hitung Gaji Karyawan ===");
        System.out.print("Masukkan Golongan Karyawan (A/B/C): ");
        String golongan = input.nextLine().toUpperCase(); // Mengubah ke huruf kapital

        System.out.print("Masukkan Jam Lembur: ");
        int jamLembur = input.nextInt();

        // 3. Menentukan Gaji Pokok dari Array menggunakan statemen IF
        if (golongan.equals("A")) {
            gajiPokok = arrayGaji[0];
        } else if (golongan.equals("B")) {
            gajiPokok = arrayGaji[1];
        } else if (golongan.equals("C")) {
            gajiPokok = arrayGaji[2];
        } else {
            System.out.println("Error: Golongan tidak valid! Silakan masukkan A, B, atau C.");
            System.exit(0); // Menghentikan eksekusi program jika golongan salah
        }

        // 4. Menentukan Gaji Lembur dari Array Persen menggunakan statemen IF
        if (jamLembur == 1) {
            gajiLembur = gajiPokok * (arrayPersenLembur[0] / 100.0);
        } else if (jamLembur == 2) {
            gajiLembur = gajiPokok * (arrayPersenLembur[1] / 100.0);
        } else if (jamLembur == 3) {
            gajiLembur = gajiPokok * (arrayPersenLembur[2] / 100.0);
        } else if (jamLembur == 4) {
            gajiLembur = gajiPokok * (arrayPersenLembur[3] / 100.0);
        } else if (jamLembur >= 5) {
            gajiLembur = gajiPokok * (arrayPersenLembur[4] / 100.0);
        } else {
            gajiLembur = 0; // Jika tidak lembur (0 jam) atau input negatif
        }

        // 5. Perhitungan Total Penghasilan dengan Operator Penjumlahan (+)
        totalPenghasilan = gajiPokok + gajiLembur;

        // 6. Output / Tampilan ke Layar
        System.out.println("\n=== Rincian Penghasilan ===");
        System.out.println("Golongan         : " + golongan);
        System.out.println("Jam Lembur       : " + jamLembur + " jam");
        System.out.printf("Gaji Pokok       : Rp. %.0f\n", gajiPokok);
        System.out.printf("Gaji Lembur      : Rp. %.0f\n", gajiLembur);
        System.out.println("--------------------------------- +");
        System.out.printf("Total Penghasilan: Rp. %.0f\n", totalPenghasilan);

        input.close();
    }
}