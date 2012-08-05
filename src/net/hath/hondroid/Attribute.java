package net.hath.hondroid;

import android.util.Log;

public enum Attribute {
	STRENGTH("Strength"), AGILITY("Agility"), INTELLIGENCE("Intelligence");
	
	private String string;
	
	Attribute(String s){
		string = s;
	}
	
	public String toString(){
		return string;
	}
	public static Attribute get(String s){
		for(Attribute a:values()){
			if(s.equals(a.toString()))
				return a;
		}
		Log.d("Attribute", "Attribute \""+s+"\" not found");
		return null;
	}
}
