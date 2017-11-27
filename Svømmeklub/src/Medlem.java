import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Medlem{

    protected int medlemsID;
    protected String fornavn;
    protected String efternavn;
    protected int alder;
    protected String køn;
    protected String email;
    protected String adresse;
    protected String medlemstype;
    protected int husnr;
    protected int postnummer;

    public Medlem(int medlemsID, String fornavn, String efternavn, int alder, String køn, String email, String medlemstype, String adresse, int husnr, int postnummer){
        this.medlemsID = medlemsID;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.alder = alder;
        this.køn = køn;
        this.email = email;
        this.adresse = adresse;
        this.medlemstype = medlemstype;
        this.husnr = husnr;
        this.postnummer = postnummer;
            }

    //getters and setters
    public int getMedlemsID(){
        return medlemsID;
    }

    public void setMedlemsID(int medlemsID) {
        this.medlemsID = medlemsID;
            }

    public String getFornavn(){
        return fornavn;
    }

    public void setForavn(String navn){
        this.fornavn = fornavn;
    }
    public String getEfternavn(){
        return efternavn;
    }

    public void setEfternavn(String navn){
        this.efternavn = efternavn;
    }

    public int getAlder(){
        return alder;
    }

    public void setAlder(int alder){
        this.alder = alder;
    }

    public String getKøn(){
        return køn;
    }

    public void setKøn(String køn){
        this.køn = køn;
    }

    public String getAdresse(){
        return adresse;
    }

    public void setAdresse(String adresse){
        this.adresse = adresse;
    }

    public String getMedlemstype(){
        return medlemstype;
    }

    public void setMedlemstype(String medlemstype1){
        this.medlemstype = medlemstype1;
    }

    public static int CountLine(String filename)throws Exception{
        Scanner file = new Scanner(new File(filename));
        int count = 0;
        while (file.hasNextLine()) {
            file.nextLine();
            count++;
        }
        return count;
    }

    public void GemFil(String file) throws Exception  {
        PrintStream outputToFile = new PrintStream(new FileOutputStream(file, true));
        String svømmer = String.format("%d %s %s %d %s %s %s %s %d %d", medlemsID, fornavn, efternavn, alder, køn, email, medlemstype, adresse, husnr, postnummer);
        outputToFile.println(svømmer);
        outputToFile.flush();
    }


    public static void GemMedlem(String file,ArrayList<Medlem> medlemArray) throws Exception {
        new PrintStream(new File(file));
        for (int i = 0; i < medlemArray.size(); i++) {
            medlemArray.get(i).GemFil(file);
        }
    }

    public static void hentMedlem(String file, ArrayList<Medlem> medlemArray) throws Exception {
        Scanner scanner = new Scanner(new File(file));
        while (scanner.hasNextLine()) {
                medlemArray.add(new Medlem(scanner.nextInt(), scanner.next(), scanner.next(), scanner.nextInt(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.nextInt(), scanner.nextInt()));
                scanner.nextLine();
        }
        scanner.close();
    }
            }