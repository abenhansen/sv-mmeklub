import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.*;

    public class Svømmeklubmain {
        public static void main(String[] args) throws Exception {
            ArrayList<Medlem> medlemArray = new ArrayList<Medlem>();
            ArrayList<Konkurrencesvømmer> crawlArray = new ArrayList<Konkurrencesvømmer>();
            ArrayList<Konkurrencesvømmer> rygArray = new ArrayList<Konkurrencesvømmer>();
            ArrayList<Konkurrencesvømmer> hundeArray = new ArrayList<Konkurrencesvømmer>();
            ArrayList<Konkurrencesvømmer> butterflyArray = new ArrayList<Konkurrencesvømmer>();
            ArrayList<Konkurrencesvømmer> brystArray = new ArrayList<Konkurrencesvømmer>();
            LoadArrays(crawlArray, medlemArray, rygArray, hundeArray, brystArray, butterflyArray);
            MenuMain(medlemArray,crawlArray, rygArray, hundeArray, brystArray, butterflyArray);
            GemArrays(crawlArray, medlemArray, rygArray, hundeArray, brystArray, butterflyArray);

        }

        public static void LoadArrays(ArrayList<Konkurrencesvømmer> crawlArray, ArrayList<Medlem> medlemArray,
                                      ArrayList<Konkurrencesvømmer> rygArray, ArrayList<Konkurrencesvømmer> hundeArray,
                                      ArrayList<Konkurrencesvømmer> brystArray, ArrayList<Konkurrencesvømmer> butterflyArray) throws Exception {
            Medlem.hentMedlem("medlemlist.txt", medlemArray);
            Konkurrencesvømmer.hentCrawl("crawl.txt", crawlArray);
            Konkurrencesvømmer.hentCrawl("ryg.txt", rygArray);
            Konkurrencesvømmer.hentCrawl("hundesvømning.txt", hundeArray);
            Konkurrencesvømmer.hentCrawl("brystsvømning.txt", brystArray);
            Konkurrencesvømmer.hentCrawl("butterfly.txt", butterflyArray);
        }

        public static void GemArrays(ArrayList<Konkurrencesvømmer> crawlArray, ArrayList<Medlem> medlemArray,
                                     ArrayList<Konkurrencesvømmer> rygArray, ArrayList<Konkurrencesvømmer> hundeArray,
                                     ArrayList<Konkurrencesvømmer> brystArray, ArrayList<Konkurrencesvømmer> butterflyArray) throws Exception {
            Konkurrencesvømmer.GemCrawl("crawl.txt", crawlArray);
            Konkurrencesvømmer.GemCrawl("ryg.txt", rygArray);
            Konkurrencesvømmer.GemCrawl("hundesvømning.txt", hundeArray);
            Konkurrencesvømmer.GemCrawl("brystsvømning.txt", brystArray);
            Konkurrencesvømmer.GemCrawl("butterfly.txt", butterflyArray);
            Medlem.GemMedlem("medlemlist.txt", medlemArray);
        }


        public static void fixArrays(ArrayList<Konkurrencesvømmer> crawlArray) {
            ArrayList<Konkurrencesvømmer> temp = (ArrayList<Konkurrencesvømmer>) crawlArray.clone();
            Collections.sort(temp);
            System.out.println("Top 5 bedste svømmere inde for crawl");
            if (crawlArray.size()<5){
                for(int j=0; j<temp.size(); j++)
                    System.out.println("ID = " + temp.get(j).getMedlemsID() + " Navn = " + temp.get(j).getFornavn() +
                            " " + temp.get(j).getEfternavn() + ", Diciplin = " + temp.get(j).getDisciplin() + ", Tid = " +
                            temp.get(j).getTid());
            }
            else{
            for (int i = 0; i < 5; i++)
                System.out.println("ID = " + temp.get(i).getMedlemsID() + " Navn = " + temp.get(i).getFornavn() +
                        " " + temp.get(i).getEfternavn() + ", Diciplin = " + temp.get(i).getDisciplin() + ", Tid = " +
                        temp.get(i).getTid());
        }}

        public static void ændreBetaling(ArrayList<Medlem> medlemArray, Scanner input) {
            System.out.println("Tast 1 for at registrere medlemmets betaling af kontingent.");
            System.out.println("Tast 2 for at redigere medlemmets betaling til ikke betalt.");
            int switchNumber = 0;
            do {
                IntPrint(input);
                switch (input.nextInt()) {
                    case 1:
                        System.out.println("Indtast ID på medlem du vil ændre");
                        int userInput = 0;
                        do {
                            IntPrint(input);
                            userInput = input.nextInt() - 1;
                            if (userInput > medlemArray.size()) {
                                System.out.println("Fejl. Indsæt ID for medlem:");
                            }
                            if (userInput < medlemArray.size()) {
                                medlemArray.get(userInput).registrerBetaling();
                            }
                        } while (userInput > medlemArray.size());
                        System.out.println(medlemArray.get(userInput));
                        switchNumber++;
                        break;

                    case 2:
                        System.out.println("Indtast ID på medlem du vil ændre");
                        do {
                            IntPrint(input);
                            userInput = input.nextInt() - 1;
                            if (userInput > medlemArray.size()) {
                                System.out.println("Fejl. Indsæt ID for medlem:");
                            }
                            if (userInput < medlemArray.size()) {
                                medlemArray.get(userInput).ikkeBetalt();
                            }
                        } while (userInput > medlemArray.size());
                        switchNumber++;
                        break;
                    default:
                        System.out.println("Fejl. Indtast 1 eller 2");
                }
            } while (switchNumber == 0);

        }


        public static void ændreBetalingKon(ArrayList<Konkurrencesvømmer> medlemArray, Scanner input) {
            System.out.println("Tast 1 for at registrere medlemmets betaling af kontingent.");
            System.out.println("Tast 2 for at redigere medlemmets betaling til ikke betalt.");
            int switchNumber = 0;
            do {
                IntPrint(input);
                switch (input.nextInt()) {
                    case 1:
                        System.out.println("Indtast ID på medlem du vil ændre");
                        int userInput = 0;
                        do {
                            IntPrint(input);
                            userInput = input.nextInt() - 1;
                            if (userInput > medlemArray.size()) {
                                System.out.println("Fejl. Indsæt ID for medlem:");
                            }
                            if (userInput < medlemArray.size()) {
                                medlemArray.get(userInput).registrerBetaling();
                            }
                        } while (userInput > medlemArray.size());
                        System.out.println(medlemArray.get(userInput));
                        switchNumber++;
                        break;

                    case 2:
                        System.out.println("Indtast ID på medlem du vil ændre");
                        do {
                            IntPrint(input);
                            userInput = input.nextInt() - 1;
                            if (userInput > medlemArray.size()) {
                                System.out.println("Fejl. Indsæt ID for medlem:");
                            }
                            if (userInput < medlemArray.size()) {
                                medlemArray.get(userInput).ikkeBetalt();
                            }
                        } while (userInput > medlemArray.size());
                        switchNumber++;
                        break;
                    default:
                        System.out.println("Fejl. Indtast 1 eller 2");
                }
            } while (switchNumber == 0);

        }

        public static void tjekBetaling(ArrayList<Konkurrencesvømmer> crawlArray, ArrayList<Medlem> medlemArray, ArrayList<Konkurrencesvømmer> rygArray, ArrayList<Konkurrencesvømmer> hundeArray,
                                        ArrayList<Konkurrencesvømmer> brystArray, ArrayList<Konkurrencesvømmer> butterflyArray) {
            ArrayList<Medlem> restanceListe = new ArrayList<Medlem>();
            for (Medlem medlem : medlemArray) {
                if (medlem.getBetaling().equals("nej")) {
                    restanceListe.add(medlem);
                }
            }
            for (Medlem medlem : crawlArray) {
                if (medlem.getBetaling().equals("nej")) {
                    restanceListe.add(medlem);
                }
            }
            for (Medlem medlem : rygArray) {
                if (medlem.getBetaling().equals("nej")) {
                    restanceListe.add(medlem);
                }
            }
            for (Medlem medlem : brystArray) {
                if (medlem.getBetaling().equals("nej")) {
                    restanceListe.add(medlem);
                }
            }
            for (Medlem medlem : butterflyArray) {
                if (medlem.getBetaling().equals("nej")) {
                    restanceListe.add(medlem);
                }
            }
            for (Medlem medlem : hundeArray) {
                if (medlem.getBetaling().equals("nej")) {
                    restanceListe.add(medlem);
                }
            }
            for (Medlem medlem : restanceListe) {
                System.out.println("Navn = " + medlem.getFornavn() + " " + medlem.getEfternavn() + ", Gæld = " + medlem.getKontingent() + ", Betalt? " + medlem.getBetaling());
            }
        }


        public static void FjernKonkurrenceMedlem(ArrayList<Konkurrencesvømmer> crawlArray) throws Exception {
            Scanner input = new Scanner(System.in);
            Scanner input2 = new Scanner(System.in);
            System.out.println("Indsæt ID for medlem der skal fjernes:");
            int count4 = 0;
            int count3 = 0;
            int count2 = 0;
            int count = 0;
            do {
                int userInput = 0;
                do {
                    IntPrint(input);
                    userInput = input.nextInt() - 1;
                    if (userInput > crawlArray.size()) {
                        System.out.println("Fejl. Indsæt ID for medlem:");
                    }
                } while (userInput > crawlArray.size());
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
                    } while (count3 == 0);

                } while (count2 == 0);
            } while (count == 0);
            System.out.println("Afslutter \"Fjern Medlem\"");
            Thread.sleep(1000);


        }

        public static void FjernMedlem(ArrayList<Medlem> crawlArray) throws Exception {
            Scanner input = new Scanner(System.in);
            Scanner input2 = new Scanner(System.in);
            System.out.println("Indsæt ID for medlem der skal fjernes:");
            int count4 = 0;
            int count3 = 0;
            int count2 = 0;
            int count = 0;
            do {
                int userInput = 0;
                do {
                    IntPrint(input);
                    userInput = input.nextInt() - 1;
                    if (userInput > crawlArray.size()) {
                        System.out.println("Fejl. Indsæt ID for medlem:");
                    }
                } while (userInput > crawlArray.size());
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
                    } while (count3 == 0);

                } while (count2 == 0);
            } while (count == 0);
            System.out.println("Afslutter \"Fjern Medlem\"");
            Thread.sleep(1000);
        }

        public static Medlem OpretMedlem(ArrayList<Medlem> medlemArray, Scanner input) throws Exception {
            int medlemsID;
            if (medlemArray.size() == 0) {
                medlemsID = 0;
            } else {
                medlemsID = medlemArray.get(medlemArray.size() - 1).getMedlemsID();
            }
            medlemsID++;
            System.out.println("\nmedlem:\n");
            System.out.println("Skriv fornavn på medlem:");
            String fornavn = input.next();
            System.out.println("Skriv efternavn på medlem:");
            String efternavn = input.next();
            System.out.println("Intast alder: ");
            int kontingent = 0;
            IntPrint(input);
            int alder = input.nextInt();
            if (alder >= 0 && alder < 18) { //alder/input
                kontingent = 1000;
            } else if (alder >= 18 && alder < 60) {
                kontingent = 1600;
            } else if (alder >= 60 && alder < 100) {
                kontingent = 1200;
            } else {
                System.out.println("Ugyldig alder. Prøv igen.");
            }
            System.out.println("Intast dit køn: ");
            String køn = input.next();
            System.out.println("Intast email: ");
            String email = input.next();
            System.out.println("Intast om personen er aktiv eller passiv: ");
            String medlemstype = "";
            boolean fejl = true;
            do {
                medlemstype = input.next();
                if (medlemstype.equals("aktiv") || (medlemstype.equals("Aktiv"))) {
                    fejl = false;
                } else if (medlemstype.equals("passiv") || (medlemstype.equals("Passiv"))) {
                    kontingent = 500;
                    fejl = false;
                } else {
                    System.out.println("Indtast aktiv eller passiv.");
                }
            }
            while (fejl == true);
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

        public static Konkurrencesvømmer OpretKonkurrence(ArrayList<Konkurrencesvømmer> crawlArray, Scanner input, String diciplin) throws Exception {
            int kontingent = 0;
            String hold = "";
            String betaling = "nej";
            int medlemsID;
            if (crawlArray.size() == 0) {
                medlemsID = 0;
            } else {
                medlemsID = crawlArray.get(crawlArray.size() - 1).getMedlemsID();
            }
            medlemsID++;
            System.out.println("\nmedlem:\n");
            System.out.println("Skriv fornavn på medlem:");
            String fornavn = input.next();
            System.out.println("Skriv efternavn på medlem:");
            String efternavn = input.next();
            System.out.println("Intast alder: ");
            IntPrint(input);
            int alder = input.nextInt();
            if (alder >= 0 && alder < 18) { //alder/input
                kontingent = 1000;
                hold = "junior";
            } else if (alder >= 18 && alder < 60) {
                kontingent = 1600;
                hold = "senior";
            } else if (alder >= 60 && alder < 100) {
                kontingent = 1200;
                hold = "senior";
            } else {
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
            do {
                medlemstype = input.next();
                if (medlemstype.equals("aktiv") || (medlemstype.equals("Aktiv"))) {
                    fejl = false;
                } else if (medlemstype.equals("passiv") || (medlemstype.equals("Passiv"))) {
                    kontingent = 500;
                    fejl = false;
                } else {
                    System.out.println("Indtast aktiv eller passiv.");
                }
            }
            while (fejl == true);
            double tid = 99.99;
            Konkurrencesvømmer Crawl = new Konkurrencesvømmer(tid, medlemsID, fornavn, efternavn, alder, køn, email, medlemstype, adresse, husnr, postnummer, diciplin, kontingent, betaling, hold);
            crawlArray.add(Crawl);
            System.out.println("Your information is as follows:\n");
            System.out.println(crawlArray + "\n");
            return Crawl;
        }


        public static void registrereTid(ArrayList<Konkurrencesvømmer> crawlArray) {
            Scanner input = new Scanner(System.in);
            int ID;
            System.out.println("Indsæt ID for det medlem som tiden skal registreres til:");

            do {
                IntPrint(input);
                ID = input.nextInt() - 1;
                if (ID > crawlArray.size()) {
                    System.out.println("Fejl. Indsæt ID for medlem:");
                }
            } while (ID > crawlArray.size());


            System.out.println("ID: [" + crawlArray.get(ID).getMedlemsID() + "] Navn: " + crawlArray.get(ID).getFornavn() + " " + crawlArray.get(ID).getEfternavn());
            System.out.println("Indsæt tid:");
            DoublePrint(input);
            double tid = input.nextDouble();
            crawlArray.get(ID).setTid(tid);
            System.out.println("Du satte tiden til: " + tid);
        }

        public static String IntPrint(Scanner input) {
            String number = null;
            while (!input.hasNextInt()) {
                number = input.next();
                System.out.println("Invalid input please enter number");
            }
            return number;
        }


        public static String DoublePrint(Scanner input) {
            String number = null;
            while (!input.hasNextDouble()) {
                number = input.next();
                System.out.println("Invalid input please enter number");
            }
            return number;
        }

        public static void MenuKonkurrenceRediger(ArrayList<Konkurrencesvømmer> crawlArray) {
            Scanner console = new Scanner(System.in);
            System.out.println("Skriv ID");
            boolean exit = true;
            int IDinput = 0;
            do {
                IntPrint(console);
                IDinput = console.nextInt()- 1;
                if (IDinput > crawlArray.size() || IDinput < 0) {
                    System.out.println("Fejl. Indsæt ID for medlem:");
                }
            } while (IDinput > crawlArray.size() || IDinput < 0);
            System.out.println(crawlArray.get(IDinput));
            String besked = "Hvad vil du ændre?\n\n1 for fornavn.\n2 for efternavn.\n3 for alder.\n4 for køn.\n5 for email.\n6 for vejnavn.\n7 for husnummer.\n8 for postnummer.\n9 for medlemstype.\n10 for disciplin.\n11 for hold.\n0 for at gå tilbage til menu.";
            System.out.println(besked);
            crawlArray.get(IDinput);
            IntPrint(console);
            int menuitem;
            do {
                menuitem = console.nextInt();
                switch (menuitem) {
                    case 1:
                        System.out.println("Skriv nyt fornavn.");
                        String fornavn = console.next();
                        crawlArray.get(IDinput).setFornavn(fornavn);
                        break;
                    case 2:
                        System.out.println("Skriv nyt efternavn.");
                        String efternavn = console.next();
                        crawlArray.get(IDinput).setEfternavn(efternavn);
                        break;
                    case 3:
                        int kontingent = 0;
                        String team = "";
                        System.out.println("Skriv ny Alder.");
                        IntPrint(console);
                        int alder = console.nextInt();
                        if (alder >= 0 && alder < 18) { //alder/input
                            kontingent = 1000;
                            team = "junior";
                        } else if (alder >= 18 && alder < 60) {
                            kontingent = 1600;
                            team = "senior";
                        } else if (alder >= 60 && alder < 100) {
                            kontingent = 1200;
                            team = "senior";
                        } else {
                            System.out.println("Ugyldig alder. Prøv igen.");
                        }
                        crawlArray.get(IDinput).setHold(team);
                        crawlArray.get(IDinput).setKontingent(kontingent);
                        crawlArray.get(IDinput).setAlder(alder);
                        break;
                    case 4:
                        System.out.println("Skriv nyt køn.");
                        String køn = console.next();
                        crawlArray.get(IDinput).setKøn(køn);
                        break;
                    case 5:
                        System.out.println("Skriv ny email.");
                        String email = console.next();
                        crawlArray.get(IDinput).setEmail(email);
                        break;
                    case 6:
                        System.out.println("Skriv ny adresse.");
                        String adresse = console.next();
                        crawlArray.get(IDinput).setAdresse(adresse);
                        break;
                    case 7:
                        System.out.println("Skriv nyt husnummer.");
                        IntPrint(console);
                        int husnr = console.nextInt();
                        crawlArray.get(IDinput).setHusnr(husnr);
                        break;
                    case 8:
                        System.out.println("Skriv nyt postnummer.");
                        IntPrint(console);
                        int postnummer = console.nextInt();
                        crawlArray.get(IDinput).setPostnummer(postnummer);
                        break;
                    case 9:
                       check(crawlArray,IDinput);
                        break;
                    case 10:
                        System.out.println("Skriv ny disciplin");
                        String disciplin = console.next();
                        crawlArray.get(IDinput).setDisciplin(disciplin);
                        break;
                    case 11:
                        System.out.println("Skriv nyt hold");
                        String hold = console.next();
                        crawlArray.get(IDinput).setHold(hold);
                        break;
                    case 0:
                        exit = false;
                        break;
                    default:
                        System.out.println("Input kan ikke læses");
                        break;
                }
                if (exit != false) {
                    System.out.println(besked);
                }

            } while (exit);


        }

        public static void MenuRediger(ArrayList<Medlem> crawlArray) {
            Scanner console = new Scanner(System.in);
            System.out.println("Skriv ID");
            boolean exit = true;
            int IDinput = 0;
            do {
                IntPrint(console);
                IDinput = console.nextInt()- 1;
                if (IDinput > crawlArray.size() || IDinput < 0) {
                    System.out.println("Fejl. Indsæt ID for medlem:");
                }
            } while (IDinput > crawlArray.size() || IDinput < 0);
            System.out.println(crawlArray.get(IDinput));
            String besked = "Hvad vil du ændre?\n\n1 for fornavn.\n2 for efternavn.\n3 for alder.\n4 for køn.\n5 for email.\n6 for vejnavn.\n7 for husnummer.\n8 for postnummer.\n9 for medlemstype.\n10 for disciplin.\n11 for hold.\n0 for at gå tilbage til menu.";
            System.out.println(besked);
            crawlArray.get(IDinput);
            IntPrint(console);
            int menuitem;
            do {
                menuitem = console.nextInt();
                switch (menuitem) {
                    case 1:
                        System.out.println("Skriv nyt fornavn.");
                        String fornavn = console.next();
                        crawlArray.get(IDinput).setFornavn(fornavn);
                        break;
                    case 2:
                        System.out.println("Skriv nyt efternavn.");
                        String efternavn = console.next();
                        crawlArray.get(IDinput).setEfternavn(efternavn);
                        break;
                    case 3:
                        System.out.println("Skriv ny Alder.");
                        IntPrint(console);
                        int alder = console.nextInt();
                        crawlArray.get(IDinput).setAlder(alder);
                        break;
                    case 4:
                        System.out.println("Skriv nyt køn.");
                        String køn = console.next();
                        crawlArray.get(IDinput).setKøn(køn);
                        break;
                    case 5:
                        System.out.println("Skriv ny email.");
                        String email = console.next();
                        crawlArray.get(IDinput).setEmail(email);
                        break;
                    case 6:
                        System.out.println("Skriv ny adresse.");
                        String adresse = console.next();
                        crawlArray.get(IDinput).setAdresse(adresse);
                        break;
                    case 7:
                        System.out.println("Skriv nyt husnummer.");
                        IntPrint(console);
                        int husnr = console.nextInt();
                        crawlArray.get(IDinput).setHusnr(husnr);
                        break;
                    case 8:
                        System.out.println("Skriv nyt postnummer.");
                        IntPrint(console);
                        int postnummer = console.nextInt();
                        crawlArray.get(IDinput).setPostnummer(postnummer);
                        break;
                    case 9:
                        System.out.println("Skriv ny medlemstype");
                        String s = "";
                        boolean fejl = true;
                        do {
                            s = console.next();
                            if (s.equals("aktiv") || (s.equals("Aktiv"))) {
                                fejl = false;
                            } else if (s.equals("passiv") || (s.equals("Passiv"))) {
                                int kontingent = 500;
                                crawlArray.get(IDinput).setKontingent(kontingent);
                                fejl = false;
                            } else {
                                System.out.println("Indtast aktiv eller passiv.");
                            }
                        }
                        while (fejl == true);
                        crawlArray.get(IDinput).setMedlemstype(s);
                        System.out.println("Medlemstype er blevet ændret");
                        break;
                    case 0:
                        exit = false;
                        break;
                    default:
                        System.out.println("Input kan ikke læses");
                        break;
                }
                if (exit != false) {
                    System.out.println(besked);
                }

            } while (exit);
        }




        public static void check(ArrayList<Konkurrencesvømmer> crawlArray, int IDinput) {
            Scanner console = new Scanner(System.in);
            System.out.println("Skriv ny medlemstype");
            String s = "";
            boolean fejl = true;
            do {
                s = console.next();
                if (s.equals("aktiv") || (s.equals("Aktiv"))) {
                    fejl = false;
                } else if (s.equals("passiv") || (s.equals("Passiv"))) {
                    int kontingent = 500;
                    crawlArray.get(IDinput).setKontingent(kontingent);
                    fejl = false;
                } else {
                    System.out.println("Indtast aktiv eller passiv.");
                }
            }
            while (fejl == true);
            crawlArray.get(IDinput).setMedlemstype(s);
            System.out.println("Medlemstype er blevet ændret");
        }

        public static void PrintInfo(ArrayList<Konkurrencesvømmer> crawlArray){
            System.out.print("\n"+"Liste over alle " + crawlArray.get(0).getDisciplin()+ " svømmere");
            String f = crawlArray.toString().replace("[", "").replace("]", "");
            System.out.println(f);
        }

        public static void PrintInfoMedlem(ArrayList<Medlem> crawlArray){
            System.out.print("\n"+"Liste over alle motionist medlemmer");
            String f = crawlArray.toString().replace("[", "").replace("]", "");
            System.out.println(f);
        }

        public static void MenuMain(ArrayList<Medlem> medlemArray, ArrayList<Konkurrencesvømmer> crawlArray,
                                    ArrayList<Konkurrencesvømmer> rygArray, ArrayList<Konkurrencesvømmer> hundeArray,
                                    ArrayList<Konkurrencesvømmer> brystArray, ArrayList<Konkurrencesvømmer> butterflyArray)throws Exception {
            Scanner console = new Scanner(System.in);
            boolean mismatch = true;
            String password;
            int menuitem;
            System.out.println("___________________________________________________\n\n      Svømmeklubben delfinens managementsystem      \n     __________________________________________     \n\n\n");

            do{
                if(mismatch=!false){
                    System.out.println("Vælg menu:\n\n1 for managermenu.(Nyt medlem/ændr medlem/slet medlem)\n2 for kassermenu.(se restanceliste/ændr betaling)\n3 for trænermenu.(Se topliste/se medlemstid/rediger medlemstid/se turneringsresultat/rediger turneringsresultat)\n9 for at se medlemsliste.\n 0 for at afslutte programmet.");
                }
                else if(mismatch=!true){
                    System.out.println("Inmput kan ikke læses.");
                    mismatch = true;
                }
                IntPrint(console);
                switch (menuitem = console.nextInt()) {
                    case 1:
                        //System.out.println("Indtast admin password");
                        //password = console.next();
                        //if(password.equalsIgnoreCase("admin")){
                            MenuManager(console, crawlArray, medlemArray, rygArray, hundeArray, brystArray, butterflyArray);
                       /* }else{
                            System.out.println("Password ikke godkendt. vælg menu igen.");
                            mismatch = true;*/
                        //}
                        break;
                    case 2:
                        System.out.println("Indtast kasser password");
                       // password = console.next();
                       // if(password.equalsIgnoreCase("kasser")){
                            MenuKasser(console,crawlArray,medlemArray, rygArray,hundeArray, brystArray, butterflyArray);
                        /*}else{
                            System.out.println("Password ikke godkendt. vælg menu igen.");
                            mismatch = true;
                        }*/
                        break;
                    case 3:
                        System.out.println("Indtast træner password");

                        //password = console.next();
                        //if(password.equalsIgnoreCase("træner")){
                            MenuTræner(console,crawlArray, medlemArray, rygArray,hundeArray, brystArray, butterflyArray);
                        //}else{
                          //  System.out.println("Password ikke godkendt. vælg menu igen.");
                           // mismatch = true;
                        //}
                        break;

                    case 0:
                        System.out.println("Hav en god dag!");
                        break;
                    default:
                        mismatch = false;
                        break;
                }
            }while(menuitem!=0);
        }



        public static void MenuManager(Scanner console, ArrayList<Konkurrencesvømmer> crawlArray,ArrayList<Medlem> medlemArray,
                                       ArrayList<Konkurrencesvømmer> rygArray, ArrayList<Konkurrencesvømmer> hundeArray,
                                       ArrayList<Konkurrencesvømmer> brystArray, ArrayList<Konkurrencesvømmer> butterflyArray)throws Exception{
            boolean mismatch = false;
            String funktion;
            int menuitem;
            do {
                if(mismatch == false){
                    System.out.println("Managermenu:\n\n1 for at oprette et nyt medlem.\n2 for at redigere et eksisterende medlem.\n3 for at fjerne et medlem.\n9 for at se medlemsliste.\n0 for at gå tilbage til hovedmenuen.");
                }
                else if(mismatch == true){
                    System.out.println("Input kan ikke læses");
                    mismatch = false;
                }
                IntPrint(console);
                switch (menuitem = console.nextInt()) {
                    case 1:
                        funktion = "Opret Medlem";
                        MenuRedigerMedlem(console, funktion, crawlArray, medlemArray, rygArray,hundeArray, brystArray, butterflyArray);
                        break;
                    case 2:
                        funktion = "Rediger Medlem";
                        MenuRedigerMedlem(console, funktion, crawlArray, medlemArray, rygArray,hundeArray, brystArray, butterflyArray);
                        break;
                    case 3:
                        funktion = "Fjern Medlem";
                        MenuRedigerMedlem(console, funktion, crawlArray, medlemArray, rygArray,hundeArray, brystArray, butterflyArray);
                        break;
                    case 9:
                        funktion = "Se medlemsliste";
                        MenuRedigerMedlem(console, funktion, crawlArray, medlemArray, rygArray,hundeArray, brystArray, butterflyArray);
                        break;
                    case 0:
                        break;
                    default:
                        mismatch = true;
                        break;
                }
            }while(menuitem!=0);
        }


        public static void MenuRedigerMedlem(Scanner console, String funktion, ArrayList<Konkurrencesvømmer> crawlArray,ArrayList<Medlem> medlemArray,
                                             ArrayList<Konkurrencesvømmer> rygArray, ArrayList<Konkurrencesvømmer> hundeArray,
                                             ArrayList<Konkurrencesvømmer> brystArray, ArrayList<Konkurrencesvømmer> butterflyArray)throws Exception{
            boolean mismatch = true;
            boolean igen = true;
           int menuitem;
            do{
                if(mismatch=true){
                    System.out.println(funktion+":\nVælg konkurrencesvømmer/motionssvømmer:\n\n1 for konkurrencesvømmer.\n2 for motionssvømmer\n0 for at gå tilbage til menuen");
                }else if(mismatch=false){
                    System.out.println("Input kan ikke læses.");
                    mismatch = true;
                }
                IntPrint(console);
                switch (menuitem=console.nextInt()) {
                    case 1:
                        MenuRedigerKonkurrence(console, funktion, crawlArray, rygArray,hundeArray, brystArray, butterflyArray);
                        igen = MenuRedigerIgen(console,funktion);
                        break;
                    case 2:
                        if(funktion=="Opret Medlem") {
                            OpretMedlem(medlemArray, console);
                            do {
                                menuitem = console.nextInt();
                            }while(menuitem!=0 && menuitem!=1);
                        }else if(funktion=="Rediger Medlem"){
                            MenuRediger(medlemArray);
                            do {
                                menuitem = console.nextInt();
                            }while(menuitem!=0 && menuitem!=1);
                        }else if(funktion=="Fjern Medlem"){
                            FjernMedlem(medlemArray);
                        }else if(funktion=="Rediger betaling for medlem"){
                            ændreBetaling(medlemArray, console);
                        }else if(funktion=="Se medlemsliste"){
                            PrintInfoMedlem(medlemArray);
                        }
                        igen = MenuRedigerIgen(console,funktion);
                        break;
                    case 0:
                        break;
                    default:
                        mismatch = true;
                        break;
                }
            } while(menuitem !=0 && igen==true);
        }

        public static boolean MenuRedigerIgen(Scanner console, String funktion) throws Exception{
            Scanner in = new Scanner (System.in);
            String besked = "1 for at forsætte og 0 for at afslutte";
            int inp;
            if(funktion=="Opret Medlem"){
                System.out.println("Medlem Oprettet. Opret et medlem til?");
            }else if(funktion=="Rediger Medlem"){
                System.out.println("Medlem redigeret. Rediger et medlem til?");
            }else if(funktion=="Fjern Medlem"){
                System.out.println("Medlem fjernet. Fjern et medlem til?");
            }else if(funktion=="Rediger betaling for medlem") {
            } System.out.println(besked);
            do{
                inp = in.nextInt();
            }while(inp!=1&&inp!=0);
            if(inp==1){
                return true;
            }else
                return false;
        }

        public static void MenuRedigerKonkurrence(Scanner console, String funktion, ArrayList<Konkurrencesvømmer> crawlArray,
                                                  ArrayList<Konkurrencesvømmer> rygArray, ArrayList<Konkurrencesvømmer> hundeArray,
                                                  ArrayList<Konkurrencesvømmer> brystArray, ArrayList<Konkurrencesvømmer> butterflyArray)throws Exception{
            boolean mismatch = true;
            String disciplin;
            int menuitem;
            do {
                if(mismatch=true){
                    System.out.println("Vælg disciplin:\n1 for crawl.\n2 for rygcrawl.\n3 for brystsvømning\n4 for butterfly.\n5 for hundesvømning.\n0 for at gå tilbage til menu.");
                }
                else if(mismatch=false){
                    System.out.println("Input kan ikke læses.");
                    mismatch = true;
                }
                IntPrint(console);
                switch(menuitem=console.nextInt()){
                    case 1:
                        disciplin = "Crawl";
                        MenuKonkurrenceFunktion(crawlArray, disciplin, funktion, console);
                        break;
                    case 2:
                        disciplin = "RygCrawl";
                        MenuKonkurrenceFunktion(rygArray, disciplin, funktion, console);
                        break;
                    case 3:
                        disciplin = "Brystsvømning";
                        MenuKonkurrenceFunktion(brystArray, disciplin, funktion, console);
                        break;
                    case 4:
                        disciplin = "Butterfly";
                        MenuKonkurrenceFunktion(butterflyArray, disciplin, funktion, console);
                        break;
                    case 5:
                        disciplin = "Hundesvømning";
                        MenuKonkurrenceFunktion(hundeArray, disciplin, funktion, console);
                        break;
                    case 0:
                        break;
                    default:
                        mismatch = false;
                        break;
                }
                if(menuitem<=5 && menuitem>=1) {
                    menuitem = 0;
                }
            }while(menuitem!=0);
        }

        public static void MenuKonkurrenceFunktion(ArrayList<Konkurrencesvømmer> konkurrenceArray, String disciplin, String funktion,Scanner console) throws Exception{
            if(funktion=="Opret Medlem"){
                OpretKonkurrence(konkurrenceArray, console, disciplin);
            }else if(funktion=="Rediger Medlem"){
                MenuKonkurrenceRediger(konkurrenceArray);
            }else if(funktion=="Fjern Medlem"){
                FjernKonkurrenceMedlem(konkurrenceArray);
            }else if(funktion=="Rediger betaling for medlem"){
                ændreBetalingKon(konkurrenceArray, console);
            }else if(funktion=="Se toplister"){
                fixArrays(konkurrenceArray);
            }else if(funktion=="Registrer tid"){
                registrereTid(konkurrenceArray);
            }else if(funktion=="Se medlemsliste"){
                PrintInfo(konkurrenceArray);
            }
        }


        public static void MenuKasser(Scanner console, ArrayList<Konkurrencesvømmer> crawlArray, ArrayList<Medlem> medlemArray,
                                      ArrayList<Konkurrencesvømmer> rygArray, ArrayList<Konkurrencesvømmer> hundeArray,
                                      ArrayList<Konkurrencesvømmer> brystArray, ArrayList<Konkurrencesvømmer> butterflyArray)throws Exception{
            boolean mismatch = true;
            String funktion;
            int menuitem;
            do{
                if(mismatch=true){
                    System.out.println("Kassérmenu:\n\n1 for at ændre betaling for et medlem.\n2 for at se restanceliste.\n9 for at se medlemsliste.\n0 for at gå tilbage til hovedmenu.");
                }
                else if(mismatch=false){
                    System.out.println("input kan ikke læses.");
                    mismatch = true;
                }
                IntPrint(console);
                switch(menuitem=console.nextInt()) {
                    case 1:
                        //rediger betaling
                        funktion = "Rediger betaling for medlem";
                        MenuRedigerMedlem(console, funktion, crawlArray, medlemArray, rygArray,hundeArray, brystArray, butterflyArray);
                        break;
                    case 2:
                        //se restanceliste
                        tjekBetaling(crawlArray, medlemArray,rygArray,hundeArray, brystArray, butterflyArray);                    break;
                    //
                    case 9:
                        //se medlemsliste
                        funktion = "Se medlemsliste";
                        MenuRedigerMedlem(console, funktion, crawlArray, medlemArray, rygArray,hundeArray, brystArray, butterflyArray);
                        break;
                    case 0:
                        break;
                    default:
                        mismatch = false;
                        break;
                }
            }while(menuitem!=0);
        }
        public static void MenuTræner(Scanner console, ArrayList<Konkurrencesvømmer> crawlArray, ArrayList<Medlem> medlemArray,
                                      ArrayList<Konkurrencesvømmer> rygArray, ArrayList<Konkurrencesvømmer> hundeArray,
                                      ArrayList<Konkurrencesvømmer> brystArray, ArrayList<Konkurrencesvømmer> butterflyArray)throws Exception{
            String funktion;
            boolean mismatch = true;
            int menuitem;
            do {
                if(mismatch=true){
                    System.out.println("Trænermenu:\n\n1 for at se toplister.\n2 for at registrere medlemstid\n\n9 for at se medlemsliste.\n0 for at gå tilbage til hovedmenuu.");
                }
                else if(mismatch=false){
                    System.out.println("input kan ikke læses.");
                }
                IntPrint(console);
                switch (menuitem=console.nextInt()) {
                    case 1:
                        //Se toplister
                        funktion = "Se toplister";
                        MenuRedigerKonkurrence(console, funktion,crawlArray, rygArray,hundeArray, brystArray, butterflyArray);
                        break;
                    case 2:
                        //Registrer tid
                        funktion = "Registrer tid";
                        MenuRedigerKonkurrence(console, funktion, crawlArray, rygArray,hundeArray, brystArray, butterflyArray);
                        break;
                    case 9:
                        funktion = "Se medlemsliste";
                        MenuRedigerMedlem(console, funktion, crawlArray, medlemArray, rygArray,hundeArray, brystArray, butterflyArray);
                        break;
                    case 0:
                        break;
                    default:
                        mismatch = false;
                        break;
                }
            }while(menuitem!=0) ;
        }
    }
