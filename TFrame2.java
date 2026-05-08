import java.awt.*;
import java.awt.event.*;

public class TFrame2 extends Frame {

    Label lbJudul, lbTugas, lbKuis, lbUTS, lbUAS, lbHasil;
    TextField txtTugas, txtKuis, txtUTS, txtUAS, txtHasil;

    CheckboxGroup cbg;
    Checkbox cbNilaiAngka, cbNilaiHuruf;

    public TFrame2() {

        setLayout(null);

        lbJudul = new Label("Hitung Nilai Akhir");
        lbJudul.setFont(new Font("Arial", Font.BOLD, 14));
        add(lbJudul);
        lbJudul.setBounds(100, 30, 170, 20);

        lbTugas = new Label("Tugas : ");
        add(lbTugas);
        lbTugas.setBounds(100, 60, 70, 20);

        lbKuis = new Label("Kuis : ");
        add(lbKuis);
        lbKuis.setBounds(100, 90, 70, 20);

        lbUTS = new Label("UTS : ");
        add(lbUTS);
        lbUTS.setBounds(100, 120, 70, 20);

        lbUAS = new Label("UAS : ");
        add(lbUAS);
        lbUAS.setBounds(100, 150, 70, 20);

        lbHasil = new Label("Hasil : ");
        add(lbHasil);
        lbHasil.setBounds(100, 180, 70, 20);

        txtTugas = new TextField("0");
        add(txtTugas);
        txtTugas.setBounds(200, 60, 60, 20);

        txtKuis = new TextField("0");
        add(txtKuis);
        txtKuis.setBounds(200, 90, 60, 20);

        txtUTS = new TextField("0");
        add(txtUTS);
        txtUTS.setBounds(200, 120, 60, 20);

        txtUAS = new TextField("0");
        add(txtUAS);
        txtUAS.setBounds(200, 150, 60, 20);

        txtHasil = new TextField("");
        add(txtHasil);
        txtHasil.setBounds(200, 180, 100, 20);

        cbg = new CheckboxGroup();

        cbNilaiAngka = new Checkbox("Nilai Angka", cbg, false);
        add(cbNilaiAngka);
        cbNilaiAngka.setBounds(100, 220, 120, 20);

        cbNilaiHuruf = new Checkbox("Nilai Huruf", cbg, false);
        add(cbNilaiHuruf);
        cbNilaiHuruf.setBounds(220, 220, 120, 20);

        cbNilaiAngka.addItemListener(new MainAction());
        cbNilaiHuruf.addItemListener(new MainAction());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    class MainAction implements ItemListener {

        public void itemStateChanged(ItemEvent e) {

            try {

                float tugas = Float.parseFloat(txtTugas.getText().trim());
                float kuis = Float.parseFloat(txtKuis.getText().trim());
                float uts = Float.parseFloat(txtUTS.getText().trim());
                float uas = Float.parseFloat(txtUAS.getText().trim());

                float hasil = (tugas + kuis + uts + uas) / 4;

                Object source = e.getItemSelectable();

                if (source == cbNilaiAngka) {

                    txtHasil.setText(String.valueOf(hasil));
                }

                else if (source == cbNilaiHuruf) {

                    String huruf;

                    if (hasil >= 80 && hasil <= 100) {
                        huruf = "A";
                    }
                    else if (hasil >= 75 && hasil < 80) {
                        huruf = "B+";
                    }
                    else if (hasil >= 65 && hasil < 75) {
                        huruf = "B";
                    }
                    else if (hasil >= 60 && hasil < 65) {
                        huruf = "C+";
                    }
                    else if (hasil >= 50 && hasil < 60) {
                        huruf = "C";
                    }
                    else if (hasil >= 45 && hasil < 50) {
                        huruf = "D+";
                    }
                    else if (hasil >= 35 && hasil < 45) {
                        huruf = "D";
                    }
                    else {
                        huruf = "E";
                    }

                    txtHasil.setText(huruf);
                }

            } catch (Exception ex) {

                txtHasil.setText("Error");
            }
        }
    }
}