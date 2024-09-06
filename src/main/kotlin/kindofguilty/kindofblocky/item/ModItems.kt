package kindofguilty.kindofblocky.item

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import kindofguilty.kindofblocky.KindOfBlocky
import kindofguilty.kindofblocky.item.custom.BootyBlaster
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

class ModItems {
    companion object {
        val SHULOMIUM_ORE: Item = registerItem("shulomium_ore", Item(Item.Settings()));
        val SHULOMIUM: Item = registerItem("shulomium", Item(Item.Settings()));
        val BAGEL_WITH_LOX: Item =
            registerItem("bagel_with_lox", Item(Item.Settings().food(ModFoodComponents.BAGEL_WITH_LOX)));

        val BOOTY_BLASTER: Item = registerItem("booty_blaster", BootyBlaster());


        private fun registerItem(name: String, item: Item): Item {
            return Registry.register(Registries.ITEM, Identifier.of(KindOfBlocky.MOD_ID, name), item);
        };

        fun registerModItems(): Unit {
            KindOfBlocky.logger.info("Registering Items for " + KindOfBlocky.MOD_ID);


            ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register { entries ->
                entries.add(SHULOMIUM_ORE)
                entries.add(SHULOMIUM)
            };
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register { entries ->
                entries.add(BOOTY_BLASTER)
            };
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register { entries ->
                entries.add(BAGEL_WITH_LOX)
            };
        }
    }
}