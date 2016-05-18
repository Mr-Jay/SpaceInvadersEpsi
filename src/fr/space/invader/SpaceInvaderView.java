package fr.space.invader;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.*;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

public class SpaceInvaderView extends View {
	
	// Dimensions souhaitées
	/*private static final int TARGET_HEIGHT = 800;
	private static final int TARGET_WIDTH = 600;*/
	private Joueur joueur;
	private Missile missile;
	private InvadersBlock block;
	private ThreadSpaceInvader thread;

	private Handler myHandler=new Handler(){
		public void handleMessage(Message msg){
			invalidate();
		}
	};

	public SpaceInvaderView(Context context, AttributeSet attrs) {

		super(context, attrs);
		Resources res = getResources();
		this.block=new InvadersBlock(getResources().getDrawable(R.drawable.alien1));
		this.joueur=new Joueur(getResources().getDrawable(R.drawable.ship), SpaceInvaderActivity.dm);
		this.missile=new Missile(getResources().getDrawable(R.drawable.missile),joueur);
	}

	@Override
	protected void onDraw(Canvas canvas) {


		Paint paint = new Paint();
		//super.onDraw(canvas);
		canvas.drawRGB(0, 0, 0);
		canvas.drawRect(0, 0, SpaceInvaderActivity.dm.widthPixels, SpaceInvaderActivity.dm.heightPixels, paint); // (x, y, largeur, hauteur)



		joueur.setBounds(SpaceInvaderActivity.dm);
		joueur.draw(canvas);
		missile.draw(canvas);
		canvas.save();
		block.draw(canvas);
		canvas.restore();

	}
	
	public void startGame(){
		thread = new ThreadSpaceInvader(myHandler,block,joueur,missile,SpaceInvaderActivity.dm.widthPixels);
		Thread thread2 = new Thread(thread);
		thread2.start();
	}


	public void moveShip(boolean left, boolean right) {
		joueur.move(left,right);
	}
}
