package tech.zzhdev.idnwtkb.datagen.server;

import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import tech.zzhdev.idnwtkb.blocks.ModBlocks;
import tech.zzhdev.idnwtkb.items.ModItems;

public class ModBlockLootTables extends VanillaBlockLoot {
    @Override
    protected void generate() {
        this.add(ModBlocks.ENDER_ORE.get(),
                createDustDrop(ModBlocks.ENDER_ORE.get(), ModItems.ENDER_DUST.get()));
        this.add(ModBlocks.DEEPSLATE_ENDER_ORE.get(),
                createDustDrop(ModBlocks.DEEPSLATE_ENDER_ORE.get(), ModItems.ENDER_DUST.get()));
        this.add(ModBlocks.NETHER_BLAZE_ORE.get(),
                createDustDrop(ModBlocks.NETHER_BLAZE_ORE.get(), Items.BLAZE_POWDER));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries() // Get all registered entries
                .stream() // Stream the wrapped objects
                .flatMap(RegistryObject::stream) // Get the object if available
                ::iterator; // Create the iterable
    }

    private LootTable.Builder createDustDrop(Block block, Item item) {
        return createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
                )
        );
    }
}
