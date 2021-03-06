/*
 * This file is part of Blue Power.
 *
 *     Blue Power is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Blue Power is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Blue Power.  If not, see <http://www.gnu.org/licenses/>
 */

package net.quetzi.bluepower.init;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Optional;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.quetzi.bluepower.compat.fmp.ItemBPMultipart;
import net.quetzi.bluepower.items.*;
import net.quetzi.bluepower.part.ItemBPPart;
import net.quetzi.bluepower.references.Dependencies;
import net.quetzi.bluepower.references.Refs;

public class BPItems {

    public static Item          amethyst;
    public static Item          sapphire;
    public static Item          ruby;
    public static Item          nikolite;
    public static Item          copper_ingot;
    public static Item          silver_ingot;
    public static Item          tin_ingot;
    public static Item          brass_ingot;
    public static Item          blue_alloy_ingot;
    public static Item          red_alloy_ingot;
    public static Item          tungsten_ingot;
    public static Item          ruby_axe;
    public static Item          ruby_sword;
    public static Item          ruby_pickaxe;
    public static Item          ruby_spade;
    public static Item          ruby_hoe;
    public static Item          ruby_sickle;
    public static Item          ruby_saw;
    public static Item          sapphire_axe;
    public static Item          sapphire_sword;
    public static Item          sapphire_pickaxe;
    public static Item          sapphire_spade;
    public static Item          sapphire_hoe;
    public static Item          sapphire_sickle;
    public static Item          sapphire_saw;
    public static Item          amethyst_axe;
    public static Item          amethyst_sword;
    public static Item          amethyst_pickaxe;
    public static Item          amethyst_spade;
    public static Item          amethyst_hoe;
    public static Item          amethyst_sickle;
    public static Item          amethyst_saw;
    public static Item          wood_sickle;
    public static Item          stone_sickle;
    public static Item          iron_sickle;
    public static Item          gold_sickle;
    public static Item          diamond_sickle;
    public static Item          iron_saw;
    public static Item          diamond_saw;
    public static Item          flax_seed;
    public static Item          indigo_dye;
    public static Item          silicon_boule;
    public static Item          silicon_wafer;
    public static Item          multipart;
    public static Item          red_doped_wafer;
    public static Item          blue_doped_wafer;
    public static Item          screwdriver;
    public static Item          athame;
    public static Item          tinplate;
    public static Item          stone_wafer;
    public static Item          stone_wire;
    public static Item          stone_anode;
    public static Item          stone_cathode;
    public static Item          stone_pointer;
    public static Item          silicon_chip;
    public static Item          taintedsilicon_chip;
    public static Item          stone_redwire;
    public static Item          plate_assembly;
    public static Item          stone_bundle;
    public static Item          screwdriver_handle;
    public static Item          seedBag;
    public static Item          canvas_bag;
    public static Item          canvas;
    public static Item          lumar;
    public static Item          wool_card;
    public static Item          diamond_drawplate;
    public static Item          copper_wire;
    public static Item          iron_wire;

    private static ToolMaterial gemMaterial = EnumHelper.addToolMaterial("GEM", 2, 750, 6.0F, 2.0F, 18);

