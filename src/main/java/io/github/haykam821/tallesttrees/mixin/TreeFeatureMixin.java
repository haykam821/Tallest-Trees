package io.github.haykam821.tallesttrees.mixin;

import java.util.Random;
import java.util.Set;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

@Mixin(TreeFeature.class)
public class TreeFeatureMixin {
	@ModifyVariable(method = "generate", name = "i", at = @At(value = "STORE", ordinal = 0))
	public int increaseTrunkHeight(int trunkHeight, ModifiableTestableWorld world, Random random, BlockPos pos, Set<BlockPos> logPositions, Set<BlockPos> leavesPositions, BlockBox box, TreeFeatureConfig config) {
		if (config == DefaultBiomeFeatures.PINE_TREE_CONFIG) return trunkHeight;
		return 220 - pos.getY();
	}
}