package jeu;

import ressource.Constantes;

import javax.swing.*;

public class Main {
    public static Scene scene;
    public static boolean jeu = true;

    public static void main(String[] args){
        //Création de la fenêtre
        JFrame fenetre = new JFrame("Space Invaders");
        fenetre.setSize(Constantes.LARGEUR_FENETRE, Constantes.HAUTEUR_FENETRE);
        fenetre.setResizable(false);
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setAlwaysOnTop(true);

        scene = new Scene();
        fenetre.setContentPane(scene);

        fenetre.setVisible(true);
    }
}
