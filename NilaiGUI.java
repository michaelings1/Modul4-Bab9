import java.awt.*;
import java.awt.event.*;

public class NilaiGUI extends Frame {
    CheckboxGroup cbg;
    Checkbox cbPemlan, cbASD, cbMatkom, cbProbstat;

    Label lbJudul, lbTugas, lbKuis, lbUTS, lbUAS, lbHasil;

    TextField txtTugas, txtKuis, txtUTS, txtUAS, txtHasil;

    Button btnHitung, btnTampil;

    TextArea areaHasil;

    String semuaNilai = "";

    public NilaiGUI() {
        setLayout(null);

        lbJudul = new Label("Hitung Nilai Akhir");
        lbJudul.setFont(new Font("Arial", Font.BOLD, 14));
        add(lbJudul);
        lbJudul.setBounds(120, 50, 150, 20);

        cbg = new CheckboxGroup();

        cbASD = new Checkbox("ASD", cbg, false);
        add(cbASD);
        cbASD.setBounds(40, 90, 60, 20);

        cbPemlan = new Checkbox("Pemlan", cbg, true);
        add(cbPemlan);
        cbPemlan.setBounds(120, 90, 80, 20);

        cbMatkom = new Checkbox("Matkomlan", cbg, false);
        add(cbMatkom);
        cbMatkom.setBounds(200, 90, 90, 20);

        cbProbstat = new Checkbox("Probstat", cbg, false);
        add(cbProbstat);
        cbProbstat.setBounds(300, 90, 90, 20);

        lbTugas = new Label("Tugas : ");
        add(lbTugas);
        lbTugas.setBounds(120, 130, 80, 20);

        lbKuis = new Label("Kuis : ");
        add(lbKuis);
        lbKuis.setBounds(120, 160, 80, 20);

        lbUTS = new Label("UTS : ");
        add(lbUTS);
        lbUTS.setBounds(120, 190, 80, 20);

        lbUAS = new Label("UAS : ");
        add(lbUAS);
        lbUAS.setBounds(120, 220, 80, 20);

        lbHasil = new Label("Hasil : ");
        add(lbHasil);
        lbHasil.setBounds(120, 250, 80, 20);

        txtTugas = new TextField();
        add(txtTugas);
        txtTugas.setBounds(200, 130, 70, 20);

        txtKuis = new TextField();
        add(txtKuis);
        txtKuis.setBounds(200, 160, 70, 20);

        txtUTS = new TextField();
        add(txtUTS);
        txtUTS.setBounds(200, 190, 70, 20);

        txtUAS = new TextField();
        add(txtUAS);
        txtUAS.setBounds(200, 220, 70, 20);

        txtHasil = new TextField();
        add(txtHasil);
        txtHasil.setBounds(200, 250, 70, 20);

        btnHitung = new Button("Hitung");
        add(btnHitung);
        btnHitung.setBounds(150, 290, 100, 30);

        areaHasil = new TextArea();
        add(areaHasil);
        areaHasil.setBounds(70, 340, 280, 150);

        btnTampil = new Button("Tampilkan Nilai Semua Matkul");
        add(btnTampil);
        btnTampil.setBounds(100, 510, 220, 30);

        btnHitung.addActionListener(new HitungAction());
        btnTampil.addActionListener(new TampilAction());

        ItemListener clearField = new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                txtTugas.setText("");
                txtKuis.setText("");
                txtUTS.setText("");
                txtUAS.setText("");
                txtHasil.setText("");
            }
        };

        cbASD.addItemListener(clearField);
        cbPemlan.addItemListener(clearField);
        cbMatkom.addItemListener(clearField);
        cbProbstat.addItemListener(clearField);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    class HitungAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                float tugas = Float.parseFloat(txtTugas.getText());
                float kuis = Float.parseFloat(txtKuis.getText());
                float uts = Float.parseFloat(txtUTS.getText());
                float uas = Float.parseFloat(txtUAS.getText());

                float hasil = 0;
                String matkul = "";

                if (cbPemlan.getState()) {
                    hasil = (tugas * 0.2f) + (kuis * 0.2f) + (uts * 0.3f) + (uas * 0.3f);
                    matkul = "Pemlan";
                }
                    
                else if (cbASD.getState()) {
                    hasil = (tugas * 0.25f) + (kuis * 0.25f) + (uts * 0.25f) + (uas * 0.25f);
                    matkul = "ASD";
                }

                else if (cbMatkom.getState()) {
                    hasil = (tugas * 0.1f) +  (kuis * 0.2f) + (uts * 0.3f) + (uas * 0.4f);
                    matkul = "Matkomlan";
                }

                else if (cbProbstat.getState()) {
                    hasil = (tugas * 0.15f) + (kuis * 0.15f) + (uts * 0.3f) + (uas * 0.4f);
                    matkul = "Probstat";
                }

                txtHasil.setText(String.valueOf(hasil));

                semuaNilai += matkul + " : " + hasil + "\n";

            } catch (Exception ex) {
                txtHasil.setText("Error");
            }
        }
    }
    
    class TampilAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            areaHasil.setText(
                    "HASIL NILAI SEMUA MATA KULIAH\n\n" + semuaNilai
            );
        }
    }
}
  
