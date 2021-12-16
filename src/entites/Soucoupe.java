package entites;

import ressource.Audio;
import ressource.Chrono;
import ressource.Constantes;

import javax.swing.*;
import java.awt.*;

public class Soucoupe extends Entite{
    public Audio musiqueSoucoupe = new Audio("/sons/sonSoucoupePasse.wav");
    public Audio musiqueDestructionSoucoupe = new Audio ("/sons/sonDestructionSoucoupe.wav");

    private int compteur = 0;

    public Soucoupe() {
        super.xPos = Constantes.X_POS_INIT_SOUCOUPE;
        super.yPos = Constantes.Y_POS_SOUCOUPE;
        super.largeur = Constantes.LARGEUR_SOUCOUPE;
        super.hauteur = Constantes.HAUTEUR_SOUCOUPE;
        super.deplacementx = Constantes.DX_SOUCOUPE;
        super.deplacementy = 0;
        this.strImg1 = "/images/soucoupe.png";
        this.strImg2 = "/images/soucoupe100.png";
        this.strImg3 = "";

        super.icone = new ImageIcon(getClass().getResource(strImg1));
        super.img = this.icone.getImage();
        super.vivant = true;

        this.musiqueSoucoupe.play();
        this.musiqueDestructionSoucoupe.stop();
        this.compteur = 0;
    }

    public int deplacementSoucoupe() {
        if(this.vivant && Chrono.compteTours % 2 == 0) {
            if (this.xPos > 0) {this.xPos = this.xPos - this.deplacementx;}
            else {this.xPos = Constantes.X_POS_INIT_SOUCOUPE;}
        }
        return this.xPos;
    }

    public void dessinSoucoupe(Graphics g) {
        if(this.vivant == false) {this.destructionSoucoupe();}
        g.drawImage(this.img, this.deplacementSoucoupe(), this.yPos, null);
    }

    public void destructionSoucoupe() {
        if(compteur < 300) {
            super.icone = new ImageIcon(getClass().getResource(super.strImg2));
            super.img = this.icone.getImage();
            compteur++;
        }else {this.xPos = Constantes.X_POS_INIT_SOUCOUPE;}

    }
}
