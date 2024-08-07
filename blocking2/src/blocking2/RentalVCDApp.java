package blocking2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class VCD {
    protected String judul;
    protected String aktor;
    protected String sutradara;
    protected String publisher;
    protected String kategori;
    protected int stok;

    public VCD(String judul, String aktor, String sutradara, String publisher, String kategori, int stok) {
        this.judul = judul;
        this.aktor = aktor;
        this.sutradara = sutradara;
        this.publisher = publisher;
        this.kategori = kategori;
        this.stok = stok;
    }

    public String toString() {
        return "Judul: " + judul + ", Aktor: " + aktor + ", Sutradara: " + sutradara +
               ", Publisher: " + publisher + ", Kategori: " + kategori + ", Stok: " + stok;
    }
}

class FilmVCD extends VCD {
    public FilmVCD(String judul, String aktor, String sutradara, String publisher, String kategori, int stok) {
        super(judul, aktor, sutradara, publisher, kategori, stok);
    }
}

public class RentalVCDApp extends JFrame {
    private ArrayList<FilmVCD> daftarVCD = new ArrayList<>();
    private JTextField tfJudul, tfAktor, tfSutradara, tfPublisher, tfStok;
    private JComboBox<String> cbKategori;
    private JTextArea taDaftarVCD;

    public RentalVCDApp() {
        setTitle("Aplikasi Rental VCD");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(7, 2));
        inputPanel.add(new JLabel("Judul:"));
        tfJudul = new JTextField();
        inputPanel.add(tfJudul);
        inputPanel.add(new JLabel("Aktor:"));
        tfAktor = new JTextField();
        inputPanel.add(tfAktor);
        inputPanel.add(new JLabel("Sutradara:"));
        tfSutradara = new JTextField();
        inputPanel.add(tfSutradara);
        inputPanel.add(new JLabel("Publisher:"));
        tfPublisher = new JTextField();
        inputPanel.add(tfPublisher);
        inputPanel.add(new JLabel("Kategori:"));
        String[] kategori = {"SU", "D", "R", "A"};
        cbKategori = new JComboBox<>(kategori);
        inputPanel.add(cbKategori);
        inputPanel.add(new JLabel("Stok:"));
        tfStok = new JTextField();
        inputPanel.add(tfStok);

        JButton btnTambah = new JButton("Tambah VCD");
        btnTambah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tambahVCD();
            }
        });
        inputPanel.add(btnTambah);

        add(inputPanel, BorderLayout.NORTH);

        taDaftarVCD = new JTextArea();
        taDaftarVCD.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(taDaftarVCD);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnTampilkan = new JButton("Tampilkan Daftar VCD");
        btnTampilkan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tampilkanDaftarVCD();
            }
        });
        add(btnTampilkan, BorderLayout.SOUTH);
    }

    private void tambahVCD() {
        String judul = tfJudul.getText();
        String aktor = tfAktor.getText();
        String sutradara = tfSutradara.getText();
        String publisher = tfPublisher.getText();
        String kategori = (String) cbKategori.getSelectedItem();
        int stok = Integer.parseInt(tfStok.getText());

        FilmVCD vcd = new FilmVCD(judul, aktor, sutradara, publisher, kategori, stok);
        daftarVCD.add(vcd);

        JOptionPane.showMessageDialog(this, "VCD berhasil ditambahkan!");
        bersihkanForm();
    }

    private void tampilkanDaftarVCD() {
        taDaftarVCD.setText("");
        for (FilmVCD vcd : daftarVCD) {
            taDaftarVCD.append(vcd.toString() + "\n");
        }
    }

    private void bersihkanForm() {
        tfJudul.setText("");
        tfAktor.setText("");
        tfSutradara.setText("");
        tfPublisher.setText("");
        cbKategori.setSelectedIndex(0);
        tfStok.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RentalVCDApp().setVisible(true);
            }
        });
    }
}