package com.kemalgeylani.simplebodyexercise;

public class Singleton {

    private static Singleton singleton = new Singleton();
    private String sentExercise;

    private Singleton() {

    }
    public static Singleton getInstance() {
        return singleton;
    }

    public String getSentExercise() {
        return sentExercise;
    }

    public void setSentExercise(String sentExercise) {
        this.sentExercise = sentExercise;
    }
}

