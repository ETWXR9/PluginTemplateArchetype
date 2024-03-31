#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.Cmd;

import java.util.List;

import org.bukkit.entity.Player;

/*
 * subcommand base class
 */
public interface SubCmdBase {

    /**
     * Executes the given command, returning its success.
     * <br>
     * If false is returned, then the "usage" plugin.yml entry for this command
     * (if defined) will be sent to the player.
     *
     * @param sender Source of the command
     * @param args   Passed command arguments(不包括主命令)
     * @return true if a valid command, otherwise false
     */
    public boolean onSubCommand(Player p, String[] args);

    /**
     * Requests a list of possible completions for a command argument.
     *
     * @param sender Source of the command. For players tab-completing a
     *               command inside of a command block, this will be the player,
     *               not the command block.
     * @param args   The arguments passed to the command, including final
     *               partial argument to be completed(不包括主命令)
     * @return A List of possible completions for the final argument, or null
     *         to default to the command executor
     */
    public List<String> onTabComplete(Player p, String[] args);

}
