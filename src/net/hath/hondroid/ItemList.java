package net.hath.hondroid;

import net.hath.hondroid.activities.HeroPage;
import net.hath.hondroid.adapter.HeroAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

public class ItemList extends GridView{
	
	public ItemList(final Context context, Bundle b) {
		super(context);
		// TODO Auto-generated constructor stub
		OnItemClickListener heroclick = new OnItemClickListener() {
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
		};


		String type = b.getString("type");
		if(type.equals("hero")){
			setAdapter(new HeroAdapter(context, R.layout.list_row, R.id.list_text, Hero.toList()));
			setOnItemClickListener(heroclick);
		}else if(type.equals("item")){
			Log.d("hath", "Enter the Item List");
		}
		
		
	}

}
