package ressource;

public abstract class Constantes {
    //Dimension de la fenêtre
    public static final int LARGEUR_FENETRE = 600;
    public static final int HAUTEUR_FENETRE = 600;
    public static final int MARGE_FENETRE = 50;

    //Dimension du Vaisseau
    public static final int LARGEUR_VAISSEAU = 39;
    public static final int HAUTEUR_VAISSEAU = 24;

    //Position initiales du vaisseau
    public static final int X_POS_INIT_VAISSEAU = (LARGEUR_FENETRE - LARGEUR_VAISSEAU) /2;
    public static final int Y_POS_VAISSEAU = 490;

    //Unité de déplacement du vaisseau
    public static final int DX_VAISSEAU = 1;

    //Limite Vaisseau
    public static final int LIMITE_GAUCHE_VAISSEAU = 60;
    public static final int LIMITE_DROITE_VAISSEAU = 500;

    //Alien
    //Dimension de l'alien
    public static final int LARGEUR_ALIEN = 33;
    public static final int HAUTEUR_ALIEN = 25;

    //Parametre de position de l'aliens
    public static final int ALT_INIT_ALIEN = 120;
    public static final int X_POS_INIT_ALIEN = 29 + MARGE_FENETRE;
    public static final int ECART_LIGNES_ALIEN = 40;
    public static final int ECART_COLONNES_ALIEN = 10;

    //Deplacement ALIEN
    public static final int DX_ALIEN = 2;
    public static final int DY_ALIEN = 20;
    public static final int VITESSE_ALIEN = 1;

    public static final int NOMBRE_ALIEN = 50;

    //Tir Vaisseau
    public static final int LARGEUR_TIR_VAISSEAU = 3;
    public static final int HAUTEUR_TIR_VAISSEAU = 13;
    //Deplacement de tir
    public static final int DY_TIR_VAISSEAU = 2;

    //Chateau
    //Dimension Brique
    public static final int DIMENSION_BRIQUE = 2;

    //Dimension du chateâu
    public static final int LARGEUR_CHATEAU = 72;
    public static final int HAUTEUR_CHATEAU = 54;

    //Parametre de positions des chteaux
    public final static int Y_POS_CHATEAU = 400;
    public final static int X_POS_INIT_CHATEAU = 39;
    public final static int ECART_CHATEAU = 42;

    //Missile Alien
    public static final int LARGEUR_TIR_ALIEN = 5;
    public static final int HAUTEUR_TIR_ALIEN = 15;
    public static final int DY_TIR_ALIEN = 3;

    //Soucoupe
    public  static final int LARGEUR_SOUCOUPE = 42;
    public  static final int HAUTEUR_SOUCOUPE = 22;
    public  static final int X_POS_INIT_SOUCOUPE = LARGEUR_FENETRE;
    public  static final int Y_POS_SOUCOUPE = 50;
    public  static final int DX_SOUCOUPE = 1;

    public static final int VALEUR_ALIEN_HAUT = 50;
    public static final int VALEUR_ALIEN_BAS = 20;
    public static final int VALEUR_ALIEN_MILIEU = 40;
    public static final int VALEUR_ALIEN_SOUCOUPE = 100;
}
