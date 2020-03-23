package nowga.plugin.kitpvp.eventos;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import nowga.plugin.kitpvp.Main;
import nowga.plugin.kitpvp.Manager;
import nowga.plugin.kitpvp.cadastro.Eventos;

public class AntiJoinBot implements Listener{


    public static ArrayList<Player> unverified= new ArrayList<Player>();
	
	public static ItemStack unlockBlock= Manager.createitemID(35, 5, "§aBloco verde");
	public static Inventory inv = Bukkit.createInventory(null, 3*9, "Clique no bloco verde");

	public static ArrayList<Player> list= unverified; 
	
	public static void inventario(Player p) {
		
		
		if(AntiRelog.relog.contains(p.getName()))return;
		list.add(p);
		delayKickPlayer(p);
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			Random r= new Random();
			int number= r.nextInt(27);
			
			
				
				for(int i= 0; i< 27; i++) {
					inv.setItem(i, Manager.createitemID(35, 8, "§8Clique no bloco verde"));
				}
				inv.setItem(number, unlockBlock);
				
				p.openInventory(inv);
				
			}
		}.runTaskLater(Main.plugin, 10);
	}
	
	public static void delayKickPlayer(Player p) {
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(!(list.contains(p)))return;
				p.kickPlayer("§a[VERIFICAÇÃO] §cVocê não clicou no bloco verde!");
			}
		}.runTaskLater(Main.plugin, 20*7);
		
	}
	
	@EventHandler
	public void click(InventoryClickEvent e) {
		
		Player p= (Player) e.getWhoClicked();
		
		if(list.contains(p)) {
		if(e.getInventory().getName().equals("Clique no bloco verde")) {
			if(e.getCurrentItem()== null)return;
			if(e.getCurrentItem().isSimilar(unlockBlock)) {
				
				list.remove(p);
				p.closeInventory();
				p.sendMessage("§a§lVERIFICADO! \n ");
				Eventos.playerjoinLogin(p);
				
			}
			e.setCancelled(true);
		}
		}
	}
	
	@EventHandler
	public void invClose(InventoryCloseEvent e) {
		Player p= (Player) e.getPlayer();
		
		if(list.contains(p)) {
		if(e.getInventory().getName().equals("Clique no bloco verde")) {
			new BukkitRunnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					p.openInventory(inv);
				}
			}.runTaskLater(Main.plugin, 5);
		}
		}
		
	}
	
}
