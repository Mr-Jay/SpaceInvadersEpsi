package fr.dubois.space.invader;



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
	private Paint paint; // Style pour le texte
	private String text; // texte à afficher


	public SpaceInvaderView(Context context) {
		super(context);
		init();
	}

	public SpaceInvaderView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public SpaceInvaderView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}


	

	void init(){
		paint = new Paint();
		paint.setStyle(Style.STROKE);
		paint.setColor(Color.YELLOW);
		paint.setTypeface(Typeface.SANS_SERIF);
		paint.setTextSize(36);
		paint.setTextAlign(Paint.Align.CENTER);
		text = "Texte";
	}








	@Override
	protected void onDraw(Canvas canvas) {
		Resources res = getResources();
		Paint paint = new Paint();
		super.onDraw(canvas);
		canvas.drawRGB(0, 0, 0);
		canvas.drawRect(100, 0, 700, 500, paint); // (x, y, largeur, hauteur)

		for(int y=0; y <=400; y+=100)
		{
			for (int i=100 ; i<=600;i+=100)
			{
				Bitmap bitmap = BitmapFactory.decodeResource(res,R.drawable.alien1);
				canvas.drawBitmap(bitmap, i, y, paint);
			}
		}

		text= null;
		if (text != null){
			paint.setTextSize(50);
			canvas.drawText(text, canvas.getWidth()/2,canvas.getHeight()/2, paint);
		}

		// Affichage du vaiseau
		Bitmap bitmap = BitmapFactory.decodeResource(res,R.drawable.ship);
		canvas.drawBitmap(bitmap, shipPosX, 800, paint);
	}

	public void click(View v)
	{
		if(v.getId()==R.id.left){
			//Ajouter vérification bord écran
			shipPosX-=5;
		}else{
			//Ajouter vérification bord écran
			shipPosX+=5;
		}
		this.invalidate();
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

}
