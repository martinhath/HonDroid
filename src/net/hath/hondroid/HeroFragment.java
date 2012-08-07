package net.hath.hondroid;

import net.hath.hondroid.database.DatabaseAdapter;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class HeroFragment extends Fragment {

	private static final String TAG = "HeroFragment";
	private Hero hero;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		int heroid = getArguments().getInt("heroid");
		if (heroid != 0) {
			hero = new DatabaseAdapter(getActivity()).getHero(heroid);
		}

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.hero_view, container, false);
		if (hero == null) {
			Log.i(TAG, "Hero is null");
			return view;
		}
		ImageView icon = (ImageView) view.findViewById(R.id.hero_icon);
		icon.setImageBitmap(hero.getIcon(getActivity()));
		TextView name = (TextView) view.findViewById(R.id.hero_heroname);
		name.setText(hero.getName());
		TextView fac = (TextView) view.findViewById(R.id.hero_faction);
		fac.setText(hero.getFaction().toString());
		fac.setTextColor(hero.getFaction().getColor());
		TextView atr = (TextView) view.findViewById(R.id.hero_attribute);
		atr.setText(hero.getAttribute().toString());
		atr.setTextColor(hero.getAttribute().getColor());

		ListView spellist = (ListView) view.findViewById(R.id.spellist);
		spellist.setAdapter(new SpellListAdapter(hero));
		spellist.setClickable(false);
		return view;
	}

	private class SpellListAdapter extends BaseAdapter {
		private Hero hero;

		public SpellListAdapter(Hero h) {
			hero = h;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 4;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View view = convertView;
			if(view==null){
				LayoutInflater la = getLayoutInflater(getArguments());
				view = la.inflate(R.layout.spell_row, null);
			}
			ImageView icon = (ImageView) view.findViewById(R.id.spell_icon);
			icon.setImageBitmap(hero.getSpellIcon(getActivity(), position+1));
			TextView text_title = (TextView) view.findViewById(R.id.spell_title);
			text_title.setText(hero.getSpell(position).getName());
			TextView text_desc = (TextView) view.findViewById(R.id.spell_text);
			text_desc.setText(hero.getSpell(position).getDesc());
			return view;
		}

	}
}
