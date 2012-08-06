package net.hath.hondroid;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class HeroActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_container);

		if (findViewById(R.id.fragmentcontainer) != null) {
			if (savedInstanceState != null) {
				return;
			}
			HeroFragment hf = new HeroFragment();
			hf.setArguments(getIntent().getExtras());
			getSupportFragmentManager().beginTransaction().add(R.id.fragmentcontainer, hf).commit();
		}
	}

}
