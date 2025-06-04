package com.bigchadguys.ores.item.custom;

import com.bigchadguys.ores.JoesOres;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class SolariumArmorItem extends ArmorItem {
    private static final ResourceLocation BONUS_HEALTH_ID = ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, "solarium_set_bonus_health");
    private static final ResourceLocation BONUS_SPEED_ID = ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, "solarium_set_bonus_speed");
    private static final ResourceLocation BONUS_JUMP_ID = ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, "solarium_set_bonus_jump");
    private static final ResourceLocation BONUS_SAFE_FALL_DISTANCE_ID = ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, "solarium_set_bonus_safe_fall_distance");
    private static final ResourceLocation BONUS_BLOCK_BREAK_SPEED_ID = ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, "solarium_set_bonus_block_break_speed");

    private static final AttributeModifier SOLARIUM_HEALTH_MODIFIER = new AttributeModifier(BONUS_HEALTH_ID, 20.0, AttributeModifier.Operation.ADD_VALUE);
    private static final AttributeModifier SOLARIUM_SPEED_MODIFIER = new AttributeModifier(BONUS_SPEED_ID, 0.35, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
    private static final AttributeModifier SOLARIUM_JUMP_MODIFIER = new AttributeModifier(BONUS_JUMP_ID, 0.3, AttributeModifier.Operation.ADD_VALUE);
    private static final AttributeModifier SOLARIUM_SAFE_FALL_DISTANCE_MODIFIER = new AttributeModifier(BONUS_SAFE_FALL_DISTANCE_ID, 3, AttributeModifier.Operation.ADD_VALUE);
    private static final AttributeModifier SOLARIUM_BLOCK_BREAK_SPEED_MODIFIER = new AttributeModifier(BONUS_BLOCK_BREAK_SPEED_ID, 0.5, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);

    public SolariumArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, Level world, net.minecraft.world.entity.@NotNull Entity entity, int slot, boolean selected) {
        if (world.isClientSide() || !(entity instanceof LivingEntity livingEntity)) {
            super.inventoryTick(stack, world, entity, slot, selected);
            return;
        }

        if (this.getEquipmentSlot() != EquipmentSlot.CHEST) {
            super.inventoryTick(stack, world, entity, slot, selected);
            return;
        }

        boolean fullSet = isWearingFullSet(livingEntity);
        boolean condition = (world.getDayTime() % 24000L < 13000L) || (world.dimension() == Level.NETHER);

        AttributeInstance healthAttr = livingEntity.getAttribute(Attributes.MAX_HEALTH);
        AttributeInstance speedAttr = livingEntity.getAttribute(Attributes.MOVEMENT_SPEED);
        AttributeInstance jumpAttr = livingEntity.getAttribute(Attributes.JUMP_STRENGTH);
        AttributeInstance safeFallDistanceAttr = livingEntity.getAttribute(Attributes.SAFE_FALL_DISTANCE);
        AttributeInstance blockBreakSpeedAttr = livingEntity.getAttribute(Attributes.BLOCK_BREAK_SPEED);

        if (healthAttr != null && speedAttr != null && jumpAttr != null && safeFallDistanceAttr != null && blockBreakSpeedAttr != null) {
            if (fullSet && condition) {
                addModifierIfAbsent(healthAttr, BONUS_HEALTH_ID, SOLARIUM_HEALTH_MODIFIER);
                addModifierIfAbsent(speedAttr, BONUS_SPEED_ID, SOLARIUM_SPEED_MODIFIER);
                addModifierIfAbsent(jumpAttr, BONUS_JUMP_ID, SOLARIUM_JUMP_MODIFIER);
                addModifierIfAbsent(safeFallDistanceAttr, BONUS_SAFE_FALL_DISTANCE_ID, SOLARIUM_SAFE_FALL_DISTANCE_MODIFIER);
                addModifierIfAbsent(blockBreakSpeedAttr, BONUS_BLOCK_BREAK_SPEED_ID, SOLARIUM_BLOCK_BREAK_SPEED_MODIFIER);

                if (livingEntity.getHealth() < livingEntity.getMaxHealth() && livingEntity.tickCount % 40 == 0) {
                    livingEntity.heal(2.0F);
                }
            } else {
                healthAttr.removeModifier(BONUS_HEALTH_ID);
                speedAttr.removeModifier(BONUS_SPEED_ID);
                jumpAttr.removeModifier(BONUS_JUMP_ID);
                safeFallDistanceAttr.removeModifier(BONUS_SAFE_FALL_DISTANCE_ID);
                blockBreakSpeedAttr.removeModifier(BONUS_BLOCK_BREAK_SPEED_ID);
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private boolean isWearingFullSet(LivingEntity entity) {
        return entity.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof SolariumArmorItem &&
                entity.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof SolariumArmorItem &&
                entity.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof SolariumArmorItem &&
                entity.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof SolariumArmorItem;
    }

    private void addModifierIfAbsent(AttributeInstance attribute, ResourceLocation id, AttributeModifier modifier) {
        if (attribute.getModifier(id) == null) {
            attribute.addTransientModifier(modifier);
        }
    }
}
