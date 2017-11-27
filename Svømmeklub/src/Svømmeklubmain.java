import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Svømmeklubmain
{
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        ArrayList<Medlem> medlemArray = new ArrayList<Medlem>();
        ArrayList<Konkurrencesvømmer> konkurrenceArray = new ArrayList<Konkurrencesvømmer>();
        Medlem.hentMedlem("medlemlist.txt", medlemArray);
        OpretMedlem(medlemArray, input);
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
            Medlem medlem = new Medlem(medlemsID, fornavn, efternavn, alder, køn, email, medlemstype, adresse, husnr, postnummer);
            medlemArray.add(medlem);

                System.out.println("Your information is as follows:\n");
                System.out.println(medlemArray + "\n");
            return medlem;
        }

    /*public static Konkurrencesvømmer OpretKonkurrence(ArrayList<Medlem> KonkurrenceArray, Scanner input)throws Exception{
        int medlemsID = CountLine("medlemList.txt")+1;
        System.out.println("\nmedlem:\n");
        System.out.println("Skriv fornavn på medlem:");
        String fornavn = input.next();
        System.out.println("Skriv efternavn på medlem:");
        String efternavn = input.next();
        System.out.println("Intast alder: ");
        IntPrint(input);
        int alder = input.nextInt();
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

        Konkurrencesvømmer konkurrence = new Medlem(medlemsID, fornavn, efternavn, alder, køn, email, medlemstype, adresse, husnr, postnummer, disciplin);
        KonkurrenceArray.add(konkurrence);

        System.out.println("Your information is as follows:\n");
        System.out.println(konkurrenceArray + "\n");
        return konkurrence;
    }*/

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
