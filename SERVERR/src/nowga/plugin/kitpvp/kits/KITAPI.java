package nowga.plugin.kitpvp.kits;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.entity.Player;

public class KITAPI {

	public static String prefix= "§a§lKIT:";
	public static HashMap<String, KITS> kits= new HashMap<String, KITS>();
	public static ArrayList<String> contadorArena = new ArrayList<String>();
	
	public static void removeArena(Player p){
		if(contadorArena.contains(p.getName())) {
			contadorArena.remove(p.getName());
		}
	}
	
	public static void setKit(Player p, KITS kit) {
		
		kits.remove(p.getName());
		kits.put(p.getName(), kit);
		
	}
	
public static void removeKit(Player p) {
		
		kits.remove(p.getName());
		
	}
   public static boolean containsKit(Player p, KITS kit) {
	   if(kits.containsKey(p.getName())) {
		   if(kits.get(p.getName())== kit) {
			   return true;
		   }
	   }
	return false;
   }
   public static boolean containsKit(Player p) {
	   if(kits.containsKey(p.getName())) {
		   return true;
	   }
	return false;
   }
	
	
}
