package me.zipestudio.fastrecipe.entrypoint;

//? if fabric {

import me.zipestudio.fastrecipe.FSServer;

import net.fabricmc.api.ModInitializer;

public class CommonEntrypoint implements ModInitializer {

	@Override
	public void onInitialize() {
		FSServer.onInitialize();
	}
}

//?} elif neoforge {

/*import me.zipestudio.frb.FRBServer;
import net.neoforged.fml.common.Mod;

@Mod(FRBServer.MOD_ID)
public class CommonEntrypoint {

	public CommonEntrypoint() {
		FRBServer.onInitialize();
	}

}

*///?} elif forge {
/*import me.zipestudio.frb.FRBServer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

@Mod(FRBServer.MOD_ID)
public class CommonEntrypoint {

	public CommonEntrypoint() {
		FRBServer.onInitialize();
		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientEntrypoint::onInitializeClient);
	}

}

*///?}

