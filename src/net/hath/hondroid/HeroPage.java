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
		
		setText();
		
		// Hero Icon
		((ImageView) findViewById(R.id.hero_icon)).setImageResource(getResources().getIdentifier("heroicon_"+hero.getId(), "drawable", getPackageName()));
		// Spell 1
		((SpellView) findViewById(R.id.hero_spell1)).setImage(getResources().getIdentifier("herospell_"+hero.getId()+"_1", "drawable", getPackageName()));
		// Spell 2
		((SpellView) findViewById(R.id.hero_spell2)).setImage(getResources().getIdentifier("herospell_"+hero.getId()+"_2", "drawable", getPackageName()));
		// Spell 3
		((SpellView) findViewById(R.id.hero_spell3)).setImage(getResources().getIdentifier("herospell_"+hero.getId()+"_3", "drawable", getPackageName()));
		// Spell 4
		((SpellView) findViewById(R.id.hero_spell4)).setImage(getResources().getIdentifier("herospell_"+hero.getId()+"_4", "drawable", getPackageName()));
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
