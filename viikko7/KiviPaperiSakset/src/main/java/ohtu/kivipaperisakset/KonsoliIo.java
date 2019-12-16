package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KonsoliIo implements Io {
    private Scanner lukija;

    public KonsoliIo() {
        this.lukija = new Scanner(System.in);
    }

    @Override
    public String seuraavaStr() {
        return lukija.nextLine();
    }

    @Override
    public void print(String m) {
        System.out.println(m);
    }
}
