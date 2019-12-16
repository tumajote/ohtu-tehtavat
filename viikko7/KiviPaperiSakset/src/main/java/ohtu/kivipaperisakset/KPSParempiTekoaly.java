package ohtu.kivipaperisakset;

import java.util.Scanner;

import java.util.Scanner;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends Peli{

    public KPSParempiTekoaly(Io io) {
        super(io);
        this.pelaaja2 = new TekoalyParannettu();

    }
}
