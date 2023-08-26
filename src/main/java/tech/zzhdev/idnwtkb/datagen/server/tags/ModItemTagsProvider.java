package tech.zzhdev.idnwtkb.datagen.server.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import tech.zzhdev.idnwtkb.IDNWTKBMod;
import tech.zzhdev.idnwtkb.blocks.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, BlockTagsProvider blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, blockTags.contentsGetter(), IDNWTKBMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(Tags.Items.ORES)
                .add(ModBlocks.ENDER_ORE_ITEM.get())
                .add(ModBlocks.ENDER_ORE_DEEPSLATE_ITEM.get());
    }
}
