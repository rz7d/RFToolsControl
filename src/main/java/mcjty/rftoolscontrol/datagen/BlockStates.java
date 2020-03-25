package mcjty.rftoolscontrol.datagen;

import mcjty.lib.datagen.BaseBlockStateProvider;
import mcjty.rftoolscontrol.RFToolsControl;
import mcjty.rftoolscontrol.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ExistingFileHelper;

public class BlockStates extends BaseBlockStateProvider {

    public BlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, RFToolsControl.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        orientedBlock(Registration.PROCESSOR.get(), frontBasedModel("processor", modLoc("block/machineprocessoron")));
        orientedBlock(Registration.WORKBENCH.get(), frontBasedModel("workbench", modLoc("block/machineworkbench")));
        orientedBlock(Registration.PROGRAMMER.get(), frontBasedModel("programmer", modLoc("block/machineprogrammer")));
        orientedBlock(Registration.NODE.get(), frontBasedModel("node", modLoc("block/machinenode")));
        orientedBlock(Registration.CRAFTING_STATION.get(), frontBasedModel("craftingstation", modLoc("block/machinecraftingstation")));

        // @todo 1.15
        //        orientedBlock(Registration.MULTITANK.get(), frontBasedModel("multitank", modLoc("block/machinecraftingstation")));
    }
}
