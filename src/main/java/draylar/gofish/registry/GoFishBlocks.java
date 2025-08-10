package draylar.gofish.registry;

import draylar.gofish.GoFish;
import draylar.gofish.block.CrateBlock;
import draylar.gofish.item.CrateItem;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Rarity;

import java.util.function.Function;

public class GoFishBlocks {

    public static Block DECORATIVE_WOODEN_CRATE = registerDecorativeCrate("wooden", Block.Settings.copy(Blocks.OAK_WOOD), Block::new, new Item.Settings().maxCount(8));
    public static Block DECORATIVE_IRON_CRATE = registerDecorativeCrate("iron", Block.Settings.copy(Blocks.IRON_BLOCK), Block::new, new Item.Settings().maxCount(8));
    public static Block DECORATIVE_GOLDEN_CRATE = registerDecorativeCrate("golden", Block.Settings.copy(Blocks.GOLD_BLOCK), Block::new, new Item.Settings().maxCount(8));
    public static Block DECORATIVE_DIAMOND_CRATE = registerDecorativeCrate("diamond", Block.Settings.copy(Blocks.DIAMOND_BLOCK), Block::new, new Item.Settings().maxCount(8));
    public static Block DECORATIVE_FROSTED_CRATE = registerDecorativeCrate("frosted", Block.Settings.copy(Blocks.BLUE_ICE), Block::new, new Item.Settings().maxCount(8));
    public static Block DECORATIVE_SLIMEY_CRATE = registerDecorativeCrate("slimey", Block.Settings.copy(Blocks.SLIME_BLOCK), Block::new, new Item.Settings().maxCount(8));
    public static Block DECORATIVE_SUPPLY_CRATE = registerDecorativeCrate("supply", Block.Settings.copy(Blocks.OAK_WOOD), Block::new, new Item.Settings().maxCount(8));
    public static Block DECORATIVE_FIERY_CRATE = registerDecorativeCrate("fiery", Block.Settings.copy(Blocks.NETHER_BRICKS), Block::new, new Item.Settings().maxCount(8));
    public static Block DECORATIVE_SOUL_CRATE = registerDecorativeCrate("soul", Block.Settings.copy(Blocks.STONE), Block::new, new Item.Settings().maxCount(8));
    public static Block DECORATIVE_GILDED_BLACKSTONE_CRATE = registerDecorativeCrate("gilded_blackstone", Block.Settings.copy(Blocks.GILDED_BLACKSTONE), Block::new, new Item.Settings().maxCount(8));
    public static Block DECORATIVE_ASTRAL_CRATE = registerDecorativeCrate("astral", Block.Settings.copy(Blocks.END_STONE), Block::new, new Item.Settings().maxCount(8));
    public static Block DECORATIVE_END_CRATE = registerDecorativeCrate("end", Block.Settings.copy(Blocks.END_STONE), Block::new, new Item.Settings().maxCount(8));

    // The Wooden crate is padded with junk and cobwebs, but will often contain minimal resources, and a rare special item drop.
    //   Junk: Cobwebs, String, Kelp, Sticks, Planks, Seaweed
    //   Resources: coal, iron ore, iron nuggets, gold nuggets, flint, gold ingots
    //   Food: carrots, wheat, potatoes, beetroots
    //   Special: enchanting bottle, low-level enchanted book, emerald, bucket / bucket with fish, more materials
    //   Weapons: damaged crossbows, arrows, bows, stone tools
    //   Fish: all types of vanilla fish
    public static Block WOODEN_CRATE = registerCrate("wooden", Block.Settings.copy(Blocks.OAK_WOOD), CrateBlock::new, new Item.Settings().maxCount(8), DECORATIVE_WOODEN_CRATE);

    // The Iron Crate provides less junk, a chance for iron tools, and better rare loot.
    //   Junk: Oak Planks, sticks, Oak Logs, String, Seaweed, Kelp, Bones
    //   Resources: coal, iron ore, iron nuggets, gold nuggets, gold ingots, lapis, redstone
    //   Food: carrots, wheat, potatoes, beetroots, cooked potatoes
    //   Special: mid-level enchanted book, emerald, more materials
    //   Weapons: damaged crossbows, arrows, bows, stone tools
    //   Fish: all types of vanilla fish
    public static Block IRON_CRATE = registerCrate("iron", Block.Settings.copy(Blocks.IRON_BLOCK), CrateBlock::new, new Item.Settings().maxCount(8), DECORATIVE_IRON_CRATE);

