package com.reetam.gatorlab.registry;

import com.reetam.gatorlab.GatorLab;
import com.reetam.gatorlab.entity.AlligatorEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = GatorLab.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LabEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, GatorLab.MODID);

    public static final EntityType<AlligatorEntity> ALLIGATOR_TYPE = EntityType.Builder.of(AlligatorEntity::new, EntityClassification.MONSTER)
            .sized(0.8F, 0.8F).build("alligator");
    public static final RegistryObject<EntityType<AlligatorEntity>> ALLIGATOR = ENTITIES.register("alligator", () -> ALLIGATOR_TYPE);

    @SubscribeEvent
    public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(LabEntities.ALLIGATOR.get(), AlligatorEntity.createAttributes().build());
    }
}
