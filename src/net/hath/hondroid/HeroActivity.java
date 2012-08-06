package net.hath.hondroid;

import net.hath.hondroid.HeroSelectionFragment.OnHeroSelectListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

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
	public void onHeroSelected(Hero hero) {
		// TODO Auto-generated method stub
		Toast toast = Toast.makeText(getApplicationContext(), hero.getName(), Toast.LENGTH_SHORT);
		toast.show();
	}

}
