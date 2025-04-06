import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeScreen {
    public static void main(String[] args) {
        JFrame welcomeFrame = new JFrame("Welcome to Event Scheduler");
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setSize(800, 600);
        welcomeFrame.setLayout(null);
        welcomeFrame.setResizable(false);
        welcomeFrame.setLocationRelativeTo(null); // Center on screen

        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Image originalImage = new ImageIcon("F:\\Individual Project by JAVA\\Event\\src\\cover5.jpg").getImage();
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                g2d.drawImage(originalImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(null);
        backgroundPanel.setBounds(0, 0, 800, 600);
        welcomeFrame.add(backgroundPanel);

        // Title
        JLabel titleLabel = new JLabel("Event Scheduler");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setForeground(new Color(0, 51, 102));
        titleLabel.setBounds(240, 40, 400, 50); // Centered top
        backgroundPanel.add(titleLabel);

        // Subtitle
        JLabel subtitleLabel = new JLabel("Plan Smart. Live Better.");
        subtitleLabel.setFont(new Font("Arial", Font.ITALIC, 22));
        subtitleLabel.setForeground(new Color(0, 51, 102));
        subtitleLabel.setBounds(270, 90, 300, 30); // Below title
        backgroundPanel.add(subtitleLabel);

        // Feature Highlights
        JLabel bulletPoints = new JLabel("<html>"
        + "<div style='text-align: center; font-size: 13px;'>"
        + "🎯 <b>Stay on top of your goals</b><br>"
        + "📅 <b>Create and manage events effortlessly</b><br>"
        + "🗂️ <b>Export schedules in .txt or .csv formats</b><br>"
        + "✨ <b>Let your productivity shine!</b>"
        + "</div>"
        + "</html>");
bulletPoints.setFont(new Font("Arial", Font.PLAIN, 13));
bulletPoints.setForeground(new Color(0, 51, 102)); // Dark blue
bulletPoints.setBounds(200, 130, 400, 120); // Centered placement
bulletPoints.setHorizontalAlignment(SwingConstants.CENTER); // Align text to center
bulletPoints.setOpaque(true); // No background
backgroundPanel.add(bulletPoints);


        // Exit Button
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(200, 450, 120, 45);
        exitButton.setBackground(new Color(255, 51, 51));
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(new Font("Arial", Font.BOLD, 15));
        backgroundPanel.add(exitButton);

        // Continue Button
        JButton continueButton = new JButton("Let's Go");
        continueButton.setBounds(480, 450, 140, 45);
        continueButton.setBackground(new Color(66, 183, 42));
        continueButton.setForeground(Color.WHITE);
        continueButton.setFont(new Font("Arial", Font.BOLD, 15));
        backgroundPanel.add(continueButton);

        // Button actions
        exitButton.addActionListener(e -> System.exit(0));
        continueButton.addActionListener(e -> {
            welcomeFrame.dispose();
            try {
                new EventScheduler();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        welcomeFrame.setVisible(true);
    }
}
