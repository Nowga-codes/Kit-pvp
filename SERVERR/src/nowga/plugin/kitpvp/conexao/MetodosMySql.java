package nowga.plugin.kitpvp.conexao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class MetodosMySql extends Connect{
	public static boolean containsPlayers(Player p) {
		try {
			stm = connection.prepareStatement("SELECT * FROM `jogadores` WHERE `player` = ?");
			stm.setString(1, p.getName());
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				return true;
			}
			
			return false;
		} catch (SQLException e) {
			return false;
		}
			
	}
	public static boolean containsPlayerOFF(OfflinePlayer p) {
		try {
			stm = connection.prepareStatement("SELECT * FROM `jogadores` WHERE `player` = ?");
			stm.setString(1, p.getName());
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				return true;
			}
			
			return false;
		} catch (SQLException e) {
			return false;
		}
			
	}
	
	
	public static void playerJoinEventMySql(Player p) {
		if (containsPlayers(p) == true) {
			return;
	
		}else {
			try {
				stm = connection.prepareStatement("INSERT INTO `jogadores`(`player`,`kills`,`deaths`,`coins`,`xp`, `ip`, `wins`, `loses`) VALUES (?,?,?,?,?,?,?,?)");
				stm.setString(1, p.getName());
				stm.setInt(2, 0);
				stm.setInt(3, 0);
				stm.setInt(4, 0);
				stm.setInt(5, 0);
				stm.setString(6, p.getAddress().getHostString());
				stm.setInt(7, 0);
				stm.setInt(8, 0);
				stm.executeUpdate();
				Bukkit.getConsoleSender().sendMessage("§6CRIADOO");
			} catch (SQLException e) {
				e.printStackTrace();
				Bukkit.getConsoleSender().sendMessage("§6NÂO CRIADOO");
			}
		}
	}
	
	//KILLS
	
	
	public static void setCoins(Player p, int valor) {
		if (containsPlayers(p) == true) {
			try {
				stm = connection.prepareStatement("UPDATE `jogadores` SET `coins` = ? WHERE `player` = ?");
				stm.setInt(1, valor);
				stm.setString(2, p.getName());
				stm.executeUpdate();
			} catch (SQLException e) {
		}
		}else {
			return;
		}
	}
	public static void setXP(Player p, int valor) {
		if (containsPlayers(p) == true) {
			try {
				stm = connection.prepareStatement("UPDATE `jogadores` SET `xp` = ? WHERE `player` = ?");
				stm.setInt(1, valor);
				stm.setString(2, p.getName());
				stm.executeUpdate();
			} catch (SQLException e) {
		}
		}else {
			return;
		}
	}
	
	public static void addKills(Player p, int kills) {
		if (containsPlayers(p) == true) {
			try {
				int killsAntes= getStatus(p, "kills");
				int killsDepois= killsAntes+kills;
				stm = connection.prepareStatement("UPDATE `jogadores` SET `kills` = ? WHERE `player` = ?");
				stm.setInt(1, killsDepois);
				stm.setString(2, p.getName());
				stm.executeUpdate();
			} catch (SQLException e) {
		}
		}else {
			return;
		}
	}
	public static void addDeaths(Player p,int deaths) {
		if (containsPlayers(p) == true) {
			try {
				int MortesAntes= getStatus(p, "deaths");
				int MortesDepois= MortesAntes+deaths;
				stm = connection.prepareStatement("UPDATE `jogadores` SET `deaths` = ? WHERE `player` = ?");
				stm.setInt(1, MortesDepois);
				stm.setString(2, p.getName());
				stm.executeUpdate();
			} catch (SQLException e) {
		}
		}else {
			return;
		}
	}
	public static void addCoins(Player p,int coins) {
		if (containsPlayers(p) == true) {
			try {
				int coinsAntes= getStatus(p, "coins");
				int coinsDepois= coinsAntes+coins;
				stm = connection.prepareStatement("UPDATE `jogadores` SET `coins` = ? WHERE `player` = ?");
				stm.setInt(1, coinsDepois);
				stm.setString(2, p.getName());
				stm.executeUpdate();
			} catch (SQLException e) {
		}
		}else {
			return;
		}
	}
	public static void addXP(Player p, int xp) {
		if (containsPlayers(p) == true) {
			try {
				int xpAntes= getStatus(p, "xp");
				int xpDepois= xpAntes+xp;
				stm = connection.prepareStatement("UPDATE `jogadores` SET `xp` = ? WHERE `player` = ?");
				stm.setInt(1, xpDepois);
				stm.setString(2, p.getName());
				stm.executeUpdate();
			} catch (SQLException e) {
		}
		}else {
			return;
		}
	}
	public static void addWins(Player p, int wins) {
		if (containsPlayers(p) == true) {
			try {
				int winsAntes= getStatus(p, "wins");
				int winsDepois= winsAntes+wins;
				stm = connection.prepareStatement("UPDATE `jogadores` SET `wins` = ? WHERE `player` = ?");
				stm.setInt(1, winsDepois);
				stm.setString(2, p.getName());
				stm.executeUpdate();
			} catch (SQLException e) {
		}
		}else {
			return;
		}
	}
	public static void addLoses(Player p, int loses) {
		if (containsPlayers(p) == true) {
			try {
				int loseAntes= getStatus(p, "loses");
				int loseDepois= loseAntes+loses;
				stm = connection.prepareStatement("UPDATE `jogadores` SET `loses` = ? WHERE `player` = ?");
				stm.setInt(1, loseDepois);
				stm.setString(2, p.getName());
				stm.executeUpdate();
			} catch (SQLException e) {
		}
		}else {
			return;
		}
	}
	public static void removeCoins(Player p,int coins) {
		if (containsPlayers(p) == true) {
			try {
				int coinsAntes= getStatus(p, "coins");
				int coinsDepois= coinsAntes-coins;
				stm = connection.prepareStatement("UPDATE `jogadores` SET `coins` = ? WHERE `player` = ?");
				stm.setInt(1, coinsDepois);
				stm.setString(2, p.getName());
				stm.executeUpdate();
			} catch (SQLException e) {
		}
		}else {
			return;
		}
	}
	public static void removeXP(Player p, int xp) {
		if (containsPlayers(p) == true) {
			try {
				int xpAntes= getStatus(p, "xp");
				int xpDepois= xpAntes-xp;
				stm = connection.prepareStatement("UPDATE `jogadores` SET `xp` = ? WHERE `player` = ?");
				stm.setInt(1, xpDepois);
				stm.setString(2, p.getName());
				stm.executeUpdate();
			} catch (SQLException e) {
		}
		}else {
			return;
		}
	}
	public static int getStatus(Player p, String statusName) {
		if (containsPlayers(p) == true) {
			try {
				stm = connection.prepareStatement("SELECT * FROM `jogadores` WHERE `player` = ?");
				stm.setString(1, p.getName());
				ResultSet rs = stm.executeQuery();
				
				while (rs.next()) {
					
					return rs.getInt(statusName);
				}
				
			} catch (SQLException e) {
				return 0;
			}
			return 0;
		}else {
			return 0;
		}
	}
	public static String getIP(Player p) {
		if (containsPlayers(p) == true) {
			try {
				stm = connection.prepareStatement("SELECT * FROM `jogadores` WHERE `player` = ?");
				stm.setString(1, p.getName());
				ResultSet rs = stm.executeQuery();
				
				while (rs.next()) {
					return rs.getString("ip");
				}
				
			} catch (SQLException e) {
				return "";
			}
			return "";
		}else {
			return "";
		}
	}
	public static String getIPOff(OfflinePlayer p) {
			try {
				stm = connection.prepareStatement("SELECT * FROM `jogadores` WHERE `player` = ?");
				stm.setString(1, p.getName());
				ResultSet rs = stm.executeQuery();
				
				while (rs.next()) {
					return rs.getString("ip");
				}
				
			} catch (SQLException e) {
				return "";
			}
			return "";
		
	}
	
	//-----------------------------------------------------
	
	//Deaths
	public static int getDeaths(Player p) {
		if (containsPlayers(p) == true) {
			try {
				stm = connection.prepareStatement("SELECT * FROM `jogadores` WHERE `player` = ?");
				stm.setString(1, p.getName());
				ResultSet rs = stm.executeQuery();
				
				while (rs.next()) {
					return rs.getInt("deaths");
				}
				
			} catch (SQLException e) {
				return 0;
			}
			return 0;
		}else {
			return 0;
		}
	}
	
	
	
}
