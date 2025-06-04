package com.bigchadguys.ores.item.custom;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import org.jetbrains.annotations.NotNull;

public class NecroniumScytheItem extends SwordItem {
    public NecroniumScytheItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        boolean didDamage = super.hurtEnemy(stack, target, attacker);

        if (didDamage && attacker instanceof ServerPlayer player) {
            if (isCriticalHit(player)) {
                NecroniumScytheEffect.spreadAttack(target, player);
            }
        }

        return didDamage;
    }

    private boolean isCriticalHit(ServerPlayer player) {
        return player.fallDistance > 0.0F
                && !player.onGround()
                && !player.isInWater()
                && !player.onClimbable()
                && !player.isInLava()
                && !player.isSprinting()
                && !player.hasEffect(MobEffects.BLINDNESS)
                && player.getVehicle() == null
                && player.getAttackStrengthScale(0.5f) == 1.0f;
    }

}
