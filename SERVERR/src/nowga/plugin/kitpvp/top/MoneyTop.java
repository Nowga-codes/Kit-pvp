package nowga.plugin.kitpvp.top;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.scheduler.BukkitRunnable;

import nowga.plugin.kitpvp.Main;

import nowga.plugin.kitpvp.conexao.Connect;
import nowga.plugin.kitpvp.conexao.MetodosWarps;

public class MoneyTop extends Connect {

	
	public static void timerTOPS() {
		
Location locTopKILLS= new Location(Bukkit.getWorld("world"), MetodosWarps.getWarpXYZ("topkills", "x"), MetodosWarps.getWarpXYZ("topkills", "y"), MetodosWarps.getWarpXYZ("topkills", "z"));
Location locTopCoins= new Location(Bukkit.getWorld("world"), MetodosWarps.getWarpXYZ("topcoins", "x"), MetodosWarps.getWarpXYZ("topcoins", "y"), MetodosWarps.getWarpXYZ("topcoins", "z"));
Location locTop1v1= new Location(Bukkit.getWorld("world"), MetodosWarps.getWarpXYZ("top1v1", "x"), MetodosWarps.getWarpXYZ("top1v1", "y"), MetodosWarps.getWarpXYZ("top1v1", "z")); 

Location misteryBox= new Location(Bukkit.getWorld("world"), MetodosWarps.getWarpXYZ("misteryBox", "x"), MetodosWarps.getWarpXYZ("misteryBox", "y"), MetodosWarps.getWarpXYZ("misteryBox", "z")); 
 
for(Entity as: Bukkit.getWorld("world").getEntities()) {
	if(as instanceof ArmorStand) {
		
		as.remove();
	
	}
}
	
	new BukkitRunnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			new BukkitRunnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					for(Entity as: Bukkit.getWorld("world").getEntities()) {
						if(as instanceof ArmorStand) {
							
							as.remove();
						
						}
					}
					//TOPS
				
					if(MetodosWarps.containsWarp("topkills")) {
					     getTop(locTopKILLS,"Kills");
						Bukkit.getConsoleSender().sendMessage(" \n §A§lTOP KILLS ATUALIZADO COM SUCESSO! \n ");	
					}else {
						Bukkit.getConsoleSender().sendMessage(" \n §c§lO TOP KILLS NAO PODE SER CARREGADO, POIS A WARP topkills NAO ESTA SETADA! \n ");
					}
					if(MetodosWarps.containsWarp("topcoins")) {
					     getTop(locTopCoins,"Coins");
						Bukkit.getConsoleSender().sendMessage(" \n §A§lTOP COINS ATUALIZADO COM SUCESSO! \n ");	
					}else {
						Bukkit.getConsoleSender().sendMessage(" \n §c§lO TOP COINS NAO PODE SER CARREGADO, POIS A WARP topkills NAO ESTA SETADA! \n ");
					}
					if(MetodosWarps.containsWarp("top1v1")) {
					     getTop(locTop1v1,"wins");
						Bukkit.getConsoleSender().sendMessage(" \n §A§lTOP 1v1 ATUALIZADO COM SUCESSO! \n ");	
					}else {
						Bukkit.getConsoleSender().sendMessage(" \n §c§lO TOP 1v1 NAO PODE SER CARREGADO, POIS A WARP top1v1 NAO ESTA SETADA! \n ");
					}
					
					
					
					//Caixa misteriosa
					
					if(MetodosWarps.containsWarp("misteryBox")) {
						
					  Spawn(misteryBox, "§a§lCAIXA MISTERIOSA",misteryBox.getY()-1.7);
					  Spawn(misteryBox, "§e§lEM BREVE!",misteryBox.getY()-2);
						Bukkit.getConsoleSender().sendMessage(" \n §A§lMYSTERYBOX ATUALIZADO COM SUCESSO! \n ");	
					}else {
						Bukkit.getConsoleSender().sendMessage(" \n §c§lO TOP COINS NAO PODE SER CARREGADO, POIS A WARP misteryBox NAO ESTA SETADA! \n ");
					}
				}
			}.runTaskLater(Main.plugin, 20);
			
		}
	}.runTaskTimerAsynchronously(Main.plugin,0, 20*600);
	}
	
	
public static ArrayList<String>getTop(Location loc,String top){
	if(connection !=null) {
      try {
		stm=connection.prepareStatement("SELECT * FROM `jogadores` ORDER BY `"+top+"` DESC limit 10");
		ArrayList<String>  tops= new ArrayList<String>();
		ResultSet result= stm.executeQuery();
		double altura= loc.getY()+1.5;
		int posicao= 0;
		

		
		Spawn(loc, "§6§l"+top.toUpperCase()+" TOP", altura);
		
		while (result.next()) {
          tops.add(result.getString(top));
          String coins=result.getString(top);
          String player=result.getString("player");

      
          altura= altura-0.3;
          
          posicao++;
          Spawn(loc, "§a"+posicao+"º §e"+player+" §f- §a"+coins+" "+top, altura);
		}
		result.close();
		stm.close();
		return tops;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}	

      
	}
	return null;

}
	
	
	public static void Spawn(Location loc, String title, double altura) {
	
		Location Ploc = new Location(Bukkit.getWorld("world"), loc.getX(), altura, loc.getZ());
        ArmorStand as = (ArmorStand) loc.getWorld().spawnEntity(Ploc, EntityType.ARMOR_STAND);

        as.setGravity(false);
        as.setCanPickupItems(false);
        as.setCustomName(title);
        as.setCustomNameVisible(true);
        as.setVisible(false);

        
       
	}
	
}
