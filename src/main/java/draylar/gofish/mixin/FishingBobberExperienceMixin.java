package draylar.gofish.mixin;

import draylar.gofish.api.ExperienceBobber;
import net.minecraft.entity.projectile.FishingBobberEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

/**
 * This mixin is responsible for allowing Fishing Bobbers to have a customizable amount of base experience gain per catch.
 * For usage, cast a {@link FishingBobberEntity} to {@link ExperienceBobber}, and manipulate the base experience through the setter provided.
 */
@Mixin(FishingBobberEntity.class)
public abstract class FishingBobberExperienceMixin implements ExperienceBobber {

    @Unique
    private int gf_baseExperience = 1;

    @Override
    public int gf_getBaseExperience() {
        return gf_baseExperience;
    }

    @Override
    public void gf_setBaseExperience(int experience) {
        this.gf_baseExperience = experience;
    }

    @ModifyArg(
            method = "use",
            at = @At(value = "NEW", target = "net/minecraft/entity/ExperienceOrbEntity")
    )
    private int modifyExperience(int amount) {
        return amount - 1 + gf_baseExperience;
    }
}
