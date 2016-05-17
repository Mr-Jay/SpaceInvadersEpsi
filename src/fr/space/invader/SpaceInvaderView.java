package fr.space.invader;



import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.*;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class SpaceInvaderView extends View {
	
	// Dimensions souhaitées
	/*private static final int TARGET_HEIGHT = 800;
	private static final int TARGET_WIDTH = 600;*/
	private int shipPosX;
	private Joueur joueur;
	private InvadersBlock block;
	private ThreadSpaceInvader thread;





	private Handler myHandler=new Handler(){
		public void handleMessage(Message msg){
			invalidate();
		}
	};

	public SpaceInvaderView(Context context, AttributeSet attrs) {

		super(context, attrs);

		block=new InvadersBlock(SpaceInvaderActivity.dm);
		joueur=new Joueur(getResources().getDrawable(R.drawable.ship),SpaceInvaderActivity.dm);
	}

	@Override
	protected void onDraw(Canvas canvas) {

		block.setBounds(SpaceInvaderActivity.dm);
		Resources res = getResources();
		Paint paint = new Paint();
		//super.onDraw(canvas);
		canvas.drawRGB(0, 0, 0);
		canvas.drawRect(0, 0, SpaceInvaderActivity.dm.widthPixels, SpaceInvaderActivity.dm.heightPixels, paint); // (x, y, largeur, hauteur)

		block.eraseList();
		for(int y=0; y <=4*SpaceInvaderActivity.dm.widthPixels/10; y+=SpaceInvaderActivity.dm.widthPixels/10)
		{
			for (int i=0 ; i<=5*SpaceInvaderActivity.dm.widthPixels/10;i+=SpaceInvaderActivity.dm.widthPixels/10)
			{
				block.addInvader(new Invader(i+block.getPosX(),y+block.getPosY(),res.getDrawable(R.drawable.alien1),block.getWidth()));
			}
		}

		joueur.setBounds(SpaceInvaderActivity.dm);
		joueur.draw(canvas);
		canvas.save();
		block.draw(canvas);
		canvas.restore();

	}
	
	public void startGame(){
		thread = new ThreadSpaceInvader(myHandler,block,joueur,SpaceInvaderActivity.dm.widthPixels);
		Thread thread2 = new Thread(thread);
		thread2.start();
	}


	public void moveShip(boolean left, boolean right) {
		joueur.move(left,right);
	}
}
