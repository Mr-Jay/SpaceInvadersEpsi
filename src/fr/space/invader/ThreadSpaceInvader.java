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
    private int screenWidth;

    public ThreadSpaceInvader(Handler myHandler, InvadersBlock block, Joueur ship, int screenWidth){
        super();
        handler=myHandler;
        this.block=block;
        this.ship=ship;
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
                if(block.getPosX()==0) {
                    block.addY(50);
                    direction=true;//Right
                }else if(block.getPosX()==screenWidth-block.getWidth()){
                    direction=false;//Left
                    block.addY(50);
                }
                block.move(direction);
            }
            tick++;
        }
    }
}
