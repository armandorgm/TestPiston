package com.hotmail.susana_0901.testpiston;

//import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;









import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
//import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class TestPiston extends JavaPlugin {
	
	
	
	
	
	
	/*@Override
	    public void onEnable() {
	        // TODO Insert logic to be performed when the plugin is enabled
		 getLogger().info("TestPiston Funciona!!!");
	    }*/
	
	public Logger log;
	public TestPistonListener spl;
	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		spl.isEnabled = false;
		log.info("[VSP] Pistons are no longer very sticky.");
	}
//----------------------------

//------------------------------------
	Player player;  
	// Map<KeyType, DataType> HashMapName = new HashMap<>(); //Example syntax
	 
	// Example Declaration
	Map<String, Boolean> pluginEnabled = new HashMap<>();
	Map<String, Boolean> isGodMode = new HashMap<>();
	
	public void togglePluginState(Player player) {
	    // Notice how we use the player name as the key here,
	    // not the player object
	    String playerName = player.getName();
	    if (pluginEnabled.containsKey(playerName)) {
	        if (pluginEnabled.get(playerName)) {
	            pluginEnabled.put(playerName, false);
	            player.sendMessage("Plugin disabled");
	        } else {
	            pluginEnabled.put(playerName, true);
	            player.sendMessage("Plugin enabled");
	        }
	    } else {
	        pluginEnabled.put(playerName, true); //If you want plugin disabled by default change this value to false.
	        player.sendMessage("Plugin enabled");
	    }
	}
	@Override
public	boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		player = (Player) sender;
		togglePluginState(player);
		return true;
	
		
		
		/*if (cmd.getName().equalsIgnoreCase("basic")) { // If the player typed /basic then do the following...
			// do something..
			sender.sendMessage("A LA MIERDA1");
			return true;
		} else if (cmd.getName().equalsIgnoreCase("basic2")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("This command can only be run by a player.");
				sender.sendMessage("A LA MIERDA2");
			} else {
				Player player = (Player) sender;
				// do something
				sender.sendMessage("A LA MIERDA3");
			}
			return true;
		}sender.sendMessage("A LA MIERDA4");
		return false;*/
	}	
//------------------------------
	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		log = Logger.getLogger("Minecraft");
		PluginManager pm = this.getServer().getPluginManager();
		spl = new TestPistonListener(this);
		spl.isEnabled = true;
		pm.registerEvents(spl, this);
		log.info("[VSP] Pistons are now very sticky.");
		//----------------------------------------------------------------
		
		this.getConfig();
		this.saveDefaultConfig();
		

		
		
		
		
		//----------------------------------------------------------------
		getConfig().set("path","c:/hola/");//sets "path" in config as property
		log.info((String) getConfig().get("path"));
		//saveConfig();//saves the config, and should be used after every time you change it
	}
	
	

}
