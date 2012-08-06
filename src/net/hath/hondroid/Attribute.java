package net.hath.hondroid;

import android.util.Log;

public enum Attribute {
	STRENGTH(0xFFcd554c, "Strength"), AGILITY(0xFF63c24a, "Agility"), INTELLIGENCE(0xFF4266cf,"Intelligence");
	
	private String string;
	private int color; 
	
	Attribute(int color, String s){
		this.color = color;
		string = s;
	}
	public int getColor(){
		return color;
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
