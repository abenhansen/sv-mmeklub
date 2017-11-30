import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;
public class Konkurrencesvømmer extends Medlem implements Comparable<Konkurrencesvømmer>{
    private String disciplin;
    private double tid;
    private String hold;

    public Konkurrencesvømmer(double tid,int medlemsID, String fornavn, String efternavn, int alder, String køn, String email, String medlemstype, String adresse, int husnr, int postnummer, String disciplin, int kontingent, String betaling,  String hold){
        super(medlemsID, fornavn, efternavn, alder, køn, email, medlemstype, adresse, husnr, postnummer, kontingent, betaling);
        this.disciplin = disciplin;
        this.tid = tid;
        this.hold = hold;
    }
    //Getters and setters
    public String getDisciplin(){
        return disciplin;
    }

    public void setDisciplin(String disciplin){
        this.disciplin = disciplin;
    }

    public double getTid() {
        return tid;
    }


    public void GemCrawlFil(String file) throws Exception  {
        PrintStream outputToFile = new PrintStream(new FileOutputStream(file, true));
        //String pæn = String.format(Arrays.toString(crawltidArray).replaceAll("[\\,\\[\\]]",""));
        String svømmer = String.format("%f %d %s %s %d %s %s %s %s %d %d %s %d %s %s", tid, medlemsID, fornavn, efternavn, alder, køn, email, medlemstype, adresse, husnr, postnummer, disciplin, kontingent, betaling, hold);
        outputToFile.println(svømmer);
        outputToFile.flush();
    }

    public static void GemCrawl(String file,ArrayList<Konkurrencesvømmer> crawlArray) throws Exception {
        new PrintStream(new File(file));
        for (int i = 0; i < crawlArray.size(); i++) {
            crawlArray.get(i).GemCrawlFil(file);
        }
    }


    public static void hentCrawl(String file, ArrayList<Konkurrencesvømmer> crawlArray) throws Exception {
        Scanner scanner = new Scanner(new File(file));
        //scanner.useLocale(Locale.US);
        while (scanner.hasNextLine()) {

            /*for (int i = 0; i < crawltidArray.length; i++) {
                crawltidArray[i] = scanner.nextDouble();
            }*/
            crawlArray.add(new Konkurrencesvømmer(scanner.nextDouble(),scanner.nextInt(), scanner.next(), scanner.next(), scanner.nextInt(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.nextInt(), scanner.nextInt(),scanner.next(), scanner.nextInt(), scanner.next(), scanner.next()));
            scanner.nextLine();
        }
        scanner.close();
    }


    public void setTid(double tid) {
        this.tid = tid;
    }

    public int compareTo(Konkurrencesvømmer o) {
        return new Double(tid).compareTo(o.tid);
    }

    @Override
    public String toString() {
        return "Konkurrencesvømmer{" +
                "disciplin='" + disciplin + '\'' +
                ", tid=" + tid +
                ", hold='" + hold + '\'' +
                ", medlemsID=" + medlemsID +
                ", fornavn='" + fornavn + '\'' +
                ", efternavn='" + efternavn + '\'' +
                ", alder=" + alder +
                ", køn='" + køn + '\'' +
                ", email='" + email + '\'' +
                ", adresse='" + adresse + '\'' +
                ", medlemstype='" + medlemstype + '\'' +
                ", husnr=" + husnr +
                ", postnummer=" + postnummer +
                ", kontingent=" + kontingent +
                ", betaling=" + betaling +
                '}';
    }
}