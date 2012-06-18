package net.hath.hondroid;

import java.util.EnumSet;

public enum Faction {
	HELLBOURNE(0xFFcd554c, "Hellbourne"), LEGION(0xFF63c24a, "Legion");

	private int color;
	private String name;
		
	Faction(int c, String s){
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
	public Faction getAttributeByName(String n){
		for(Faction f:EnumSet.allOf(Faction.class)){
			if(f.toString().equals(n)){
				return f;
			}
		}
		return null;
	}
	
}
