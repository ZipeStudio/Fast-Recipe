package me.zipestudio.fastrecipe.entrypoint;

//? if fabric {

/*import me.zipestudio.fastrecipe.FSServer;

import net.fabricmc.api.ModInitializer;

public class CommonEntrypoint implements ModInitializer {

	@Override
	public void onInitialize() {
		FSServer.onInitialize();
	}
}

*///?} elif neoforge {

import me.zipestudio.fastrecipe.FSServer;
import net.neoforged.fml.common.Mod;

@Mod(FSServer.MOD_ID)
public class CommonEntrypoint {

	public CommonEntrypoint() {
		FSServer.onInitialize();
	}

}

//?} elif forge {
/*import me.zipestudio.fastrecipe.FSServer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

@Mod(FSServer.MOD_ID)
public class CommonEntrypoint {

	public CommonEntrypoint() {
		FSServer.onInitialize();
		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientEntrypoint::onInitializeClient);
	}

}

*///?}

