package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends Peli {
    public KPSTekoaly(Io io) {
        super(io);
        this.pelaaja2 = new Tekoaly();
    }
}