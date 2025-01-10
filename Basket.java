class Basket extends Lapangan {
    public Basket(String namaLapangan) {
        super(namaLapangan);
    }

    @Override
    public double hitungBiaya(double durasi, boolean fasilitasTambahan) {
        double biaya = 100000 * durasi;
        if (fasilitasTambahan) {
            biaya += 50000;
        }
        return biaya;
    }
}