package com.reetam.gatorlab.datagen;

import com.reetam.gatorlab.GatorLab;
import com.reetam.gatorlab.registry.LabBlocks;
import com.reetam.gatorlab.registry.LabItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.data.LanguageProvider;

public class LabLang extends LanguageProvider {

    public LabLang(DataGenerator gen) {
        super(gen, GatorLab.MODID, "en_us");
    }

    private void addItemGroup(ItemGroup group, String name) {
        add(group.getDisplayName().getString(), name);
    }

    @Override
    protected void addTranslations() {
        addItemGroup(LabItems.blockGroup, "Lab Blocks");
        addItemGroup(LabItems.itemGroup, "Lab Items");

        add(LabBlocks.BRANCHES.get(), "Branches");
        add(LabBlocks.SCUTE_BLOCK.get(), "Alligator Scute Block");
        add(LabBlocks.WEATHER_DETECTOR.get(), "Weather Detector");
        add(LabBlocks.LED_BLOCK.get(), "LED Block");
        add(LabBlocks.REDLIGHT_RUNE.get(), "Redlight Rune");

        add(LabItems.BLAST_BOMB.get(), "Blast Bomb Spell");
        add(LabItems.GEAR_GILD_SPAWN_EGG.get(), "Gear Gild Spawn Egg");
    }
}
