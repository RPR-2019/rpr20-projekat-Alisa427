import org.junit.jupiter.api.Test;
import testPackage.Korisnik;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class KorisnikTest {
    @Test
    void konstruktor() {
        Korisnik k = new Korisnik("ime", "lozinka", "170", "75", "60", "muški");
        assertEquals("ime", k.getIme());
        assertEquals("lozinka", k.getLozinka());
        assertEquals("170", k.getVisina());
        assertEquals("75", k.getTezina());
        assertEquals("60", k.getCiljanaTezina());
        assertEquals("muški", k.getSpol());

    }

    @Test
    void toStringTest() {
        Korisnik k = new Korisnik("ime", "lozinka", "170", "75", "60", "muški");
        String s = "" + k;
        assertEquals("ime='ime', ciljanaTezina='60'", s);
    }

    @Test
    void setteri() {
        Korisnik k = new Korisnik("ime", "lozinka", "170", "75", "60", "muški");
        k.setIme("a");
        k.setLozinka("b");
        k.setTezina("c");
        k.setVisina("d");
        k.setCiljanaTezina("e");
        k.setSpol("žensko");
        assertEquals("a", k.getIme());
        assertEquals("b", k.getLozinka());
        assertEquals("c", k.getTezina());
        assertEquals("d", k.getVisina());
        assertEquals("e", k.getCiljanaTezina());
        assertEquals("žensko", k.getSpol());
    }
}
