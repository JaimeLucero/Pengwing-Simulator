package com.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class WindowQueue extends Thread{

    private Queue<Customer> window = new LinkedList<>();
    public Customer customer = null;
    SimulatorPanel sp = null;
    private boolean isQueueDone = false;

    public WindowQueue(SimulatorPanel sp) {
        this.sp = sp;
    }
    
    public void queueCustomer(Customer customer) throws InterruptedException{ // queues customer to the window
        window.add(customer);
        this.customer = customer;
        queueingCustomer();
    }

    public void queueStatus(boolean queueStatus){ //sets true if all customer assigned to the window is done
        isQueueDone = queueStatus;
    }

    public void queueingCustomer() throws InterruptedException{ //sets how long a customer stays in a window
        Random random = new Random();
        if (customer.getWindowNo() == 1) {
            Thread.sleep(5000+random.nextInt(3000));
        } else {
            Thread.sleep(5000+random.nextInt(2000));
        }
        System.out.println("Customer done: " + customer.getWindowNo() + "|" + customer.getPriorityNo() + customer.isPriority());
        customer = null;
    }

    @Override
    public void run() { // runs the window in a separate thread
        while (true) {
            if (isQueueDone) { //breaks the thread is the queue is done
                break;
            }
        }
    }


}
