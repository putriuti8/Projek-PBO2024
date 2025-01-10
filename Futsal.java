class Futsal extends Lapangan {
    public Futsal(String namaLapangan) {
        super(namaLapangan);
    }

    @Override
    public double hitungBiaya(double durasi, boolean fasilitasTambahan) {
        double biaya = 120000 * durasi;
        if (fasilitasTambahan) {
            biaya += 50000;
        }
        return biaya;
    }
}