import javax.swing.*;
import java.awt.*;

public class Window {

    public JLabel result = null;
    public void createWindow() {

        JFrame frame = new JFrame("555 Calculator");
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(350, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        // Capacitor label
        JLabel c_label = new JLabel("Capacitor:");
        c_label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        c_label.setBounds(50, 50, 95, 30);

        JTextField c_tf = new JTextField();
        c_tf.setBounds(155, 50, 100, 30);

        JLabel unit_F = new JLabel("[F]");
        unit_F.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        unit_F.setBounds(260, 52, 20, 20);

        frame.add(c_label); frame.add(c_tf); frame.add(unit_F);



        // R1 label
        JLabel r1_label = new JLabel("R1:");
        r1_label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        r1_label.setBounds(50, 100, 95, 30);
        frame.add(r1_label);

        JTextField r1_tf = new JTextField();
        r1_tf.setBounds(155, 100, 100, 30);
        frame.add(r1_tf);

        JLabel unit_R1 = new JLabel("[Ω]");
        unit_R1.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        unit_R1.setBounds(260, 102, 20, 20);
        frame.add(unit_R1);



        // R2 label
        JLabel r2_label = new JLabel("R2:");
        r2_label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        r2_label.setBounds(50, 150, 95, 30);
        frame.add(r2_label);

        JTextField r2_tf = new JTextField();
        r2_tf.setBounds(155, 150, 100, 30);
        frame.add(r2_tf);

        JLabel unit_R2 = new JLabel("[Ω]");
        unit_R2.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        unit_R2.setBounds(260, 152, 20, 20);
        frame.add(unit_R2);



        // Result label
        result = new JLabel("frequency:");
        result.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        result.setBounds(50, 200, 300, 30);
        frame.add(result);



        // Result button
        JButton button = new JButton("calculate");
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setBackground(Color.green);
        button.setBounds(200, 330, 90, 40);
        button.addActionListener(e -> {
            try {

                Calculator555 calculator555 = new Calculator555();
                double c = Double.parseDouble(c_tf.getText());
                int r1 = Integer.parseInt(r1_tf.getText());
                int r2 = Integer.parseInt(r2_tf.getText());

                double freq = calculator555.frequency(r1, r2, c);

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
        frame.add(button);



        frame.setVisible(true);

    }
}
