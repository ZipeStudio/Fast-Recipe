package me.zipestudio.fastrecipe.mixin;

import com.mojang.blaze3d.platform.InputConstants;
import me.zipestudio.fastrecipe.client.FSClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.gui.screens.recipebook.RecipeBookPage;
import net.minecraft.client.gui.screens.recipebook.RecipeCollection;
import net.minecraft.world.inventory.RecipeBookMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


import java.util.*;

@Mixin(RecipeBookComponent.class)
public class RecipeBookComponentMixin {

    @Shadow
    @Final
    private RecipeBookPage recipeBookPage;

    //? if >=1.21.9 {
    /*@Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screens/recipebook/RecipeBookComponent;isOffsetNextToMainGUI()Z"), method = "mouseClicked")
    private void init(net.minecraft.client.input.MouseButtonEvent mouseButtonEvent, boolean bl, CallbackInfoReturnable<Boolean> cir) {
    *///?} else {
    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screens/recipebook/RecipeBookComponent;isOffsetNextToMainGUI()Z"), method = "mouseClicked")
    private void init(double mouseX, double mouseY, int button, CallbackInfoReturnable<Boolean> cir) {
        //?}

        RecipeCollection lastClickedResults = this.recipeBookPage.getLastClickedRecipeCollection();

        //? if >=1.21.2 {
        /*net.minecraft.world.item.crafting.display.RecipeDisplayId
         *///?} elif >=1.20.2 {
        net.minecraft.world.item.crafting.RecipeHolder<?>
                //?} else {
                /*net.minecraft.world.item.crafting.Recipe<?>
                 *///?}
                lastClickedRecipe = this.recipeBookPage.getLastClickedRecipe();

        if (lastClickedResults == null) {
            return;
        }
        if (lastClickedRecipe == null) {
            return;
        }

        //? if >=1.21.2 {
        /*net.minecraft.util.context.ContextMap parameters = net.minecraft.world.item.crafting.display.SlotDisplayContext.fromLevel(Objects.requireNonNull(Minecraft.getInstance().level));
        List<Item> result = lastClickedResults.getSelectedRecipes(net.minecraft.client.gui.screens.recipebook.RecipeCollection.CraftableStatus.CRAFTABLE)
                .stream()
                .map(net.minecraft.world.item.crafting.display.RecipeDisplayEntry::display)
                .map(net.minecraft.world.item.crafting.display.RecipeDisplay::result)
                .map((slotDisplay) -> slotDisplay.resolveForStacks(parameters))
                .flatMap(List::stream)
                .map(ItemStack::getItem)
                .toList();
        *///?} elif >=1.20.2 {
        List<Item> result = List.of(lastClickedRecipe.value().getResultItem(lastClickedResults.registryAccess()).getItem());
        //?} else {
        /*List<Item> result = List.of(lastClickedRecipe.getResultItem(/^? >=1.19.4 {^/ lastClickedResults.registryAccess() /^?}^/).getItem());
         *///?}

        if (result.isEmpty()) {
            return;
        }

        boolean controlDown =
        //? if >=1.21.9 {
        /*mouseButtonEvent.hasControlDown();
        *///?} else {
        Screen.hasControlDown();
        //?}

        if (!controlDown || !FSClient.canStartWaiting(result)) {
            return;
        }

        FSClient.setWaitingResult(result);
    }
}