    public static void init() {

        amethyst = new ItemGem(Refs.AMETHYST_NAME);
        sapphire = new ItemGem(Refs.SAPPHIRE_NAME);
        ruby = new ItemGem(Refs.RUBY_NAME);
        nikolite = new ItemNikolite();
        copper_ingot = new ItemIngot(Refs.COPPERINGOT_NAME);
        silver_ingot = new ItemIngot(Refs.SILVERINGOT_NAME);
        tin_ingot = new ItemIngot(Refs.TININGOT_NAME);
        tungsten_ingot = new ItemIngot(Refs.TUNGSTENINGOT_NAME);
        brass_ingot = new ItemIngot(Refs.BRASSINGOT_NAME);
        blue_alloy_ingot = new ItemIngot(Refs.BLUEALLOYINGOT_NAME);
        red_alloy_ingot = new ItemIngot(Refs.REDALLOYINGOT_NAME);

        ruby_axe = new ItemGemAxe(gemMaterial, Refs.RUBYAXE_NAME);
        ruby_sword = new ItemGemSword(gemMaterial, Refs.RUBYSWORD_NAME);
        ruby_pickaxe = new ItemGemPickaxe(gemMaterial, Refs.RUBYPICKAXE_NAME);
        ruby_spade = new ItemGemSpade(gemMaterial, Refs.RUBYSPADE_NAME);
        ruby_hoe = new ItemGemHoe(gemMaterial, Refs.RUBYHOE_NAME);
        ruby_sickle = new ItemSickle(gemMaterial, Refs.RUBYSICKLE_NAME);

        sapphire_axe = new ItemGemAxe(gemMaterial, Refs.SAPPHIREAXE_NAME);
        sapphire_sword = new ItemGemSword(gemMaterial, Refs.SAPPHIRESWORD_NAME);
        sapphire_pickaxe = new ItemGemPickaxe(gemMaterial, Refs.SAPPHIREPICKAXE_NAME);
        sapphire_spade = new ItemGemSpade(gemMaterial, Refs.SAPPHIRESPADE_NAME);
        sapphire_hoe = new ItemGemHoe(gemMaterial, Refs.SAPPHIREHOE_NAME);
        sapphire_sickle = new ItemSickle(gemMaterial, Refs.SAPPHIRESICKLE_NAME);

        amethyst_axe = new ItemGemAxe(gemMaterial, Refs.AMETHYSTAXE_NAME);
        amethyst_sword = new ItemGemSword(gemMaterial, Refs.AMETHYSTSWORD_NAME);
        amethyst_pickaxe = new ItemGemPickaxe(gemMaterial, Refs.AMETHYSTPICKAXE_NAME);
        amethyst_spade = new ItemGemSpade(gemMaterial, Refs.AMETHYSTSPADE_NAME);
        amethyst_hoe = new ItemGemHoe(gemMaterial, Refs.AMETHYSTHOE_NAME);
        amethyst_sickle = new ItemSickle(gemMaterial, Refs.AMETHYSTSICKLE_NAME);

        wood_sickle = new ItemSickle(ToolMaterial.WOOD, Refs.WOODSICKLE_NAME);
        stone_sickle = new ItemSickle(ToolMaterial.STONE, Refs.STONESICKLE_NAME);
        iron_sickle = new ItemSickle(ToolMaterial.IRON, Refs.IRONSICKLE_NAME);
        gold_sickle = new ItemSickle(ToolMaterial.GOLD, Refs.GOLDSICKLE_NAME);
        diamond_sickle = new ItemSickle(ToolMaterial.EMERALD, Refs.DIAMONDSICKLE_NAME);

        flax_seed = new ItemCropSeed(BPBlocks.flax_crop, Blocks.farmland).setUnlocalizedName(Refs.FLAXSEED_NAME);
        indigo_dye = new ItemIndigoDye(Refs.INDIGODYE_NAME);

        ruby_saw = new ItemSaw(1, Refs.RUBYSAW_NAME);
        amethyst_saw = new ItemSaw(1, Refs.AMETHYSTSAW_NAME);
        sapphire_saw = new ItemSaw(1, Refs.SAPPHIRESAW_NAME);
        iron_saw = new ItemSaw(1, Refs.IRONSAW_NAME);
        diamond_saw = new ItemSaw(2, Refs.DIAMONDSAW_NAME);

        silicon_boule = new ItemSiliconBoule(Refs.SILICONBOULE_NAME);
        silicon_wafer = new ItemSiliconWafer(Refs.SILICONWAFER_NAME);
        blue_doped_wafer = new ItemSiliconWafer(Refs.BLUEDOPEDWAFER_NAME);
        red_doped_wafer = new ItemSiliconWafer(Refs.REDDOPEDWAFER_NAME);
        screwdriver = new ItemScrewdriver();
        athame = new ItemAthame();
        tinplate = new ItemTinPlate();
        stone_wafer = new ItemCrafting(Refs.STONEWAFER_NAME);
        stone_wire = new ItemCrafting(Refs.STONEWIRE_NAME);
        stone_anode = new ItemCrafting(Refs.STONEANODE_NAME);
        stone_cathode = new ItemCrafting(Refs.STONECATHODE_NAME);
        stone_pointer = new ItemCrafting(Refs.STONEPOINTER_NAME);
        silicon_chip = new ItemCrafting(Refs.SILICONCHIP_NAME);
        taintedsilicon_chip = new ItemCrafting(Refs.TAINTEDSILICONCHIP_NAME);
        stone_redwire = new ItemCrafting(Refs.STONEREDWIRE_NAME);
        plate_assembly = new ItemCrafting(Refs.PLATEASSEMBLY_NAME);
        stone_bundle = new ItemCrafting(Refs.STONEBUNDLE_NAME);
        screwdriver_handle = new ItemHandle(Refs.SCREWDRIVERHANDLE_NAME);
        seedBag = new ItemSeedBag(Refs.SEEDBAG_NAME);
        canvas_bag = new ItemCanvasBag(Refs.CANVASBAG_NAME);
        canvas = new ItemCrafting(Refs.CANVAS_NAME);
        lumar = new ItemLumar();
        copper_wire = new ItemCrafting(Refs.COPPERWIRE_NAME);
        iron_wire = new ItemCrafting(Refs.IRONWIRE_NAME);
        wool_card = new ItemLimitedCrafting(Refs.WOOLCARD_NAME,64);
        diamond_drawplate = new ItemLimitedCrafting(Refs.DIAMONDDRAWPLATE_NAME,256);

        if (!Loader.isModLoaded(Dependencies.FMP)) {
            multipart = new ItemBPPart();
        } else {
            initFMP();
        }

        registerItems();
    }