    // The Gold Crate is a rare crate that drops gold items and materials.
    public static Block GOLDEN_CRATE = registerCrate("golden", Block.Settings.copy(Blocks.GOLD_BLOCK), CrateBlock::new, new Item.Settings().maxCount(8).rarity(Rarity.UNCOMMON), DECORATIVE_GOLDEN_CRATE);

    // The Diamond Crate provides good materials
    public static Block DIAMOND_CRATE = registerCrate("diamond", Block.Settings.copy(Blocks.DIAMOND_BLOCK), CrateBlock::new, new Item.Settings().maxCount(8).rarity(Rarity.RARE), DECORATIVE_DIAMOND_CRATE);
    public static Block FROSTED_CRATE = registerCrate("frosted", Block.Settings.copy(Blocks.BLUE_ICE), CrateBlock::new, new Item.Settings().maxCount(8).rarity(Rarity.RARE), DECORATIVE_FROSTED_CRATE);
    public static Block SLIMEY_CRATE = registerCrate("slimey", Block.Settings.copy(Blocks.SLIME_BLOCK), CrateBlock::new, new Item.Settings().maxCount(8), DECORATIVE_SLIMEY_CRATE);
    public static Block SUPPLY_CRATE = registerCrate("supply", Block.Settings.copy(Blocks.OAK_WOOD), CrateBlock::new, new Item.Settings().maxCount(8), DECORATIVE_SUPPLY_CRATE);
    public static Block FIERY_CRATE = registerCrate("fiery", Block.Settings.copy(Blocks.NETHER_BRICKS), CrateBlock::new, new Item.Settings().fireproof().maxCount(8), DECORATIVE_FIERY_CRATE);
    public static Block SOUL_CRATE = registerCrate("soul", Block.Settings.copy(Blocks.STONE), CrateBlock::new, new Item.Settings().fireproof().maxCount(8).rarity(Rarity.RARE), DECORATIVE_SOUL_CRATE);
    public static Block GILDED_BLACKSTONE_CRATE = registerCrate("gilded_blackstone", Block.Settings.copy(Blocks.GILDED_BLACKSTONE), CrateBlock::new, new Item.Settings().fireproof().maxCount(8).rarity(Rarity.UNCOMMON), DECORATIVE_GILDED_BLACKSTONE_CRATE);
    public static Block ASTRAL_CRATE = registerCrate("astral", Block.Settings.copy(Blocks.END_STONE).nonOpaque(), CrateBlock::new, new Item.Settings().fireproof().maxCount(8).rarity(Rarity.EPIC), DECORATIVE_ASTRAL_CRATE);
    public static Block END_CRATE = registerCrate("end", Block.Settings.copy(Blocks.END_STONE), CrateBlock::new, new Item.Settings().fireproof().maxCount(8).rarity(Rarity.EPIC), DECORATIVE_END_CRATE);

    public static <T extends Block> T registerDecorativeCrate(String name, AbstractBlock.Settings blockSettings, Function<AbstractBlock.Settings, T> blockFunc, Item.Settings settings) {
        var id = GoFish.id("decorative_"+name+"_crate");
        var block = blockFunc.apply(blockSettings.nonOpaque());
        T registeredBlock = Registry.register(Registries.BLOCK, id, block);
        var item = Registry.register(Registries.ITEM, id, new BlockItem(block, settings));
        GoFishItems.ITEMS.add(item);
        return registeredBlock;
    }

    public static <T extends CrateBlock> T registerCrate(String name, AbstractBlock.Settings blockSettings, Function<AbstractBlock.Settings, T> blockFunc, Item.Settings settings, Block decorative) {
        var id = GoFish.id(name+"_crate");
        var block = blockFunc.apply(blockSettings.nonOpaque());
        T registeredBlock = Registry.register(Registries.BLOCK, id, block);
        var item = Registry.register(Registries.ITEM, id, new CrateItem(block, settings, GoFish.id("gameplay/fishing/"+name+"_crate"), decorative));
        GoFishItems.ITEMS.add(item);
        return registeredBlock;
    }

    public static void init() {
        // NO-OP
    }
}
