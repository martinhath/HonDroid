package net.hath.hondroid;

import net.hath.hondroid.database.DatabaseAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class HeroFragment extends Fragment {

	private static final String TAG = "HeroFragment";
	private Hero hero;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		int heroid = getArguments().getInt("heroid");
		if(heroid != 0){
			hero = new DatabaseAdapter(getActivity()).getHero(heroid);
			Log.i(TAG, "ID: " + heroid + " Name: " + hero.getName());
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
		fac.setTextColor(hero.getAttribute().getColor());
		TextView atr = (TextView) view.findViewById(R.id.hero_attribute);
		atr.setText(hero.getAttribute().toString());
		fac.setTextColor(hero.getFaction().getColor());
		return view;
	}

}
