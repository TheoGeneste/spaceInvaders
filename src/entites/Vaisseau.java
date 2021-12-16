package entites;

import jeu.Main;
import ressource.Chrono;
import ressource.Constantes;

import javax.swing.*;
import java.awt.*;

public class Vaisseau extends Entite{

    private int compteur = 0;

    public Vaisseau(){
        //Initialisation des variables de la super classe
        super.xPos = Constantes.X_POS_INIT_VAISSEAU;
        super.yPos = Constantes.Y_POS_VAISSEAU;
        super.largeur = Constantes.LARGEUR_VAISSEAU;
        super.hauteur = Constantes.HAUTEUR_VAISSEAU;
        super.deplacementx = 0;
        super.deplacementy = 0;

        //Addresse des images vaisseau
        super.strImg1 = "/images/vaisseau.png";
        super.strImg2 = "/images/vaisseauDetruit1.png";
        super.strImg3 = "/images/vaisseauDetruit2.png";

        //Chargement de l'image vaisseau
        super.icone = new ImageIcon(getClass().getResource(super.strImg1));
        super.img = this.icone.getImage();
        super.vivant = true;
    }

    public int deplacementVaisseau(){
        //Renvoie la nouvelle position du vaisseau
        if(this.deplacementx < 0) {
            if (this.xPos > Constantes.LIMITE_GAUCHE_VAISSEAU) {
                this.xPos = this.xPos + this.deplacementx;
            }
        }else if( deplacementx > 0 ){
            if (this.xPos + this.deplacementx < Constantes.LIMITE_DROITE_VAISSEAU){
                this.xPos = this.xPos + this.deplacementx;
            }
        }
        return this.xPos;

    }

    public void dessinVaisseau(Graphics g){
        if (this.vivant == false){
            this.destructionVaisseau();
        }
        g.drawImage(this.img, this.deplacementVaisseau(), this.yPos,null);
    }

    public void destructionVaisseau(){
        if (compteur < 300){
            if (Chrono.compteTours % 2 == 0){
                super.icone = new ImageIcon(getClass().getResource(super.strImg2));
            }else{
                super.icone = new ImageIcon(getClass().getResource(super.strImg3));
            }
            compteur++;
        }else{
            Main.jeu = false;
        }
        super.img = this.icone.getImage();
    }
}
