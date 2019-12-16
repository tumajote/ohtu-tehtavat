package ohtu.kivipaperisakset;

public class Peli {
    Tuomari tuomari;
    Io io;
    Pelaaja pelaaja2;

    public Peli(Io io) {
        this.tuomari = new Tuomari();
        this.io = io;
        this.pelaaja2 = new Ihminen(io);
    }
    public void pelaa() {
        io.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = io.seuraavaStr();
        io.print("Ensimmäinen pelaaja valitsi: " + ekanSiirto);
        io.print("Toisen pelaajan siirto: ");
        String tokanSiirto = pelaaja2.annaSiirto();
        io.print("Toinen pelaaja valitsi: " + tokanSiirto);

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            io.print(tuomari.toString());
            io.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = io.seuraavaStr();
            io.print("Ensimmäinen pelaaja valitsi: " + ekanSiirto);
            tokanSiirto = pelaaja2.annaSiirto();
            io.print("Toinen pelaaja valitsi: " + tokanSiirto);
            pelaaja2.asetaSiirto(ekanSiirto);

        }
        io.print("Kiitos!");
        io.print(tuomari.toString());
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

}

