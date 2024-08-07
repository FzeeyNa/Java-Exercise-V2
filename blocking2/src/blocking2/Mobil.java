package blocking2;

public class Mobil extends Kendaraan {
    private long harga;
    protected String namaClass = "Mobil";

    protected void setHarga(String harga) {
        this.harga = Long.parseLong(harga);
        harga = null;
    }

    protected long getHarga() {
        return harga;
    }

    protected String keterangan() {
        return (namaClass + " : Ini adalah class " + namaClass);
    }

    public String keterangan_Kendaraan() {
        return super.namaClass + " : " + super.keterangan();
    }

    protected void hapus() {
        harga = 0;
        super.hapus();
    }
}
