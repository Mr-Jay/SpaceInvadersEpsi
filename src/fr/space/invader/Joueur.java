package fr.space.invader;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

/**
 * Created by Adrien on 22/04/2016.
 */
public class Joueur extends Drawable{
    private int posX,posY;
    private int width,height;
    private Drawable ship;
    private boolean left,right=false;
    private int posXMax;

    public Joueur(Drawable drawable, DisplayMetrics dm){
        posX=300;

        ship=drawable;
        ship.setBounds(posX,posY,posX+width,posY+height);
    }

    public Drawable getShip() {
        return ship;
    }


    public int getPosX() {
        return posX;
    }
    public int getPosY(){
        return posY;
    }

    @Override
    public void draw(Canvas canvas)
    {
        ship.setBounds(posX,posY,posX+width,posY+width);
        ship.draw(canvas);
    }



    public void move(boolean left, boolean right) {
        this.right=right;
        this.left=left;
    }
    public void moveLeft()
    {
        if(posX>0){
            posX-=25;
        }
    }

    public void moveRight()
    {
        if(posX<posXMax)
        {
            posX+=25;
        }
    }

    public boolean getRight()
    {
        return right;
    }
    public boolean getLeft()
    {
        return left;
    }

    public void setBounds(DisplayMetrics dm) {
        width=dm.widthPixels/12;
        height=dm.widthPixels/12;
        posXMax=dm.widthPixels-width;
        posY=(int) (dm.heightPixels*0.6f);
       // this.setBounds(posX,posY,posX+width,posY+height);
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
