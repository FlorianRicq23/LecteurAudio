import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Morceau {
    String nom;
    String album;
    String file;
    String auteur;

    private JLabel texte;
    private JButton bouton = new JButton("Go");
    private JButton bouton2 = new JButton("Stop");
    private JButton bouton8 = new JButton("10 sc");



    private boolean animated = true;

    private AudioMp3 audioMp3;

    public Morceau(String album, String auteur, String nom, String file){
        audioMp3=new AudioMp3(file);
        texte = new JLabel(nom);
        this.album=album;
        this.auteur=auteur;
        this.nom=nom;
        this.file=file;

    }

    public String getNom() {
        return nom;
    }

    public String getAlbum() {
        return album;
    }

    public String getFile() {
        return file;
    }

    public String getAuteur() {
        return auteur;
    }

    public Morceau(String nom) {
        texte = new JLabel(nom);
    }

    public void ajouteMorceau(JPanel panel){
        Border blackline = BorderFactory.createLineBorder(Color.blue);

        texte.setBackground(Color.CYAN);
        texte.setBorder(blackline);
        texte.setHorizontalAlignment(JLabel.CENTER);
        panel.add(texte);
        bouton.addActionListener(new BoutonListener());
        bouton.setEnabled(true);
        bouton2.addActionListener(new Bouton2Listener());
        bouton2.setEnabled(false);
        bouton8.addActionListener(new Bouton8Listener());
        bouton8.setEnabled(true);


        panel.add(bouton);
        panel.add(bouton2);
        panel.add(bouton8);

    }

    class BoutonListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            animated = true;
            texte.setForeground(Color.red);
            bouton.setEnabled(false);
            bouton2.setEnabled(true);
            bouton8.setEnabled(false);
            System.out.println("Je joue");
            audioMp3.joue();
        }
    }

    class Bouton2Listener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            animated = false;
            texte.setForeground(Color.black);
            bouton.setEnabled(true);
            bouton2.setEnabled(false);
            bouton8.setEnabled(true);
            System.out.println("Je stop");
            audioMp3.stop();
        }
    }

    class Bouton8Listener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            animated = true;
            texte.setForeground(Color.red);
            audioMp3.extrait();
            /*
            bouton.setEnabled(false);
            bouton2.setEnabled(true);
            bouton8.setEnabled(false);
            try {
                Thread.sleep(5000);
                if (Thread.currentThread()
                System.out.println(Thread.currentThread());
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            */


            System.out.println("test2");

        }
    }


}


