package net.jepeta.wizards_odyssey.datagen.loot;

import net.jepeta.wizards_odyssey.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.ILLUSION_GRASS_BLOCK.get());
        this.dropSelf(ModBlocks.ILLUSION_DIRT.get());

        this.dropSelf(ModBlocks.ILLUSION_LOG.get());
        this.dropSelf(ModBlocks.ILLUSION_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_ILLUSION_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_ILLUSION_LOG.get());
        this.dropSelf(ModBlocks.ILLUSION_PLANKS.get());

        this.add(ModBlocks.ILLUSION_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.ILLUSION_DIRT.get(), NORMAL_LEAVES_SAPLING_CHANCES)); //Todo Change to sapling
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
