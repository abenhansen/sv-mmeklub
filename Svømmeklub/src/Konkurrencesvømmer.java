import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;
public class Konkurrencesvømmer extends Medlem {
    private String disciplin;



    public Konkurrencesvømmer(int medlemsID, String fornavn, String efternavn, int alder, String køn, String email, String medlemstype, String adresse, int husnr, int postnummer, String disciplin,Double[] crawltidArray, int kontingent){
        super(medlemsID, fornavn, efternavn, alder, køn, email, medlemstype, adresse, husnr, postnummer, kontingent);
        this.disciplin = disciplin;
    }
    //Getters and setters
    public String getDisciplin(){
        return disciplin;
    }

    public void setDisciplin(String disciplin){
        this.disciplin = disciplin;
    }


    public void GemCrawlFil(String file, Double[] crawltidArray) throws Exception  {
        PrintStream outputToFile = new PrintStream(new FileOutputStream(file, true));
        String pæn = String.format(Arrays.toString(crawltidArray).replaceAll("[\\,\\[\\]]",""));
        String svømmer = String.format("%s %d %s %s %d %s %s %s %s %d %d %s %d", pæn, medlemsID, fornavn, efternavn, alder, køn, email, medlemstype, adresse, husnr, postnummer, disciplin, kontingent);
        outputToFile.println(svømmer);
        outputToFile.flush();
    }

    public static void GemCrawl(String file,ArrayList<Konkurrencesvømmer> crawlArray, Double[] crawltidArray) throws Exception {
        new PrintStream(new File(file));
        for (int i = 0; i < crawlArray.size(); i++) {
            crawlArray.get(i).GemCrawlFil(file, crawltidArray);
        }
    }


    public static void hentCrawl(String file, ArrayList<Konkurrencesvømmer> crawlArray, Double[] crawltidArray) throws Exception {
        Scanner scanner = new Scanner(new File(file));
        scanner.useLocale(Locale.US);
        while (scanner.hasNextLine()) {

            for (int i = 0; i < crawltidArray.length; i++) {
                crawltidArray[i] = scanner.nextDouble();
            }
            crawlArray.add(new Konkurrencesvømmer(scanner.nextInt(), scanner.next(), scanner.next(), scanner.nextInt(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.nextInt(), scanner.nextInt(),scanner.next(), crawltidArray, scanner.nextInt()));
            scanner.nextLine();
        }
        scanner.close();
    }


}