package entites;

import javax.swing.*;
import java.awt.*;

public abstract class Entite {
    protected int largeur, hauteur, xPos, yPos, deplacementx, deplacementy;
    protected boolean vivant;
    protected String strImg1, strImg2, strImg3;
    protected ImageIcon icone;
    protected Image img;


    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getDeplacementx() {
        return deplacementx;
    }

    public void setDeplacementx(int deplacementx) {
        this.deplacementx = deplacementx;
    }

    public int getDeplacementy() {
        return deplacementy;
    }

    public void setDeplacementy(int deplacementy) {
        this.deplacementy = deplacementy;
    }

    public boolean isVivant() {
        return vivant;
    }

    public void setVivant(boolean vivant) {
        this.vivant = vivant;
    }

    public String getStrImg1() {
        return strImg1;
    }

    public void setStrImg1(String strImg1) {
        this.strImg1 = strImg1;
    }

    public String getStrImg2() {
        return strImg2;
    }

    public void setStrImg2(String strImg2) {
        this.strImg2 = strImg2;
    }

    public String getStrImg3() {
        return strImg3;
    }

    public void setStrImg3(String strImg3) {
        this.strImg3 = strImg3;
    }

    public ImageIcon getIcone() {
        return icone;
    }

    public void setIcone(ImageIcon icone) {
        this.icone = icone;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
}
