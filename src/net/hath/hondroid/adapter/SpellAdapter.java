package net.hath.hondroid.adapter;

import java.util.List;

import net.hath.hondroid.R;
import net.hath.hondroid.activities.HeroPage;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Each row in the list. Handles the data in it's constructor
 * @author MartinHaTh
 *
 */
public class SpellAdapter extends ArrayAdapter<String> {

	Context context;
	List<String> spells;
	
	public SpellAdapter(Context context, int resource, int textViewResourceId, List<String> objects) {
		super(context, resource, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		this.context = context;
		spells = objects;
		Log.d("hath", "ctor");
	}

	/**
	 * Returns the view for each row.
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View row = convertView;
		
		if(row == null){
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			row = inflater.inflate(R.layout.list_row, parent, false);
		}
		
		ImageView image = (ImageView) row.findViewById(R.id.list_icon);
		TextView text = (TextView) row.findViewById(R.id.list_text);
		
		if(position==0){
			text.setText("Stats");
			return row;
		}
		else{
			text.setText("Spell"+(position));
		}
		image.setImageResource(context.getResources().getIdentifier("herospell_"+((HeroPage) context).getHero().getId()+"_"+Integer.toString(position), "drawable", context.getPackageName()));
		return row;
	}
}