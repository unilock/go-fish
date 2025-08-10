package draylar.gofish.registry;

import draylar.gofish.GoFish;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class GoFishParticles {

    public static final SimpleParticleType LAVA_FISHING = register("lava_fishing", false);

    private static SimpleParticleType register(String name, boolean alwaysShow) {
        return Registry.register(Registries.PARTICLE_TYPE, GoFish.id(name), FabricParticleTypes.simple(alwaysShow));
    }

    public static void init() {
        // NO-OP
    }

    private GoFishParticles() {
        // NO-OP
    }
}
