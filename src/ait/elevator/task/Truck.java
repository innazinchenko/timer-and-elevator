package ait.elevator.task;

import ait.elevator.model.Elevator;

public class Truck implements Runnable {
    private static Object monitor = new Object();
    private int nRaces;
    private int capacity;
    private Elevator elevator;
    private Elevator secondElevator;


    public Truck(int nRaces, int capacity, Elevator elevator, Elevator secondElevator) {
        this.nRaces = nRaces;
        this.capacity = capacity;
        this.elevator = elevator;
        this.secondElevator = secondElevator;
    }

    @Override
    public void run() {

        for (int i = 0; i < nRaces; i++) {
            synchronized (monitor) {
                elevator.add(capacity / 2);
                secondElevator.add(capacity / 2);
            }
        }
    }
}
