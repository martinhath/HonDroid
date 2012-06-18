package net.hath.hondroid;

import java.util.EnumSet;

public enum Attribute {
	STRENGTH(0xFFcd554c, "Strength"), AGILITY(0xFF63c24a, "Agility"), INTELLIGENCE(0xFF4266cf,"Intelligence");

	private int color;
	private String name;
		
	Attribute(int c, String s){
		color = c;
		name = s;
	}

	public int getColor() {
		return color;
	}

	public String getName() {
		return name;
	}
	public String toString(){
		return getName();
	}
	public Attribute getAttributeByName(String n){
		for(Attribute a:EnumSet.allOf(Attribute.class)){
			if(a.toString().equals(n)){
				return a;
			}
		}
		return null;
	}
}
