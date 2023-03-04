package de.justin.craftingempire.Listener;

import de.justin.craftingempire.util.MessageManager;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import java.util.ArrayList;

public class ChatListener implements Listener {
    @EventHandler
    public void chatEvent(AsyncChatEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("colorchat.color")) {
            TextComponent textComponent = (TextComponent) event.message();
            String message = textComponent.content();

            //Black
            if (message.contains("&0")) {
                message = message.replace("&0", "§0");
            }
            //Dark Blue
            if (message.contains("&1")) {
                message = message.replace("&1", "§1");
            }
            //Dark Green
            if (message.contains("&2")) {
                message = message.replace("&2", "§2");
            }
            //Dark Aqua
            if (message.contains("&3")) {
                message = message.replace("&3", "§3");
            }
            //Dark Red
            if (message.contains("&4")) {
                message = message.replace("&4", "§4");
            }
            //Dark Purple
            if (message.contains("&5")) {
                message = message.replace("&5", "§5");
            }
            //Gold
            if (message.contains("&6")) {
                message = message.replace("&6", "§6");
            }
            //Gray
            if (message.contains("&7")) {
                message = message.replace("&7", "§7");
            }
            //Dark Gray
            if (message.contains("&8")) {
                message = message.replace("&8", "§8");
            }
            //Blue
            if (message.contains("&9")) {
                message = message.replace("&9", "§9");
            }
            //Green
            if (message.contains("&a")) {
                message = message.replace("&a", "§a");
            }
            //Aqua
            if (message.contains("&b")) {
                message = message.replace("&b", "§b");
            }
            //Red
            if (message.contains("&c")) {
                message = message.replace("&c", "§c");
            }
            //Light Purple
            if (message.contains("&d")) {
                message = message.replace("&d", "§d");
            }
            //Yellow
            if (message.contains("&e")) {
                message = message.replace("&e", "§e");
            }
            //White
            if (message.contains("&f")) {
                message = message.replace("&f", "§f");
            }
            //Reset
            if (message.contains("&r")) {
                message = message.replace("&r", "§r");
            }

            //Format
            if (player.hasPermission("colorchat.format")) {
                //Obfuscated
                if (message.contains("&k")) {
                    message = message.replace("&k", "§k");
                }
                //Bold
                if (message.contains("&l")) {
                    message = message.replace("&l", "§l");
                }
                //Strikethrough
                if (message.contains("&m")) {
                    message = message.replace("&m", "§m");
                }
                //Underline
                if (message.contains("&n")) {
                    message = message.replace("&n", "§n");
                }
                //Italic
                if (message.contains("&o")) {
                    message = message.replace("&o", "§o");
                }
            }
            textComponent = textComponent.content(message);
            event.message(textComponent);
        }
    }

    @EventHandler
    public void SignEvent(SignChangeEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("colorchat.sign")) {
            ArrayList<Component> components = (ArrayList<Component>) event.lines();
            for (int i = 0; i < components.size(); i++) {
                TextComponent textComponent = (TextComponent) components.get(i);
                String message = textComponent.content();

                //Black
                if (message.contains("&0")) {
                    message = message.replace("&0", "§0");
                }
                //Dark Blue
                if (message.contains("&1")) {
                    message = message.replace("&1", "§1");
                }
                //Dark Green
                if (message.contains("&2")) {
                    message = message.replace("&2", "§2");
                }
                //Dark Aqua
                if (message.contains("&3")) {
                    message = message.replace("&3", "§3");
                }
                //Dark Red
                if (message.contains("&4")) {
                    message = message.replace("&4", "§4");
                }
                //Dark Purple
                if (message.contains("&5")) {
                    message = message.replace("&5", "§5");
                }
                //Gold
                if (message.contains("&6")) {
                    message = message.replace("&6", "§6");
                }
                //Gray
                if (message.contains("&7")) {
                    message = message.replace("&7", "§7");
                }
                //Dark Gray
                if (message.contains("&8")) {
                    message = message.replace("&8", "§8");
                }
                //Blue
                if (message.contains("&9")) {
                    message = message.replace("&9", "§9");
                }
                //Green
                if (message.contains("&a")) {
                    message = message.replace("&a", "§a");
                }
                //Aqua
                if (message.contains("&b")) {
                    message = message.replace("&b", "§b");
                }
                //Red
                if (message.contains("&c")) {
                    message = message.replace("&c", "§c");
                }
                //Light Purple
                if (message.contains("&d")) {
                    message = message.replace("&d", "§d");
                }
                //Yellow
                if (message.contains("&e")) {
                    message = message.replace("&e", "§e");
                }
                //White
                if (message.contains("&f")) {
                    message = message.replace("&f", "§f");
                }
                //Reset
                if (message.contains("&r")) {
                    message = message.replace("&r", "§r");
                }

                //Format
                    //Obfuscated
                    if (message.contains("&k")) {
                        message = message.replace("&k", "§k");
                    }
                    //Bold
                    if (message.contains("&l")) {
                        message = message.replace("&l", "§l");
                    }
                    //Strikethrough
                    if (message.contains("&m")) {
                        message = message.replace("&m", "§m");
                    }
                    //Underline
                    if (message.contains("&n")) {
                        message = message.replace("&n", "§n");
                    }
                    //Italic
                    if (message.contains("&o")) {
                        message = message.replace("&o", "§o");
                    }
                textComponent = textComponent.content(message);
                event.line(i, textComponent);
            }
        }
    }
}
