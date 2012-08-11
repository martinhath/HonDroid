package net.hath.hondroid;

import net.hath.hondroid.HeroListFragment.OnHeroSelectListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

public class HeroScreenActivity extends FragmentActivity implements
		OnHeroSelectListener {

	private static final String TAG = "HeroScreenActivity";
	HeroListFragment hsf;
	HeroScreenFragment hf;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hero_screen);

		// Small screen
		if (findViewById(R.id.fragmentcontainer) != null) {
			Log.i(TAG, "Small screen detected");
			if (savedInstanceState != null) {
				return;
			}
			hsf = new HeroListFragment();
			hsf.setArguments(getIntent().getExtras());
			getSupportFragmentManager().beginTransaction()
					.add(R.id.fragmentcontainer, hsf).commit();
		} 
	}

	public void onHeroSelected(Hero hero) {
		// TODO Auto-generated method stub
		// Large layout
		HeroScreenFragment hs = (HeroScreenFragment) getSupportFragmentManager().findFragmentById(R.id.hero_fragment);
		if(hs != null){
			hs.updateView(hero);
			return;
		}
		hf = new HeroScreenFragment();
		Bundle arg = new Bundle();
		arg.putInt("heroid", hero.getId());
		hf.setArguments(arg);
		FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
		transaction.remove(hsf);
		transaction.replace(R.id.fragmentcontainer, hf);
		transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
		transaction.addToBackStack(null);
		transaction.commit();
	}

}
