abstract class Lapangan {
    protected String namaLapangan;

    public Lapangan(String namaLapangan) {
        this.namaLapangan = namaLapangan;
    }

    public abstract double hitungBiaya(double durasi, boolean fasilitasTambahan);

    public String getNamaLapangan() {
        return namaLapangan;
    }
}
