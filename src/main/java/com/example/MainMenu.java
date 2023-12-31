/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.example;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author jaimelucero
 */
public class MainMenu extends javax.swing.JFrame {
    
    
    
    
    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/START.png"))); // NOI18N
        jLabel2.setAlignmentY(0.0F);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(360, 140, 120, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/ABOUT.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(360, 200, 119, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/EXIT.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(370, 250, 100, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/title.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(100, 50, 640, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/store_front_with_penguins_best.jpeg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setPreferredSize(new java.awt.Dimension(800, 500));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) { // launches the simulator frame                                 
        stopMusic();
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/Music/button_sfx.wav").getAbsoluteFile());
            Clip clipbtn = AudioSystem.getClip();
            clipbtn.open(audioInputStream);

            // Start playing the audio
            clipbtn.start();

        } catch (Exception e) {
        }

        this.dispose();
        Simulator sim = new Simulator();
        sim.setVisible(true);

    }                                    
    
    public static void playMusicLoop() { // loops the music
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./src/main/resources/Music/menu_sfx.wav"));
            menuMusic = AudioSystem.getClip();
            menuMusic.open(audioInputStream);
            menuMusic.loop(Clip.LOOP_CONTINUOUSLY); // Play in a loop
            menuMusic.start();
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public void stopMusic() { //stops the music
        if (menuMusic != null) {
            menuMusic.stop();
            menuMusic.close();
        }
    }
    
    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) { //confirm dialogue if the user want to exit
        int choice = JOptionPane.showConfirmDialog(null, "Do you want to go to close the program?\nChoosing No or closing the dialog will exit this dialog.", "Confirmation", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            // User chose "Yes"
            System.out.println("You chose Yes.");
            System.exit(0);
        } else {
            // User chose "No" or closed the dialog
            System.out.println("You chose No or closed the dialog.");
        }
        
        // TODO add your handling code here:
    }                                    

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) { //opens the dialog for the program about
        JOptionPane.showMessageDialog(null, getAbout(), "Penguing Simulator | About",  JOptionPane.INFORMATION_MESSAGE);
// TODO add your handling code here:
    }                                    
    
    
    
    public String getAbout(){ //the message for the program about
            String aboutText = "About:\n" +
    "The \"Penguin Queue Simulator\" is a delightful and engaging program designed to simulate a queue of adorable penguins waiting to access three \n  different windows for various services. What sets this simulation apart is the inclusion of a special priority queue for penguins that have an unmistakable style - red shoes!\n" +
    "\n" +
    "Key Features:\n" +
    "\n" +
    "Three Service Windows: The program presents a queue of charming penguins, each waiting their turn to be served at the specific windows assigned to them. \n    These windows represent distinct services, making the simulation more interactive and fun.\n" +
    "\n" +
    "Priority Queue: Among the penguins patiently awaiting their turn, there's a unique twist. Some penguins sport eye-catching red shoes, and they get special treatment. \n   The program maintains a separate priority queue for these fashionable penguins which is located at the right side of the area, ensuring they receive expedited service.\n" +
    "\n" +
    "Adorable Penguin Characters: The penguins featured in the simulation are full of character and charm. Watch as they waddle and wait their turn, \n     making the entire experience delightful for users of all ages.\n" +
    "\n" +
    "Interactive and Educational: The Penguin Queue Simulator is not just about fun but also provides an educational experience. It introduces users, \n    especially children, to the concepts of queues and prioritization in a playful and engaging manner.\n" +
    "\n" +
    "Visual Appeal: The program's user interface is designed to be visually appealing, with colorful graphics and animations that bring \n      the penguin characters to life." +
    "\n\n\n" +
    "Created by; Jaime Emanuel B. Lucero BSCS-2A USeP CIC";
     
            return aboutText;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws InterruptedException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
        playMusicLoop();
        
    }

    private static Clip menuMusic;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
