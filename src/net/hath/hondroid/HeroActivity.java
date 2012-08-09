package net.hath.hondroid;

import net.hath.hondroid.HeroSelectionFragment.OnHeroSelectListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class HeroActivity extends FragmentActivity implements OnHeroSelectListener{

	HeroSelectionFragment hsf;
	HeroFragment hf;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_container);

		if (findViewById(R.id.fragmentcontainer) != null) {
			if (savedInstanceState != null) {
				return;
			}
			hsf= new HeroSelectionFragment();
			hsf.setArguments(getIntent().getExtras());
			getSupportFragmentManager().beginTransaction().add(R.id.fragmentcontainer, hsf).commit();
		}
	}

	@Override
	public void onHeroSelected(Hero hero) {
		// TODO Auto-generated method stub
		hf = new HeroFragment();
		Bundle arg = new Bundle();
		arg.putInt("heroid", hero.getId());
		hf.setArguments(arg);
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.remove(hsf);
		transaction.replace(R.id.fragmentcontainer, hf);
		transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
		transaction.addToBackStack(null);
		transaction.commit();
	}

}
