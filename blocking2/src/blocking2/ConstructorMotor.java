package blocking2;
public class ConstructorMotor extends ConstructorKendaraan {
    private String warna;

    protected ConstructorMotor(String merk, String warna) {
        super(merk);
        this.warna = warna;
        merk = null;
        warna = null;
    }

    protected String getWarna() {
        return warna;
    }

    protected void hapus() {
        warna = null;
        super.hapus();
    }
}