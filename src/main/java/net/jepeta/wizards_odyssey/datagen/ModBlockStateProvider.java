package net.jepeta.wizards_odyssey.datagen;

import net.jepeta.wizards_odyssey.Wizards_Odyssey;
import net.jepeta.wizards_odyssey.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.List;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Wizards_Odyssey.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ILLUSION_DIRT);
        createGrassLikeBlock(ModBlocks.ILLUSION_GRASS_BLOCK);

        logBlock((RotatedPillarBlock) ModBlocks.ILLUSION_LOG.get());
        axisBlock(((RotatedPillarBlock) ModBlocks.ILLUSION_WOOD.get()), blockTexture(ModBlocks.ILLUSION_LOG.get()), blockTexture(ModBlocks.ILLUSION_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_ILLUSION_LOG.get()), blockTexture(ModBlocks.STRIPPED_ILLUSION_LOG.get()),
                new ResourceLocation(Wizards_Odyssey.MOD_ID, "block/stripped_illusion_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_ILLUSION_WOOD.get()), blockTexture(ModBlocks.STRIPPED_ILLUSION_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_ILLUSION_LOG.get()));

        blockItem(ModBlocks.ILLUSION_LOG);
        blockItem(ModBlocks.ILLUSION_WOOD);
        blockItem(ModBlocks.STRIPPED_ILLUSION_LOG);
        blockItem(ModBlocks.STRIPPED_ILLUSION_WOOD);

        blockWithItem(ModBlocks.ILLUSION_PLANKS);
        leavesBlock(ModBlocks.ILLUSION_LEAVES);
    }



    public void createGrassLikeBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().cube(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                        new ResourceLocation(Wizards_Odyssey.MOD_ID, "block/illusion_dirt"),
                        new ResourceLocation(Wizards_Odyssey.MOD_ID, "block/illusion_grass_top"),
                        new ResourceLocation(Wizards_Odyssey.MOD_ID, "block/illusion_grass_side"),
                        new ResourceLocation(Wizards_Odyssey.MOD_ID, "block/illusion_grass_side"),
                        new ResourceLocation(Wizards_Odyssey.MOD_ID, "block/illusion_grass_side"),
                        new ResourceLocation(Wizards_Odyssey.MOD_ID, "block/illusion_grass_side")
                ));
    }

    public void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    public void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(Wizards_Odyssey.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

}
