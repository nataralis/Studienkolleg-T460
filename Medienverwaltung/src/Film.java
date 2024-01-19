public class Film extends Medium {
    private String regisseur;
    private int laenge;

    public String toString() {
        return "Titel: " + getTitel() + "\nRegisseur: " + regisseur + "\nLänge: " + laenge + "\nPreis: " + getPreis() + "€";
    }

    public String getRegisseur() {
        return regisseur;
    }

    public void setRegisseur(String regisseur) {
        this.regisseur = regisseur;
    }

    public int getLaenge() {
        return laenge;
    }

    public void setLaenge(int laenge) {
        this.laenge = laenge;
    }
}
