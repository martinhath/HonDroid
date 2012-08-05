package net.hath.hondroid;

import net.hath.hondroid.database.DatabaseAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HathLauncher extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		DatabaseAdapter da = new DatabaseAdapter(this);
		if(!da.isEmpty()){
			end();
		}
        setContentView(R.layout.db_create);
        
        Button btn_crt = (Button)findViewById(R.id.dbcreate_create);
        btn_crt.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cont();
			}
        });
        Button btn_cont = (Button)findViewById(R.id.dbcreate_cont);
        btn_cont.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				end();
			}
        });
        Button btn_wifi = (Button)findViewById(R.id.dbcreate_wifibtn);
        btn_wifi.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS));
			}
        });

	}
	private void cont(){
		startActivity(new Intent(this, DatabaseCreator.class));
	}
	private void end(){
		startActivity(new Intent(this, MainActivity.class));
		finish();
	}
	
}
