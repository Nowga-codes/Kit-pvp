package nowga.plugin.kitpvp.conexao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MotodosPunir extends Connect{
	
	
	public static boolean hasBanned(String uuid) {
		try {
			stm = connection.prepareStatement("SELECT * FROM `bans` WHERE `uuid` = ?");
			stm.setString(1, uuid);
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				return true;
			}
			
			return false;
		} catch (SQLException e) {
			return false;
		}
			
	}
	public static boolean hasBannedIP(String ip) {
		try {
			stm = connection.prepareStatement("SELECT * FROM `bansip` WHERE `ip` = ?");
			stm.setString(1, ip);
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				return true;
			}
			
			return false;
		} catch (SQLException e) {
			return false;
		}
			
	}
	
	
	public static String getDados(String uuid, String coluna) {
		if (hasBanned(uuid) == true) {
			try {
				
				//Com esse metodo da para pegar todos os dados do player só colocando o nome da coluna
				//por exemplo: coloque motivo na variavel coluna e ira pegar o motivo...
				stm = connection.prepareStatement("SELECT * FROM `bans` WHERE `uuid` = ?");
				stm.setString(1, uuid);
				ResultSet rs = stm.executeQuery();
				
				while (rs.next()) {
					return rs.getString(coluna);
				}
				
			} catch (SQLException e) {
				return "";
			}
			return "";
		}else {
			return "";
		}
	}
	public static String getDadosIP(String ip, String coluna) {
		if (hasBannedIP(ip) == true) {
			try {
				
				//Com esse metodo da para pegar todos os dados do player só colocando o nome da coluna
				//por exemplo: coloque motivo na variavel coluna e ira pegar o motivo...
				stm = connection.prepareStatement("SELECT * FROM `bansip` WHERE `ip` = ?");
				stm.setString(1, ip);
				ResultSet rs = stm.executeQuery();
				
				while (rs.next()) {
					return rs.getString(coluna);
				}
				
			} catch (SQLException e) {
				return "";
			}
			return "";
		}else {
			return "";
		}
	}
	
	
	public static void setBanned(String uuid, String name, String autor, String motivo, String prova) {
		if (hasBanned(uuid) == true) {
			return;
		}else {
			try {
				stm = connection.prepareStatement("INSERT INTO `bans` (`uuid` , `player` , `autor` , `motivo` , `prova` ) VALUES (?,?,?,?,?)");
				stm.setString(1, uuid);
				stm.setString(2, name);
				stm.setString(3, autor);
				stm.setString(4, motivo);
				stm.setString(5, prova);

				stm.execute();
				Bukkit.getConsoleSender().sendMessage("§6CRIADOO");
			} catch (SQLException e) {
				e.printStackTrace();
				Bukkit.getConsoleSender().sendMessage("§6NÂO CRIADOO");
			}
		}
	}
	public static void setBannedIP(String ip, String autor, String motivo, String prova) {
		if (hasBannedIP(ip) == true) {
			return;
		}else {
			try {
				stm = connection.prepareStatement("INSERT INTO `bansip` (`ip`, `autor` , `motivo` , `prova` ) VALUES (?,?,?,?)");
				stm.setString(1, ip);
				stm.setString(2, autor);
				stm.setString(3, motivo);
				stm.setString(4, prova);

				stm.execute();
				Bukkit.getConsoleSender().sendMessage("§6CRIADOO");
			} catch (SQLException e) {
				e.printStackTrace();
				Bukkit.getConsoleSender().sendMessage("§6NÂO CRIADOO");
			}
		}
	}
	

	 public static void Unban(String uuid) {
		 if (hasBanned(uuid) == true) {
		 try {
	        	stm= connection.prepareStatement("DELETE FROM `bans` WHERE `uuid`= '"+uuid+"';");
	        	stm.executeUpdate();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		 }
	 }
	 public static void UnbanIP(String ip) {
		 if (hasBannedIP(ip) == true) {
		 try {
	        	stm= connection.prepareStatement("DELETE FROM `bansip` WHERE `ip`= '"+ip+"';");
	        	stm.executeUpdate();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		 }
	 }
	
	
	public static void createTableBans() {
		if(connection == null) {
			Bukkit.getConsoleSender().sendMessage("§cNAO ABRIU TABLE");
			return;
		}
			try {
				stm= connection.prepareStatement("CREATE TABLE IF NOT EXISTS `bans`(`uuid`VARCHAR(50), `player` VARCHAR(25), `autor` VARCHAR(25) , `motivo` VARCHAR(25), `prova` VARCHAR(50))");
				stm.executeUpdate();
				Bukkit.getConsoleSender().sendMessage("§a A tabela Bans foi carregada com sucesso!");
			} catch (SQLException e) {
				e.printStackTrace();
				Bukkit.getConsoleSender().sendMessage("§7 Não foi possível criar a tabela!");
			}
		
	}
	public static void createTableBansIP() {
		if(connection == null) {
			Bukkit.getConsoleSender().sendMessage("§cNAO ABRIU TABLE");
			return;
		}
			try {
				stm= connection.prepareStatement("CREATE TABLE IF NOT EXISTS `bansip`(`ip`VARCHAR(25), `autor` VARCHAR(25) , `motivo` VARCHAR(25), `prova` VARCHAR(50))");
				stm.executeUpdate();
				Bukkit.getConsoleSender().sendMessage("§a A tabela BansIP foi carregada com sucesso!");
			} catch (SQLException e) {
				e.printStackTrace();
				Bukkit.getConsoleSender().sendMessage("§7 Não foi possível criar a tabela!");
			}
		
	}
	
}
