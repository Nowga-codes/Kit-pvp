package nowga.plugin.kitpvp;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.block.Dropper;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import nowga.plugin.kitpvp.cadastro.Eventos;
import nowga.plugin.kitpvp.combate.Combate;
import nowga.plugin.kitpvp.combate.Killstreak;
import nowga.plugin.kitpvp.conexao.MetodosWarps;
import nowga.plugin.kitpvp.eventos.AntiJoinBot;
import nowga.plugin.kitpvp.eventos.AntiRelog;
import nowga.plugin.kitpvp.killdeathsxp.KillsDeathsXP;
import nowga.plugin.kitpvp.kits.KITAPI;
import nowga.plugin.kitpvp.punir.BanAPI;
import nowga.plugin.kitpvp.warps.Warp1V1;
import nowga.plugin.kitpvp.warps.WarpAPI;

public class Geral extends BanAPI implements Listener {

	
	
	@EventHandler
	public void join(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		if(AntiRelog.relog.contains(p.getName())) {
			AntiRelog.onJoinRelog(e);
			return;
			}
		
		if(p.hasPotionEffect(PotionEffectType.JUMP)) {
			p.removePotionEffect(PotionEffectType.JUMP);
			}
		
		e.setJoinMessage(null);


		p.setGameMode(GameMode.SURVIVAL);
		
       AntiJoinBot.inventario(p);
		MetodosWarps.teleportWarpName(p, "spawn");
		p.getInventory().clear();
	
		if(Eventos.status == false) {
			Manager.HOTBARLOBBY(p);
		}
	
		if(!(MetodosWarps.containsWarp("spawn"))) {
		Bukkit.getConsoleSender().sendMessage("§c§lWARP spawn NÃO ESTA SETADA!");
	}

	}
		
 
	@EventHandler
	public void aoSair(PlayerQuitEvent e) {
		Player p= e.getPlayer();
		//Remover player to Tag
		if(AntiRelog.relog.contains(p.getName())) {
			e.setQuitMessage(null);
			return;
		}

		KITAPI.removeArena(p);
		KITAPI.removeKit(p);
		WarpAPI.removeWarps(p);
		if(p.hasPotionEffect(PotionEffectType.JUMP)) {
			p.removePotionEffect(PotionEffectType.JUMP);
			}
		
		AntiRelog.onQuitRelog(e);
		e.setQuitMessage(null);
		if(Combate.combate.containsKey(p)) {
		Combate.aoSair(e);
		}
		
	}
	
	
	@EventHandler
	public void death(PlayerDeathEvent e) {
		Player p= e.getEntity();
		
		if(Warp1V1.contador1v1.contains(p.getName())) {
		Warp1V1.death1v1(e);
		KITAPI.removeArena(p);
		KITAPI.removeKit(p);
		e.setDeathMessage(null);
		}else {
			KillsDeathsXP.aoMorrer(e);
        Killstreak.deathKillStreak(e);
		KITAPI.removeArena(p);
		KITAPI.removeKit(p);
		WarpAPI.removeWarps(p);
		}
		
		if(p.hasPotionEffect(PotionEffectType.JUMP)) {
			p.removePotionEffect(PotionEffectType.JUMP);
			}
		
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<Item> drops = new ArrayList();

		for (ItemStack dropItemStack : e.getDrops()) {
		  Item dropItem = p.getWorld().dropItemNaturally(p.getLocation(), dropItemStack);

		  drops.add(dropItem);
		}

		// Dentro do runnable
		e.getDrops().clear();
		  new BukkitRunnable() {
				
				
				@SuppressWarnings("deprecation")
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					
					for (Item itemDrop : drops) {
						  itemDrop.remove();
						  
						  for(Player pls:Bukkit.getOnlinePlayers()) {
							  if(pls.getLocation().distance(itemDrop.getLocation())<=10) {
					pls.playEffect(itemDrop.getLocation(), Effect.SMOKE, 1);	
							  }
					
						  }
					}
					p.spigot().respawn();
					
		
				}
			}.runTaskLater(Main.plugin, 20);
		
	}

	@EventHandler
	public void respawn(PlayerRespawnEvent e) {
		Player p= e.getPlayer();
		
		if(WarpAPI.contador1v1.contains(p.getName())) {
		Warp1V1.respawn1v1(e);
		return;
		}
		new BukkitRunnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				Manager.HOTBARLOBBY(p);
				
				if(Combate.combate.containsKey(p)) {
					Combate.combate.remove(p);
				}
				
				if(MetodosWarps.containsWarp("spawn")){
					MetodosWarps.teleportWarpName(p, "spawn");
					
				
					
				}else {
					p.sendMessage("§cO spawn não foi setado!");
				}
			}
		}.runTaskLater(Main.plugin, 1);
		
		
	}
	@EventHandler
	public void onmove(PlayerMoveEvent e) {
		Eventos.move(e);
	}
	@EventHandler 
	public void chatCommand(PlayerCommandPreprocessEvent e) {
		
		Player p= e.getPlayer();
		
		if(Eventos.unlogged.contains(p.getName())) {
		Eventos.commandUnlogged(e);
		
		return;
		}
		
		if(Combate.combate.containsKey(p)) {
		if(e.getMessage().contains("/")) {
			e.setCancelled(true);
			p.sendMessage(Combate.prefix+"§cVocê não pode usar comandos em combate!");
		}
		}
		
		//COMBATE
		//VERIFICAR SE O AGRESSOR É IGUAL AO QUE ESTA SALVO NA HASHMAP COMBATE, SE NÃO FOR ... SUBSTITUI O VALUE DA HASHMAP PELO AGRESSOR
		
		
	}
	
	@EventHandler
	public static void chuva(WeatherChangeEvent e) {
	 e.setCancelled(true);
	}

	
	//esse é o metodo que esta cancelando o drop
public void onRespawnMobs(EntitySpawnEvent e) {
	
	if(e.getEntity() instanceof Dropper)
	if(!(e.getEntity() instanceof Player|| e.getEntity() instanceof ArmorStand)) {
		e.setCancelled(true);
	}
}
}
