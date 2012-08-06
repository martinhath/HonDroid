package net.hath.hondroid;

import net.hath.hondroid.HeroSelectionFragment.OnHeroSelectListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class HeroActivity extends FragmentActivity implements OnHeroSelectListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_container);

		if (findViewById(R.id.fragmentcontainer) != null) {
			if (savedInstanceState != null) {
				return;
			}
			HeroSelectionFragment hf = new HeroSelectionFragment();
			hf.setArguments(getIntent().getExtras());
			getSupportFragmentManager().beginTransaction().add(R.id.fragmentcontainer, hf).commit();
		}
	}

	@Override
	public void onHeroSelected(int heroid) {
		// TODO Auto-generated method stub
		Fragment hf = new HeroFragment();
		Bundle arg = new Bundle();
		arg.putInt("heroid", heroid);
		hf.setArguments(arg);
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.fragmentcontainer, hf);
		transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
		transaction.addToBackStack(null);
		transaction.commit();
	}

}
