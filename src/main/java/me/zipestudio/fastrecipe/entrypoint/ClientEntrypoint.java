package me.zipestudio.fastrecipe.entrypoint;

//? if fabric {

import net.fabricmc.api.ClientModInitializer;

import me.zipestudio.fastrecipe.client.FSClient;

public class ClientEntrypoint implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		FSClient.onInitializeClient();
	}
}

//?} elif neoforge {
/*import me.zipestudio.frb.FRBServer;
import me.zipestudio.frb.client.FRBClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(value = FRBServer.MOD_ID, dist = Dist.CLIENT)
public class ClientEntrypoint {

	public ClientEntrypoint(ModContainer container) {
		FRBClient.onInitializeClient();
	}

}

*///?} elif forge {
/*import me.zipestudio.frb.client.FRBClient;
import net.minecraftforge.fml.ModLoadingContext;

public class ClientEntrypoint {

	public static void onInitializeClient() {
		FRBClient.onInitializeClient();
	}

}

*///?}
