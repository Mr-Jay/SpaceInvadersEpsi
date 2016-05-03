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
    private boolean left,right=false;

    public Joueur(Drawable drawable){
        posX=300;
        ship=drawable;
        ship.setBounds(posX,700,posX+100,800);
//        canvas.drawBitmap(bitmap, shipPosX, 800, paint);
    }

    public Drawable getShip() {
        return ship;
    }


    public int getPosX() {
        return posX;
    }


    @Override
    public void draw(Canvas canvas)
    {
        ship.setBounds(posX,700,posX+100,800);
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

    public void move(boolean left, boolean right) {
        this.left=left;
        this.right=right;
    }
    public void moveLeft() {posX-=25;}
    public void moveRight() {posX+=25;}

    public boolean getRight()
    {
        return right;
    }
    public boolean getLeft()
    {
        return left;
    }
}
