package blocking2;

public class Kendaraan {
    private String merk, warna;
    protected String namaClass = "Kendaraan";

    protected void setMerk(String merk) {
        this.merk = merk;
        merk = null;
    }

    protected String getMerk() {
        return merk;
    }

    protected void setWarna(String warna) {
        this.warna = warna;
        warna = null;
    }

    protected String getWarna() {
        return warna;
    }

    protected void tampil(String a) {
        System.out.println(a);
        a = null;
    }

    protected String keterangan() {
        return ("Ini adalah class " + namaClass);
    }

    protected void hapus() {
        warna = null;
        merk = null;
        namaClass = null;
    }
}
