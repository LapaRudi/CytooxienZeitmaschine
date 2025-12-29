package de.laparudi.timemachine;

import de.laparudi.timemachine.listener.ItemTooltipListener;
import de.laparudi.timemachine.listener.JoinListener;
import net.fabricmc.api.ClientModInitializer;

public class CytooxienTimeMachine implements ClientModInitializer {
	
	public static boolean CXN = false;
	
	@Override
	public void onInitializeClient() {
		ItemTooltipListener.register();
		JoinListener.register();
	}
}