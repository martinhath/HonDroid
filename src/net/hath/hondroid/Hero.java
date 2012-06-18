package net.hath.hondroid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

public enum Hero {
	EMPTY(0,"Empty"),
	ARMADON(2,"Armadon"),
	BEHEMOTH(3,"Behemoth"),
	CHRONOS(4,"Chronos"),
	DEFILER(5,"Defiler"),
	DEVOURER(6,"Devourer"),
	BLACKSMITH(7,"Blacksmith"),
	SLITHER(8,"Slither"),
	ELECTRICIAN(9,"Electrician"),
	NYMPHORA(10,"Nymphora"),
	GLACIUS(12,"Glacius"),
	HAMMERSTORM(13,"Hammerstorm"),
	NIGHT_HOUND(14,"Night Hound"),
	SWIFTBLADE(15,"Swiftblade"),
	BLOOD_HUNTER(16,"Blood Hunter"),
	KRAKEN(17,"Kraken"),
	THUNDERBRINGER(18,"Thunderbringer"),
	MOON_QUEEN(20,"Moon Queen"),
	POLLYWOG_PRIEST(21,"Pollywog Priest"),
	PEBBLES(22,"Pebbles"),
	SOULSTEALER(24,"Soulstealer"),
	KEEPER_OF_THE_FOREST(25,"Keeper Of The Forest"),
	THE_DARK_LADY(26,"The Dark Lady"),
	VOODOO_JESTER(27,"Voodoo Jester"),
	HELLBRINGER(28,"Hellbringer"),
	WAR_BEAST(29,"War Beast"),
	WILDSOUL(30,"Wildsoul"),
	ZEPHYR(31,"Zephyr"),
	PHARAOH(34,"Pharaoh"),
	TEMPEST(35,"Tempest"),
	OPHELIA(36,"Ophelia"),
	MAGEBANE(37,"Magebane"),
	LEGIONNAIRE(38,"Legionnaire"),
	PREDATOR(39,"Predator"),
	ACCURSED(40,"Accursed"),
	MADMAN(42,"Madman"),
	DEMENTED_SHAMAN(43,"Demented Shaman"),
	SCOUT(44,"Scout"),
	JEREZIAH(89,"Jereziah"),
	TORTURER(90,"Torturer"),
	PUPPET_MASTER(91,"Puppet Master"),
	ARACHNA(92,"Arachna"),
	PYROMANCER(94,"Pyromancer"),
	PESTILENCE(95,"Pestilence"),
	MALIKEN(96,"Maliken"),
	ANDROMEDA(102,"Andromeda"),
	VALKYRIE(103,"Valkyrie"),
	WRETCHED_HAG(104,"Wretched Hag"),
	SUCCUBUS(105,"Succubus"),
	MAGMUS(106,"Magmus"),
	PLAGUE_RIDER(108,"Plague Rider"),
	SOUL_REAPER(109,"Soul Reaper"),
	PANDAMONIUM(110,"Pandamonium"),
	CORRUPTED_DISCIPLE(114,"Corrupted Disciple"),
	VINDICATOR(115,"Vindicator"),
	SAND_WRAITH(116,"Sand Wraith"),
	RAMPAGE(117,"Rampage"),
	WITCH_SLAYER(120,"Witch Slayer"),
	FORSAKEN_ARCHER(121,"Forsaken Archer"),
	ENGINEER(122,"Engineer"),
	DEADWOOD(123,"Deadwood"),
	THE_CHIPPER(124,"The Chipper"),
	BUBBLES(125,"Bubbles"),
	FAYDE(126,"Fayde"),
	BALPHAGORE(127,"Balphagore"),
	GAUNTLET(128,"Gauntlet"),
	TUNDRA(160,"Tundra"),
	THE_GLADIATOR(161,"The Gladiator"),
	DOCTOR_REPULSOR(162,"Doctor Repulsor"),
	FLINT_BEASTWOOD(163,"Flint Beastwood"),
	BOMBARDIER(164,"Bombardier"),
	MORAXUS(165,"Moraxus"),
	MYRMIDON(166,"Myrmidon"),
	DAMPEER(167,"Dampeer"),
	EMPATH(168,"Empath"),
	ALUNA(169,"Aluna"),
	TREMBLE(170,"Tremble"),
	NOMAD(171,"Nomad"),
	SILHOUETTE(185,"Silhouette"),
	FLUX(187,"Flux"),
	MARTYR(188,"Martyr"),
	AMUN_RA(192,"Amun Ra"),
	PARASITE(194,"Parasite"),
	EMERALD_WARDEN(195,"Emerald Warden"),
	REVENANT(196,"Revenant"),
	MONKEY_KING(197,"Monkey King"),
	DRUNKEN_MASTER(201,"Drunken Master"),
	MASTER_OF_ARMS(202,"Master Of Arms"),
	RHAPSODY(203,"Rhapsody"),
	GEOMANCER(204,"Geomancer"),
	MIDAS(205,"Midas"),
	CHUTHULUFANT(206,"Chuthulufant"),
	MONARCH(207,"Monarch"),
	GEMINI(208,"Gemini"),
	LORD_SALFORIS(209,"Lord Salforis"),
	SHADOWBLADE(210,"Shadowblade"),
	ARTESIA(211,"Artesia"),
	GRAVEKEEPER(212,"Gravekeeper"),
	BERZERKER(213,"Berzerker"),
	DRACONIS(214,"Draconis"),
	KINESIS(215,"Kinesis"),
	GUNBLADE(216,"Gunblade"),
	BLITZ(217,"Blitz"),
	ARTILLERY(218,"Artillery"),
	ELLONIA(219,"Ellonia"),
	RIFTWALKER(220,"Riftwalker"),
	BRAMBLE(221,"Bramble"),
	RAVENOR(222,"Ravenor");

	private int id;
	private String name;
	
	Hero(int i,String n){
		id = i;
		name = n;
	}
	public int getId(){
		return id; 
	}
	public String getName(){
		return toString();
	}
	@Override
	public String toString() {
		return name;
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
