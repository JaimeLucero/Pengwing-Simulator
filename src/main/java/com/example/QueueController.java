package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class QueueController{
    private static Queue<Customer> customerQueue = new LinkedList<>();
    public static SimulatorPanel sp;
    public static int windowActive = 3;

    public QueueController(SimulatorPanel sp){
        this.sp = sp;
        windowActive = 3;
    }

    public void generateQueue(){
        for (int i = 1; i <= 20; i++) {
            Random random = new Random();
            boolean ifPriority = random.nextBoolean(); //random to determine if the customer is a priority
            if (ifPriority) {
                customerQueue.offer(new Customer(i, false));
            } else {
                customerQueue.offer(new Customer(i,true));
            }
        }
    }

    public void priorityWindow() throws InterruptedException{ //queues the customer to a specific priority window
        Iterator<Customer> iterator = customerQueue.iterator();

        WindowQueue pw = new WindowQueue(sp);
        pw.start();

        Timer updateTimer = new Timer(10, (ActionEvent e) -> {
            sp.updatePenguinP();
        });
        updateTimer.start();
        while (!customerQueue.isEmpty() && iterator.hasNext()) {
            Customer customer = iterator.next();
            // Update UI to show the penguin for the specific window
            if (customer.getWindowNo() == 1 && !customer.isIsProcessed()) {
                try {
                    Thread.sleep(1000);
                    sp.setPenguinP();
                    pw.queueCustomer(customer);
                    customer.setIsProcessed(true);

                } catch (InterruptedException e1) {
                }
            }
        }
        pw.queueStatus(true);
                windowActive--;

    }

    public void processWindow2() throws InterruptedException{ // queues customer assigned in window 2

        WindowQueue window2 = new WindowQueue(sp);
        window2.start();
        Iterator<Customer> iterator = customerQueue.iterator();

    
        Timer updateTimer = new Timer(10, (ActionEvent e) -> {
            sp.updatePenguin2();
        });
        updateTimer.start();

        while (!customerQueue.isEmpty() && iterator.hasNext()) {
            Customer customer = iterator.next();
            // Update UI to show the penguin for the specific window
                if (customer.getWindowNo() == 2 && !customer.isIsProcessed()) {
                try {
                    Thread.sleep(1000);
                    sp.setPenguin2();
                    window2.queueCustomer(customer);
                    customer.setIsProcessed(true);
                } catch (InterruptedException e1) {
                }
            }
        }

        window2.queueStatus(true);
                windowActive--;

    }

    public void processWindow3() throws InterruptedException{ // queues customer assigned in window 3

        WindowQueue window3 = new WindowQueue(sp);
        window3.start();
        Iterator<Customer> iterator = customerQueue.iterator();

    
        Timer updateTimer = new Timer(10, (ActionEvent e) -> {
            sp.updatePenguin3();
        });
        updateTimer.start();

        while (!customerQueue.isEmpty() && iterator.hasNext()) {
            Customer customer = iterator.next();
            // Update UI to show the penguin for the specific window
                if (customer.getWindowNo() == 3 && !customer.isIsProcessed()) {
                try {
                    Thread.sleep(1000);
                    sp.setPenguin3();
                    window3.queueCustomer(customer);
                    customer.setIsProcessed(true);

                } catch (InterruptedException e1) {
                }
            }
        }
        window3.queueStatus(true);
        windowActive--;
    }  

    public void checkQueue(Simulator sim){ // checks if all windows are done queueing customers
        while (windowActive != 0) {
            System.out.println(windowActive);
        }
        System.out.println("end");
        int choice = JOptionPane.showConfirmDialog(null, "Queue Done! \nDo you want to go to main menu?\nChoosing No or closing the dialog will exit the program.", "Confirmation", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            // User chose "Yes"
            System.out.println("You chose Yes.");
            sim.stopMusic();
            sim.dispose();
            try {
                MainMenu.main(null);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            // User chose "No" or closed the dialog
            System.out.println("You chose No or closed the dialog.");
            System.exit(0);
        }
    }
}
