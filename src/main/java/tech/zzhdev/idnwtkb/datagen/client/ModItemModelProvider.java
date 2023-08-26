package tech.zzhdev.idnwtkb.datagen.client;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import tech.zzhdev.idnwtkb.IDNWTKBMod;
import tech.zzhdev.idnwtkb.blocks.ModBlocks;
import tech.zzhdev.idnwtkb.items.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, IDNWTKBMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        this.basicItem(ModItems.ENDER_DUST.get());
        this.withExistingParent(ModBlocks.ENDER_ORE.getId().getPath(), modLoc("block/ender_ore"));
        this.withExistingParent(ModBlocks.DEEPSLATE_ENDER_ORE.getId().getPath(), modLoc("block/deepslate_ender_ore"));
        this.withExistingParent(ModBlocks.NETHER_BLAZE_ORE.getId().getPath(), modLoc("block/nether_blaze_ore"));
    }
}
