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

    public ThreadSpaceInvader(Handler myHandler,InvadersBlock block){
        super();
        handler=myHandler;
        this.block=block;
    }

    @Override
    public void run() {
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
            handler.sendEmptyMessage(0);
            if(tick%10==0){
              block.setPosX(block.getPosX()-50);
            }
            tick++;
        }
    }
}
