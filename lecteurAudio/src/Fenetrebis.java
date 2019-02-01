import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
import java.util.*;
import java.io.IOException;
import javax.swing.*;

public class Fenetrebis extends JFrame{

    public static JPanel container = new JPanel();
    private JPanel container2 = new JPanel();
    private JPanel container3 = new JPanel();
    private JPanel container4 = new JPanel();
    private JLabel label = new JLabel("Lecteur de musique");
    static Morceau morceau;
    private int nbMorceaux=9;
    ArrayList<Morceau> playlist = new ArrayList<>();
    private boolean animated = true;
    private AudioMp3 audioMp3;

    private String nom;
    private String file;
    private String album;
    private String type;


    private JButton bouton3 = new JButton("Tri par nom");
    private JButton bouton4 = new JButton("Tri par auteur");
    private JButton bouton5 = new JButton("Tri par album");

    public static JButton bouton6 = new JButton("Lecture");
    public static JButton bouton7 = new JButton("Lecture aléatoire");




    public Fenetrebis() throws IOException {
        this.setTitle("Mes musiques");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel north = new JPanel();
        Font police = new Font("Tahoma", Font.BOLD, 16);
        label.setFont(police);
        label.setForeground(Color.green);
        label.setHorizontalAlignment(JLabel.CENTER);
        north.setLayout(new GridLayout(4,1));
        north.add(label);
        north.add(container2);
        north.add(container3);
        north.add(container);

        container.setBackground(Color.white);
        container.setLayout(new GridLayout(nbMorceaux,3));
        container3.setLayout(new GridLayout(1,2));
        container2.setLayout(new GridLayout(1,3));


        bouton3.addActionListener(new Bouton3Nom());
        bouton3.setEnabled(true);
        bouton4.addActionListener(new Bouton4Auteur());
        bouton4.setEnabled(true);
        bouton5.addActionListener(new Bouton5Album());
        bouton5.setEnabled(true);
        container2.add(bouton3);
        container2.add(bouton4);
        container2.add(bouton5);
        container3.add(bouton6);
        container3.add(bouton7);

        container2.setBackground(Color.white);
        container3.setBackground(Color.white);

        Scanner scanner = new Scanner(Paths.get("/Users/florianricq/Documents/DUT/DUT2/CPA/lecteurAudio/Musiques/listeMorceaux.csv"));

        try {
            while(scanner.hasNext()) {
                String line=scanner.nextLine();
                Morceau m;
                try (Scanner scanner2= new Scanner(line).useDelimiter(",")) {
                    m = new Morceau(scanner2.next(), scanner2.next(), scanner2.next(), scanner2.next());
                }
                playlist.add(m);
            }
        } catch(InputMismatchException e) {
            System.out.println("Le fichier a un probleme");
            System.exit(1);
        }


        for (int i = 0; i < playlist.size(); i++) {
            playlist.get(i).ajouteMorceau(container);
        }

        this.setContentPane(north);
        this.setVisible(true);


    }
    class Bouton3Nom implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            animated = false;
            playlist.sort(Comparator.comparing(Morceau::getNom));
            for (int i = 0; i < playlist.size(); i++) {
                playlist.get(i).ajouteMorceau(container);
            }
            container.revalidate();
            container.repaint();

        }
    }
    class Bouton4Auteur implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            animated = false;

            playlist.sort(Comparator.comparing(Morceau::getAuteur));
            for (int i = 0; i < playlist.size(); i++) {
                playlist.get(i).ajouteMorceau(container);
            }
            container.revalidate();
            container.repaint();
        }
    }
    class Bouton5Album implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            animated = false;
            playlist.sort(Comparator.comparing(Morceau::getAlbum));
            for (int i = 0; i < playlist.size(); i++) {
                playlist.get(i).ajouteMorceau(container);
            }
            container.revalidate();
            container.repaint();
        }
    }

    class Bouton6Listener implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            animated = true;
            audioMp3.lecture();
            try {
                System.out.println("test");

                Thread.sleep(5000);
                System.out.println("test2");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }




}