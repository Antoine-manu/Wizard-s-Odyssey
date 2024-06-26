package net.jepeta.wizards_odyssey.datagen;

import net.jepeta.wizards_odyssey.Wizards_Odyssey;
import net.jepeta.wizards_odyssey.block.ModBlocks;
import net.jepeta.wizards_odyssey.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Wizards_Odyssey.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //Celui la sert a rien c'est un exemple de ce qui peut etre fait
        this.tag(ModTags.Blocks.STAFF_VALUABLES)
                .add(ModBlocks.ILLUSION_DIRT.get());

        //Pareil que en haut je .add un block pour lui donner le niveau de minable requis
        this.tag(BlockTags.NEEDS_IRON_TOOL);
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .add(ModBlocks.FAERITE_ORE.get())
            .add(ModBlocks.DEEPSLATE_FAERITE_ORE.get());
        this.tag(BlockTags.NEEDS_STONE_TOOL);
        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);

        //Pareil que en haut je .add un block pour lui donner le type d'outils (je peux faire .add(item, item, item , ..)
        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.ILLUSION_SLAB.get())
                .add(ModBlocks.ILLUSION_STAIRS.get())
                .add(ModBlocks.ILLUSION_FENCE.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ILLUSION_STONE_BRICKS.get())
                .add(ModBlocks.ILLUSION_STONE_BRICKS_SLAB.get())
                .add(ModBlocks.ILLUSION_STONE_BRICKS_STAIRS.get())
                .add(ModBlocks.ILLUSION_COBBLESTONE.get())
                .add(ModBlocks.ILLUSION_STONE.get())
                .add(ModBlocks.FAERITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_FAERITE_ORE.get());
        this.tag(BlockTags.MINEABLE_WITH_HOE);
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL);

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.ILLUSION_LOG.get())
                .add(ModBlocks.ILLUSION_WOOD.get())
                .add(ModBlocks.STRIPPED_ILLUSION_WOOD.get())
                .add(ModBlocks.STRIPPED_ILLUSION_LOG.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.ILLUSION_PLANKS.get());

    }
}
