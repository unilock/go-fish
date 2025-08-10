package draylar.gofish;

import draylar.gofish.registry.GoFishItems;
import draylar.gofish.registry.GoFishParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.particle.FishingParticle;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FishingRodItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class GoFishClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registerFishingRodPredicates(GoFishItems.BLAZE_ROD);
        registerFishingRodPredicates(GoFishItems.CELESTIAL_ROD);
        registerFishingRodPredicates(GoFishItems.FROSTED_ROD);
        registerFishingRodPredicates(GoFishItems.SOUL_ROD);
        registerFishingRodPredicates(GoFishItems.MATRIX_ROD);
        registerFishingRodPredicates(GoFishItems.SLIME_ROD);
        registerFishingRodPredicates(GoFishItems.DIAMOND_REINFORCED_ROD);
        registerFishingRodPredicates(GoFishItems.SKELETAL_ROD);
        registerFishingRodPredicates(GoFishItems.EYE_OF_FISHING);

        ParticleFactoryRegistry.getInstance().register(GoFishParticles.LAVA_FISHING, FishingParticle.Factory::new);
    }

    public void registerFishingRodPredicates(Item item) {
        ModelPredicateProviderRegistry.register(item, Identifier.of("cast"), (itemStack, clientWorld, livingEntity, i) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                boolean bl = livingEntity.getMainHandStack() == itemStack;
                boolean bl2 = livingEntity.getOffHandStack() == itemStack;
                if (livingEntity.getMainHandStack().getItem() instanceof FishingRodItem) {
                    bl2 = false;
                }

                return (bl || bl2) && livingEntity instanceof PlayerEntity && ((PlayerEntity)livingEntity).fishHook != null ? 1.0F : 0.0F;
            }
        });
    }
}
