package kindofguilty.kindofblocky.block

import kindofguilty.kindofblocky.KindOfBlocky
import kindofguilty.kindofblocky.KindOfBlocky.MOD_ID
import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.ExperienceDroppingBlock
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier
import net.minecraft.util.math.intprovider.UniformIntProvider
import net.minecraft.world.gen.GenerationStep
import net.minecraft.world.gen.feature.PlacedFeature

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


        val SHULOMIUM_ORE_PLACED_KEY: RegistryKey<PlacedFeature> =
            RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MOD_ID, "shulomium_ore_gen"))

        private fun registerBlock(name: String, block: Block): Block {
            registerBlockItem(name, block)
            return Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, name), block)
        }

        private fun registerBlockItem(name: String, block: Block) {
            Registry.register(
                Registries.ITEM,
                Identifier.of(MOD_ID, name),
                BlockItem(block, Item.Settings())
            )
        }

        fun registerModBlocks() {
            KindOfBlocky.logger.info("Registering Mod Blocks for $MOD_ID")

            ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register { entries ->
                entries.add(SHULOMIUM_BLOCK)
            }
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register { entries ->
                entries.add(SHULOMIUM_ORE_BLOCK)
            }

            // add blocks to spawn in world
            BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                SHULOMIUM_ORE_PLACED_KEY
            )
        }
    }
}