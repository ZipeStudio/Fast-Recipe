package me.zipestudio.fastrecipe.mixin;

import me.zipestudio.fastrecipe.client.FSClient;
import me.zipestudio.fastrecipe.slot.ListenableSlot;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.RecipeBookMenu;
import net.minecraft.world.inventory.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(AbstractContainerMenu.class)
public class AbstractContainerMenuMixin {

    @Inject(at = @At("HEAD"), method = "addSlot")
    private void startListening(Slot slot, CallbackInfoReturnable<Slot> cir) {
        AbstractContainerMenu o = (AbstractContainerMenu) (Object) (this);
        boolean bl = slot.index == 0;
        boolean bl2 = o instanceof RecipeBookMenu;
        if (!bl || !bl2) {
            return;
        }
        ((ListenableSlot) slot).fastRecipe$setListener(FSClient.getSlotListener());
    }

}