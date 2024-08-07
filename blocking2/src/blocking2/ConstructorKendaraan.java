package blocking2;
public class ConstructorKendaraan {
    private String merk;
    private static String pemilik;

    protected ConstructorKendaraan() {
        merk = null;
    }

    protected ConstructorKendaraan(String merk) {
        this.merk = merk;
        merk = null;
    }

    protected void setMerk(String merk) {
        this.merk = merk;
    }

    protected String getMerk() {
        return merk;
    }

    protected static void setPemilik(String pemilik) {
        ConstructorKendaraan.pemilik = pemilik;
    }

    protected static String getPemilik() {
        return ConstructorKendaraan.pemilik;
    }

    protected void tampil(String a) {
        System.out.println(a);
        a = null;
    }

    protected void hapus() {
        merk = null;
        pemilik = null;
    }
}
