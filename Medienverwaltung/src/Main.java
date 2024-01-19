public class Main {
    public static void main(String[] args) {
        Buch b = new Buch();

        b.setTitel("1984");
        b.setAutor("George Orwell");
        b.setSeitenzahl(300);
        b.setPreis(19.8);

        System.out.println(b);
        System.out.println();

        Film f = new Film();

        f.setTitel("Jurassic Park");
        f.setRegisseur("Steven Spielberg");
        f.setLaenge(130);
        f.setPreis(20);

        System.out.println(f);
    }
}
