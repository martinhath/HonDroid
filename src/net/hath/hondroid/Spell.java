package net.hath.hondroid;

public class Spell {
	private String name;
	private String desc;
	private int id;
	private int num;

	public Spell(String name, String desc, int id, int num) {
		this.name = name;
		this.desc = desc;
		this.id = id;
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public int getId() {
		return id;
	}

	public int getNum() {
		return num;
	}
}
