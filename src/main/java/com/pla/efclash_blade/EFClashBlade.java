package com.pla.efclash_blade;

import com.mojang.logging.LogUtils;
import com.pla.efclash_blade.client.CameraEngine;
import com.pla.efclash_blade.config.EFClashBladeConfig;
import com.pla.efclash_blade.gameasset.EFClashBladeSkillCategories;
import com.pla.efclash_blade.gameasset.EFClashBladeSkillSlots;
import com.pla.efclash_blade.gameasset.EFClashBladeSkills;
import com.pla.efclash_blade.network.NetworkRegister;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import org.slf4j.Logger;

@Mod(EFClashBlade.MOD_ID)
public class EFClashBlade {
    public static final String MOD_ID = "efclash_blade";
    public static final Logger LOGGER = LogUtils.getLogger();

    public EFClashBlade(IEventBus modEventBus, ModContainer modContainer, Dist dist) {
        modContainer.registerConfig(ModConfig.Type.COMMON, EFClashBladeConfig.SPEC, "efclash_blade-server.toml");

        EFClashBladeSkillSlots.ENUM_MANAGER.registerEnumCls(MOD_ID, EFClashBladeSkillSlots.class);
        EFClashBladeSkillCategories.ENUM_MANAGER.registerEnumCls(MOD_ID, EFClashBladeSkillCategories.class);
        EFClashBladeSkills.register(modEventBus);
        modEventBus.addListener(NetworkRegister::register);

        if (dist.isClient()) {
            modEventBus.addListener(EFClashBlade::clientSetup);
        }
    }

    private static void clientSetup(FMLClientSetupEvent event) {
        new CameraEngine();
    }
}
