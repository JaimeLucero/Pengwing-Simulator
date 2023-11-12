package com.example;


import java.util.Random;

public class Customer {
    private int priorityNo;
    private int windowNo;
    private boolean isPriority;
    private boolean isProcessed = false;

    Customer(){
        priorityNo = 0;
        windowNo = 0;
        isPriority = false;
    }

    Customer(int priorityNo, boolean isPriority){
        this.priorityNo = priorityNo;
        this.isPriority = isPriority;
        if (isPriority == false){
            Random random = new Random();
            windowNo = 2 + random.nextInt(2);
        } else {
            windowNo = 1;
        }
    }
    
    //setters and getters for priority number
    public int getPriorityNo() {
        return priorityNo;
    }

    public void setPriorityNo(int priorityNo) {
        this.priorityNo = priorityNo;
    }

    //setters and getters if the customer is a priority
    public Boolean isPriority() {
        return isPriority;
    }

    public void setIsPriority(boolean isPriority) {
        this.isPriority = isPriority;
    }

    //setters and getters for the window number
    public int getWindowNo() {
        return windowNo;
    }

    public void setWindowNo(int windowNo) {
        this.windowNo = windowNo;
    }

    @Override
    public String toString() {
        return "Customer [priorityNo=" + priorityNo + ", windowNo=" + windowNo + ", isPriority=" + isPriority + "]";
    }

    public boolean isIsProcessed() { // check if customer has finished queueing
        return isProcessed;
    }

    public void setIsProcessed(boolean isProcessed) {  // flags if customer is done queueing
        this.isProcessed = isProcessed;
    }
}
