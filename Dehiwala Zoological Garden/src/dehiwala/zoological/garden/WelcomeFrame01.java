package dehiwala.zoological.garden;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import javax.sound.sampled.*;

public class WelcomeFrame01 extends javax.swing.JFrame {
    
    private Clip audioClip;
    private JLabel gifLabel;

    public WelcomeFrame01() {
       
        // Set frame properties
        setTitle("Welcome to Dehiwala Zoo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null); // Center on screen
        setLayout(new BorderLayout());

        // Load the animated GIF
        URL gifUrl = getClass().getResource("/images/zoo.gif");

        if (gifUrl != null) {
            String html = "<html><img width='600' height='600' src='" + gifUrl + "'></html>";
            gifLabel = new JLabel(html);
            gifLabel.setHorizontalAlignment(SwingConstants.CENTER);
            gifLabel.setVerticalAlignment(SwingConstants.CENTER);
            gifLabel.setPreferredSize(new Dimension(600, 600));
            add(gifLabel, BorderLayout.CENTER);
        } else {
            JLabel errorLabel = new JLabel("GIF not found!", SwingConstants.CENTER);
            errorLabel.setFont(new Font("Arial", Font.BOLD, 24));
            add(errorLabel, BorderLayout.CENTER);
        }
        
        // Start background sound
        playSound("/sounds/welcome.wav");

        // Set a timer to transition after 15 seconds (15000 milliseconds)
        Timer timer = new Timer(15_000, e -> transitionToLogin());
        timer.setRepeats(false); // Run only once
        timer.start();
        
        setVisible(true);
    }
    
    private void playSound(String soundPath) {
        try {
            URL soundUrl = getClass().getResource(soundPath);
            if (soundUrl == null) {
                System.err.println("Sound file not found: " + soundPath);
                return;
            }
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundUrl);
            audioClip = AudioSystem.getClip();
            audioClip.open(audioIn);
            audioClip.start();
            
        } catch (Exception e) {
        e.printStackTrace();
        }
        }
    
    
    private void stopSound() {
        if (audioClip != null && audioClip.isRunning()) {
            audioClip.stop();
            audioClip.close();
        }
    }
    
    private void transitionToLogin() {
        // Stop audio
        stopSound();

        // Close welcome frame
        this.dispose();

        // Open login frame
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(WelcomeFrame01::new);
    }

    



    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}