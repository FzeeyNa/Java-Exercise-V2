package blocking2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Universitas {
    private static String namaUniversitas;

    public static void setNamaUniversitas(String nama) {
        namaUniversitas = nama;
    }

    public static String getNamaUniversitas() {
        return namaUniversitas;
    }
}

class Orang {
    protected String nama;
    protected String alamat;

    public Orang(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }
}

class Mahasiswa extends Orang {
    private String nim;
    private String jurusan;

    public Mahasiswa(String nim, String nama, String alamat, String jurusan) {
        super(nama, alamat);
        this.nim = nim;
        this.jurusan = jurusan;
    }

    @Override
    public String toString() {
        return "NIM: " + nim + ", Nama: " + nama + ", Alamat: " + alamat + ", Jurusan: " + getJurusanLengkap();
    }

    private String getJurusanLengkap() {
        switch (jurusan) {
            case "61": return "MATEMATIKA";
            case "62": return "BIOLOGI";
            case "63": return "KIMIA";
            case "64": return "FISIKA";
            case "65": return "TEKNIK INFORMATIKA";
            case "66": return "TEKNIK ARSITEKTUR";
            default: return "TIDAK DIKETAHUI";
        }
    }
}

public class AplikasiDataMahasiswa extends JFrame {
    private ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    private JTextField tfNamaUniv, tfNIM, tfNama, tfAlamat;
    private JComboBox<String> cbJurusan;
    private JTextArea taDaftarMahasiswa;
    private JList<String> listMahasiswa;
    private DefaultListModel<String> listModel;

    public AplikasiDataMahasiswa() {
        setTitle("Aplikasi Data Mahasiswa");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelUniv = new JPanel();
        panelUniv.add(new JLabel("Nama Universitas:"));
        tfNamaUniv = new JTextField(20);
        panelUniv.add(tfNamaUniv);
        JButton btnSetUniv = new JButton("Set");
        btnSetUniv.addActionListener(e -> Universitas.setNamaUniversitas(tfNamaUniv.getText()));
        panelUniv.add(btnSetUniv);
        add(panelUniv, BorderLayout.NORTH);

        JPanel panelInput = new JPanel(new GridLayout(6, 2));
        panelInput.add(new JLabel("NIM:"));
        tfNIM = new JTextField();
        panelInput.add(tfNIM);
        panelInput.add(new JLabel("Nama:"));
        tfNama = new JTextField();
        panelInput.add(tfNama);
        panelInput.add(new JLabel("Alamat:"));
        tfAlamat = new JTextField();
        panelInput.add(tfAlamat);
        panelInput.add(new JLabel("Jurusan:"));
        String[] jurusan = {"61 - MATEMATIKA", "62 - BIOLOGI", "63 - KIMIA", "64 - FISIKA", "65 - TEKNIK INFORMATIKA", "66 - TEKNIK ARSITEKTUR"};
        cbJurusan = new JComboBox<>(jurusan);
        panelInput.add(cbJurusan);

        JButton btnTambah = new JButton("Tambah Mahasiswa");
        btnTambah.addActionListener(e -> tambahMahasiswa());
        panelInput.add(btnTambah);

        JButton btnLihatData = new JButton("Lihat Data Mahasiswa");
        btnLihatData.addActionListener(e -> lihatDataMahasiswa());
        panelInput.add(btnLihatData);

        add(panelInput, BorderLayout.CENTER);

        listModel = new DefaultListModel<>();
        listMahasiswa = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listMahasiswa);
        add(scrollPane, BorderLayout.SOUTH);
    }

    private void tambahMahasiswa() {
        String nim = tfNIM.getText();
        String nama = tfNama.getText();
        String alamat = tfAlamat.getText();
        String jurusan = ((String)cbJurusan.getSelectedItem()).substring(0, 2);

        Mahasiswa mahasiswa = new Mahasiswa(nim, nama, alamat, jurusan);
        daftarMahasiswa.add(mahasiswa);

        updateListMahasiswa();
        bersihkanForm();
    }

    private void updateListMahasiswa() {
        listModel.clear();
        for (Mahasiswa mahasiswa : daftarMahasiswa) {
            listModel.addElement(mahasiswa.toString());
        }
    }

    private void bersihkanForm() {
        tfNIM.setText("");
        tfNama.setText("");
        tfAlamat.setText("");
        cbJurusan.setSelectedIndex(0);
    }

    private void lihatDataMahasiswa() {
        int selectedIndex = listMahasiswa.getSelectedIndex();
        if (selectedIndex != -1) {
            Mahasiswa mahasiswa = daftarMahasiswa.get(selectedIndex);
            JOptionPane.showMessageDialog(this,
                "Detail Mahasiswa:\n" + mahasiswa.toString(),
                "Data Mahasiswa",
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                "Pilih mahasiswa terlebih dahulu!",
                "Peringatan",
                JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AplikasiDataMahasiswa app = new AplikasiDataMahasiswa();
            app.setVisible(true);
        });
    }
}