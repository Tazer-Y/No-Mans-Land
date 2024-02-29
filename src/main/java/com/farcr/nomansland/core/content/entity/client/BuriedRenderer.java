package com.farcr.nomansland.core.content.entity.client;

import com.farcr.nomansland.core.NoMansLand;
import com.farcr.nomansland.core.content.client.NMLModelLayers;
import com.farcr.nomansland.core.content.entity.BuriedEntity;
import com.farcr.nomansland.core.content.entity.variant.BuriedVariant;
import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class BuriedRenderer extends MobRenderer<BuriedEntity, BuriedModel<BuriedEntity>> {
    public static final Map<BuriedVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(BuriedVariant.class), (p_114874_) -> {
                p_114874_.put(BuriedVariant.ZERO,
                        new ResourceLocation(NoMansLand.MODID, "textures/entity/buried/buried_0.png"));
                p_114874_.put(BuriedVariant.ONE,
                        new ResourceLocation(NoMansLand.MODID, "textures/entity/buried/buried_1.png"));
                p_114874_.put(BuriedVariant.TWO,
                        new ResourceLocation(NoMansLand.MODID, "textures/entity/buried/buried_2.png"));
            });

    public BuriedRenderer(EntityRendererProvider.Context pContext) {
        this(pContext, ModelLayers.SKELETON, ModelLayers.SKELETON_INNER_ARMOR, ModelLayers.SKELETON_OUTER_ARMOR);
    }

    public BuriedRenderer(EntityRendererProvider.Context pContext, ModelLayerLocation skeleton, ModelLayerLocation skeletonInnerArmor, ModelLayerLocation skeletonOuterArmor) {
        super(pContext, new BuriedModel(pContext.bakeLayer(NMLModelLayers.BURIED_LAYER)), 0.5f);
    }


    @Override
    public ResourceLocation getTextureLocation(BuriedEntity instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant());
    }
}