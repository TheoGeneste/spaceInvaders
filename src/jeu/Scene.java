package jeu;

import entites.*;
import ressource.Chrono;
import ressource.Clavier;
import ressource.Constantes;

import javax.swing.*;
import java.awt.*;


public class Scene extends JPanel {

    //Variables

    public Vaisseau vaisseau = new Vaisseau();
    public GroupeAliens groupeAliens = new GroupeAliens();
    public TirVaisseau tirVaisseau = new TirVaisseau();

    public Chateau tabChateaux[] = new Chateau[4]; // Creation d'un tableau contenant les 4 chateaux

    public TirAlien tirAlien1, tirAlien2, tirAlien3;

    public Soucoupe soucoupe;

    private Font afficheScore = new Font("Arial", Font.PLAIN, 20);
    private Font afficheTexte = new Font("Arial", Font.PLAIN, 80);

    private int manche = 1;
    public int score = 0;

    //Constructeur
    public Scene() {
        super();

        // Instanciation des chateaux
        for(int colonne=0; colonne<4; colonne++) {
            this.tabChateaux[colonne] = new Chateau(Constantes.MARGE_FENETRE +
                    Constantes.X_POS_INIT_CHATEAU + colonne * (Constantes.LARGEUR_CHATEAU + Constantes.ECART_CHATEAU));
        }


        // Instanciation du clavier
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Clavier());

        // Instanciation du chrono
        Thread chronoEcran = new Thread(new Chrono());
        chronoEcran.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;

        // Dessin du fond
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, Constantes.LARGEUR_FENETRE, Constantes.HAUTEUR_FENETRE);

        // Dessin ligne verte
        g2.setColor(Color.GREEN);
        g2.fillRect(30, 530, 535, 5);

        // Affichage du score
        g.setFont(afficheScore);
        g.drawString("SCORE : " + score, 400, 25);

        g.setFont(afficheScore);
        g.drawString("MANCHE : " + manche, 100, 25);

        // Dessin du vaisseau
        this.vaisseau.dessinVaisseau(g2);

        // Dessin des aliens
        this.groupeAliens.dessinAliens(g2);

        // Dessin du tir vaisseau
        this.tirVaisseau.dessinTirVaisseau(g2);

        this.groupeAliens.tirVaisseauToucheAlien(this.tirVaisseau);

        for(int colonne=0; colonne<4; colonne++) {this.tabChateaux[colonne].dessinChateau(g2);}

        // Message de debut du jeu
        if(Chrono.compteTours < 500) {
            g.setFont(afficheTexte);
            g.drawString("Good luck !", 95, 100);
        }

        // Affichage de la fin du jeu
        if(this.vaisseau.isVivant() == false) {
            g.setFont(afficheTexte);
            g.drawString("GAME OVER", 50, 100);
        }

        this.tirVaisseau.tirVaisseauDetruitChateau(tabChateaux);

        // Dessin des tirs des aliens
        if(Chrono.compteTours % 500 == 0) {
            tirAlien1 = new TirAlien(this.groupeAliens.choixAlienQuiTire());}
        if(this.tirAlien1 != null) {
            this.tirAlien1.dessinTirAlien(g2);
            this.tirAlien1.tirAlienDetruitChateau(tabChateaux);
            if(this.tirAlien1.toucheVaisseau(vaisseau) == true) {this.vaisseau.setVivant(false);}
        }
        if(Chrono.compteTours % 750 == 0) {
            tirAlien2 = new TirAlien(this.groupeAliens.choixAlienQuiTire());}
        if(this.tirAlien2 != null) {
            this.tirAlien2.dessinTirAlien(g2);
            this.tirAlien2.tirAlienDetruitChateau(tabChateaux);
            if(this.tirAlien2.toucheVaisseau(vaisseau) == true) {this.vaisseau.setVivant(false);}
        }
        if(Chrono.compteTours % 900 == 0) {
            tirAlien3 = new TirAlien(this.groupeAliens.choixAlienQuiTire());}
        if(this.tirAlien3 != null) {
            this.tirAlien3.dessinTirAlien(g2);
            this.tirAlien3.tirAlienDetruitChateau(tabChateaux);
            if(this.tirAlien3.toucheVaisseau(vaisseau) == true) {this.vaisseau.setVivant(false);}
        }
        // Dessin de la soucoupe
        if(Chrono.compteTours % 2500 == 0) {soucoupe = new Soucoupe();}
        if(this.soucoupe != null) {
            if(this.soucoupe.getxPos()>0) {
                // Detection contact tir vaisseau avec soucoupe
                if(this.tirVaisseau.detruitSoucoupe(this.soucoupe) == true) {
                    if(this.soucoupe.getDeplacementx() != 0) {this.score = this.score + Constantes.VALEUR_ALIEN_SOUCOUPE;}
                    this.soucoupe.setDeplacementx(0);
                    this.soucoupe.setVivant(false);
                    this.soucoupe.musiqueSoucoupe.stop();
                    this.soucoupe.musiqueDestructionSoucoupe.play();
                }
                this.soucoupe.dessinSoucoupe(g2);
            }else {this.soucoupe = null;}
        }

        if (this.groupeAliens.getNombreAliens() == 0){
            manche++;
            groupeAliens = new GroupeAliens();
            float vit = groupeAliens.getVitesse() * (manche/2);
            groupeAliens.setVitesse(vit);
            System.out.println(groupeAliens.getVitesse());
        }
        if (this.groupeAliens.positionAlienLePlusBas() > Constantes.Y_POS_VAISSEAU){
            this.vaisseau.destructionVaisseau();
        }
    }
}

