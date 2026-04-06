package me.zipestudio.fastrecipe;

import net.minecraft.network.chat.*;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FSServer {

	public static final String MOD_NAME = /*$ mod_name*/ "Fast Recipe";
	public static final String MOD_ID = /*$ mod_id*/ "fast_recipe";

	public static Logger LOGGER = LoggerFactory.getLogger(FSServer.MOD_NAME);

	public static void onInitialize() {
		LOGGER.info("{} Initialized", MOD_NAME);
	}
}