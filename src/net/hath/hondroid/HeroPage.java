package net.hath.hondroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;
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
		
		setImages();
		setText();
	}
	
	private void setImages(){
		// Hero Icon
		((ImageView) findViewById(R.id.hero_icon)).setImageResource(getResources().getIdentifier("heroicon_"+hero.getId(), "drawable", getPackageName()));
		// Spell 1
		((ImageView) findViewById(R.id.hero_spell1)).setImageResource(getResources().getIdentifier(String.format("herospell_%d_%d",hero.getId(),1), "drawable", getPackageName()));
		// Spell 2
		((ImageView) findViewById(R.id.hero_spell2)).setImageResource(getResources().getIdentifier(String.format("herospell_%d_%d",hero.getId(),2), "drawable", getPackageName()));
		// Spell 3
		((ImageView) findViewById(R.id.hero_spell3)).setImageResource(getResources().getIdentifier(String.format("herospell_%d_%d",hero.getId(),3), "drawable", getPackageName()));
		// Spell 4
		((ImageView) findViewById(R.id.hero_spell4)).setImageResource(getResources().getIdentifier(String.format("herospell_%d_%d",hero.getId(),4), "drawable", getPackageName()));
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

}
