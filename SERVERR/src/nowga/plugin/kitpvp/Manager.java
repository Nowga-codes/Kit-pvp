package nowga.plugin.kitpvp;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import nowga.plugin.kitpvp.conexao.MetodosWarps;

public class Manager {
	
	public static ItemStack kits = new ItemStack(Material.CHEST);
	public static ItemStack loja = new ItemStack(Material.EMERALD);
	public static ItemStack warp = new ItemStack(Material.PAPER);
	
	public static void playSoundXp(Player p) {
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
	}
	public static ItemStack createiItem(Material i, String name) {
		
		ItemStack item= new ItemStack(i);
		ItemMeta itemm= item.getItemMeta();
		itemm.setDisplayName(name);
		item.setItemMeta(itemm);
		
		return item;
		
	}
public static ItemStack createiItem(Material i, int quantidade, String name) {
		
		ItemStack item= new ItemStack(i,quantidade);
		ItemMeta itemm= item.getItemMeta();
		itemm.setDisplayName(name);
		item.setItemMeta(itemm);
		
		return item;
		
	}
public static ItemStack createiItemEnchantment(Material i, String name, Enchantment encantamento, int level) {
		
		ItemStack item= new ItemStack(i,1);
		ItemMeta itemm= item.getItemMeta();
		itemm.setDisplayName(name);
		itemm.addEnchant(encantamento, level, true);
		item.setItemMeta(itemm);
		
		return item;
	}
	
	public static ItemStack createitemID(int id, int idshort, String name) {

		@SuppressWarnings("deprecation")
		ItemStack i= new ItemStack(id, 1,(short) idshort);
		ItemMeta imeta= i.getItemMeta();
		imeta.setDisplayName(name);
		i.setItemMeta(imeta);
		
		return i;
	}
	public static void teleportArena(Player p){
	
		p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1);
		
		Random r= new Random();
		int a= r.nextInt(4);

		
		if(a== 0) {
		MetodosWarps.teleportWarpName(p, "arena1");
		}
		if(a== 1) {
			MetodosWarps.teleportWarpName(p, "arena2");
			}
           if(a== 2) {
			MetodosWarps.teleportWarpName(p, "arena3");
			}
           if(a== 3) {
			MetodosWarps.teleportWarpName(p, "arena4");
			}
           if(a== 4) {
			MetodosWarps.teleportWarpName(p, "arena5");
			}
	}
	
	public static void HOTBARLOBBY(Player p) {

		p.getInventory().clear();

		ItemMeta kitsm = kits.getItemMeta();
		kitsm.setDisplayName("§6Kits");
		kits.setItemMeta(kitsm);

		ItemMeta lojam = loja.getItemMeta();
		lojam.setDisplayName("§aLoja");
		loja.setItemMeta(lojam);

		ItemMeta warpm = warp.getItemMeta();
		warpm.setDisplayName("§aWarps");
		warp.setItemMeta(warpm);

		p.getInventory().setItem(2, warp);
		p.getInventory().setItem(4, kits);
		p.getInventory().setItem(6, loja);

	}

	public static void diaEterno() {
		
				Bukkit.getWorld("world").setTime(6000);

	}

	public static void sopas(Player p) {


		 ItemStack sopa= Manager.createiItem(Material.MUSHROOM_SOUP, "§cSopinha");
		 ItemStack cogumeloMarrom= Manager.createiItem(Material.BROWN_MUSHROOM,64, "§6Cogumelo marrom");
			ItemStack cogumeloVermelho= Manager.createiItem(Material.RED_MUSHROOM,64, "§cCogumelo vermelho");
					ItemStack Pote= Manager.createiItem(Material.BOWL,64, "§7Pote");
		
		p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
		p.removePotionEffect(PotionEffectType.WATER_BREATHING);
		p.removePotionEffect(PotionEffectType.SPEED);
		p.removePotionEffect(PotionEffectType.JUMP);
		
		p.getInventory().setArmorContents(null);
		p.setGameMode(GameMode.SURVIVAL);
		p.setAllowFlight(false);
		
		for (int i = 0; i < 36; i++) {

			p.getInventory().setItem(i, sopa);
			p.getInventory().setArmorContents(null);
			p.setHealth(p.getMaxHealth());

		}
		p.getInventory().setItem(13, cogumeloMarrom);
		p.getInventory().setItem(14, cogumeloVermelho);
		p.getInventory().setItem(15, Pote);

	}
	public static void anuncios() {
		
		ArrayList<String> msgs= new ArrayList<String>();
		
		msgs.add("§c§lAVISO:"+"§7 Quer se tornar youtuber do server? Digite /youtuber ou /yt");
		msgs.add("§c§lAVISO:"+"§7 Para ter acesso aos formularios digite: /aplicar");
		msgs.add("§c§lAVISO:"+"§7 Entre no nosso discord para ter informações exclusivas: https://discord.gg/jJTH2cP");
		msgs.add("§c§lAVISO:"+"§7 Servidor esta em fase beta.");
		msgs.add("§c§lAVISO:"+"§7 Jogadores Vip tem desconto nos kits da loja.");
		msgs.add("§c§lAVISO:"+"§7 Visite a loja do nosso servidor: http://bit.ly/thundermc");
		msgs.add("§c§lAVISO:"+" §f§lConscientização§7: Evitem tocar o próprio rosto, pois as principais formas de contrair o Corona virus "
				+ "é quando se toca na boca, nariz ou olhos.");
		
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Random r= new Random();
				int number= r.nextInt(7);
				
				

				
				for(Player p: Bukkit.getOnlinePlayers()) {
					p.sendMessage(msgs.get(number));
				}
				
			}
		}.runTaskTimerAsynchronously(Main.plugin, 0, 20*60);
	}

}
