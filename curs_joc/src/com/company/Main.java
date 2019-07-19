package com.company;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String film = alege();
        System.out.println(film);

        Ghiceste ghici = new Ghiceste(film);
        ghici.incepe();
    }

    private static String alege() {
        String film = "";
        try {
            File fisier = new File("filme.txt");
            Scanner scan = new Scanner(fisier);
            String[] filme = new String[100];
            int index = 0;
            while (scan.hasNextLine()) {
                filme[index++] = scan.nextLine();
            }

            int nr = (int)(Math.random() * index);

            film = filme[nr];
        } catch (Exception e) {
            System.out.println("Nu exista fisierul");
        }
        return film;
    }
}

