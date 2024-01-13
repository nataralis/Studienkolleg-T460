public class Bruch {
    int zaehler;
    int nenner;

    public Bruch() {

    }

    public Bruch(int zaehler, int nenner) {
        this.zaehler = zaehler;
        this.nenner = nenner;
    }

    public String toString() {
        String str = zaehler + "/" + nenner;
        return str;
    }

    public Bruch multiplizieren(Bruch faktor) {
        Bruch produkt = new Bruch();
        produkt.zaehler = this.zaehler * faktor.zaehler;
        produkt.nenner = this.nenner * faktor.nenner;
        return produkt;
    }

    public Bruch dividieren(Bruch faktor) {
        Bruch quotient = new Bruch();
        quotient.zaehler = this.zaehler * faktor.nenner;
        quotient.nenner = this.nenner * faktor.zaehler;
        return quotient;
    }

    public Bruch addieren(Bruch summand) {
        Bruch summe = new Bruch();
        summe.zaehler = (this.zaehler * summand.nenner) + (summand.zaehler * this.nenner);
        summe.nenner = this.nenner * summand.nenner;
        return summe;
    }

    public Bruch subtrahieren(Bruch subtrahend) {
        Bruch differenz = new Bruch();
        differenz.zaehler = (this.zaehler * subtrahend.nenner) -  (subtrahend.zaehler * this.nenner);
        differenz.nenner = this.nenner * subtrahend.nenner;
        return differenz;
    }

    public Bruch kuerzen() {
        Bruch gekuerzterBruch = new Bruch();
        int ggt = ggtFinden(this.zaehler, this.nenner);
        gekuerzterBruch.zaehler = this.zaehler / ggt;
        gekuerzterBruch.nenner = this.nenner / ggt;
        return gekuerzterBruch;
    }

    private int ggtFinden(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return ggtFinden(b, a % b);
        }
    }

    public static void main(String[] args) throws Exception {
        Bruch a = new Bruch(3, 5);
        Bruch b = new Bruch(5, 2);
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.multiplizieren(b).kuerzen());
        System.out.println(a.dividieren(b));
        System.out.println(a.addieren(b));
        System.out.println(a.subtrahieren(b));
    }
}
