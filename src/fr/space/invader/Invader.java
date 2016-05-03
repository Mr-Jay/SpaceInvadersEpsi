package fr.space.invader;

import android.graphics.drawable.Drawable;
import android.content.res.Resources;
import android.graphics.*;
import android.util.DisplayMetrics;

/**
 * Created by Adrien on 22/04/2016.
 */
public class Invader {
    private int posX;
    private int posY;
    private Drawable alien;


    public Invader(int x, int y, Drawable drawable, int width)
    {
        super();
        alien=drawable;
        posX=x;
        posY=y;
        alien.setBounds(posX,posY,posX+width/6,posY+width/6);

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
}
