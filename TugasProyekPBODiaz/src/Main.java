import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class OnlineTest extends JFrame implements ActionListener {
    JLabel l;
    JRadioButton[] jb = new JRadioButton[5];
    JButton b1, b2;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, now = 0;
    int[] m = new int[20];

    OnlineTest(String s) {
        super(s);
        getContentPane().setBackground(new Color(225, 178, 178));
        l = new JLabel();
        add(l);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            jb[i] = new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1 = new JButton("Next");
        b2 = new JButton("Bookmark");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b1.setBackground(new Color(128, 0, 128));
        b2.setBackground(new Color(238, 178, 238));
        add(b1);
        add(b2);
        set();
        l.setBounds(40, 30, 2050, 40);
        jb[0].setBounds(50, 80, 200, 20);
        jb[0].setBackground(new Color(128, 224, 208));
        jb[1].setBounds(50, 110, 200, 20);
        jb[1].setBackground(new Color(128, 224, 208));
        jb[2].setBounds(50, 140, 200, 20);
        jb[2].setBackground(new Color(128, 224, 208));
        jb[3].setBounds(50, 170, 200, 20);
        jb[3].setBackground(new Color(128, 224, 208));
        b1.setBounds(100, 240, 100, 30);
        b2.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if (check())
                count = count + 1;

            current++;
            set();

            if (current == 19) {
                b1.setEnabled(false);
                b2.setText("Result");
                b2.setBackground(Color.GREEN);
            }
        }
        if (e.getActionCommand().equals("Bookmark")) {
            JButton bk = new JButton("Bookmark" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 9)
                b2.setText("Result");

            setVisible(false);
            setVisible(true);

        }
        for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if (check())
                    count = count + 1;
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }

        if (e.getActionCommand().equals("Result")) {
            if (check())
                count = count + 1;
            current++;
            JOptionPane.showMessageDialog(this, "correct ans=" + count);
            JOptionPane.showMessageDialog(this, "Nilai=" + count * 10);
            System.exit(0);
        }
    }

    void set() {
        jb[4].setSelected(true);
        if (current == 0) {
            l.setText("1.Apa yang menjadi dasar negara Indonesia?");
            jb[0].setText("HAM");
            jb[1].setText("Pancasila");
            jb[2].setText("Keadilan");
            jb[3].setText(" Demokrasi");
        }
        if (current == 1) {
            l.setText("2: Siapa yang dianggap sebagai pencetus Pancasila?");
            jb[0].setText("Ir.Soekarno");
            jb[1].setText("Bung Hatta");
            jb[2].setText("Soepomo");
            jb[3].setText("Ki Hajar Dewantara");
        }
        if(current==2)
        {
            l.setText("3: Pancasila sebagai dasar negara diresmikan pada tanggal?");
            jb[0].setText(" 17 Agustus 1945");jb[1].setText("1 Juni 1945");jb[2].setText("18 Agustus 1945");jb[3].setText("22 Juni 1945");
        }
        if(current==3)
        {
            l.setText("4: Apa peran norma-norma kebangsaan dalam membangun kesatuan dan persatuan di indonesia ?");
            jb[0].setText("Menciptakan konflik");jb[1].setText("Memperkuat keberagaman");jb[2].setText("Mendorong pemisahan");jb[3].setText("Menciptakan segregasi");
        }
        if(current==4)
        {
            l.setText("5: Konsep negara hukum menekankan pada?");
            jb[0].setText("Kekuatan absolut pemerintah");jb[1].setText(" Kekuasaan berlandaskan hukum");jb[2].setText("Kekuasaan ekonomi");jb[3].setText("Kekuasaan militer");
        }
        if(current==5)
        {
            l.setText("6: Apa yang dimaksud wawasan kebangsaan?");
            jb[0].setText("Pemahaman tentang wawasan global");jb[1].setText("Pemahaman yang mendalam tentang identitas,sejarah, dan budaya bangsa");jb[2].setText("Pengetahuan tentang ekonomi negara");jb[3].setText(" Keahlian dalam bidang teknologi");
        }
        if(current==6)
        {
            l.setText("7: Apa itu Hak Asasi Manusia(HAM)? ");
            jb[0].setText(" Hak yang diberikan oleh pemerintah");jb[1].setText("Hak yang melekat pada diri sendiri sejak lahir");jb[2].setText("Hak yang dicabut oleh pemerintah");
            jb[3].setText("Hak yang berlaku untuk warga negara");
        }
        if(current==7)
        {
            l.setText("8: Bagaimana peran masyarakat dalam menciptakan ketertiban sosial?");
                    jb[0].setText("Hanya menjadi tanggung jawab pemerintah ");jb[1].setText(" Dapat memberikan kontribusi dengan menjalankan kewajiban masing-masing");jb[2].setText("Tidak memiliki peran dalam menciptakan ketertiban sosial");
            jb[3].setText("Harus bergantung sepenuhnya pada kebijakan pemerintah");
        }
        if(current==8)
        {
            l.setText("9: Apa yang menjadi semboyan negara Indonesia?");
            jb[0].setText(" Bhinneka Tunggal Ika");jb[1].setText("Garuda Pancasila ");jb[2].setText("Dirgahayu Indonesia");jb[3].setText(" Merdeka atau Mati");
        }
        if(current==9)
        {
            l.setText("10: Apa yang dimaksud Bhinneka Tunggal Ika?");
            jb[0].setText(" Kesatuan dalam keberagaman");jb[1].setText("Kesamaan dalam perbedaan");jb[2].setText("Khebinekaan dalam satu kesatuan");
            jb[3].setText(" Kesatuan tanpa perbedaan");
        }

        l.setBounds(40, 30, 2050, 40);
        for (int i = 0, j = 0; i <= 90; i += 30, j++)
            jb[j].setBounds(50, 80 + i, 300, 20);
    }

    boolean check() {
        // Fungsi check diubah sesuai dengan nomor urut pertanyaan
        if (current == 0)
            return (jb[1].isSelected());
        if (current == 1)
            return (jb[0].isSelected());
        if(current==2)
            return(jb[2].isSelected());
        if(current==3)
            return(jb[1].isSelected());
        if(current==4)
            return(jb[1].isSelected());
        if(current==5)
            return(jb[1].isSelected());
        if(current==6)
            return(jb[1].isSelected());
        if(current==7)
            return(jb[1].isSelected());
        if(current==8)
            return(jb[0].isSelected());
        if(current==9)
            return(jb[2].isSelected());
        return false;
    }

    public static void main(String[] args) {
        new OnlineTest("Tes Wawasan Kebangsaan?");
    }
}
