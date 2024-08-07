package blocking2;
public class Matriks {
    private double[][] data;

    public Matriks(int baris, int kolom) {
        data = new double[baris][kolom];
    }

    public void setElemen(int baris, int kolom, double nilai) {
        data[baris][kolom] = nilai;
    }

    public double getElemen(int baris, int kolom) {
        return data[baris][kolom];
    }

    public Matriks tambah(Matriks lain) {
        Matriks hasil = new Matriks(data.length, data[0].length);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                hasil.setElemen(i, j, this.getElemen(i, j) + lain.getElemen(i, j));
            }
        }
        return hasil;
    }

    public void kali(double skalar) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                setElemen(i, j, getElemen(i, j) * skalar);
            }
        }
    }

    public void tampilkan() {
        for (double[] baris : data) {
            for (double elemen : baris) {
                System.out.print(elemen + " ");
            }
            System.out.println();
        }
    }
}
