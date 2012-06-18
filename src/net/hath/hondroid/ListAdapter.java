package net.hath.hondroid;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter<String> {

	Context context;
	List<String> heroes;
	
	public ListAdapter(Context context, int resource, int textViewResourceId, List<String> objects) {
		super(context, resource, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		this.context = context;
		heroes = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View row = convertView;
		
		if(row == null){
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			row = inflater.inflate(R.layout.list_row, parent, false);
		}
		
		Hero hero = Hero.getHeroByName(heroes.get(position));
		
		ImageView image = (ImageView) row.findViewById(R.id.list_icon);
		TextView text = (TextView) row.findViewById(R.id.list_text);
		
		text.setText(hero.getName());
		
		image.setImageResource(context.getResources().getIdentifier("heroicon_"+hero.getId(), "drawable", context.getPackageName()));
		
		

		return row;
	}
	

}
