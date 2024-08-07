package blocking2;
public class MainConstructorMotor {
    public static void main(String args[]) {
        String pemilik = "Ahmad Afif";
        String merk = "Honda";
        String warna = "Merah";

        ConstructorKendaraan.setPemilik(pemilik);
        System.out.println("Pemilik Kendaraan = " + ConstructorKendaraan.getPemilik());

        ConstructorKendaraan ob = new ConstructorKendaraan(merk);
        ob.tampil("Merk Kendaraan = " + ob.getMerk());
        System.out.println("Pemilik Kendaraan = " + ob.getPemilik());

        ConstructorKendaraan ob2 = new ConstructorKendaraan();
        ob2.tampil("Merk Kendaraan (instant variable) = " + ob2.getMerk());
        ob2.tampil("Pemilik Kendaraan (static variable) = " + ob2.getPemilik());
        System.out.println("==========================");

        ConstructorMotor ob3 = new ConstructorMotor(merk, warna);
        ob3.tampil("Merk Motor = " + ob3.getMerk());
        ob3.tampil("Warna Motor = " + ob3.getWarna());
        ob3.tampil("Pemilik Motor = " + ob3.getPemilik());

        pemilik = null;
        merk = null;
        warna = null;
        ob.hapus();
        ob2.hapus();
        ob3.hapus();
        ob = null;
        ob2 = null;
        ob3 = null;
    }
}