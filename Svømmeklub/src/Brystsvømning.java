public class Brystsvømning extends Disciplin {
    public Brystsvømning(int medlemsID, String dato, double træningstid, String stævne, int placering, double stævnetid){
        super(medlemsID, dato, træningstid, stævne, placering, stævnetid);
    }

    public Brystsvømning(int medlemsID, String dato, double træningstid) {
        super(medlemsID, dato, træningstid);
    }
}
