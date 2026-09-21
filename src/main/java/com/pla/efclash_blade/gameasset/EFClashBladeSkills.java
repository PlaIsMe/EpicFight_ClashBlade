package com.pla.efclash_blade.gameasset;

import com.pla.efclash_blade.EFClashBlade;
import com.pla.efclash_blade.skill.ClashBladeSkill;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import yesman.epicfight.registry.EpicFightRegistries;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.passive.PassiveSkill;

public final class EFClashBladeSkills {
    public static final DeferredRegister<Skill> REGISTRY =
            DeferredRegister.create(EpicFightRegistries.Keys.SKILL, EFClashBlade.MOD_ID);

    public static final DeferredHolder<Skill, ClashBladeSkill> CLASH_BLADE = REGISTRY.register(
            "clash_blade",
            id -> PassiveSkill.createPassiveBuilder(ClashBladeSkill::new)
                    .setCategory(EFClashBladeSkillCategories.CLASH_BLADE)
                    .build(id)
    );

    private EFClashBladeSkills() {
    }

    public static void register(IEventBus modEventBus) {
        REGISTRY.register(modEventBus);
    }
}
