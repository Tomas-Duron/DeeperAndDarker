package tomasd.deeperanddarker.registry;

import com.sammy.lodestone.systems.rendering.particle.ParticleBuilders;
import com.sammy.lodestone.systems.rendering.particle.type.LodestoneParticleType;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import tomasd.deeperanddarker.DeeperAndDarker;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

import static tomasd.deeperanddarker.DeeperAndDarker.MOD_ID;

public class ModParticles {

	public static LodestoneParticleType PIXEL = new LodestoneParticleType();

	public static void initialize(){
		ParticleFactoryRegistry.getInstance().register(PIXEL, LodestoneParticleType.Factory::new);
		PIXEL = Registry.register(Registry.PARTICLE_TYPE, new Identifier(MOD_ID, "pixel"), PIXEL);
	}
}
