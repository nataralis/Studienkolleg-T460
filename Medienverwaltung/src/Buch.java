public class Buch extends Medium {
    private String autor;
    private int seitenzahl;

    public String toString() {
        return "Titel: " + getTitel() + "\nAutor: " + autor + "\nSeitenzahl: " + seitenzahl + "\nPreis: " + getPreis() + "€";
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getSeitenzahl() {
        return seitenzahl;
    }

    public void setSeitenzahl(int seitenzahl) {
        this.seitenzahl = seitenzahl;
    }
}
