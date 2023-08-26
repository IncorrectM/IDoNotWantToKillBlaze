package tech.zzhdev.idnwtkb.datagen.client;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import tech.zzhdev.idnwtkb.IDNWTKBMod;
import tech.zzhdev.idnwtkb.blocks.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, IDNWTKBMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.simpleBlock(ModBlocks.ENDER_ORE.get());
        this.simpleBlock(ModBlocks.DEEPSLATE_ENDER_ORE.get());
        this.simpleBlock(ModBlocks.NETHER_BLAZE_ORE.get());
    }
}
