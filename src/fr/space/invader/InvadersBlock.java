package fr.space.invader;


import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import java.util.ArrayList;

/**
 * Created by Adrien on 22/04/2016.
 */
public class InvadersBlock extends Drawable {
    private ArrayList<Invader> invadersList;
    private int posX;
    private int posY;
    private int width;
    private int height;

    public void addInvader(Invader invader){
        invadersList.add(invader);
    }

    public InvadersBlock(Drawable alien)
    {
        posX=0;
        posY=0;
        invadersList=new ArrayList<Invader>();
        width=6*SpaceInvaderActivity.dm.widthPixels/10;
        height=5*SpaceInvaderActivity.dm.widthPixels/10;
        this.setBounds(posX,posY,posX+width,posY+height);
        for(int y=0; y <=4*SpaceInvaderActivity.dm.widthPixels/10; y+=SpaceInvaderActivity.dm.widthPixels/10)
        {
            for (int i=0 ; i<=5*SpaceInvaderActivity.dm.widthPixels/10;i+=SpaceInvaderActivity.dm.widthPixels/10)
            {
                addInvader(new Invader(i+posX,y+posY,alien,width));
            }
        }
        

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
            invader.draw(canvas);
        }

    }

    public void eraseList(){
        invadersList=new ArrayList<Invader>();
    }
    @Override
    public void setAlpha(int alpha) {}

    @Override
    public void setColorFilter(ColorFilter cf) {}

    @Override
    public int getOpacity() {
        return 0;
    }

    public void move(Boolean direction) {
        if(direction){
            posX+=width/12;//Se deplace de la moitié d'un alien vers la droite
            for(Invader inv : invadersList)
            {
                inv.move(width/12);
            }
        }else{
            posX-=width/12;//idem vers la gauche
            for(Invader inv:invadersList) {
                inv.move(-width / 12);
            }
        }
    }

    public int getWidth() {
        return width;
    }
    public int getHeight(){
        return height;
    }


    public void addY(int i) {
        posY+=50;
        for(Invader inv:invadersList){
            inv.addY();
        }
    }

	public Invader getLastInvader()
    {
        return invadersList.get(invadersList.size()-1);
    }

    public boolean toucheUnVaisseau(int x,int y){

        return false;
    }

}
