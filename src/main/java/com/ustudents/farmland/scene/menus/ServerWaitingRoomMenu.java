package com.ustudents.farmland.scene.menus;

import com.ustudents.engine.Game;
import com.ustudents.engine.core.cli.print.Out;
import com.ustudents.engine.core.event.EventListener;
import com.ustudents.engine.core.json.Json;
import com.ustudents.engine.network.Client;
import com.ustudents.engine.network.ClientUpdatorThread;
import com.ustudents.farmland.Farmland;
import com.ustudents.farmland.core.SaveGame;
import com.ustudents.farmland.scene.InGameScene;

import java.util.Map;

@SuppressWarnings("unchecked")
public class ServerWaitingRoomMenu extends MenuScene {
    @Override
    public void initialize() {
        boolean localServerExists;

        Map<String, Object> json = Client.commandExists();
        localServerExists = json != null;

        int capacity = ((Long)json.get("capacity")).intValue();
        int connectedPlayers = ((Long)json.get("connectedSize")).intValue();

        int i = 0;
        String[] buttonNames = new String[capacity - connectedPlayers];
        String[] buttonIds = new String[capacity - connectedPlayers];

        int j = 0;
        for (i = 0; i < capacity; i++) {
            if (!((Map<String,Object>)json.get("connected")).containsKey(String.valueOf(i))) {
                buttonNames[j] = "Joueur " + (i + 1);
                buttonIds[j] = (i + 1) + "Button";
                j++;
            }
        }

        EventListener[] eventListeners = new EventListener[buttonNames.length];

        for (i = 0; i < buttonNames.length; i++) {
            int k = i;
            eventListeners[i] = (dataType, data) -> {
                if (Character.isDigit(buttonIds[k].charAt(0))) {
                    int player = Integer.parseInt(String.valueOf(buttonIds[k].charAt(0))) - 1;

                    if (Client.commandPlayerExists(player)) {
                        Client.playerId = player;
                        changeScene(new ServerWaitingPlayersMenu());
                    } else {
                        changeScene(new ServerNewPlayerMenu(player));
                    }
                }
            };
        }

        initializeMenu(buttonNames, buttonIds, eventListeners, true, false, false, true);

        super.initialize();
    }
}
