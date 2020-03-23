package nowga.plugin.kitpvp.vips;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.connorlinfoot.titleapi.TitleAPI;

public class VipAPI {

	public static String BETA= "§d§lBETA";
	public static String LIGHT= "§e§lLIGHT";
	public static String ALPHA= "§5§lALPHA";
	
	@SuppressWarnings("deprecation")
	public static void ativarBETA(Player p) {
		
		for(Player pls: Bukkit.getOnlinePlayers()) {
			TitleAPI.sendFullTitle(pls, 20, 60, 20, "§d"+p.getName(), "§7Tornou-se vip "+ BETA);
			
		}
		
	}
	
	
}
