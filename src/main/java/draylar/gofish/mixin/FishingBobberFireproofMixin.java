package draylar.gofish.mixin;

import draylar.gofish.api.FireproofEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FishingBobberEntity.class)
public abstract class FishingBobberFireproofMixin extends Entity implements FireproofEntity {

    @Unique
    private boolean fireproof = false;

    private FishingBobberFireproofMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(
            method = "initDataTracker",
            at = @At("RETURN"))
    private void registerFireImmuneTracker(CallbackInfo ci) {
    }

    // todo: inject into super instead
    @Override
    public boolean isOnFire() {
        if(this.fireproof) {
            return false;
        }

        return super.isOnFire();
    }

    @Override
    public boolean gf_isFireproof() {
        return this.fireproof;
    }

    @Override
    public void gf_setFireproof(boolean value) {
        this.fireproof = value;
    }
}
