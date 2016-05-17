package fr.space.invader;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/**
 * Created by LordMalak on 29/04/2016.
 */

public class Missile extends Drawable {
    private int posX; // constante X (celle du vaisseau lors du tir)
    private int posY; //hauteur du missile (monte chaque tour)
    private Joueur ship;
    private Drawable missile;

    public Missile(Drawable img, Joueur joueur){

        this.ship = joueur;
        this.posX = this.ship.getPosX();
        this.posY = 0; //Démarrage du missile à la posY du vaisseau

        missile=img;
        missile.setBounds(posX,posY,posX+10,posY+56);

    }

    public Drawable getMissile() {
        return missile;
    }

    public int getPosY() {
        return posY;
    }


    @Override
    public void draw(Canvas canvas)
    {
        missile.setBounds(posX,posY,posX+10,posY+56);
        missile.draw(canvas);
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter cf) {

    }

    @Override
    public int getOpacity() {
        return 0;
    }

    public void move() {
        this.posY += 25;
    }

    public void relance() {
        this.posX = ship.getPosX();
        this.posY = 0;
    }

}

