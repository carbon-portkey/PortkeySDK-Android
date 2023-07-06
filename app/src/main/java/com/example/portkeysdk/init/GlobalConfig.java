package com.example.portkeysdk.init;

import com.example.portkeysdk.Props.Global;

import io.aelf.sdkv2.AElfClientV2;

public class GlobalConfig {
    private static final GlobalConfig ins;

    static {
        ins = new GlobalConfig();
    }

    public static GlobalConfig getIns() {
        return ins;
    }

    private GlobalConfig() {
        client = new AElfClientV2(Global.PEER_HTTP_URL);
    }

    public AElfClientV2 getClient() {
        return client;
    }

    private AElfClientV2 client;

}
