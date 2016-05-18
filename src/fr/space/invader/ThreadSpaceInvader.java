package fr.space.invader;

import android.os.Handler;
import android.os.SystemClock;

/**
 * Created by Adrien on 22/04/2016.
 */
public class ThreadSpaceInvader implements Runnable {
    private boolean runThread;
    private Handler handler;
    private long currentTime,startTime;
    private InvadersBlock block;
    private Joueur ship;
    private Missile missile;
    private int screenWidth;
    private int alienHeight;

    public ThreadSpaceInvader(Handler myHandler, InvadersBlock block, Joueur ship,Missile missile, int screenWidth){
        super();
        handler=myHandler;
        this.block=block;
        this.ship=ship;
        this.missile = missile;
        alienHeight=block.getHeight()/5;
        this.screenWidth=screenWidth;
    }

    @Override
    public void run() {
        Boolean direction=false;
        runThread=true;
        startTime= System.currentTimeMillis();
        int tick=0;
        while(runThread){
            currentTime=System.currentTimeMillis();
            try {
                Thread.sleep(100-(currentTime-startTime)%100); //
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(ship.getLeft())
            {
                ship.moveLeft();
            }
            else if(ship.getRight())
            {
                ship.moveRight();
            }
            handler.sendEmptyMessage(0);

            if(tick%10==0){
                System.out.println(block.getWidth());
                if(block.getLastInvader().getPosY()+alienHeight>ship.getPosY())
                {
                    runThread=false;
                }
                if(block.getPosX()==0) {
                    block.addY(25);
                    direction=true;//Right
                }else if(block.getPosX()>=screenWidth-block.getWidth()){
                    direction=false;//Left
                    block.addY(25);
                }
                block.move(direction);



            }
            if(tick%2==0){
                if(missile.getPosY()<=0||MissileToucheVaisseau()){
                    missile.relance();

                }
                else{// Le missile n'a rien touché
                    missile.move();
                }
            }
            tick++;
        }
    }
    private boolean MissileToucheVaisseau(){
        return block.toucheUnVaisseau(this.missile.getPosX(),this.missile.getPosY());
    }
}
