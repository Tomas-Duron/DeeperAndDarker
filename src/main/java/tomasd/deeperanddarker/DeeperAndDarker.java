package tomasd.deeperanddarker;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.item.group.api.QuiltItemGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tomasd.deeperanddarker.registry.ModBlocks;
import tomasd.deeperanddarker.registry.ModItems;
import tomasd.deeperanddarker.registry.ModParticles;

public class DeeperAndDarker implements ModInitializer {
	public static final String MOD_ID = "deeperanddarker";
	public static final Logger LOGGER = LoggerFactory.getLogger("DeeperAndDarker");
	public static final ItemGroup ModItemGroup = QuiltItemGroup.createWithIcon(new Identifier(MOD_ID, "deeperanddarkertab"), () -> new ItemStack(Items.SCULK));

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Lorem! Presented by {}!", mod.metadata().name());

		// Register Stuff
		//		ModEntities.initialize();
		ModBlocks.initialize();
//		ModItemGroup.initialize();
		ModItems.initialize();
//		ModSoundEvents.initialize();
//		ModEnchantments.initialize();
//		ModLootTables.initialize();
//		ModStatusEffects.initialize();
		ModParticles.initialize();
	}
}
