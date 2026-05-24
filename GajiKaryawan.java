import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class GajiKaryawan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("===============================================");
        System.out.println("   PROGRAM PENGHITUNGAN GAJI KARYAWAN          ");
        System.out.println("===============================================");
        
        // Input Golongan
        System.out.print("Masukkan Golongan Karyawan (A/B/C): ");
        String golongan = input.nextLine().trim().toUpperCase();
        
        // Input Jam Lembur
        System.out.print("Masukkan Jumlah Jam Lembur: ");
        int jamLembur = 0;
        try {
            jamLembur = Integer.parseInt(input.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Error: Jumlah jam lembur harus berupa angka bulat!");
            input.close();
            return;
        }
        
        // Validasi Jam Lembur
        if (jamLembur < 0) {
            System.out.println("Error: Jumlah jam lembur tidak boleh negatif!");
            input.close();
            return;
        }
        
        // Hitung Gaji Pokok Berdasarkan Golongan
        long gajiPokok = 0;
        boolean golonganValid = true;
        
        if (golongan.equals("A")) {
            gajiPokok = 5000000;
        } else if (golongan.equals("B")) {
            gajiPokok = 6500000;
        } else if (golongan.equals("C")) {
            gajiPokok = 9500000;
        } else {
            golonganValid = false;
        }
        
        if (!golonganValid) {
            System.out.println("Error: Golongan tidak valid! Pilih Golongan A, B, atau C.");
            input.close();
            return;
        }
        
        // Hitung Persentase Lembur Berdasarkan Jam Lembur
        double persentaseLembur = 0;
        if (jamLembur == 1) {
            persentaseLembur = 0.30;
        } else if (jamLembur == 2) {
            persentaseLembur = 0.32;
        } else if (jamLembur == 3) {
            persentaseLembur = 0.34;
        } else if (jamLembur == 4) {
            persentaseLembur = 0.36;
        } else if (jamLembur >= 5) {
            persentaseLembur = 0.38;
        } else {
            // jamLembur == 0
            persentaseLembur = 0.00;
        }
        
        // Hitung Gaji Lembur dan Total Penghasilan
        double gajiLembur = gajiPokok * persentaseLembur;
        double totalPenghasilan = gajiPokok + gajiLembur;
        
        // Format Mata Uang Rupiah (Custom format agar universal dan tidak bergantung locale OS)
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat currencyFormat = new DecimalFormat("Rp #,###", symbols);
        
        // Tampilkan Hasil ke Layar
        System.out.println("\n===============================================");
        System.out.println("               RINCIAN PENGHASILAN             ");
        System.out.println("===============================================");
        System.out.println("Golongan Karyawan   : " + golongan);
        System.out.println("Gaji Pokok          : " + currencyFormat.format(gajiPokok));
        System.out.println("Jumlah Jam Lembur   : " + jamLembur + " Jam");
        System.out.println("Persentase Lembur   : " + (int)(persentaseLembur * 100) + "%");
        System.out.println("Gaji Lembur         : " + currencyFormat.format(gajiLembur));
        System.out.println("-----------------------------------------------");
        System.out.println("TOTAL PENGHASILAN   : " + currencyFormat.format(totalPenghasilan));
        System.out.println("===============================================");
        
        input.close();
    }
}
