package net.hath.hondroid;

import android.util.Log;

public enum Faction {
	HELLBOURNE(0xFFcd554c, "Hellbourne"), LEGION(0xFF63c24a, "Legion");

	private String string;
	private int color;

	Faction(int color, String s) {
		string = s;
		this.color = color;
	}
	public int getColor(){
		return color;
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