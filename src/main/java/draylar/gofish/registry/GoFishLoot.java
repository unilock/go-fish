package draylar.gofish.registry;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import draylar.gofish.GoFish;
import draylar.gofish.loot.WeatherCondition;
import draylar.gofish.loot.biome.MatchBiomeLootCondition;
import draylar.gofish.loot.moon.FullMoonCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.LootConditionType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.JsonSerializer;
import net.minecraft.util.Util;

public class GoFishLoot {

    public static final LootConditionType MATCH_BIOME = register("match_biome", MatchBiomeLootCondition.CODEC);
    public static final LootConditionType FULL_MOON = register("full_moon", FullMoonCondition.CODEC);
    public static final LootConditionType WEATHER = register("weather", WeatherCondition.CODEC);

    private static <T extends LootCondition> LootConditionType register(String id, Codec<T> codec) {
        return Registry.register(Registries.LOOT_CONDITION_TYPE, GoFish.id(id), new LootConditionType(new JsonSerializer<T>() {
            @Override
            public void toJson(JsonObject json, T object, JsonSerializationContext context) {
                Util.getResult(codec.encodeStart(JsonOps.INSTANCE, object), IllegalStateException::new);
            }

            @Override
            public T fromJson(JsonObject json, JsonDeserializationContext context) {
                return Util.getResult(codec.parse(JsonOps.INSTANCE, json), JsonParseException::new);
            }
        }));
    }

    public static void init() {
        // NO-OP
    }
}
