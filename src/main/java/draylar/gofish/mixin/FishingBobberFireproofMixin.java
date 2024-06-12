package draylar.gofish.mixin;

import draylar.gofish.api.FireproofEntity;
import draylar.gofish.registry.GoFishAttachments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@SuppressWarnings("UnstableApiUsage")
@Mixin(FishingBobberEntity.class)
public abstract class FishingBobberFireproofMixin extends Entity implements FireproofEntity {

    private FishingBobberFireproofMixin(EntityType<?> type, World world) {
        super(type, world);
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
