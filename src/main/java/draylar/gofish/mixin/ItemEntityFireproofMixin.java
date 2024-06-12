package draylar.gofish.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import draylar.gofish.api.FireproofEntity;
import draylar.gofish.registry.GoFishAttachments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@SuppressWarnings("UnstableApiUsage")
@Mixin(ItemEntity.class)
public abstract class ItemEntityFireproofMixin extends Entity implements FireproofEntity {

    public ItemEntityFireproofMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @ModifyReturnValue(
            method = "isFireImmune",
            at = @At("RETURN")
    )
    private boolean isLavaFishingLoot(boolean original) {
        return original || gf_isFireproof();
    }

    // todo: inject into super instead
    @Override
    public boolean isOnFire() {
        if(gf_isFireproof()) {
            return false;
        }

        return super.isOnFire();
    }

    @Override
    public boolean gf_isFireproof() {
        return Boolean.TRUE.equals(this.getAttached(GoFishAttachments.FIRE_IMMUNE));
    }

    @Override
    public void gf_setFireproof(boolean value) {
        this.setAttached(GoFishAttachments.FIRE_IMMUNE, value);
    }
}
