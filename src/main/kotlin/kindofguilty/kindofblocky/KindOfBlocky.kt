package kindofguilty.kindofblocky

import kindofguilty.kindofblocky.block.ModBlocks
import kindofguilty.kindofblocky.item.ModItemGroups
import kindofguilty.kindofblocky.item.ModItems
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object KindOfBlocky : ModInitializer {
    const val MOD_ID: String = "kindofblocky"
    val logger = LoggerFactory.getLogger(MOD_ID)


    override fun onInitialize() {
        ModItems.registerModItems()
        ModBlocks.registerModBlocks()
        ModItemGroups.registerItemGroups()
    }
}
