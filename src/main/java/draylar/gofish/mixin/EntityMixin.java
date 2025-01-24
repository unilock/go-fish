package draylar.gofish.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import draylar.gofish.api.FireproofEntity;
import draylar.gofish.registry.GoFishAttachments;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@SuppressWarnings("UnstableApiUsage")
@Mixin(Entity.class)
public abstract class EntityMixin implements FireproofEntity {
	@ModifyReturnValue(
			method = "isFireImmune",
			at = @At("RETURN")
	)
	private boolean isFireImmune(boolean original) {
		return original || gf_isFireproof();
	}

	@Override
	public boolean gf_isFireproof() {
		return Boolean.TRUE.equals(((Entity) (Object) this).getAttached(GoFishAttachments.FIRE_IMMUNE));
	}

	@Override
	public void gf_setFireproof(boolean value) {
		((Entity) (Object) this).setAttached(GoFishAttachments.FIRE_IMMUNE, value);
	}
}
