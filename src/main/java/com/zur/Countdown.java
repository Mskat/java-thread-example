package com.zur;

public class Countdown {

    public static void main(String[] args) {
        Person person = new Person();
        Counter firstPerson = new Counter(person, "Hana");
        Counter secondPerson = new Counter(person, "Pola");
        Counter thirdPerson = new Counter(person, "Max");

        try {
            firstPerson.thread.join();
            secondPerson.thread.join();
            thirdPerson.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Counter implements Runnable{

    private Person person;
    private String personName;
    Thread thread;

    public Counter(Person person, String personName) {
        this.person = person;
        this.personName = personName;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        synchronized (person) {
            person.personCountsDown(personName);
        }
    }

}

class Person {

    public void personCountsDown(String name) {
        System.out.println(name + " is starting the countdown...");
        for(int number = 5; number > 0; number--) {
            System.out.println(number);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Countdown is over.\n");
    }

}
