import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Svømmeklubmain
{
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        ArrayList<Medlem> medlemArray = new ArrayList<Medlem>();
        ArrayList<Konkurrencesvømmer> crawlArray = new ArrayList<Konkurrencesvømmer>();
        Double[] crawltidArray ={0.0,0.0,0.0,0.0};
        Medlem.hentMedlem("medlemlist.txt", medlemArray);
        Konkurrencesvømmer.hentCrawl("crawl.txt", crawlArray, crawltidArray);
        System.out.println(Arrays.toString(crawltidArray));
        OpretCrawl(crawlArray,crawltidArray, input);
        Konkurrencesvømmer.GemCrawl("crawl.txt", crawlArray, crawltidArray);
        Medlem.GemMedlem("medlemlist.txt", medlemArray);

    }
        public static Medlem OpretMedlem(ArrayList<Medlem> medlemArray, Scanner input)throws Exception{
            int medlemsID = CountLine("medlemList.txt")+1;
            System.out.println("\nmedlem:\n");
            System.out.println("Skriv fornavn på medlem:");
            String fornavn = input.next();
            System.out.println("Skriv efternavn på medlem:");
            String efternavn = input.next();
            System.out.println("Intast alder: ");
            IntPrint(input);
            int alder = input.nextInt();
            int kontingent = 0;
            System.out.println("Intast dit køn: ");
             String køn = input.next();
            System.out.println("Intast email: ");
            String email = input.next();
            System.out.println("Intast om personen er aktiv eller passiv: ");
            String medlemstype = input.next();
            System.out.println("Skriv adresse navn på medlemet : ");
            String adresse = input.next();
            System.out.println("Skriv hus nummer til adressen : ");
            IntPrint(input);
            int husnr = input.nextInt();
            System.out.println("Intast postnummer: ");
            IntPrint(input);
            int postnummer = input.nextInt();
            Medlem medlem = new Medlem(medlemsID, fornavn, efternavn, alder, køn, email, medlemstype, adresse, husnr, postnummer, kontingent);
            medlemArray.add(medlem);

                System.out.println("Your information is as follows:\n");
                System.out.println(medlemArray + "\n");
            return medlem;
        }

    /*public static Disciplin OpretCrawl(ArrayList<Disciplin> crawlArray, Scanner input)throws Exception{
        Disciplin Crawl = new Disciplin(Medlem.getMedlemsID(),"Crawl", "0",0 );
        crawlArray.add(Crawl);
        return Crawl;
   }*/
    public static Konkurrencesvømmer OpretCrawl(ArrayList<Konkurrencesvømmer> crawlArray, Double[] crawltidArray, Scanner input)throws Exception{
        int medlemsID = CountLine("medlemList.txt")+1;
        System.out.println("\nmedlem:\n");
        System.out.println("Skriv fornavn på medlem:");
        String fornavn = input.next();
        System.out.println("Skriv efternavn på medlem:");
        String efternavn = input.next();
        System.out.println("Intast alder: ");
        IntPrint(input);
        int alder = input.nextInt();
        int kontingent =0;
        System.out.println("Intast dit køn: ");
        String køn = input.next();
        System.out.println("Intast email: ");
        String email = input.next();
        System.out.println("Intast om personen er aktiv eller passiv: ");
        String medlemstype = input.next();
        System.out.println("Skriv adresse navn på medlemet : ");
        String adresse = input.next();
        System.out.println("Skriv hus nummer til adressen : ");
        IntPrint(input);
        int husnr = input.nextInt();
        System.out.println("Intast postnummer: ");
        IntPrint(input);
        int postnummer = input.nextInt();

        Konkurrencesvømmer Crawl = new Konkurrencesvømmer(medlemsID, fornavn, efternavn, alder, køn, email, medlemstype, adresse, husnr, postnummer, "Crawl",crawltidArray, kontingent);
        crawlArray.add(Crawl);

        System.out.println("Your information is as follows:\n");
        System.out.println(crawlArray + "\n");
        return Crawl;
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

    public static String IntPrint(Scanner input){
        String number =null;
        while (!input.hasNextInt()) {
            number = input.next();
            System.out.println("Invalid input please enter number");
        }
        return number;
    }

}
