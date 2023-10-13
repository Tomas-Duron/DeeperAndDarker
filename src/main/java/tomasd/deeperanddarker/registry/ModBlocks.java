package tomasd.deeperanddarker.registry;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;
import tomasd.deeperanddarker.DeeperAndDarker;
import tomasd.deeperanddarker.common.block.WailingPotShort;

import java.util.LinkedHashMap;
import java.util.Map;

import static tomasd.deeperanddarker.DeeperAndDarker.ModItemGroup;

public interface ModBlocks {
	Map<Block, Identifier> BLOCKS = new LinkedHashMap<>();

	//	Block MOD_BLOCK = createBlock("mod_block", new ModBlock(QuiltBlockSettings.of(Material.METAL, MapColor.DEEPSLATE_GRAY).strength(-1.0F, 3600000.0F).sounds(BlockSoundGroup.COPPER)), true);
	Block WAILING_POT_SHORT = createBlock("wailing_pot_short", new WailingPotShort(QuiltBlockSettings.copyOf(Blocks.TERRACOTTA)), true, ItemGroup.MISC);
//	Block WAILING_POT_TALL = createBlock("wailing_pot_tall", new WailingPotShort(QuiltBlockSettings.copyOf(Blocks.TERRACOTTA)), true);
	Block SCULK_SHROOM = createBlock("sculk_shroom", new Block(QuiltBlockSettings.copyOf(Blocks.BROWN_MUSHROOM)), true, ModItemGroup);

	static void initialize() {
		BLOCKS.keySet().forEach(block -> Registry.register(Registry.BLOCK, BLOCKS.get(block), block));
	}

	private static <T extends Block> T createBlock(String name, T block, boolean createItem, ItemGroup itemGroup) {
		BLOCKS.put(block, new Identifier(DeeperAndDarker.MOD_ID, name));
		if (createItem) {
			ModItems.ITEMS.put(new BlockItem(block, new QuiltItemSettings()), BLOCKS.get(block));
		}
		return block;
	}
}
