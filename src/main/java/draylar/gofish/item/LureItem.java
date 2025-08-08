package draylar.gofish.item;

import draylar.gofish.api.FishingBonus;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class LureItem extends Item implements FishingBonus {

    private final int lure;

    public LureItem(Settings settings, int lure) {
        super(settings);
        this.lure = lure;
    }

    @Override
    public int getLure() {
        return lure;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);

        for(int i = 1; i <= 2; i++) {
            tooltip.add(Text.translatable(String.format("gofish.lure.tooltip_%d", i), lure).formatted(Formatting.GRAY));
        }
    }
}
