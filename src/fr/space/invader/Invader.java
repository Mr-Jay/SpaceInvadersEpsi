package fr.space.invader;

import android.graphics.drawable.Drawable;
import android.content.res.Resources;
import android.graphics.*;
/**
 * Created by Adrien on 22/04/2016.
 */
public class Invader {
    private int posX;
    private int posY;
    private Drawable alien;

    public Invader(int x,int y,Drawable drawable)
    {
        super();
        alien=drawable;
        posX=x;
        posY=y;
        alien.setBounds(posX,posY,posX+100,posY+100);
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
