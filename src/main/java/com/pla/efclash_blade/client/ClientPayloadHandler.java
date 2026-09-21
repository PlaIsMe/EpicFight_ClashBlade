package com.pla.efclash_blade.client;

import com.pla.efclash_blade.network.CPApplyShake;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public final class ClientPayloadHandler {
    private ClientPayloadHandler() {
    }

    public static void handleApplyShake(CPApplyShake payload, IPayloadContext context) {
        CameraEngine engine = CameraEngine.getInstance();

        if (engine != null) {
            engine.shakeCamera(payload.strength(), payload.time(), payload.frequency(), payload.decayTime());
        }
    }
}
