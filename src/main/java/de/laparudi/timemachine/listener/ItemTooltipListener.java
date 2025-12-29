package de.laparudi.timemachine.listener;

import de.laparudi.timemachine.registry.LoreRegistry;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.CustomModelData;

public class ItemTooltipListener {

    public static void register() {
        ItemTooltipCallback.EVENT.register( (itemStack, context, flag, lines) -> {
            final CustomModelData data = itemStack.get(DataComponents.CUSTOM_MODEL_DATA);
            if (data == null || data.floats().isEmpty()) return;

            final int id = data.floats().getFirst().intValue();
            final Item item = itemStack.getItem();
            final Component lore = LoreRegistry.getLore(id, item);
            if (lore == null) return;
            
            lines.add(Component.empty());
            lines.add(lore);
            lines.add(Component.empty());
        });
    }
}
