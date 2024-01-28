package main.java.edu.escuelaing.arem;

import java.io.IOException;

import edu.escuelaing.arep.taller1.Facade.WebServer;

public class Main {
    public static void main(String[] args) {
        try {
            WebServer.startSever();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}