package ohtu.kivipaperisakset;

import java.util.HashMap;

public class Pelitehdas {
    private HashMap<String, Peli> pelit;

    public Pelitehdas(Io io) {
        this.pelit = new HashMap<>();
        pelit.put("a", new Peli(io));
        pelit.put("b", new KPSTekoaly(io));
        pelit.put("c", new KPSParempiTekoaly(io));
    }

    public Peli hae(String valinta) {
        return pelit.get(valinta);
    }
}
