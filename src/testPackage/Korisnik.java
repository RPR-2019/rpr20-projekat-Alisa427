package testPackage;

public class Korisnik {
    private static String ime, lozinka, visina, tezina, ciljanaTezina, spol = "";
    static int id = 0;

    public Korisnik(String ime, String lozinka, String visina, String tezina, String ciljanaTezina, String spol) {
        this.ime = ime;
        this.lozinka = lozinka;
        this.visina = visina;
        this.tezina = tezina;
        this.ciljanaTezina = ciljanaTezina;
        this.spol = spol;
        id++;
    }

    public Korisnik() {

    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Korisnik.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getVisina() {
        return visina;
    }

    public void setVisina(String visina) {
        this.visina = visina;
    }

    public String getTezina() {
        return tezina;
    }

    public void setTezina(String tezina) {
        this.tezina = tezina;
    }

    public String getCiljanaTezina() {
        return ciljanaTezina;
    }

    public void setCiljanaTezina(String ciljanaTezina) {
        this.ciljanaTezina = ciljanaTezina;
    }

    public String getSpol() {
        return spol;
    }

    public void setSpol(String spol) {
        this.spol = spol;
    }

    @Override
    public String toString() {
        return "ime='" + ime + '\'' +
                ", ciljanaTezina='" + ciljanaTezina + "'";
    }
}
