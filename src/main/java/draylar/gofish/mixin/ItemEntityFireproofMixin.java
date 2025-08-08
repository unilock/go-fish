package draylar.gofish.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import draylar.gofish.api.FireproofEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ItemEntity.class)
public abstract class ItemEntityFireproofMixin extends Entity implements FireproofEntity {

    @Unique
    private boolean fireImmune = false;

    public ItemEntityFireproofMixin(EntityType<?> type, World world) {
        super(type, world);
    }


    @ModifyReturnValue(
            method = "isFireImmune",
            at = @At("RETURN"))
    private boolean isLavaFishingLoot(boolean original) {
        return original || this.fireImmune;
    }

    @Override
    public boolean isOnFire() {
        if(gf_isFireproof()) {
            return false;
        }

        return super.isOnFire();
    }

    @Override
    public boolean gf_isFireproof() {
        return this.fireImmune;
    }

    @Override
    public void gf_setFireproof(boolean value) {
        this.fireImmune = value;
    }
}
