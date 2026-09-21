package com.pla.efclash_blade.config;

import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.List;

public class EFClashBladeConfig {
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    public static ModConfigSpec.ConfigValue<List<? extends String>> BLACK_LIST;
    public static ModConfigSpec.ConfigValue<Integer> BREAK_WEAPON_VALUE_ON_CLASH;
    public static ModConfigSpec.ConfigValue<Double> CLASH_CHANCE;
    public static ModConfigSpec.ConfigValue<Boolean> SHAKE_SCREEN;

    static {
        BLACK_LIST = BUILDER.comment(
                        "A list of entities that can't do Clash Blade",
                        "Input: [\"minecraft\"] will disable Clash Blade for all of entities from Minecraft",
                        "Input: [\"minecraft:zombie\"] will disable Clash Blade for zombie entity from Minecraft.")
                .defineListAllowEmpty(
                        "blackList",
                        List.of("nightfall_invade"),
                        () -> "",
                        entry -> entry instanceof String
                );
        BREAK_WEAPON_VALUE_ON_CLASH = BUILDER.comment(
                        "The value for breaking weapon value for each successfullly clashing",
                        "Set to 0 to disable.")
                .defineInRange("breakWeaponValueOnClash", 1, 0, 10000);
        CLASH_CHANCE = BUILDER.comment(
                        "Chance for clashing")
                .defineInRange("clashChance", 1.0, 0, 1);
        SHAKE_SCREEN = BUILDER.comment(
                        "Shake your screen on clashing")
                .define("shakeScreen", true);
        SPEC = BUILDER.build();
    }
}
