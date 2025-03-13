package com.bigchadguys.ores.item.custom;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class FloriteHoeItem extends HoeItem {

    public FloriteHoeItem(Tier tier, Item.Properties properties) {
        super(tier, properties);
    }

    @Override
    public @NotNull InteractionResult useOn(@NotNull UseOnContext context) {
        return super.useOn(context);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level world, net.minecraft.world.entity.player.@NotNull Player player, @NotNull InteractionHand hand) {
        if (!world.isClientSide() && player instanceof ServerPlayer serverPlayer) {
            FloriteHoeEffect.useHoe(world, serverPlayer);
            return InteractionResultHolder.success(player.getItemInHand(hand));
        }
        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }
}
