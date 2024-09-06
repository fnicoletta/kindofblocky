package kindofguilty.kindofblocky.block

import kindofguilty.kindofblocky.KindOfBlocky
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.ExperienceDroppingBlock
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier
import net.minecraft.util.math.intprovider.UniformIntProvider

class ModBlocks {
    companion object {
        val SHULOMIUM_BLOCK: Block = registerBlock(
            "shulomium_block", Block(
                AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(
                    BlockSoundGroup.AMETHYST_BLOCK
                )
            )
        )

        val SHULOMIUM_ORE_BLOCK: Block = registerBlock(
            "shulomium_ore_block", ExperienceDroppingBlock(
                UniformIntProvider.create(2, 5), AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(
                    BlockSoundGroup.DEEPSLATE
                )
            )
        )

        val DEEPSLATE_SHULOMIUM_ORE_BLOCK: Block = registerBlock(
            "deepslate_shulomium_ore_block", ExperienceDroppingBlock(
                UniformIntProvider.create(3, 6), AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(
                    BlockSoundGroup.DEEPSLATE
                )
            )
        )

        private fun registerBlock(name: String, block: Block): Block {
            registerBlockItem(name, block)
            return Registry.register(Registries.BLOCK, Identifier.of(KindOfBlocky.MOD_ID, name), block)
        }

        private fun registerBlockItem(name: String, block: Block): Unit {
            Registry.register(
                Registries.ITEM,
                Identifier.of(KindOfBlocky.MOD_ID, name),
                BlockItem(block, Item.Settings())
            );
        };

        fun registerModBlocks(): Unit {
            KindOfBlocky.logger.info("Registering Mod Blocks for " + KindOfBlocky.MOD_ID);

            ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register { entries ->
                entries.add(SHULOMIUM_BLOCK)
            };
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register { entries ->
                entries.add(SHULOMIUM_ORE_BLOCK)
            };
        }
    }
}