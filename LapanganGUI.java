import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LapanganGUI {

    // Jadwal untuk menyimpan informasi booking
    private static final Map<String, String> jadwal = new HashMap<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pemesanan Lapangan");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));

        JLabel nameLabel = new JLabel("Nama Penyewa:");
        JTextField nameField = new JTextField();

        JLabel contactLabel = new JLabel("Kontak Penyewa:");
        JTextField contactField = new JTextField();

        JLabel competitionLabel = new JLabel("Nama Kompetisi:");
        JTextField competitionField = new JTextField();

        JLabel fieldLabel = new JLabel("Pilih Lapangan:");
        String[] fields = {"Futsal", "Badminton", "Basket"};
        JComboBox<String> fieldCombo = new JComboBox<>(fields);

        JLabel dateLabel = new JLabel("Tanggal (YYYY-MM-DD):");
        JTextField dateField = new JTextField();

        JLabel startTimeLabel = new JLabel("Waktu Mulai (HH:mm):");
        JTextField startTimeField = new JTextField();

        JLabel durationLabel = new JLabel("Durasi (jam):");
        JTextField durationField = new JTextField();

        JLabel facilityLabel = new JLabel("Fasilitas Tambahan:");
        JCheckBox facilityCheckBox = new JCheckBox("Ya");

        JButton submitButton = new JButton("Pesan");

        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = nameField.getText();
                String kontak = contactField.getText();
                String namaKompetisi = competitionField.getText();
                String lapanganDipilih = (String) fieldCombo.getSelectedItem();
                String tanggal = dateField.getText();
                String waktuMulai = startTimeField.getText();
                double durasi;
                try {
                    durasi = Double.parseDouble(durationField.getText());
                } catch (NumberFormatException ex) {
                    outputArea.setText("Durasi harus berupa angka.");
                    return;
                }
                boolean fasilitasTambahan = facilityCheckBox.isSelected();

                // Validasi jadwal
                String jadwalKey = lapanganDipilih + "-" + tanggal + " " + waktuMulai;
                if (jadwal.containsKey(jadwalKey)) {
                    outputArea.setText("Jadwal lapangan sudah dipesan pada waktu ini.");
                    return;
                }

                Lapangan lapangan;
                if (lapanganDipilih.equals("Futsal")) {
                    lapangan = new Futsal("Lapangan Futsal");
                } else if (lapanganDipilih.equals("Badminton")) {
                    lapangan = new Badminton("Lapangan Badminton");
                } else {
                    lapangan = new Basket("Lapangan Basket");
                }

                double totalBiaya = lapangan.hitungBiaya(durasi, fasilitasTambahan);

                String struk = "--- STRUK PEMESANAN ---\n" +
                        "Nama Penyewa: " + nama + "\n" +
                        "Kontak Penyewa: " + kontak + "\n" +
                        "Nama Kompetisi: " + namaKompetisi + "\n" +
                        "Lapangan: " + lapangan.getNamaLapangan() + "\n" +
                        "Tanggal: " + tanggal + "\n" +
                        "Waktu Mulai: " + waktuMulai + "\n" +
                        "Durasi: " + durasi + " jam\n" +
                        "Fasilitas Tambahan: " + (fasilitasTambahan ? "Ya" : "Tidak") + "\n" +
                        "Total Biaya: Rp" + totalBiaya + "\n";

                // Simpan ke jadwal dan tampilkan struk jika tidak bentrok
                jadwal.put(jadwalKey, struk);
                outputArea.setText(struk);

                // Simpan ke file
                try (FileWriter writer = new FileWriter("pesanan.txt", true)) {
                    writer.write(struk + "\n");
                    outputArea.append("\nStruk berhasil disimpan ke pesanan.txt\n");
                } catch (IOException ex) {
                    outputArea.append("\nGagal menyimpan struk ke file: " + ex.getMessage());
                }
            }
        });

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(contactLabel);
        panel.add(contactField);
        panel.add(competitionLabel);
        panel.add(competitionField);
        panel.add(fieldLabel);
        panel.add(fieldCombo);
        panel.add(dateLabel);
        panel.add(dateField);
        panel.add(startTimeLabel);
        panel.add(startTimeField);
        panel.add(durationLabel);
        panel.add(durationField);
        panel.add(facilityLabel);
        panel.add(facilityCheckBox);
        panel.add(submitButton);
        panel.add(new JLabel());

        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
