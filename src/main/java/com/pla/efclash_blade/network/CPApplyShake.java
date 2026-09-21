package com.pla.efclash_blade.network;

/*
 * AnnoyingVillagers - Third-Party Derived File Notice
 *
 * SPDX-License-Identifier: CC-BY-NC-SA-3.0
 *
 * Upstream: Epic-Fight-Impactful
 * Source: https://github.com/Cyber2049/Epic-Fight-Impactful
 *
 * This file contains code adapted from the upstream project (Screen Shake algorithm).
 * Required upstream notices must be preserved.
 *
 * License texts:
 *   - third_party/licenses/LGPL-2.1.md
 *
 * Modifications and integration:
 *   Copyright (c) 2025 pla_is_me
 */

import com.pla.efclash_blade.EFClashBlade;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public class CPApplyShake implements CustomPacketPayload {
    public static final Type<CPApplyShake> TYPE = new Type<>(
            ResourceLocation.fromNamespaceAndPath(EFClashBlade.MOD_ID, "apply_shake")
    );
    public static final StreamCodec<RegistryFriendlyByteBuf, CPApplyShake> STREAM_CODEC =
            StreamCodec.ofMember(CPApplyShake::encode, CPApplyShake::new);

    private final int time;
    private final float strength;
    private final float frequency;
    private final int decayTime;

    public CPApplyShake(int time, float strength, float frequency, int decayTime) {
        this.time = time;
        this.strength = strength;
        this.frequency = frequency;
        this.decayTime = decayTime;
    }

    private CPApplyShake(RegistryFriendlyByteBuf buf) {
        this.time = buf.readInt();
        this.strength = buf.readFloat();
        this.frequency = buf.readFloat();
        this.decayTime = buf.readInt();
    }

    private void encode(RegistryFriendlyByteBuf buf) {
        buf.writeInt(time);
        buf.writeFloat(strength);
        buf.writeFloat(frequency);
        buf.writeInt(decayTime);
    }

    public int time() {
        return time;
    }

    public float strength() {
        return strength;
    }

    public float frequency() {
        return frequency;
    }

    public int decayTime() {
        return decayTime;
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
