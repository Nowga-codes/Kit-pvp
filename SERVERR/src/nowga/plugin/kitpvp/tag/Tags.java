package nowga.plugin.kitpvp.tag;

import org.bukkit.entity.Player;

import nowga.plugin.kitpvp.Permissions;

public class Tags {
	
	public static String getTagScore(Player p) {
		
		if(TagCommand.tags.get(p.getName())== "MEMBRO")return "§7§lMEMBRO";
        if( !(TagCommand.tags.containsKey(p.getName())))return "§7§lMEMBRO";
		
		String tag= TagCommand.tags.get(p.getName());
		return p.getScoreboard().getTeam(tag).getPrefix();
	}
	public static void setTag(Player p, String tagName) {
		TagCommand.tags.put(p.getName(), tagName);
	}
	public static void setTagJoin(Player p) {

		
		if(p.isOp()) {
			if(p.getName().equals("Rasen")|| p.getName().equals("Nowga")) {
				setTag(p, "DONO");
			}else {
				setTag(p, "ADMIN");
			}
			return;
		}
		
		if(p.hasPermission(Permissions.ADMIN)) {
			setTag(p, "ADMIN");
		}
		if(p.hasPermission(Permissions.MODGC)) {
			setTag(p, "MODGC");
		}
		if(p.hasPermission(Permissions.MOD)) {
			setTag(p, "MOD");
		}
		if(p.hasPermission(Permissions.TRIAL)) {
			setTag(p, "TRIAL");
		}
		if(p.hasPermission(Permissions.BUILDER)) {
			setTag(p, "BUILDER");
		}
		if(p.hasPermission(Permissions.HELPER)) {
			setTag(p, "HELPER");
		}
		if(p.hasPermission(Permissions.ALPHA)) {
			setTag(p, "ALPHA");
		}
		if(p.hasPermission(Permissions.LIGHT)) {
			setTag(p, "LIGHT");
		}
		if(p.hasPermission(Permissions.BETA)) {
			setTag(p, "BETA");
		}
		if(p.hasPermission(Permissions.YTPLUS)) {
			setTag(p, "YTPLUS");
		}
		if(p.hasPermission(Permissions.YT)) {
			setTag(p, "YT");
		}
		if(p.hasPermission(Permissions.PRO)) {
			setTag(p, "PRO");
		}
		if(p.hasPermission(Permissions.MEMBRO)) {
			setTag(p, "MEMBRO");
		}
		
		
	}
	
	public static String DONO= "§6§lDONO §6";
	public static String ADMIN= "§c§lADMIN §c";
	public static String MODGC= "§2§LMOD-GC §2";
	public static String MOD= "§a§lMOD §a";
	public static String TRIAL= "§9§lTRIAL §9";
	public static String BUILDER= "§f§lBUILDER §f";
	public static String HELPER= "§e§lHELPER §e";
	public static String ALPHA= "§d§lALPHA §d";
	public static String LIGHT= "§5§lLIGHT §5";
	public static String BETA= "§4§LBETA §4";
	public static String YTPLUS= "§b§lYT+ §b";
	public static String YT= "§3§lYT §3";
	public static String PRO= "§f§lPRO §f";
	public static String MEMBRO= "§7MEMBRO";
	
	
}
