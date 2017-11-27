public class Hundesvømning extends Disciplin {
    public Hundesvømning(int medlemsID, String dato, double træningstid, String stævne, int placering, double stævnetid){
        super(medlemsID, dato, træningstid, stævne, placering, stævnetid);
    }

    public Hundesvømning(int medlemsID, String dato, double træningstid) {
        super(medlemsID, dato, træningstid);
    }
}