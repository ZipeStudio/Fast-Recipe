package me.zipestudio.fastrecipe.client;

import lombok.*;
import me.zipestudio.fastrecipe.FSServer;
import me.zipestudio.fastrecipe.slot.SlotListener;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.CraftingScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.RecipeBookMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.slf4j.*;

import java.util.List;

import org.jetbrains.annotations.Nullable;

public class FSClient {

    public static Logger LOGGER = LoggerFactory.getLogger(FSServer.MOD_NAME + "/Client");

    @Setter
    @Getter
    @Nullable
    private static List<Item> waitingResult;

    public static SlotListener getSlotListener() {
        return (slot) -> {
            List<Item> waitingResult = FSClient.getWaitingResult();
            if (waitingResult == null) {
                return;
            }
            ItemStack stack = slot.getItem();
            if (stack == null || stack.isEmpty() || !waitingResult.contains(stack.getItem())) {
                return;
            }
            Minecraft client = Minecraft.getInstance();
            LocalPlayer player = client.player;
            if (player == null) {
                FSClient.setWaitingResult(null);
                return;
            }
            MultiPlayerGameMode manager = client.gameMode;
            if (manager == null) {
                FSClient.setWaitingResult(null);
                return;
            }
            if (!(player.containerMenu instanceof RecipeBookMenu)) {
                FSClient.setWaitingResult(null);
                return;
            }

            manager.handleInventoryMouseClick(player.containerMenu.containerId, 0, 0, ClickType.QUICK_MOVE, player);
            FSClient.setWaitingResult(null);
        };
    }

    public static boolean canStartWaiting(List<Item> waitingResult) {
        Screen currentScreen = Minecraft.getInstance().screen;
        if (!(currentScreen instanceof InventoryScreen || currentScreen instanceof CraftingScreen)) {
            return false;
        }
        AbstractContainerScreen<?> handledScreen = (AbstractContainerScreen<?>) currentScreen;
        AbstractContainerMenu screenHandler = handledScreen.getMenu();
        if (!(screenHandler instanceof RecipeBookMenu)) {
            return false;
        }
        Slot slot = screenHandler.getSlot(0);
        return slot != null && !waitingResult.contains(slot.getItem().getItem());
    }

    public static void onInitializeClient() {
        LOGGER.info("{} Client Initialized", FSServer.MOD_NAME);
    }

}