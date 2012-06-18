package net.hath.hondroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class List extends ListView{

	public List(final Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		setAdapter(new ListAdapter(context, R.layout.list_row, R.id.list_text, Hero.toList()));
		
		
		setOnItemClickListener(new OnItemClickListener() {
			/**
			 * The onClickListener for each list item
			 */
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				// Finds the hero selected
				TextView tw = (TextView) view.findViewById(R.id.list_text);
				Hero hero = Hero.getHeroByName(tw.getText().toString());
				
				Intent intent = new Intent(context, HeroPage.class);
				// Puts hero in the intent
				Bundle b = new Bundle();
				b.putString("hero", hero.toString());
				intent.putExtras(b);
				context.startActivity(intent);
			}
		});
	}

}
