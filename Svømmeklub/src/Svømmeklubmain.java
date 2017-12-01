import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

    public class Svømmeklubmain
    {
        public static void main(String[] args) throws Exception {
            Scanner input = new Scanner(System.in);
            ArrayList<Medlem> medlemArray = new ArrayList<Medlem>();
            ArrayList<Konkurrencesvømmer> crawlArray = new ArrayList<Konkurrencesvømmer>();
            //Double[] crawltidArray ={10.0,5.6,0.8,0.0};
            Medlem.hentMedlem("medlemlist.txt", medlemArray);
            Konkurrencesvømmer.hentCrawl("crawl.txt", crawlArray);
            System.out.println(crawlArray);
            fixArrays(crawlArray);
            FjernMedlem(crawlArray);
        //OpretMedlem(medlemArray, input);
        //OpretCrawl(crawlArray, input);
        Konkurrencesvømmer.GemCrawl("crawl.txt", crawlArray);
        Medlem.GemMedlem("medlemlist.txt", medlemArray);

    }

    public static void fixArrays (ArrayList<Konkurrencesvømmer>crawlArray) {
        Collections.sort(crawlArray);
        System.out.println(crawlArray);
    }

        public static void ændreBetaling(ArrayList<Medlem> medlemArray, Scanner input){
            System.out.println("Tast 1 for at registrere medlemmets betaling af kontingent.");
            System.out.println("Tast 2 for at redigere medlemmets betaling til ikke betalt.");

            switch(input.nextInt()) {
                case 1:
                    System.out.println("Indtast ID på medlem du vil ændre");
                    medlemArray.get(input.nextInt()-1).registrerBetaling();
                    break;

                case 2:
                    medlemArray.get(input.nextInt()-1).ikkeBetalt();
                    break;
            }
        }

        public static void tjekBetaling(ArrayList<Medlem> medlemArray){
            ArrayList<Medlem> restanceListe = new ArrayList<Medlem>();
            for (Medlem medlem: medlemArray) {
                if(medlem.getBetaling().equals("nej")){
                    restanceListe.add(medlem);
                }
            }
            for (Medlem medlem: restanceListe) {
                System.out.println(medlem.getFornavn()+" "+medlem.getEfternavn());
            }
        }


        public static void FjernMedlem (ArrayList<Konkurrencesvømmer> crawlArray) throws Exception   {
            Scanner input = new Scanner(System.in);
            Scanner input2 = new Scanner(System.in);
            System.out.println("Indsæt ID for medlem der skal fjernes:");
            int count4 = 0;
            int count3 = 0;
            int count2 = 0;
            int count  = 0;
            do {

                IntPrint(input);
                int userInput = input.nextInt()-1;
                System.out.println(crawlArray.get(userInput));


                do {
                    System.out.println("Slet medlem? (J for ja - N for nej)");
                    String JN = input.next();
                    do {
                        switch (JN) {
                            case "J":
                                System.out.println("Sletter medlem \n" + crawlArray.get(userInput));
                                crawlArray.remove(userInput);
                                count++;
                                count2++;
                                count3++;
                                break;
                            case "N":
                                count4++;
                                count3++;
                                count2++;
                                count++;
                                break;
                            default:
                                System.out.println("Fejl. Indtast J for ja, N for nej");
                                count3++;
                                break;
                        }
                    }while (count3==0);

                }   while (count2==0);
            }   while (count==0);
            System.out.println("Afslutter \"Fjern Medlem\"");
            Thread.sleep(1000);



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
            String medlemstype = "";
            boolean fejl = true;
            do{
                medlemstype = input.next();
                if(medlemstype.equals("aktiv") || (medlemstype.equals("Aktiv"))){
                    break;
                }
                else if(medlemstype.equals("passiv") || (medlemstype.equals("Passiv"))){
                    kontingent = 500;
                    break;
                }
                else{
                    System.out.println("Indtast aktiv eller passiv.");
                }
            }
            while(fejl);
            String betalt = "nej";
            System.out.println("Skriv adresse navn på medlemet : ");
            String adresse = input.next();
            System.out.println("Skriv hus nummer til adressen : ");
            IntPrint(input);
            int husnr = input.nextInt();
            System.out.println("Intast postnummer: ");
            IntPrint(input);
            int postnummer = input.nextInt();
            Medlem medlem = new Medlem(medlemsID, fornavn, efternavn, alder, køn, email, medlemstype, adresse, husnr, postnummer, kontingent, betalt);
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
    public static Konkurrencesvømmer OpretCrawl(ArrayList<Konkurrencesvømmer> crawlArray, Scanner input)throws Exception{
        int kontingent =0;
        String hold ="";
        String betaling="nej";
        int medlemsID = CountLine("medlemList.txt")+1;
        System.out.println("\nmedlem:\n");
        System.out.println("Skriv fornavn på medlem:");
        String fornavn = input.next();
        System.out.println("Skriv efternavn på medlem:");
        String efternavn = input.next();
        System.out.println("Intast alder: ");
        IntPrint(input);
        int alder = input.nextInt();
        if(alder >= 0 && alder < 18){ //alder/input
            kontingent = 1000;
            hold = "junior";
        }
        else if(alder >= 18 && alder < 60){
            kontingent = 1600;
            hold = "senior";
        }
        else if(alder >= 60 && alder < 100){
            kontingent = 1200;
            hold = "senior";
        }
        else{
            System.out.println("Ugyldig alder. Prøv igen.");
        }
        System.out.println("Intast dit køn: ");
        String køn = input.next();
        System.out.println("Intast email: ");
        String email = input.next();
        System.out.println("Skriv adresse navn på medlemet : ");
        String adresse = input.next();
        System.out.println("Skriv hus nummer til adressen : ");
        IntPrint(input);
        int husnr = input.nextInt();
        System.out.println("Intast postnummer: ");
        IntPrint(input);
        int postnummer = input.nextInt();
        System.out.println("Intast om personen er aktiv eller passiv: ");
        String medlemstype = "";
        boolean fejl = true;
        do{
            medlemstype = input.next();
            if(medlemstype.equals("aktiv") || (medlemstype.equals("Aktiv"))){
                break;
            }
            else{
                System.out.println("Indtast aktiv eller passiv.");
                break;
            }
        }
        while(fejl);
        System.out.println("Indtast svømmers bedste tid");
        DoublePrint(input);
        double tid = input.nextDouble();
        Konkurrencesvømmer Crawl = new Konkurrencesvømmer(tid, medlemsID, fornavn, efternavn, alder, køn, email, medlemstype, adresse, husnr, postnummer, "Crawl", kontingent, betaling, hold);
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


    public static String DoublePrint(Scanner input){
        String number =null;
        while (!input.hasNextDouble()) {
            number = input.next();
            System.out.println("Invalid input please enter number");
        }
        return number;
    }

}
