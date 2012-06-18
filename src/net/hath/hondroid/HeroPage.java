package net.hath.hondroid;

import android.app.Activity;
import android.os.Bundle;

public class HeroPage extends Activity {

	private Hero hero;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hero);
		
		String heroName = getIntent().getExtras().getString("hero");
		hero = Hero.getHeroByName(heroName);
	}

}
