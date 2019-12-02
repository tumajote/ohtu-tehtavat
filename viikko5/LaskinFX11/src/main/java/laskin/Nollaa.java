package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        sovellus.nollaa();
        int laskunTulos = sovellus.tulos();
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
        nollaa.disableProperty().set(true);
        nollaa.disableProperty().set(false);
        undo.disableProperty().set(false);
    }
    @Override
    public void peru() {
        sovellus.undo();
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
        if ( sovellus.tulos()==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(true);
    }
}
