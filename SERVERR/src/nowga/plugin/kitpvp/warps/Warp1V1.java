package nowga.plugin.kitpvp.warps;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import nowga.plugin.kitpvp.Main;
import nowga.plugin.kitpvp.Manager;
import nowga.plugin.kitpvp.comandos.Admin;
import nowga.plugin.kitpvp.conexao.MetodosMySql;
import nowga.plugin.kitpvp.conexao.MetodosWarps;

public class Warp1V1 extends WarpAPI implements Listener{

	static BukkitTask task;
	public static String prefix= "§6§l1V1: ";
	public static HashMap<Player, Player> convite= new HashMap<Player, Player>();
	public static HashMap<Player, Player> combate1v1= new HashMap<Player, Player>();

	@EventHandler
	public void interact(PlayerInteractEntityEvent e) {
		Player p1= e.getPlayer();
		
		if(contador1v1.contains(p1.getName())) {
		   if(p1.getItemInHand().getType()== Material.BLAZE_ROD) {
        if(combate1v1.containsKey(p1))return;
        if(!(e.getRightClicked()instanceof Entity))  return;
        
		
        Player p2= (Player) e.getRightClicked();
        
        	if(convite.get(p1)== p2) {	p1.sendMessage(prefix+"§cVocê ja desafiou este jogador"); return;}
        	
        	if(convite.get(p2)== p1) {
        		
        		if(Admin.adminMode.contains(p1)) {
        			
        			p1.sendMessage(prefix+" §cVocê não pode entrar no duelo em modo admin!");
        			return;
        		}
        		
        			p1.sendMessage(prefix+"§aVocê aceitou o Desafio de §7"+p2.getName());
        			p2.sendMessage(prefix+"§7"+p1.getName()+" §aaceitou seu desafio.");
        			convite.remove(p2);
        			startDuelo(p1, p2);
        			return;
        		}
        	
        	if(Admin.adminMode.contains(p1)) {
    			
    			p1.sendMessage(prefix+" §cVocê não pode desafiar em modo admin!");
    			return;
    		}
        delayRemovePedido(p1);
        	p1.sendMessage(prefix+"§7Você desafiou §a"+ p2.getDisplayName()+" §7para um duelo!");
        	p2.sendMessage(prefix+ "§a"+p1.getDisplayName()+" §7lhe desafiou para um duelo!");
        	
        	convite.put(p1, p2);
        }
		}
	}
        
		
			public static void startDuelo(Player p1, Player p2) {
				
			   MetodosWarps.teleportWarpName(p1, "1Spawn1v1");
			   MetodosWarps.teleportWarpName(p2, "2Spawn1v1");
				
				combate1v1.put(p1, p2);
				combate1v1.put(p2, p1);
				p1.getInventory().clear();
				p1.getInventory().setArmorContents(null);
				p1.setGameMode(GameMode.SURVIVAL);
				
				p2.getInventory().clear();
				p2.getInventory().setArmorContents(null);
				p2.setGameMode(GameMode.SURVIVAL);
				
				ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
				ItemMeta sopam = sopa.getItemMeta();
				sopam.setDisplayName("§cSOPINHA");
				sopa.setItemMeta(sopam);

				for(Player all: Bukkit.getOnlinePlayers()) {
					p1.hidePlayer(all);
					p2.hidePlayer(all);
					
					p1.showPlayer(p2);
					p2.showPlayer(p1);
				}
				
				
				for(int i= 1; i<=8; i++) {
					
				
					p1.getInventory().setItem(i, sopa);
					p2.getInventory().setItem(i, sopa);
					
				}
				p1.getInventory().setItem(0, Manager.createiItem(Material.STONE_SWORD, "§cEspada"));
				p2.getInventory().setItem(0, Manager.createiItem(Material.STONE_SWORD, "§cEspada"));
				
				
				
			}
	public static void death1v1(PlayerDeathEvent e) {
		
		Player p= e.getEntity();
		if(contador1v1.contains(p.getName())) {
		if(combate1v1.containsKey(p)) {
			
			Player oponente= combate1v1.get(p);
			
			if(MetodosWarps.containsWarp("1v1")){
			MetodosWarps.teleportWarpName(oponente, "1v1");
			WarpAPI.hotBar1v1(oponente);
			combate1v1.remove(oponente);
			MetodosMySql.addWins(oponente, 1);
			
			oponente.setHealth(p.getMaxHealth());
			
			oponente.sendMessage("");
			oponente.sendMessage(prefix+"§aVocê ganhou o duelo contra o jogador §7"+p.getName()+".");
			oponente.sendMessage("");
			
			for(Player all: Bukkit.getOnlinePlayers()) {
				if(!(Admin.adminMode.contains(all))) {
				p.showPlayer(all);
				oponente.showPlayer(all);
				}
			}
			
			
			}else {
				p.sendMessage("§cO spawn 1v1 não foi setado!");
			}
		}
		}
		
		
	}
	public static void respawn1v1(PlayerRespawnEvent e) {
		
		Player p= e.getPlayer();
		if(contador1v1.contains(p.getName())) {
		if(combate1v1.containsKey(p)) {

			
			new BukkitRunnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					if(MetodosWarps.containsWarp("1v1")){
						
						MetodosWarps.teleportWarpName(p, "1v1");
						WarpAPI.hotBar1v1(p);
						MetodosMySql.addLoses(p, 1);
						
						p.sendMessage("");
						p.sendMessage(prefix+"§aVocê perdeu o duelo contra o jogador §7"+combate1v1.get(p).getName()+".");
						p.sendMessage("");
						
						combate1v1.remove(p);
						
					}else {
						p.sendMessage("§cO spawn 1v1 não foi setado!");
					}
				}
			}.runTaskLater(Main.plugin,5);
			
			return;
		}
		}
		
		
	}
	public static void delayRemovePedido(Player p) {
		task = new BukkitRunnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				if(convite.get(p)== null) {
					task.cancel();
				return;
				}
				p.sendMessage(prefix+"§7"+convite.get(p).getName()+" §cNão aceitou seu convite para o duelo.");
				
				convite.remove(p);
			}
		}.runTaskLater(Main.plugin, 20*10);
	}
	

	@EventHandler 
	public void clickInfo(PlayerInteractEvent e) {
		Player p1= e.getPlayer();
		
		if(contador1v1.contains(p1.getName())) {
		if(e.getAction()== Action.RIGHT_CLICK_AIR|| e.getAction()== Action.RIGHT_CLICK_BLOCK) {
if(p1.getItemInHand().getType()==Material.SKULL_ITEM) {
			
			Inventory inv = Bukkit.createInventory(null, 1*9, "Informações");
			
			int partidasJogadas = MetodosMySql.getStatus(p1, "loses")+MetodosMySql.getStatus(p1, "wins");
			
			ItemStack info= new ItemStack(Material.SKULL_ITEM);
		    SkullMeta infom= (SkullMeta) info.getItemMeta();
			infom.setOwner(p1.getName());
			infom.setDisplayName("§eInformações");
			ArrayList<String> lore= new ArrayList<String>();
			lore.add("");
			lore.add(" §fJogador:§e "+p1.getName());
			lore.add("");
			lore.add(" §fWins:§e "+MetodosMySql.getStatus(p1, "wins"));
			lore.add(" §fLoses:§e "+MetodosMySql.getStatus(p1, "loses"));
			lore.add(" §fDuelos jogados:§e "+partidasJogadas);
			lore.add("");
			infom.setLore(lore);
			info.setItemMeta(infom);
			
			   ItemStack vidroLaranja = Manager.createitemID(160, 1, "");
			   ItemStack vidro = Manager.createitemID(160, 0, "");
			
			inv.setItem(0, vidroLaranja);
			inv.setItem(1, vidro);
			inv.setItem(2, vidro);

			inv.setItem(6, vidro);
			inv.setItem(7, vidro);
			inv.setItem(8, vidroLaranja);
			
			inv.setItem(4, info);
			
			p1.openInventory(inv);
		}
		}
		}
		
	}
	@EventHandler
	public void invClick(InventoryClickEvent e) {
		Player p= (Player) e.getWhoClicked();
		
		if(contador1v1.contains(p.getName())) {
		if(e.getInventory().getName().equalsIgnoreCase("Informações")) {
			e.setCancelled(true);
		}
		}
		
	}
	
}
