/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tmjterho
 */
public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void pelaajaLoytyy() {
        String pelaaja1 = stats.search("Kurri").toString();
        String pelaaja2 = new Player("Kurri", "EDM", 37, 53).toString();
        assertEquals(pelaaja2, pelaaja1);
    }

    @Test
    public void pelaajaEiLoydy() {
        Player pelaaja1 = stats.search("Kurrie");
        assertNull(pelaaja1);

    }

    @Test
    public void topScorerOikein() {
        String pelaaja1 = stats.topScorers(1).get(0).toString();
        String pelaaja2 = new Player("Gretzky", "EDM", 35, 89).toString();
        assertEquals(pelaaja2, pelaaja1);
    }

    @Test
    public void teamToimiiOikein() {
        
        String pelaaja1 = stats.team("PIT").get(0).toString();
        String pelaaja2 = new Player("Lemieux", "PIT", 45, 54).toString();
        
        assertEquals(pelaaja2, pelaaja1);
    }

}
