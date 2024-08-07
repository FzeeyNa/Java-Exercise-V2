package blocking2;
public class MainMatrik {
    public static void main(String[] args) {
        Matriks A = new Matriks(3, 2);
        A.setElemen(0, 0, 1); A.setElemen(0, 1, 2);
        A.setElemen(1, 0, 3); A.setElemen(1, 1, 5);
        A.setElemen(2, 0, 6); A.setElemen(2, 1, 7);

        Matriks B = new Matriks(3, 2);
        B.setElemen(0, 0, 8); B.setElemen(0, 1, 9);
        B.setElemen(1, 0, 10); B.setElemen(1, 1, 11);
        B.setElemen(2, 0, 12); B.setElemen(2, 1, 13);

        System.out.println("Matriks A:");
        A.tampilkan();
        System.out.println("\nMatriks B:");
        B.tampilkan();

        Matriks C = A.tambah(B);
        System.out.println("\nMatriks C (A + B):");
        C.tampilkan();

        C.kali(0.5);
        System.out.println("\nMatriks C setelah dikalikan 0.5:");
        C.tampilkan();
    }
}
