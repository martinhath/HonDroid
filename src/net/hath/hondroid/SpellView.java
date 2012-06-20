package net.hath.hondroid;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SpellView extends LinearLayout {

	private View content; 
	
	public SpellView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		//inflate(context, R.layout.spellview, null);
		content = LayoutInflater.from(context).inflate(R.layout.spellview, this);
	}

	public void setImage(int resource){
		
		((ImageView) findViewById(R.id.spellicon)).setImageResource(resource);
	}
}
