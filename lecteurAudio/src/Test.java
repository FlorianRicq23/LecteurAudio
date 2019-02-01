import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {



        Fenetrebis fenetre=new Fenetrebis();
        System.out.println();


        ArrayList<String> liste = new ArrayList<String>();
        Scanner scanner = new Scanner(Paths.get("/Users/florianricq/Documents/DUT/DUT2/CPA/lecteurAudio/Musiques/listeMorceaux.csv"));
        while (scanner.hasNext()) {
            Test.Musique musique = Test.parseCSVLine(scanner.nextLine());
            liste.add(musique.nom);
            liste.add(musique.album);
            liste.add(musique.morceau);

        }
        scanner.close();

        ArrayList<ArrayList> affichageListe = new ArrayList<ArrayList>();
        ArrayList<String> musique = new ArrayList<String>();
        ArrayList<String> nomMusiques = new ArrayList<String>();

        int i=0;
        while (i<liste.size()) {
            if (i%3==0 ) {
                musique = new ArrayList<String>();
                for (int j = 0; j < 3; j++) {
                    musique.add(liste.get(i+j));
                }
                affichageListe.add(musique);
                i+=3;
            }
        }
    }



    public static Musique parseCSVLine(String line){
            Scanner sc = new Scanner(line);
            sc.useDelimiter(",");
            String type = sc.next();
            String album = sc.next();
            String nom = sc.next();
            String morceau = sc.next();

            sc.close();
            return new Musique(nom, morceau, album, type);
        }

        public static class Musique{
            public String nom;
            public String morceau;
            public String album;
            private String type;

            public Musique(String nom, String morceau, String album, String type) {
                this.nom = nom;
                this.morceau = morceau;
                this.album = album;
                this.type = type;
            }

            public String toString() {
                return "Morceau : " + nom;
            }

            public String getNom() {
                return nom;
            }
        }
    }

