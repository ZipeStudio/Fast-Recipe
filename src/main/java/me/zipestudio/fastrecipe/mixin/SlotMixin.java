package me.zipestudio.fastrecipe.mixin;

import me.zipestudio.fastrecipe.slot.ListenableSlot;
import me.zipestudio.fastrecipe.slot.SlotListener;
import net.minecraft.world.inventory.Slot;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(Slot.class)
public class SlotMixin implements ListenableSlot {

    @Unique
    private SlotListener listener;

    @Override
    public void fastRecipe$setListener(SlotListener listener) {
        this.listener = listener;
    }

    @Inject(at = @At("TAIL"), method = "set")
    private void setStackNoCallbacks(CallbackInfo ci) {
        if (this.listener == null) {
            return;
        }
        this.listener.trigger((Slot) (Object) this);
    }

}