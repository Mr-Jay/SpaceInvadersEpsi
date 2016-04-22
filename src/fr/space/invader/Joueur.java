package fr.space.invader;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/**
 * Created by Adrien on 22/04/2016.
 */
public class Joueur extends Drawable{
    private int posX;
    private Drawable ship;

    public Joueur(Drawable drawable){
        posX=300;
        ship=drawable;
        ship.setBounds(posX,700,posX+100,800);
//        canvas.drawBitmap(bitmap, shipPosX, 800, paint);
    }

    public Drawable getShip() {
        return ship;
    }

    public void moveLeft(){
        posX-=15;
    }

    public void moveRight(){
        posX+=15;
    }
    public int getPosX() {
        return posX;
    }


    @Override
    public void draw(Canvas canvas) {
        ship.draw(canvas);
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
}
