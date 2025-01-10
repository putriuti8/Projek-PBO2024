class Badminton extends Lapangan {
    public Badminton(String namaLapangan) {
        super(namaLapangan);
    }

    @Override
    public double hitungBiaya(double durasi, boolean fasilitasTambahan) {
        double biaya = 80000 * durasi;
        if (fasilitasTambahan) {
            biaya += 30000;
        }
        return biaya;
    }
}