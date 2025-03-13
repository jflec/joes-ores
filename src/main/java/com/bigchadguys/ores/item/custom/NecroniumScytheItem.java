package com.bigchadguys.ores.item.custom;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class NecroniumScytheItem extends SwordItem {
    public NecroniumScytheItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        if (!attacker.level().isClientSide() && attacker instanceof ServerPlayer player) {
            NecroniumScytheEffect.spreadAttack(target, player);
        }
        return super.hurtEnemy(stack, target, attacker);
    }
}
