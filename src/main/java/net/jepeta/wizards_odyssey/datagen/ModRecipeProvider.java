package net.jepeta.wizards_odyssey.datagen;

import net.jepeta.wizards_odyssey.Wizards_Odyssey;
import net.jepeta.wizards_odyssey.block.ModBlocks;
import net.jepeta.wizards_odyssey.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    // Ajout de recette a faire cuir RAW par ORE (dans la list.OF je peux mettre item a cuir, item a cuir, ..)
    private static final List<ItemLike> SMELTABLES_FAERITE = List.of(ModBlocks.FAERITE_ORE.get(),
            ModBlocks.DEEPSLATE_FAERITE_ORE.get());

    private static final List<ItemLike> SMELTABLES_ILLUSION = List.of(ModBlocks.ILLUSION_COBBLESTONE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        //Ici tu load le fait que les recettes soient utilisé pour les smelt and blast c.F au dessus
        oreBlasting(consumer, SMELTABLES_FAERITE, RecipeCategory.MISC, ModItems.FAERITE.get(), 0.25f, 100, "faerite");
        oreSmelting(consumer, SMELTABLES_FAERITE, RecipeCategory.MISC, ModItems.FAERITE.get(), 0.25f, 100, "faerite");

        oreBlasting(consumer, SMELTABLES_ILLUSION, RecipeCategory.MISC, ModBlocks.ILLUSION_STONE.get(), 0.1f, 100, "illusion");
        oreSmelting(consumer, SMELTABLES_ILLUSION, RecipeCategory.MISC, ModBlocks.ILLUSION_STONE.get(), 0.1f, 100, "illusion");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FIRE_STAFF.get())
                .pattern("B  ")
                .pattern(" S ")
                .pattern("  S")
                .define('S', Items.STICK)
                .define('B', Items.BLAZE_POWDER)
                .unlockedBy(getHasName(Items.BLAZE_POWDER), has(Items.BLAZE_POWDER))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FAERITE_BLOCK.get())
                .pattern("FFF")
                .pattern("FFF")
                .pattern("FFF")
                .define('F', ModItems.FAERITE.get())
                .unlockedBy(getHasName(ModItems.FAERITE.get()), has(ModItems.FAERITE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ILLUSION_STONE_BRICKS.get())
                .pattern("SS")
                .pattern("SS")
                .define('S', ModBlocks.ILLUSION_STONE.get())
                .unlockedBy(getHasName(ModBlocks.ILLUSION_STONE.get()), has(ModBlocks.ILLUSION_STONE.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FAERITE.get(), 9)
                .requires(ModBlocks.FAERITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.FAERITE_BLOCK.get()), has(ModBlocks.FAERITE_BLOCK.get()))
                .save(consumer);

//        Exemplte de recette shapeless genre avec un block de X truc tu donnes X items
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.ILLUSION_PLANKS.get(), 4)
                .requires(ModBlocks.ILLUSION_LOG.get())
                .unlockedBy(getHasName(ModBlocks.ILLUSION_LOG.get()), has(ModBlocks.ILLUSION_LOG.get()))
                .save(consumer);
    }


    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, Wizards_Odyssey.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}