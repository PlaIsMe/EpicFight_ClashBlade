package com.pla.efclash_blade.network;

import com.pla.efclash_blade.client.ClientPayloadHandler;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public final class NetworkRegister {
    private static final String PROTOCOL_VERSION = "1";

    private NetworkRegister() {
    }

    public static void register(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar(PROTOCOL_VERSION);
        registrar.playToClient(CPApplyShake.TYPE, CPApplyShake.STREAM_CODEC, ClientPayloadHandler::handleApplyShake);
    }
}
