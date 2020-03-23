package nowga.plugin.kitpvp.comandos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import nowga.plugin.kitpvp.Main;
import nowga.plugin.kitpvp.Manager;
import nowga.plugin.kitpvp.Permissions;

public class Admin implements CommandExecutor{

	public static ArrayList<Player> adminMode= new ArrayList<Player>();
	public static HashMap<Player, ItemStack[]> itensInv= new HashMap<Player, ItemStack[]>();
	public static String prefix= "§6§lADMINMODE: ";
	
	public static ItemStack AntiKB= Manager.createiItemEnchantment(Material.STICK, "§aAnti KB", Enchantment.KNOCKBACK, 2);
	public static ItemStack ff= Manager.createiItem(Material.BLAZE_ROD, "§aForce Field");
	public static ItemStack noFall= Manager.createiItem(Material.FEATHER, "§aNo-Fall");
	public static ItemStack cage= Manager.createitemID(101, 0, "§aCage");
	public static ItemStack autosoup= Manager.createiItem(Material.MUSHROOM_SOUP, "§aAuto-Soup");
	public static ItemStack QuitModeItem= Manager.createiItem(Material.REDSTONE_TORCH_ON, "§cSAIR");
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(!(sender instanceof Player))return true;
		if(cmd.getName().equalsIgnoreCase("admin")) {
			Player p= (Player)sender;
			if(p.hasPermission(Permissions.ADMINMODE)) {
				
				if(!(adminMode.contains(p))) {
					
					
					adminMode.add(p);
					itensInv.put(p, p.getInventory().getContents());
					p.sendMessage(prefix+"§7Você entrou no modo admin!");
					p.getInventory().clear();
					p.setGameMode(GameMode.CREATIVE);
					
					for(Player pls: Bukkit.getOnlinePlayers()) {
						if(!(pls.hasPermission(Permissions.ADMINMODEVER))) {
                      
						pls.hidePlayer(p);
						}else {
							pls.showPlayer(p);
						}
						
					}
					
					new BukkitRunnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							
							p.getInventory().setItem(0, AntiKB);
							p.getInventory().setItem(1, ff);
							p.getInventory().setItem(3, noFall);
							p.getInventory().setItem(5, cage);
							p.getInventory().setItem(7, autosoup);
							p.getInventory().setItem(8, QuitModeItem);
						}
					}.runTaskLater(Main.plugin, 10);
					
				}else {
					
					p.sendMessage(prefix+"§7Você saiu do modo admin!");
					adminMode.remove(p);
					p.getInventory().clear();
					
                    for(Player pls: Bukkit.getOnlinePlayers()) {
						
                    	pls.showPlayer(p);
						
					}
					new BukkitRunnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							p.getInventory().setContents(itensInv.get(p));
							itensInv.remove(p);
						}
					}.runTaskLater(Main.plugin, 10);
					
				}
				
				
			}else {
				p.sendMessage(Permissions.nopermission);
			}
		}
		return false;
	}
	
}
