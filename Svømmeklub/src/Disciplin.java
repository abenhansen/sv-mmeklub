public class Disciplin {
    private String navn;
    protected int medlemsID;
    protected String dato;
    protected double træningstid;
    protected String stævne;
    protected int placering;
    protected double stævnetid;

    public Disciplin(int medlemsID, String navn, String dato, double træningstid, String stævne, int placering, double stævnetid){
        this.medlemsID = medlemsID;
        this.navn = navn;
        this.dato = dato;
        this.træningstid = træningstid;
        this.stævne = stævne;
        this.placering = placering;
        this.stævnetid = stævnetid;
    }

    public Disciplin(int medlemsID, String navn, String dato, double træningstid) {
        this.medlemsID = medlemsID;
        this.navn = navn;
        this.dato = dato;
        this.træningstid = træningstid;
    }


    //getters and setters
    public int getMedlemsID() {
        return medlemsID;
    }

    public void setMedlemsID(int medlemsID) {
        this.medlemsID = medlemsID;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public double getTræningstid() {
        return træningstid;
    }

    public void setTræningstid(double træningstid) {
        this.træningstid = træningstid;
    }

    public String getStævne() {
        return stævne;
    }

    public void setStævne(String stævne) {
        this.stævne = stævne;
    }

    public int getPlacering() {
        return placering;
    }

    public void setPlacering(int placering) {
        this.placering = placering;
    }

    public double getStævnetid() {
        return stævnetid;
    }

    public void setStævnetid(double stævnetid) {
        this.stævnetid = stævnetid;
    }
}
