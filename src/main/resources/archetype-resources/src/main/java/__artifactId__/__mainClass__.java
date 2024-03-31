#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId};

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import ${package}.${artifactId}.Cmd.CmdManager;
import ${package}.${artifactId}.Listener.SampleListener;

/**
 * Hello world!
 *
 */
public class ${mainClass} extends JavaPlugin {

    private static ${mainClass} instance;

    private FileConfiguration config;

    public static ${mainClass} getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("Starting up ${mainClass}...");

        // read config
        saveDefaultConfig();
        config = getConfig();
        config.getString("SampleConfig");

        // register command
        getCommand("${mainClass}").setExecutor(new CmdManager());

        // register listener
        Bukkit.getPluginManager().registerEvents(new SampleListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Goodbye, World!");
    }
}
