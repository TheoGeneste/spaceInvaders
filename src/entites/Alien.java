package entites;

import ressource.Constantes;

import javax.swing.*;

public class Alien extends Entite{
    public Alien(int xPos, int yPos, String strImg1, String strImg2) {
        //Initialisation super CLass
        super.xPos = xPos;
        super.yPos = yPos;
        super.largeur = Constantes.LARGEUR_ALIEN;
        super.hauteur = Constantes.HAUTEUR_ALIEN;
        super.deplacementx = 0;
        super.deplacementy = 0;
        super.vivant = true;

        // Addresse image du vaisseau
        super.strImg1 = strImg1;
        super.strImg2 = strImg2;
        super.strImg3 = "/images/alienMeurt.png";

        //Chargement du vaisseau
        super.icone = new ImageIcon(getClass().getResource(super.strImg1));
        super.img = this.icone.getImage();
    }

    public void choixImage(boolean pos1){
        if (this.vivant == true){
            if(pos1 == true){
                super.icone = new ImageIcon(getClass().getResource(strImg1));
            }else {
                super.icone = new ImageIcon(getClass().getResource(strImg2));
            }
        }else{
            super.icone = new ImageIcon(getClass().getResource(strImg3));
        }
        super.img = this.icone.getImage();
    }
}
