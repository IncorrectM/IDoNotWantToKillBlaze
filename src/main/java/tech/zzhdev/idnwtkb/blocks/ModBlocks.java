package tech.zzhdev.idnwtkb.blocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.zzhdev.idnwtkb.IDNWTKBMod;
import tech.zzhdev.idnwtkb.items.ModItems;

public class ModBlocks {
    // Create a Deferred Register to hold Blocks which will all be registered under the "idnwtkb" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, IDNWTKBMod.MODID);

    public static final RegistryObject<Block> ENDER_ORE =
            BLOCKS.register("ender_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_ORE)));
    public static final RegistryObject<Block> DEEPSLATE_ENDER_ORE =
            BLOCKS.register("deepslate_ender_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_GOLD_ORE)));

    public static final RegistryObject<Block> NETHER_BLAZE_ORE =
            BLOCKS.register("nether_blaze_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE)));

    public static final RegistryObject<Item> ENDER_ORE_ITEM =
            ModItems.ITEMS.register("ender_ore", () -> new BlockItem(ENDER_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> ENDER_ORE_DEEPSLATE_ITEM =
            ModItems.ITEMS.register("deepslate_ender_ore", () -> new BlockItem(DEEPSLATE_ENDER_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> NETHER_BLAZE_ORE_ITEM =
            ModItems.ITEMS.register("nether_blaze_ore", () -> new BlockItem(NETHER_BLAZE_ORE.get(), new Item.Properties()));
}
