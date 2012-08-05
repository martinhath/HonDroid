package net.hath.hondroid;

public class Hero {
	private int id;
	private String name;
	private Faction faction;
	private Attribute attribute;
	private int icon;

	public Hero(int id, String n, Faction f, Attribute a, int icon) {
		this.id = id;
		name = n;
		faction = f;
		attribute = a;
		this.icon = icon;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Faction getFaction() {
		return faction;
	}

	public Attribute getAttribute() {
		return attribute;
	}

	public int getIcon() {
		return icon;
	}
	public void setIcon(int id){
		icon = id;
	}

}
