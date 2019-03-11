package mcjty.rftoolscontrol.proxy;

import mcjty.lib.compat.MainCompatHandler;
import mcjty.lib.setup.DefaultCommonSetup;
import mcjty.rftoolscontrol.CommandHandler;
import mcjty.rftoolscontrol.ForgeEventHandlers;
import mcjty.rftoolscontrol.RFToolsControl;
import mcjty.rftoolscontrol.blocks.ModBlocks;
import mcjty.rftoolscontrol.config.ConfigSetup;
import mcjty.rftoolscontrol.items.ModItems;
import mcjty.rftoolscontrol.logic.registry.Functions;
import mcjty.rftoolscontrol.logic.registry.Opcodes;
import mcjty.rftoolscontrol.network.RFToolsCtrlMessages;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod.EventBusSubscriber
public class CommonSetup extends DefaultCommonSetup {

    public static boolean mcmpPresent = false;

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);

        MinecraftForge.EVENT_BUS.register(new ForgeEventHandlers());
        NetworkRegistry.INSTANCE.registerGuiHandler(RFToolsControl.instance, new GuiProxy());

        CommandHandler.registerCommands();

        RFToolsCtrlMessages.registerMessages("rftoolsctrl");

        ConfigSetup.init();
        Opcodes.init();
        Functions.init();
        ModBlocks.init();
        ModItems.init();
    }

    @Override
    protected void setupModCompat() {
        mcmpPresent = Loader.isModLoaded("mcmultipart");
//        if (RFToolsControl.mcmpPresent) {
//            MCMPSetup.init();
//        }
        MainCompatHandler.registerWaila();
        MainCompatHandler.registerTOP();
        FMLInterModComms.sendFunctionMessage("rftools", "getScreenModuleRegistry", "mcjty.rftoolscontrol.rftoolssupport.RFToolsSupport$GetScreenModuleRegistry");
    }

    @Override
    public void createTabs() {
        createTab("RFToolsControl", new ItemStack(ModItems.rfToolsControlManualItem));
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
        ConfigSetup.postInit();
    }
}
