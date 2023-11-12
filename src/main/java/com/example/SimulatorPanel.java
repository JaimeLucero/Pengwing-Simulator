/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.example;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author jaimelucero
 */
public class SimulatorPanel extends javax.swing.JPanel{

    /**
     * Creates new form SimulatorPanel
     */
    @SuppressWarnings("empty-statement")
    public SimulatorPanel() {
        bg = new ImageIcon((getClass().getResource("/Elements/pixel_art_store_with_3_counter.jpeg"))).getImage();
        initComponents();;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 500));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/pixel_art_store_with_3_counter.jpeg"))); // NOI18N
        add(jLabel1);
    }// </editor-fold>//GEN-END:initComponents


    public void setPenguinP() {
            penguinP = new ImageIcon((getClass().getResource("/Elements/penguin_priority.png"))).getImage();
            xP = 640;
            yP = 240;
            repaint();
    }

    public void setPenguin3(){
        penguin2 = new ImageIcon((getClass().getResource("/Elements/penguin.png"))).getImage();
            x3 = 425;
            y3 = 315;
            repaint();
    }

    public void setPenguin2(){
        penguin3 = new ImageIcon((getClass().getResource("/Elements/penguin.png"))).getImage();
            x2 = 340;
            y2 = 365;
            repaint();
    }
    
    public void updatePenguinP(){
        int destinationX = 510;
        int destinationY = 230;

        if (xP >= destinationX) {
            xP = xP - 2;
        }
        if(yP >= destinationY) {
            yP = yP - 1;
        }
        repaint();

    }

    public void updatePenguin2(){
        int destinationX = 170;
        int destinationY = 285;

        if (x2 >= destinationX) {
            x2 = x2 - 1;
        }
        if(y2 >= destinationY) {
            y2 = y2 - 1;
        }
        repaint();
    }

    public void updatePenguin3(){
        int destinationX = 270;
        int destinationY = 250;

        if (x3 >= destinationX) {
            x3 = x3 - 1;
        }
        if(y3 >= destinationY) {
            y3 = y3 - 1;
        }
        repaint();
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(bg, 0, 0, null);
        g2D.drawImage(penguinP, xP, yP, null);
        g2D.drawImage(penguin3, x3, y3, null);
        g2D.drawImage(penguin2, x2, y2, null);

    }

    Image penguin2;
    Image penguin3;
    Image penguinP;
    Image bg;

    int xP = 0;
    int yP = 0;
    int x2 = 0;
    int y2 = 0;
    int x3 = 0;
    int y3 = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
