package tech.zzhdev.idnwtkb;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import tech.zzhdev.idnwtkb.blocks.ModBlocks;

import static tech.zzhdev.idnwtkb.items.ModItems.ENDER_DUST;

public class ModCreativeTab {
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "idnwtkb" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IDNWTKBMod.MODID);
    // Creates a creative tab with the id "idnwtkb:example_tab" for the example item, that is placed after the combat tab
    public static final RegistryObject<CreativeModeTab> MOD_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .title(Component.literal("I D N W T K B"))
            .icon(() -> ENDER_DUST.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                // Add the item to the tab.
                // For your own tabs, this method is preferred over the event
                output.accept(ENDER_DUST.get());
                output.accept(ModBlocks.ENDER_ORE_ITEM.get());
                output.accept(ModBlocks.ENDER_ORE_DEEPSLATE_ITEM.get());
                output.accept(ModBlocks.NETHER_BLAZE_ORE_ITEM.get());
            }).build());
}
