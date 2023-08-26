package tech.zzhdev.idnwtkb.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import tech.zzhdev.idnwtkb.datagen.client.ModBlockStateProvider;
import tech.zzhdev.idnwtkb.datagen.client.ModItemModelProvider;
import tech.zzhdev.idnwtkb.datagen.client.ModLanguageProvider;
import tech.zzhdev.idnwtkb.datagen.server.ModBlockLootTables;
import tech.zzhdev.idnwtkb.datagen.server.ModRecipeProvider;
import tech.zzhdev.idnwtkb.datagen.server.tags.ModBlockTagsProvider;
import tech.zzhdev.idnwtkb.datagen.server.tags.ModItemTagsProvider;

import java.util.Collections;
import java.util.List;

public class ModDataGeneration {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper efh = event.getExistingFileHelper();
        PackOutput output = gen.getPackOutput();

        gen.addProvider(event.includeClient(), new ModLanguageProvider(output, "en_us"));
        gen.addProvider(event.includeClient(), new ModBlockStateProvider(output, efh));
        gen.addProvider(event.includeClient(), new ModItemModelProvider(output, efh));

        gen.addProvider(event.includeServer(), new ModRecipeProvider(output));
        ModBlockTagsProvider blockTags = new ModBlockTagsProvider(output, event.getLookupProvider(), efh);
        gen.addProvider(event.includeServer(), blockTags);
        gen.addProvider(event.includeServer(), new ModItemTagsProvider(output, event.getLookupProvider(), blockTags, efh));
        gen.addProvider(event.includeServer(), new LootTableProvider(output, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK))));
    }
}
