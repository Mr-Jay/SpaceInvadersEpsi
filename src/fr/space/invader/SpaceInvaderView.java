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
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class SpaceInvaderView extends View {
	
	// Dimensions souhaitées
	private static final int TARGET_HEIGHT = 800;
	private static final int TARGET_WIDTH = 600;
	private int shipPosX;
	private Joueur joueur=new Joueur(getResources().getDrawable(R.drawable.ship));
	private InvadersBlock block;
	private ThreadSpaceInvader thread;
	private Handler myHandler=new Handler(){
		public void handleMessage(Message msg){
			invalidate();
		}
	};

	public SpaceInvaderView(Context context, AttributeSet attrs) {
		super(context, attrs);
		block=new InvadersBlock();

	}

	@Override
	protected void onDraw(Canvas canvas) {

		Resources res = getResources();
		Paint paint = new Paint();
		//super.onDraw(canvas);
		canvas.drawRGB(0, 0, 0);
		canvas.drawRect(100, 0, 700, 500, paint); // (x, y, largeur, hauteur)

		block.eraseList();
		for(int y=0; y <=400; y+=100)
		{
			for (int i=0 ; i<=500;i+=100)
			{
				block.addInvader(new Invader(i+block.getPosX(),y+block.getPosY(),res.getDrawable(R.drawable.alien1)));
			}
		}


		joueur.draw(canvas);
		canvas.save();
		block.draw(canvas);
		canvas.restore();

	}

	public void click(View v)
	{

		if(v.getId()==R.id.left){
			joueur.moveLeft();
		}else{
			joueur.moveRight();
		}


	}
	public void startGame(){
		thread = new ThreadSpaceInvader(myHandler,block,joueur);
		Thread thread2 = new Thread(thread);
		thread2.start();
	}
	private int computeSize(int spec,int def){
		int mode = View.MeasureSpec.getMode(spec);
		if (mode == View.MeasureSpec.UNSPECIFIED) return def;
		int size = View.MeasureSpec.getSize(spec);
		if (mode == View.MeasureSpec.EXACTLY) {
			return size;
		}
		//		MeasureSpec.AT_MOST
		if (size < def ) return size;
		return def;
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int x = computeSize(widthMeasureSpec,TARGET_WIDTH);
		int y = computeSize(heightMeasureSpec,TARGET_HEIGHT);
		this.setMeasuredDimension(x,y);
	}

	public void moveShip(boolean left, boolean right) {
		joueur.move(left,right);
	}
}
