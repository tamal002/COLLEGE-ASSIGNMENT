import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class A4_Q1 extends JFrame {
    private JTextField inputField;
    private JPanel bulbPanel;
    private JTextArea resultArea;

     BulbToggleSimulator() {
        setTitle("Bulb Toggle Simulator");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top panel for input
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Enter number of bulbs (n < 10):"));
        inputField = new JTextField(5);
        topPanel.add(inputField);
        JButton startButton = new JButton("Start Simulation");
        topPanel.add(startButton);
        add(topPanel, BorderLayout.NORTH);

        // Panel to display bulbs
        bulbPanel = new JPanel();
        bulbPanel.setLayout(new FlowLayout());
        add(bulbPanel, BorderLayout.CENTER);

        // Text area to show round info
        resultArea = new JTextArea(10, 50);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane, BorderLayout.SOUTH);

        // Button action
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                simulateBulbs();
            }
        });
    }

    private void simulateBulbs() {
        bulbPanel.removeAll();s
        resultArea.setText("");

        int n;
        try {
            n = Integer.parseInt(inputField.getText());
            if (n >= 10 || n <= 0) {
                JOptionPane.showMessageDialog(this, "Please enter n between 1 and 9.");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.");
            return;
        }

        boolean[] bulbs = new boolean[n]; // false = off, true = on

        for (int round = 1; round <= n; round++) {
            for (int i = round - 1; i < n; i += round) {
                bulbs[i] = !bulbs[i]; // Toggle
            }

            resultArea.append("After round " + round + ": ");
            for (int i = 0; i < n; i++) {
                resultArea.append((bulbs[i] ? "1 " : "0 "));
            }
            resultArea.append("\n");
        }

        // Final visual display
        for (int i = 0; i < n; i++) {
            JLabel bulb = new JLabel();
            bulb.setOpaque(true);
            bulb.setPreferredSize(new Dimension(50, 50));
            bulb.setHorizontalAlignment(SwingConstants.CENTER);
            bulb.setVerticalAlignment(SwingConstants.CENTER);
            bulb.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            bulb.setText("B" + (i + 1));
            bulb.setBackground(bulbs[i] ? Color.YELLOW : Color.LIGHT_GRAY);
            bulbPanel.add(bulb);
        }

        bulbPanel.revalidate();
        bulbPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BulbToggleSimulator().setVisible(true);
        });
    }
}