    @Optional.Method(modid = Dependencies.FMP)
    private static void initFMP() {

        multipart = new ItemBPMultipart();
    }

    public static void registerItems() {

        GameRegistry.registerItem(amethyst, Refs.AMETHYST_NAME);
        GameRegistry.registerItem(sapphire, Refs.SAPPHIRE_NAME);
        GameRegistry.registerItem(ruby, Refs.RUBY_NAME);
        GameRegistry.registerItem(nikolite, Refs.NIKOLITE_NAME);
        GameRegistry.registerItem(copper_ingot, Refs.COPPERINGOT_NAME);
        GameRegistry.registerItem(silver_ingot, Refs.SILVERINGOT_NAME);
        GameRegistry.registerItem(tin_ingot, Refs.TININGOT_NAME);
        GameRegistry.registerItem(tungsten_ingot, Refs.TUNGSTENINGOT_NAME);
        GameRegistry.registerItem(brass_ingot, Refs.BRASSINGOT_NAME);
        GameRegistry.registerItem(blue_alloy_ingot, Refs.BLUEALLOYINGOT_NAME);
        GameRegistry.registerItem(red_alloy_ingot, Refs.REDALLOYINGOT_NAME);

        GameRegistry.registerItem(ruby_axe, Refs.RUBYAXE_NAME);
        GameRegistry.registerItem(ruby_sword, Refs.RUBYSWORD_NAME);
        GameRegistry.registerItem(ruby_pickaxe, Refs.RUBYPICKAXE_NAME);
        GameRegistry.registerItem(ruby_spade, Refs.RUBYSPADE_NAME);
        GameRegistry.registerItem(ruby_hoe, Refs.RUBYHOE_NAME);
        GameRegistry.registerItem(ruby_sickle, Refs.RUBYSICKLE_NAME);

        GameRegistry.registerItem(sapphire_axe, Refs.SAPPHIREAXE_NAME);
        GameRegistry.registerItem(sapphire_sword, Refs.SAPPHIRESWORD_NAME);
        GameRegistry.registerItem(sapphire_pickaxe, Refs.SAPPHIREPICKAXE_NAME);
        GameRegistry.registerItem(sapphire_spade, Refs.SAPPHIRESPADE_NAME);
        GameRegistry.registerItem(sapphire_hoe, Refs.SAPPHIREHOE_NAME);
        GameRegistry.registerItem(sapphire_sickle, Refs.SAPPHIRESICKLE_NAME);

        GameRegistry.registerItem(amethyst_axe, Refs.AMETHYSTAXE_NAME);
        GameRegistry.registerItem(amethyst_sword, Refs.AMETHYSTSWORD_NAME);
        GameRegistry.registerItem(amethyst_pickaxe, Refs.AMETHYSTPICKAXE_NAME);
        GameRegistry.registerItem(amethyst_spade, Refs.AMETHYSTSPADE_NAME);
        GameRegistry.registerItem(amethyst_hoe, Refs.AMETHYSTHOE_NAME);
        GameRegistry.registerItem(amethyst_sickle, Refs.AMETHYSTSICKLE_NAME);

        GameRegistry.registerItem(wood_sickle, Refs.WOODSICKLE_NAME);
        GameRegistry.registerItem(stone_sickle, Refs.STONESICKLE_NAME);
        GameRegistry.registerItem(iron_sickle, Refs.IRONSICKLE_NAME);
        GameRegistry.registerItem(gold_sickle, Refs.GOLDSICKLE_NAME);
        GameRegistry.registerItem(diamond_sickle, Refs.DIAMONDSICKLE_NAME);

        GameRegistry.registerItem(iron_saw, Refs.IRONSAW_NAME);
        GameRegistry.registerItem(diamond_saw, Refs.DIAMONDSAW_NAME);
        GameRegistry.registerItem(ruby_saw, Refs.RUBYSAW_NAME);
        GameRegistry.registerItem(sapphire_saw, Refs.SAPPHIRESAW_NAME);
        GameRegistry.registerItem(amethyst_saw, Refs.AMETHYSTSAW_NAME);

        GameRegistry.registerItem(flax_seed, Refs.FLAXSEED_NAME);
        GameRegistry.registerItem(indigo_dye, Refs.INDIGODYE_NAME);
        GameRegistry.registerItem(silicon_boule, Refs.SILICONBOULE_NAME);
        GameRegistry.registerItem(silicon_wafer, Refs.SILICONWAFER_NAME);
        GameRegistry.registerItem(blue_doped_wafer, Refs.BLUEDOPEDWAFER_NAME);
        GameRegistry.registerItem(red_doped_wafer, Refs.REDDOPEDWAFER_NAME);
        GameRegistry.registerItem(screwdriver, Refs.SCREWDRIVER_NAME);
        GameRegistry.registerItem(athame, Refs.ATHAME_NAME);
        GameRegistry.registerItem(tinplate, Refs.TINPLATE_NAME);

        GameRegistry.registerItem(stone_wafer, Refs.STONEWAFER_NAME);
        GameRegistry.registerItem(stone_wire, Refs.STONEWIRE_NAME);
        GameRegistry.registerItem(stone_anode, Refs.STONEANODE_NAME);
        GameRegistry.registerItem(stone_cathode, Refs.STONECATHODE_NAME);
        GameRegistry.registerItem(stone_pointer, Refs.STONEPOINTER_NAME);
        GameRegistry.registerItem(silicon_chip, Refs.SILICONCHIP_NAME);
        GameRegistry.registerItem(taintedsilicon_chip, Refs.TAINTEDSILICONCHIP_NAME);
        GameRegistry.registerItem(stone_redwire, Refs.STONEREDWIRE_NAME);
        GameRegistry.registerItem(plate_assembly, Refs.PLATEASSEMBLY_NAME);
        GameRegistry.registerItem(stone_bundle, Refs.STONEBUNDLE_NAME);
        GameRegistry.registerItem(screwdriver_handle, Refs.SCREWDRIVERHANDLE_NAME);
        GameRegistry.registerItem(seedBag, Refs.SEEDBAG_NAME);
        GameRegistry.registerItem(canvas_bag, Refs.CANVASBAG_NAME);
        GameRegistry.registerItem(canvas, Refs.CANVAS_NAME);
        GameRegistry.registerItem(lumar, Refs.LUMAR_NAME);
        GameRegistry.registerItem(wool_card, Refs.WOOLCARD_NAME);
        GameRegistry.registerItem(diamond_drawplate, Refs.DIAMONDDRAWPLATE_NAME);
        GameRegistry.registerItem(copper_wire, Refs.COPPERWIRE_NAME);
        GameRegistry.registerItem(iron_wire, Refs.IRONWIRE_NAME);

        MinecraftForge.addGrassSeed(new ItemStack(flax_seed), 5);

        GameRegistry.registerItem(multipart, Refs.MULTIPART_NAME);
    }
}
