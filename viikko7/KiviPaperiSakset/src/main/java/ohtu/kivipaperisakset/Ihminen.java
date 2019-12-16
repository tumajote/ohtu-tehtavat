package ohtu.kivipaperisakset;

public class Ihminen implements Pelaaja {
    Io io;

    public Ihminen(Io io) {
        this.io = io;
    }

    @Override
    public String annaSiirto() {
        return io.seuraavaStr();
    }

    @Override
    public void asetaSiirto(String ekanSiirto) {
    }
}
