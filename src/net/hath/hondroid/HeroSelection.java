package net.hath.hondroid;

import java.util.List;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HeroSelection extends ListActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle(R.string.heroselecttitle);

		setListAdapter(new CustomAdapter(this, R.layout.list_row, Hero.toList()));
	}

	public class CustomAdapter extends ArrayAdapter<String> {
		List<String> heroes;
		public CustomAdapter(Context context, int textViewResourceId, List<String> objects) {
			super(context, textViewResourceId, objects);
			// TODO Auto-generated constructor stub
			heroes = objects;
			
			
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			final View row = convertView==null?getLayoutInflater().inflate(R.layout.list_row, parent, false):convertView;

			TextView label = (TextView) row.findViewById(R.id.text);
			label.setText(heroes.get(position));
			String name = label.getText().toString(); 
			final Hero hero = Hero.getHeroByName(name);
			
			ImageView icon = (ImageView) row.findViewById(R.id.icon);
			icon.setImageResource(getResources().getIdentifier("heroicon_"+hero.getId(), "drawable", getPackageName()));
			
			row.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Log.w("hath", "click on "+hero);
				}
			});
			
			return row;
		}

	}
}
