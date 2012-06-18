package net.hath.hondroid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

public enum Hero {
	EMPTY(0,"Empty",null,null),
	ARMADON(2,"Armadon",Faction.LEGION,Attribute.STRENGTH),
	BEHEMOTH(3,"Behemoth",Faction.LEGION,Attribute.STRENGTH),
	CHRONOS(4,"Chronos",Faction.HELLBOURNE,Attribute.AGILITY),
	DEFILER(5,"Defiler",Faction.HELLBOURNE,Attribute.INTELLIGENCE),
	DEVOURER(6,"Devourer",Faction.HELLBOURNE,Attribute.STRENGTH),
	BLACKSMITH(7,"Blacksmith",Faction.LEGION,Attribute.INTELLIGENCE),
	SLITHER(8,"Slither",Faction.HELLBOURNE,Attribute.AGILITY),
	ELECTRICIAN(9,"Electrician",Faction.HELLBOURNE,Attribute.STRENGTH),
	NYMPHORA(10,"Nymphora",Faction.LEGION,Attribute.INTELLIGENCE),
	GLACIUS(12,"Glacius",Faction.HELLBOURNE,Attribute.INTELLIGENCE),
	HAMMERSTORM(13,"Hammerstorm",Faction.LEGION,Attribute.STRENGTH),
	NIGHT_HOUND(14,"Night Hound",Faction.LEGION,Attribute.AGILITY),
	SWIFTBLADE(15,"Swiftblade",Faction.LEGION,Attribute.AGILITY),
	BLOOD_HUNTER(16,"Blood Hunter",Faction.HELLBOURNE,Attribute.AGILITY),
	KRAKEN(17,"Kraken",Faction.HELLBOURNE,Attribute.STRENGTH),
	THUNDERBRINGER(18,"Thunderbringer",Faction.LEGION,Attribute.INTELLIGENCE),
	MOON_QUEEN(20,"Moon Queen",Faction.LEGION,Attribute.AGILITY),
	POLLYWOG_PRIEST(21,"Pollywog Priest",Faction.LEGION,Attribute.INTELLIGENCE),
	PEBBLES(22,"Pebbles",Faction.LEGION,Attribute.STRENGTH),
	SOULSTEALER(24,"Soulstealer",Faction.HELLBOURNE,Attribute.AGILITY),
	KEEPER_OF_THE_FOREST(25,"Keeper Of The Forest",Faction.LEGION,Attribute.STRENGTH),
	THE_DARK_LADY(26,"The Dark Lady",Faction.HELLBOURNE,Attribute.AGILITY),
	VOODOO_JESTER(27,"Voodoo Jester",Faction.HELLBOURNE,Attribute.INTELLIGENCE),
	HELLBRINGER(28,"Hellbringer",Faction.HELLBOURNE,Attribute.INTELLIGENCE),
	WAR_BEAST(29,"War Beast",Faction.HELLBOURNE,Attribute.STRENGTH),
	WILDSOUL(30,"Wildsoul",Faction.LEGION,Attribute.AGILITY),
	ZEPHYR(31,"Zephyr",Faction.LEGION,Attribute.AGILITY),
	PHARAOH(34,"Pharaoh",Faction.HELLBOURNE,Attribute.STRENGTH),
	TEMPEST(35,"Tempest",Faction.LEGION,Attribute.INTELLIGENCE),
	OPHELIA(36,"Ophelia",Faction.LEGION,Attribute.INTELLIGENCE),
	MAGEBANE(37,"Magebane",Faction.LEGION,Attribute.AGILITY),
	LEGIONNAIRE(38,"Legionnaire",Faction.LEGION,Attribute.STRENGTH),
	PREDATOR(39,"Predator",Faction.LEGION,Attribute.STRENGTH),
	ACCURSED(40,"Accursed",Faction.HELLBOURNE,Attribute.STRENGTH),
	MADMAN(42,"Madman",Faction.HELLBOURNE,Attribute.AGILITY),
	DEMENTED_SHAMAN(43,"Demented Shaman",Faction.HELLBOURNE,Attribute.INTELLIGENCE),
	SCOUT(44,"Scout",Faction.LEGION,Attribute.AGILITY),
	JEREZIAH(89,"Jereziah",Faction.LEGION,Attribute.STRENGTH),
	TORTURER(90,"Torturer",Faction.HELLBOURNE,Attribute.INTELLIGENCE),
	PUPPET_MASTER(91,"Puppet Master",Faction.HELLBOURNE,Attribute.INTELLIGENCE),
	ARACHNA(92,"Arachna",Faction.HELLBOURNE,Attribute.AGILITY),
	PYROMANCER(94,"Pyromancer",Faction.LEGION,Attribute.INTELLIGENCE),
	PESTILENCE(95,"Pestilence",Faction.HELLBOURNE,Attribute.STRENGTH),
	MALIKEN(96,"Maliken",Faction.HELLBOURNE,Attribute.STRENGTH),
	ANDROMEDA(102,"Andromeda",Faction.LEGION,Attribute.AGILITY),
	VALKYRIE(103,"Valkyrie",Faction.LEGION,Attribute.AGILITY),
	WRETCHED_HAG(104,"Wretched Hag",Faction.HELLBOURNE,Attribute.INTELLIGENCE),
	SUCCUBUS(105,"Succubus",Faction.HELLBOURNE,Attribute.INTELLIGENCE),
	MAGMUS(106,"Magmus",Faction.HELLBOURNE,Attribute.STRENGTH),
	PLAGUE_RIDER(108,"Plague Rider",Faction.HELLBOURNE,Attribute.INTELLIGENCE),
	SOUL_REAPER(109,"Soul Reaper",Faction.HELLBOURNE,Attribute.INTELLIGENCE),
	PANDAMONIUM(110,"Pandamonium",Faction.LEGION,Attribute.STRENGTH),
	CORRUPTED_DISCIPLE(114,"Corrupted Disciple",Faction.HELLBOURNE,Attribute.AGILITY),
	VINDICATOR(115,"Vindicator",Faction.LEGION,Attribute.INTELLIGENCE),
	SAND_WRAITH(116,"Sand Wraith",Faction.HELLBOURNE,Attribute.AGILITY),
	RAMPAGE(117,"Rampage",Faction.LEGION,Attribute.STRENGTH),
	WITCH_SLAYER(120,"Witch Slayer",Faction.LEGION,Attribute.INTELLIGENCE),
	FORSAKEN_ARCHER(121,"Forsaken Archer",Faction.HELLBOURNE,Attribute.AGILITY),
	ENGINEER(122,"Engineer",Faction.LEGION,Attribute.AGILITY),
	DEADWOOD(123,"Deadwood",Faction.HELLBOURNE,Attribute.STRENGTH),
	THE_CHIPPER(124,"The Chipper",Faction.LEGION,Attribute.INTELLIGENCE),
	BUBBLES(125,"Bubbles",Faction.LEGION,Attribute.INTELLIGENCE),
	FAYDE(126,"Fayde",Faction.HELLBOURNE,Attribute.AGILITY),
	BALPHAGORE(127,"Balphagore",Faction.HELLBOURNE,Attribute.STRENGTH),
	GAUNTLET(128,"Gauntlet",Faction.HELLBOURNE,Attribute.STRENGTH),
	TUNDRA(160,"Tundra",Faction.LEGION,Attribute.STRENGTH),
	THE_GLADIATOR(161,"The Gladiator",Faction.LEGION,Attribute.STRENGTH),
	DOCTOR_REPULSOR(162,"Doctor Repulsor",Faction.HELLBOURNE,Attribute.INTELLIGENCE),
	FLINT_BEASTWOOD(163,"Flint Beastwood",Faction.HELLBOURNE,Attribute.AGILITY),
	BOMBARDIER(164,"Bombardier",Faction.LEGION,Attribute.INTELLIGENCE),
	MORAXUS(165,"Moraxus",Faction.HELLBOURNE,Attribute.STRENGTH),
	MYRMIDON(166,"Myrmidon",Faction.HELLBOURNE,Attribute.INTELLIGENCE),
	DAMPEER(167,"Dampeer",Faction.HELLBOURNE,Attribute.AGILITY),
	EMPATH(168,"Empath",Faction.LEGION,Attribute.INTELLIGENCE),
	ALUNA(169,"Aluna",Faction.LEGION,Attribute.INTELLIGENCE),
	TREMBLE(170,"Tremble",Faction.HELLBOURNE,Attribute.AGILITY),
	NOMAD(171,"Nomad",Faction.LEGION,Attribute.AGILITY),
	SILHOUETTE(185,"Silhouette",Faction.LEGION,Attribute.AGILITY),
	FLUX(187,"Flux",Faction.LEGION,Attribute.STRENGTH),
	MARTYR(188,"Martyr",Faction.LEGION,Attribute.INTELLIGENCE),
	AMUN_RA(192,"Amun Ra",Faction.HELLBOURNE,Attribute.STRENGTH),
	PARASITE(194,"Parasite",Faction.HELLBOURNE,Attribute.INTELLIGENCE),
	EMERALD_WARDEN(195,"Emerald Warden",Faction.LEGION,Attribute.AGILITY),
	REVENANT(196,"Revenant",Faction.HELLBOURNE,Attribute.INTELLIGENCE),
	MONKEY_KING(197,"Monkey King",Faction.LEGION,Attribute.AGILITY),
	DRUNKEN_MASTER(201,"Drunken Master",Faction.LEGION,Attribute.STRENGTH),
	MASTER_OF_ARMS(202,"Master Of Arms",Faction.LEGION,Attribute.AGILITY),
	RHAPSODY(203,"Rhapsody",Faction.LEGION,Attribute.INTELLIGENCE),
	GEOMANCER(204,"Geomancer",Faction.HELLBOURNE,Attribute.INTELLIGENCE),
	MIDAS(205,"Midas",Faction.LEGION,Attribute.STRENGTH),
	CHUTHULUFANT(206,"Chuthulufant",Faction.HELLBOURNE,Attribute.STRENGTH),
	MONARCH(207,"Monarch",Faction.LEGION,Attribute.INTELLIGENCE),
	GEMINI(208,"Gemini",Faction.HELLBOURNE,Attribute.AGILITY),
	LORD_SALFORIS(209,"Lord Salforis",Faction.HELLBOURNE,Attribute.STRENGTH),
	SHADOWBLADE(210,"Shadowblade",Faction.HELLBOURNE,Attribute.AGILITY),
	ARTESIA(211,"Artesia",Faction.HELLBOURNE,Attribute.INTELLIGENCE),
	GRAVEKEEPER(212,"Gravekeeper",Faction.HELLBOURNE,Attribute.INTELLIGENCE),
	BERZERKER(213,"Berzerker",Faction.LEGION,Attribute.STRENGTH),
	DRACONIS(214,"Draconis",Faction.LEGION,Attribute.AGILITY),
	KINESIS(215,"Kinesis",Faction.LEGION,Attribute.INTELLIGENCE),
	GUNBLADE(216,"Gunblade",Faction.HELLBOURNE,Attribute.AGILITY),
	BLITZ(217,"Blitz",Faction.LEGION,Attribute.AGILITY),
	ARTILLERY(218,"Artillery",Faction.LEGION,Attribute.AGILITY),
	ELLONIA(219,"Ellonia",Faction.LEGION,Attribute.INTELLIGENCE),
	RIFTWALKER(220,"Riftwalker",Faction.HELLBOURNE,Attribute.INTELLIGENCE),
	BRAMBLE(221,"Bramble",Faction.LEGION,Attribute.STRENGTH),
	RAVENOR(222,"Ravenor",Faction.HELLBOURNE,Attribute.STRENGTH);
	
	private int id;
	private String name;
	private Faction faction;
	private Attribute attribute;
	
	Hero(int i,String n, Faction c, Attribute a){
		id = i;
		name = n;
		faction = c;
		attribute = a;
	}
	public int getId(){
		return id; 
	}
	public String getName(){
		return name;
	}
	public Faction getFaction() {
		return faction;
	}
	public Attribute getAttribute() {
		return attribute;
	}
	@Override
	public String toString() {
		return getName();
	}
	public static Hero getHeroByName(String name){
		for(Hero h:EnumSet.allOf(Hero.class)){
			if(h.toString().equals(name)){
				return h;
			}
		}
		return Hero.EMPTY;
	}
	public static List<String> toList(){
		List<String> list = new ArrayList<String>();
		for(Hero h:EnumSet.allOf(Hero.class)){
			if(h==Hero.EMPTY) continue;
			list.add(h.toString());
		}
		Collections.sort(list);
		return list;
	}
}
