package tech.zzhdev.idnwtkb.datagen.client;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import tech.zzhdev.idnwtkb.IDNWTKBMod;
import tech.zzhdev.idnwtkb.blocks.ModBlocks;
import tech.zzhdev.idnwtkb.items.ModItems;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output, String locale) {
        super(output, IDNWTKBMod.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        // mod blocks
        this.add(ModBlocks.ENDER_ORE.get(), "Ender Ore");
        this.add(ModBlocks.DEEPSLATE_ENDER_ORE.get(), "Deepslate Ender Ore");
        this.add(ModBlocks.NETHER_BLAZE_ORE.get(), "Nether Blaze Ore");

        // mod items
        this.add(ModItems.ENDER_DUST.get(), "Ender Dust");
    }
}
