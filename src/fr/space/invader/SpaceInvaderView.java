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
	private Joueur joueur=new Joueur(getResources().getDrawable(R.drawable.ship));
	private InvadersBlock block;
	private ThreadSpaceInvader thread;

	private DisplayMetrics dm;



	public void setdm(DisplayMetrics dm)
	{
		this.dm=dm;
	}

	private Handler myHandler=new Handler(){
		public void handleMessage(Message msg){
			invalidate();
		}
	};

	public SpaceInvaderView(Context context, AttributeSet attrs) {

		super(context, attrs);
		block=new InvadersBlock(dm);


	}

	@Override
	protected void onDraw(Canvas canvas) {

		block.setBounds(dm);
		Resources res = getResources();
		Paint paint = new Paint();
		//super.onDraw(canvas);
		canvas.drawRGB(0, 0, 0);
		canvas.drawRect(0, 0, dm.widthPixels, dm.heightPixels, paint); // (x, y, largeur, hauteur)

		block.eraseList();
		for(int y=0; y <=4*dm.widthPixels/10; y+=dm.widthPixels/10)
		{
			for (int i=0 ; i<=5*dm.widthPixels/10;i+=dm.widthPixels/10)
			{
				block.addInvader(new Invader(i+block.getPosX(),y+block.getPosY(),res.getDrawable(R.drawable.alien1),block.getWidth()));
			}
		}


		joueur.draw(canvas);
		canvas.save();
		block.draw(canvas);
		canvas.restore();

	}

/*	public void click(View v)
	{

		if(v.getId()==R.id.left){
			joueur.moveLeft();
		}else{
			joueur.moveRight();
		}


	}*/
	public void startGame(){
		thread = new ThreadSpaceInvader(myHandler,block,joueur,dm.widthPixels);
		Thread thread2 = new Thread(thread);
		thread2.start();
	}


	public void moveShip(boolean left, boolean right) {
		joueur.move(left,right);
	}
}
