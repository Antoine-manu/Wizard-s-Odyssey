package net.jepeta.wizards_odyssey.block;

import net.jepeta.wizards_odyssey.Wizards_Odyssey;
import net.jepeta.wizards_odyssey.item.ModItems;
import net.jepeta.wizards_odyssey.item.custom.ModFlammableRotatedPillarBlock;
import net.jepeta.wizards_odyssey.worldgen.tree.IllusionTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Wizards_Odyssey.MOD_ID);

    public static final RegistryObject<Block> ILLUSION_GRASS_BLOCK = registerBlock("illusion_grass_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK)));

    public static final RegistryObject<Block> ILLUSION_DIRT = registerBlock("illusion_dirt",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));

    public static final RegistryObject<Block> ILLUSION_LOG = registerBlock("illusion_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(3f)));

    public static final RegistryObject<Block> ILLUSION_WOOD = registerBlock("illusion_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(3f)));

    public static final RegistryObject<Block> STRIPPED_ILLUSION_LOG = registerBlock("stripped_illusion_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(3f)));

    public static final RegistryObject<Block> STRIPPED_ILLUSION_WOOD = registerBlock("stripped_illusion_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(3f)));


    public static final RegistryObject<Block> ILLUSION_PLANKS = registerBlock("illusion_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> ILLUSION_STAIRS = registerBlock("illusion_stairs",
            () -> new StairBlock(ModBlocks.ILLUSION_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(ModBlocks.ILLUSION_PLANKS.get()).strength(3f).requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ILLUSION_SLAB = registerBlock("illusion_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ILLUSION_FENCE = registerBlock("illusion_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)
                    .strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ILLUSION_LEAVES = registerBlock("illusion_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final RegistryObject<Block> FAERITE_ORE = registerBlock("faerite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> DEEPSLATE_FAERITE_ORE = registerBlock("deepslate_faerite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> FAERITE_BLOCK = registerBlock("faerite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));

    public static final RegistryObject<Block> ILLUSION_STONE = registerBlock("illusion_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> ILLUSION_COBBLESTONE = registerBlock("illusion_cobblestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> ILLUSION_STONE_BRICKS = registerBlock("illusion_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));

    public static final RegistryObject<Block> ILLUSION_STONE_BRICKS_STAIRS = registerBlock("illusion_stone_bricks_stairs",
            () -> new StairBlock(ModBlocks.ILLUSION_STONE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(ModBlocks.ILLUSION_STONE_BRICKS.get()).strength(3f).requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ILLUSION_STONE_BRICKS_SLAB = registerBlock("illusion_stone_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(ModBlocks.ILLUSION_STONE_BRICKS.get())
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> ILLUSION_SAPLING = registerBlock("illusion_sapling",
            () -> new SaplingBlock(new IllusionTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
