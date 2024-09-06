package kindofguilty.kindofblocky.item

import kindofguilty.kindofblocky.KindOfBlocky
import kindofguilty.kindofblocky.block.ModBlocks
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text
import net.minecraft.util.Identifier

class ModItemGroups {
    companion object {
        val SHULOMIUM_ITEMS_GROUP: ItemGroup =
            Registry.register(
                Registries.ITEM_GROUP, Identifier.of(KindOfBlocky.MOD_ID, "shulomium_items"),
                FabricItemGroup.builder().icon { ItemStack(ModItems.SHULOMIUM) }
                    .displayName(Text.translatable("itemgroup.kindofblocky.shulomium_items"))
                    .entries { displayContent, entries ->
                        entries.add(ModItems.SHULOMIUM)
                        entries.add(ModItems.SHULOMIUM_ORE)
                        entries.add(ModItems.BOOTY_BLASTER)
                        entries.add(ModItems.BAGEL_WITH_LOX)
                    }
                    .build()
            )

        val SHULOMIUM_BLOCKS_GROUP: ItemGroup =
            Registry.register(
                Registries.ITEM_GROUP, Identifier.of(KindOfBlocky.MOD_ID, "shulomium_blocks"),
                FabricItemGroup.builder().icon { ItemStack(ModBlocks.SHULOMIUM_BLOCK) }
                    .displayName(Text.translatable("itemgroup.kindofblocky.shulomium_blocks"))
                    .entries { displayContent, entries ->
                        entries.add(ModBlocks.SHULOMIUM_BLOCK)
                        entries.add(ModBlocks.SHULOMIUM_ORE_BLOCK)
                        entries.add(ModBlocks.DEEPSLATE_SHULOMIUM_ORE_BLOCK)
                    }
                    .build()
            )


        fun registerItemGroups() {
            KindOfBlocky.logger.info("Registering Item Groups for " + KindOfBlocky.MOD_ID)
        }
    }
}