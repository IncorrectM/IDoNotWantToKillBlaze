package tech.zzhdev.idnwtkb.datagen.server.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.zzhdev.idnwtkb.IDNWTKBMod;
import tech.zzhdev.idnwtkb.blocks.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, IDNWTKBMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ENDER_ORE.get())
                .add(ModBlocks.DEEPSLATE_ENDER_ORE.get())
                .add(ModBlocks.NETHER_BLAZE_ORE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ENDER_ORE.get())
                .add(ModBlocks.DEEPSLATE_ENDER_ORE.get())
                .add(ModBlocks.NETHER_BLAZE_ORE.get());
    }
}
