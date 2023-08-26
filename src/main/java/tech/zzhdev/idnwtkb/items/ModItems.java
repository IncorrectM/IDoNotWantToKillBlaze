package tech.zzhdev.idnwtkb.items;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.zzhdev.idnwtkb.IDNWTKBMod;

public class ModItems {
    // Create a Deferred Register to hold Items which will all be registered under the "idnwtkb" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, IDNWTKBMod.MODID);

    // Creates a new food item with the id "idnwtkb:example_id", nutrition 1 and saturation 2
    public static final RegistryObject<Item> ENDER_DUST =
            ITEMS.register("ender_dust", () -> new Item(new Item.Properties()));
}
