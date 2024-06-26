#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId};

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import ${package}.${artifactId}.Cmd.CmdManager;
import ${package}.${artifactId}.Cmd.CmdSample;
import ${package}.${artifactId}.Listener.SampleListener;

public class ${mainClass} extends JavaPlugin {

    private static ${mainClass} instance;

    private FileConfiguration config;

    public static ${mainClass} getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("Starting up ${artifactId}...");

        // read config
        saveDefaultConfig();
        config = getConfig();
        config.getString("SampleConfig");

        // register command
        getCommand("${artifactId}").setExecutor(new CmdManager());
        // register subcommand
        CmdManager.registerSubCommand("sample", new CmdSample());

        // register listener
        Bukkit.getPluginManager().registerEvents(new SampleListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Shutting down ${artifactId}...");
    }
}
