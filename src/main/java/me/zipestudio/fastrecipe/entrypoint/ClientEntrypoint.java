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
/*import me.zipestudio.fastrecipe.FSServer;
import me.zipestudio.fastrecipe.client.FSClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(value = FSServer.MOD_ID, dist = Dist.CLIENT)
public class ClientEntrypoint {

	public ClientEntrypoint(ModContainer container) {
		FSClient.onInitializeClient();
	}

}

*///?} elif forge {
/*import me.zipestudio.fastrecipe.client.FSClient;
import net.minecraftforge.fml.ModLoadingContext;

public class ClientEntrypoint {

	public static void onInitializeClient() {
		FSClient.onInitializeClient();
	}

}

*///?}
