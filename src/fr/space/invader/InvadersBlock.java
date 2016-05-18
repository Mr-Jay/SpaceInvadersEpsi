package fr.space.invader;


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

    public InvadersBlock(DisplayMetrics dm)
    {
        posX=0;
        posY=0;
        invadersList=new ArrayList<Invader>();
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
        }else{
            posX-=width/12;//idem vers la gauche
        }
    }

    public int getWidth() {
        return width;
    }
    public int getHeight(){
        return height;
    }
    public void setBounds(DisplayMetrics dm) {
        width=6*dm.widthPixels/10;
        height=5*dm.widthPixels/10;
        this.setBounds(posX,posY,posX+width,posY+height);
    }

    public void addY(int i) {
        posY+=50;
    }

	public Invader getLastInvader()
    {
        return invadersList.get(invadersList.size()-1);
    }

    public void suppUnInvader(int x, int y){
        this.invadersList.remove(x*y-1);
        System.out.println("remove : "+x+" : "+y);
    }

    public boolean toucheUnVaisseau(int x,int y){
        if(x>=this.posX && x<=this.posX+this.width && y>=this.posY && y<=this.posY+this.height){//Touche le bloc d'ennemis
            int invX = (x-this.posX)/(SpaceInvaderActivity.dm.widthPixels/10)+1;
            System.out.println("invX : "+invX);
            int invY = (y-this.posY)/(SpaceInvaderActivity.dm.widthPixels/10)+1;
            System.out.println("invY : "+invY);
            this.suppUnInvader(invX,invY);
            return true;
        }
        return false;
    }

}
