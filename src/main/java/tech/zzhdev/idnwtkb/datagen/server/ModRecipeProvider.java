package tech.zzhdev.idnwtkb.datagen.server;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;
import tech.zzhdev.idnwtkb.items.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BLAZE_ROD)
                .define('B', Items.BLAZE_POWDER)
                .pattern(" B ")
                .pattern(" B ")
                .pattern(" B ")
                .unlockedBy(
                        "has_diamond",
                        InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate
                                .Builder.item().of(Items.BLAZE_POWDER).build())
                )
                .save(recipeConsumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.ENDER_PEARL)
                .requires(ModItems.ENDER_DUST.get(), 9)
                .unlockedBy(
                        "has_diamond",
                        InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate
                                .Builder.item().of(ModItems.ENDER_DUST.get()).build())
                )
                .save(recipeConsumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.GUNPOWDER)
                .requires(Items.CHARCOAL, 1)
                .requires(Items.SUGAR, 4)
                .requires(Items.BLAZE_POWDER)
                .unlockedBy(
                        "has_diamond",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ItemPredicate.Builder.item().of(Items.BLAZE_POWDER).build(),
                                ItemPredicate.Builder.item().of(Items.CHARCOAL).build())
                )
                .save(recipeConsumer);

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModItems.ENDER_DUST.get()), RecipeCategory.MISC,
                        Items.BLAZE_POWDER, 0.7f, 400)
                .unlockedBy(
                        "has_diamond",
                        InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate
                                .Builder.item().of(ModItems.ENDER_DUST.get()).build())
                )
                .save(recipeConsumer);
    }
}
