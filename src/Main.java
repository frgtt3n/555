import javax.swing.*;
import java.awt.*;




public class Main {


    static double calc555_freq(int r1, int r2, double c) {
        return 1.443 / ((r1 + 2 * r2) * c);
    }


    public static void main(String[] args) {


        JFrame window = new JFrame("555 calculator");
        window.setLayout(null);
        window.setResizable(false);
        window.setSize(350, 450);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon img = new ImageIcon("resources/555t.png");
        window.setIconImage(img.getImage());




        JLabel c_label = new JLabel("Capacitor:");      JLabel unit_F = new JLabel("[F]");
        JLabel r1_label = new JLabel("R1:");            JLabel unit_R1 = new JLabel("[Ω]");
        JLabel r2_label = new JLabel("R2:");            JLabel unit_R2 = new JLabel("[Ω]");
        JLabel result = new JLabel("frequency:");

        JTextField c_tf = new JTextField();
        JTextField r1_tf = new JTextField();
        JTextField r2_tf = new JTextField();




        c_label.setBounds(50, 50, 95, 30);
        c_label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        c_tf.setBounds(155, 50, 100, 30);

        r1_label.setBounds(50, 100, 95, 30);
        r1_label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        r1_tf.setBounds(155, 100, 100, 30);

        r2_label.setBounds(50, 150, 95, 30);
        r2_label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        r2_tf.setBounds(155, 150, 100, 30);

        unit_F.setBounds(260, 52, 20, 20);      unit_F.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        unit_R1.setBounds(260, 102, 20, 20);    unit_R1.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        unit_R2.setBounds(260, 152, 20, 20);    unit_R2.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));

        result.setBounds(50, 200, 300, 30);
        result.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));




        JButton button = new JButton("calculate");
        button.setBounds(200, 330, 90, 40);
        button.setBackground(Color.green);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.addActionListener(e -> {
            try {
                double cap = Double.parseDouble(c_tf.getText());
                int r1 = Integer.parseInt(r1_tf.getText());
                int r2 = Integer.parseInt(r2_tf.getText());
                double freq = calc555_freq(r1, r2, cap);
                String val;
                if(freq > 1000000) {
                    freq /= 1000000;
                    val = String.format("%.3f %s", freq, "MHz");
                } else if(freq > 1000) {
                    freq /= 1000;
                    val = String.format("%.3f %s", freq, "kHz");
                } else {
                    val = String.format("%.3f %s", freq, "Hz");
                }
                result.setText("frequency: " + val);
            } catch (Exception ignored) {}
        });




        window.add(c_label);    window.add(c_tf);   window.add(unit_F);
        window.add(r1_label);   window.add(r1_tf);  window.add(unit_R1);
        window.add(r2_label);   window.add(r2_tf);  window.add(unit_R2);
        window.add(result);
        window.add(button);

        window.setVisible(true);
    }

}