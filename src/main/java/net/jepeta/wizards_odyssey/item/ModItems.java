package net.jepeta.wizards_odyssey.item;

import net.jepeta.wizards_odyssey.Wizards_Odyssey;
import net.jepeta.wizards_odyssey.item.custom.StaffItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
                DeferredRegister.create(ForgeRegistries.ITEMS, Wizards_Odyssey.MOD_ID);

    public static final RegistryObject<Item> FIRE_STAFF = ITEMS.register("fire_staff",
            () -> new StaffItem(new Item.Properties()));

    public static final RegistryObject<Item> FAERITE = ITEMS.register("faerite",
            () -> new StaffItem(new Item.Properties()));


    public  static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
