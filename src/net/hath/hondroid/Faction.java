package net.hath.hondroid;

import android.util.Log;

public enum Faction {
	LEGION("Legion"), HELLBOURNE("Hellbourne");

	private String string;

	Faction(String s) {
		string = s;
	}

	public String toString() {
		return string;
	}
	public static Faction get(String s){
		for(Faction f:values()){
			if(s.equals(f.toString()))
				return f;
		}
		Log.d("Faction", "Faction \""+s+"\" not found");
		return null;
	}
}