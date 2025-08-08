package draylar.gofish.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import draylar.gofish.api.FireproofEntity;
import draylar.gofish.impl.GoFishLootTables;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FishingBobberEntity.class)
public abstract class FishingBobberLootMixin extends Entity {

    private FishingBobberLootMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @ModifyArg(
            method = "use",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/registry/ReloadableRegistries$Lookup;getLootTable(Lnet/minecraft/registry/RegistryKey;)Lnet/minecraft/loot/LootTable;"))
    private RegistryKey<LootTable> getTable(RegistryKey<LootTable> key) {
        assert getWorld().getServer() != null;

        final DimensionType dimension = getWorld().getDimension();
        if(dimension.ultrawarm()) {
            return GoFishLootTables.NETHER_FISHING;
        } else if (!dimension.bedWorks()) {
            return GoFishLootTables.END_FISHING;
        }

        // Default
        return LootTables.FISHING_GAMEPLAY;
    }

    @Inject(
            method = "use",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/ItemEntity;setVelocity(DDD)V")
    )
    private void setFireproof(ItemStack usedItem, CallbackInfoReturnable<Integer> cir, @Local ItemEntity itemEntity) {
        // If the user is fishing in the nether, tell the dropped loot to ignore lava/fire burning until pickup
        if(getWorld().getDimension().ultrawarm()) {
            ((FireproofEntity) itemEntity).gf_setFireproof(true);
        }
    }
}
