package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        Io io = new KonsoliIo();
        Pelitehdas pelitehdas = new Pelitehdas(io);

        while (true) {
            io.print("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = io.seuraavaStr();
            if (vastaus.equals("a") || vastaus.equals("b") || vastaus.equals("c")) {
                io.print("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                pelitehdas.hae(vastaus).pelaa();
            } else {
                break;
        }
    }

}
}
