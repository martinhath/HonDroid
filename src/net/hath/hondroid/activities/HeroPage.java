package net.hath.hondroid.activities;

import java.util.ArrayList;
import java.util.Arrays;

import net.hath.hondroid.Hero;
import net.hath.hondroid.R;
import net.hath.hondroid.R.id;
import net.hath.hondroid.R.layout;
import net.hath.hondroid.adapter.SpellAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class HeroPage extends Activity {

	private Hero hero;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.hero);
		
		String heroName = getIntent().getExtras().getString("hero");
		hero = Hero.getHeroByName(heroName);
		
		setText();
		
		// Hero Icon
		((ImageView) findViewById(R.id.hero_icon)).setImageResource(getResources().getIdentifier("heroicon_"+hero.getId(), "drawable", getPackageName()));
		// Spell names
		java.util.List<String> liste = Arrays.asList("En", "To", "Tre", "Fire");
		((ListView) findViewById(R.id.spellist)).setAdapter(new SpellAdapter(this,R.layout.list_row, R.id.list_text, liste));
	}
	
	private void setText(){
		// Hero name
		((TextView) findViewById(R.id.hero_heroname)).setText(hero.getName());
		// Faction
		TextView faction = ((TextView) findViewById(R.id.hero_faction));
		faction.setText(hero.getFaction().toString());
		faction.setTextColor(hero.getFaction().getColor());
		// Attribute
		TextView attribute = ((TextView) findViewById(R.id.hero_attribute));
		attribute.setText(hero.getAttribute().toString());
		attribute.setTextColor(hero.getAttribute().getColor());
		
	}
	
	public Hero getHero(){
		return hero;
	}

}
