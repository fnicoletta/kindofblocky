package kindofguilty.kindofblocky.item

import net.minecraft.component.type.FoodComponent
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects

class ModFoodComponents {
    companion object {
        val BAGEL_WITH_LOX: FoodComponent =
            FoodComponent.Builder().nutrition(10).saturationModifier(0.25f)
                .statusEffect(StatusEffectInstance(StatusEffects.HEALTH_BOOST, 200), 0.15f).build()
    }
}