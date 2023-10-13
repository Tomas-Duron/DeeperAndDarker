package tomasd.deeperanddarker.mixin;

import com.sammy.lodestone.systems.rendering.particle.Easing;
import com.sammy.lodestone.systems.rendering.particle.ParticleBuilders;
import com.sammy.lodestone.systems.rendering.particle.ParticleTextureSheets;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.random.PositionalRandomFactory;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tomasd.deeperanddarker.registry.ModParticles;

import java.awt.*;
import java.util.Random;

@Mixin(Block.class)
public class SculkDustBlockBreakParticleSpawner {


	@Inject(method = "spawnBreakParticles", at = @At(value = "HEAD"))
	public void addBlockBreakParticles(World world, PlayerEntity player, BlockPos pos, BlockState state, CallbackInfo ci) {
		if (state.getBlock() == Blocks.SCULK) {
			for (int i = 0; i<10000; i++){
//				boolean bright = random.nextInt(50) == 0;
//				Color color = bright ? new Color(0x29DFEB) : new Color(0x0D1217);
//				ParticleBuilders.create(ModParticles.PIXEL)
//					.setScale(0.02f)
//					.setAlpha(1f, 1f, 0f)
//					.setAlphaEasing(Easing.SINE_OUT)
//					.setColor(color, color)
//					.enableNoClip()
//					.setLifetime(100 + random.nextInt(50))
//					.setMotion(0f, 0.01f + random.nextFloat() * .01f, 0f)
//					.overrideRenderType(bright ? ParticleTextureSheets.ADDITIVE : ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT)
//					.spawn(world, pos.getX() + .5f + random.nextGaussian() / 3f, pos.getY() + 0.975f, pos.getZ() + .5f + random.nextGaussian() / 3f);

			}
		}
	}
}
