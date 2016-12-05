package com.bernasss12.pbtmod.util;

import com.bernasss12.pbtmod.PlusBlazeToolsMain;
import com.bernasss12.pbtmod.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;


/**
 * Created by Bernardo on 05/12/2016.
 */

public class Config {

    private static final String CATEGORY_GENERAL = "general";

    public static boolean normalCraftingRecipes = true;

    public static void checkConfig() {
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            initGeneralConfigs(cfg);
        } catch (Exception e1) {
            PlusBlazeToolsMain.logger.log(Level.ERROR, "Problem loading config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    private static void initGeneralConfigs(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
        normalCraftingRecipes = cfg.getBoolean("goodTutorial", CATEGORY_GENERAL, normalCraftingRecipes, "If the mod should use normal crafting system or the vanilla one.");
    }

}