package draylar.gofish.impl;

import draylar.gofish.GoFish;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class GoFishLootTables {

    public static final RegistryKey<LootTable> NETHER_FISHING = of("gameplay/fishing/nether/fishing");
    public static final RegistryKey<LootTable> END_FISHING = of("gameplay/fishing/end/fishing");
    public static final RegistryKey<LootTable> CRATES = of("gameplay/fishing/crates");

    private static RegistryKey<LootTable> of(String s) {
        return RegistryKey.of(RegistryKeys.LOOT_TABLE, GoFish.id(s));
    }
}
