package fr.space.invader;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

/**
 * Created by Adrien on 22/04/2016.
 */
public class InvadersBlock extends Drawable {
    private ArrayList<Invader> invadersList;
    private int posX;
    private int posY;

    public void addInvader(Invader invader){
        invadersList.add(invader);
    }

    public InvadersBlock()
    {
        posX=300;
        posY=0;
        invadersList=new ArrayList<Invader>();
        this.setBounds(posX,posY,posX+600,posY+500);
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
    public void setPosX(int x)
    {
        posX=x;
    }
    @Override
    public void draw(Canvas canvas) {
        for (Invader invader:invadersList) {
          invader.getAlien().draw(canvas);
        }
    }

    public void eraseList(){
        invadersList=new ArrayList<Invader>();
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

    public void move(Boolean direction) {
        if(direction){
            posX+=50;
        }else{
            posX-=50;
        }
    }
}
