public class Konkurrencesvømmer extends Medlem {
    private String disciplin;

    public Konkurrencesvømmer(int medlemsID, String fornavn, String efternavn, int alder, String køn, String email, String medlemstype, String adresse, int husnr, int postnummer, String disciplin){
        super(medlemsID, fornavn, efternavn, alder, køn, email, medlemstype, adresse, husnr, postnummer);
        this.disciplin = disciplin;
    }
    //Getters and setters
    public String getDisciplin(){
        return disciplin;
    }

    public void setDisciplin(String disciplin){
        this.disciplin = disciplin;
    }


}