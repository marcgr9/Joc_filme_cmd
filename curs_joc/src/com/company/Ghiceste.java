package com.company;

import java.util.Scanner;

public class Ghiceste {
    private String film;
    private String ghicit;

    Ghiceste() {
        film = "";
        ghicit = "";
    }
    Ghiceste(String f) {
        film = f;
        ghicit = "";
        for (int i = 0; i < f.length(); i++)
            ghicit = ghicit + "_";
    }

    public void incepe() {
        int gresit = 0;
        String litereGresite = "";
        String litera;
        boolean pierdut = true;

        System.out.println("Ghiceste filmul, are " + film.length() + " litere");
        Scanner scan = new Scanner(System.in);

        while (gresit != 10) {
            System.out.println("Ai ghicit pana acum: " + ghicit);
            System.out.println("Litere gresite pana acum(" + litereGresite.length() / 2 + "/10): " + litereGresite);
            litera = scan.nextLine();
            //System.out.println(1);
            while (litera.length() > 1 || litera.length() < 1 || !Character.isLetter(litera.charAt(0))) {
                System.out.println("Alege o litera!");
                litera = scan.nextLine();
            }
            //System.out.println(11 + litera.length());
            boolean apare = false;
            for (int i = 0; i < film.length(); i++) {
                if (Character.toLowerCase(litera.charAt(0)) == Character.toLowerCase(film.charAt(i))) {
                    apare = true;
                    ghicit = ghicit.substring(0, i)
                            + film.charAt(i)
                            + ghicit.substring(i + 1);
                }
            }
            if (!apare) {
                boolean ok = true;
                for (int i = 0; i < litereGresite.length(); i++) {
                    if (Character.toLowerCase(litereGresite.charAt(i)) == Character.toLowerCase(litera.charAt(0))) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    litereGresite += litera + " ";
                    gresit++;
                    System.out.println("Litera nu apare!");
                } else System.out.println("Ai mai zis odata litera asta gresita");
            } else {
                if (ghicit.equals(film)) {
                    pierdut = false;
                    break;
                }
            }
        }
        if (pierdut) {
            System.out.println("Ai pierdut, filmul era " + film);
        } else {
            System.out.println("Ai ghicit filmul!! - " + film);
        }
    }





}
