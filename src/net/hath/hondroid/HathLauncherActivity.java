package net.hath.hondroid;

import net.hath.hondroid.database.DatabaseAdapter;
import net.hath.hondroid.database.DatabaseCreatorActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class HathLauncherActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		
		DatabaseAdapter da = new DatabaseAdapter(this);
		if (!da.isEmpty()) {
			end();
		}
		setContentView(R.layout.db_create);

		Button btn_crt = (Button) findViewById(R.id.dbcreate_create);
		btn_crt.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (!isOnline()) {
					AlertDialog.Builder builder = new AlertDialog.Builder(HathLauncherActivity.this);
					builder.setMessage(getString(R.string.dbcreate_network));
					builder.setPositiveButton(getString(R.string.dbcreate_opennetwork), new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							startActivity(new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS));
						}
					});
					builder.setNegativeButton(getString(R.string.back), new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.cancel();
						}
					});
					AlertDialog alert = builder.create();
					alert.show();
				}else{
					cont();
				}
			}
		});
		Button btn_cont = (Button) findViewById(R.id.dbcreate_cont);
		btn_cont.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				end();
			}
		});

	}

	private void cont() {
		startActivity(new Intent(this, DatabaseCreatorActivity.class));
		finish();
	}

	private void end() {
		startActivity(new Intent(this, MainActivity.class));
		finish();
	}

	public boolean isOnline() {
		ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if (netInfo != null && netInfo.isConnectedOrConnecting()) {
			return true;
		}
		return false;
	}

}
