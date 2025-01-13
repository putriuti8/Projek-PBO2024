# Projek-PBO2024
Projek Aplikasi Pengelola  Booking Lapangan Olahraga
# Aplikasi Pengelola Booking Lapangan Olahraga

Aplikasi ini adalah sistem pemesanan lapangan olahraga berbasis Java yang dirancang menggunakan konsep **Object-Oriented Programming (OOP)**. Aplikasi ini memungkinkan pengguna untuk memesan lapangan futsal, badminton, atau basket dengan perhitungan biaya otomatis, jadwal pemesanan, dan pencatatan data ke file.

## Fitur Utama
- Pemesanan lapangan olahraga: **Futsal**, **Badminton**, dan **Basket**.
- Perhitungan biaya berdasarkan durasi dan fasilitas tambahan.
- Validasi jadwal untuk menghindari konflik pemesanan.
- Pembuatan struk pemesanan yang disimpan ke file `pesanan.txt`.
- Antarmuka berbasis **GUI (Graphical User Interface)** dengan komponen dari Swing.

## Struktur Program
- **`Lapangan`**: Abstract class yang mendefinisikan struktur dasar lapangan olahraga.
- **`Futsal`**, **`Badminton`**, dan **`Basket`**: Subclass dari `Lapangan` dengan perhitungan biaya masing-masing.
- **`LapanganGUI`**: Kelas utama yang menangani antarmuka pengguna dan logika pemesanan.

## Teknologi yang Digunakan
- **Java Swing** untuk antarmuka pengguna.
- **File I/O** untuk penyimpanan data pemesanan.
- **OOP (Inheritance dan Polymorphism)** untuk struktur program yang modular.

## Cara Menjalankan Aplikasi
1. Pastikan Anda memiliki **Java Development Kit (JDK)** terinstal di komputer Anda.
2. Salin kode program ke dalam file dengan nama `LapanganGUI.java`.
3. Buka terminal atau command prompt, lalu navigasikan ke direktori tempat file disimpan.
4. Kompilasi program:
   ```bash
   javac LapanganGUI.java
