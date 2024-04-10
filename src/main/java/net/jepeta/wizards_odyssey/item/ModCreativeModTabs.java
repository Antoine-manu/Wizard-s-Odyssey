package net.jepeta.wizards_odyssey.item;

import net.jepeta.wizards_odyssey.Wizards_Odyssey;
import net.jepeta.wizards_odyssey.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Wizards_Odyssey.MOD_ID);

    public static final RegistryObject<CreativeModeTab> WIZARDS_TAB = CREATIVE_MODE_TABS.register("wizards_odyssey",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.FAERITE.get()))
                    .title(Component.translatable("creativetab.wizards_odyssey"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.FIRE_STAFF.get());
                        output.accept(ModItems.FAERITE.get());

                        output.accept(ModBlocks.FAERITE_BLOCK.get());
                        output.accept(ModBlocks.FAERITE_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_FAERITE_ORE.get());
                        output.accept(ModBlocks.ILLUSION_GRASS_BLOCK.get());
                        output.accept(ModBlocks.ILLUSION_DIRT.get());
                        output.accept(ModBlocks.ILLUSION_LOG.get());
                        output.accept(ModBlocks.STRIPPED_ILLUSION_LOG.get());
                        output.accept(ModBlocks.ILLUSION_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_ILLUSION_WOOD.get());
                        output.accept(ModBlocks.ILLUSION_LEAVES.get());
                        output.accept(ModBlocks.ILLUSION_PLANKS.get());
                        output.accept(ModBlocks.ILLUSION_STAIRS.get());
                        output.accept(ModBlocks.ILLUSION_SLAB.get());
                        output.accept(ModBlocks.ILLUSION_FENCE.get());
                        output.accept(ModBlocks.ILLUSION_STONE.get());
                        output.accept(ModBlocks.ILLUSION_COBBLESTONE.get());
                        output.accept(ModBlocks.ILLUSION_STONE_BRICKS.get());
                        output.accept(ModBlocks.ILLUSION_STONE_BRICKS_STAIRS.get());
                        output.accept(ModBlocks.ILLUSION_STONE_BRICKS_SLAB.get());
                        output.accept(ModBlocks.ILLUSION_SAPLING.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
