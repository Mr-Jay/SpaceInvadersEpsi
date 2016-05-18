package fr.space.invader;


import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.prefs.Preferences;

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
            if(invader != null){
                invader.draw(canvas);
            }

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
                if(inv != null){
                    inv.move(width/12);
                }

            }
        }else{
            posX-=width/12;//idem vers la gauche
            for(Invader inv:invadersList) {
                if(inv != null){
                    inv.move(-width / 12);
                }

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
            if(inv != null){
                inv.addY();
            }

        }
    }

	public Invader getLastInvader()
    {
        return invadersList.get(invadersList.size()-1);
    }

    public void suppUnInvader(int x, int y){
        this.invadersList.set((6*(y-1))+x-1,null);
        //this.invadersList.remove((6*(y-1))+x-1);
        //System.out.println("remove : "+x+" : "+y);
    }

    public boolean invaderExist(int x, int y){
        if(this.invadersList.get((6*(y-1))+x-1) != null){
            return true;
        }
        return false;
    }

    public boolean toucheUnVaisseau(int x,int y){
        if(x>=this.posX && x<=this.posX+this.width && y>=this.posY && y<=this.posY+this.height){//Touche le bloc d'ennemis
            int invX = (x-this.posX)/(SpaceInvaderActivity.dm.widthPixels/10)+1;
            int invY = (y-this.posY)/(SpaceInvaderActivity.dm.widthPixels/10)+1;

            if(invaderExist(invX, invY)){
                this.suppUnInvader(invX,invY);
                return true;
            }
            return false;
        }
        return false;
    }

}
