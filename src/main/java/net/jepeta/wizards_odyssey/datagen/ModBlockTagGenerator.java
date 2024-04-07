package net.jepeta.wizards_odyssey.datagen;

import net.jepeta.wizards_odyssey.block.ModBlocks;
import net.jepeta.wizards_odyssey.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //Celui la sert a rien c'est un exemple de ce qui peut etre fait
        this.tag(ModTags.Blocks.STAFF_VALUABLES)
                .add(ModBlocks.ILLUSION_DIRT.get());

        //Pareil que en haut je .add un block pour lui donner le niveau de minable requis
        this.tag(BlockTags.NEEDS_IRON_TOOL);
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);
        this.tag(BlockTags.NEEDS_STONE_TOOL);

        //Pareil que en haut je .add un block pour lui donner le type d'outils (je peux faire .add(item, item, item , ..)
        this.tag(BlockTags.MINEABLE_WITH_AXE);
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE);
        this.tag(BlockTags.MINEABLE_WITH_HOE);
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL);
    }
}
