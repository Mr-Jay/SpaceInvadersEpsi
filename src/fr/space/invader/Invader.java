package fr.space.invader;

import android.graphics.drawable.Drawable;
import android.content.res.Resources;
import android.graphics.*;
import android.util.DisplayMetrics;

/**
 * Created by Adrien on 22/04/2016.
 */
public class Invader extends Drawable{
    private int posX;
    private int posY;
    private Drawable alien;
    private int width;


    public Invader(int x, int y, Drawable drawable, int width)
    {
        super();
        alien=drawable;
        posX=x;
        posY=y;
        this.width=width/6;
        alien.setBounds(posX,posY,posX+width/6,posY+width/6);

        System.out.println("invader x:"+posX+"y:"+posY);


    }
    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Drawable getAlien() {
        return alien;
    }
    public void move(int i)
    {
        posX+=i;
    }
    public void addY()
    {
        posY+=50;
    }
    @Override
    public void draw(Canvas canvas) {
        System.out.println(posX+"   "+posY);
        alien.setBounds(posX,posY,posX+width,posY+width);
        alien.draw(canvas);
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
