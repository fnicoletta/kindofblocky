package kindofguilty.kindofblocky.item.custom

import net.minecraft.item.SwordItem
import net.minecraft.item.ToolMaterials
import net.minecraft.item.Item

class BootyBlaster : SwordItem(
    ToolMaterials.NETHERITE,
    Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 30, -2.4F))
) {
}