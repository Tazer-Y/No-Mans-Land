package com.farcr.nomansland.core.registry;

import com.farcr.nomansland.core.NoMansLand;
import com.farcr.nomansland.core.content.block.StandingSignBlock;
import com.farcr.nomansland.core.content.block.WallHangingSignBlock;
import com.farcr.nomansland.core.content.block.WallSignBlock;
import com.farcr.nomansland.core.content.block.*;
import com.farcr.nomansland.core.content.world.tree.*;
import com.farcr.nomansland.core.registry.integration.FDIntegration;
import com.google.common.collect.Sets;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashSet;
import java.util.function.Supplier;

public class NMLBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, NoMansLand.MODID);

    public static LinkedHashSet<RegistryObject<Item>> CREATIVE_TAB_ITEMS = Sets.newLinkedHashSet();

    //Plants and Other Natural Decorations
    public static final RegistryObject<Block> GRASS_SPROUTS = registerBlock("grass_sprouts",
            () -> new GrassSproutsBlock(Block.Properties.copy(Blocks.FERN).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryObject<Block> OAT_GRASS = registerBlock("oat_grass",
            () -> new SimpleFoliageBlock(Block.Properties.copy(Blocks.FERN).offsetType(BlockBehaviour.OffsetType.XYZ)));

    public static final RegistryObject<Block> DRIED_GRASS = registerBlock("dried_grass",
            () -> new DesertPlantBlock(Block.Properties.copy(Blocks.DEAD_BUSH).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryObject<Block> FIDDLEHEAD = registerBlock("fiddlehead",
            () -> new SimpleFoliageBlock(Block.Properties.copy(Blocks.FERN).offsetType(BlockBehaviour.OffsetType.XYZ)));
    public static final RegistryObject<Block> CATTAIL = registerBlock("cattail",
            () -> new WaterDoublePlantBlock(Block.Properties.copy(Blocks.TALL_GRASS).offsetType(BlockBehaviour.OffsetType.XYZ)));
    public static final RegistryObject<Block> PEBBLES = registerBlock("pebbles",
            () -> new PebbleBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).noCollission().instabreak().sound(SoundType.STONE).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> YELLOW_BIRCH_LEAVES = registerBlock("yellow_birch_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_LEAVES)));
    public static final RegistryObject<Block> YELLOW_BIRCH_SAPLING = registerBlock("yellow_birch_sapling",
            () -> new SaplingBlock((new YellowBirchTreeGrower()), BlockBehaviour.Properties.copy(Blocks.BIRCH_SAPLING)));
    public static final RegistryObject<Block> POTTED_YELLOW_BIRCH_SAPLING = BLOCKS.register("potted_yellow_birch_sapling",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), NMLBlocks.YELLOW_BIRCH_SAPLING,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_BIRCH_SAPLING).noOcclusion()));
    public static final RegistryObject<Block> AUTUMNAL_OAK_LEAVES = registerBlock("autumnal_oak_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> AUTUMNAL_OAK_SAPLING = registerBlock("autumnal_oak_sapling",
            () -> new SaplingBlock((new AutumnalOakTreeGrower()), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_AUTUMNAL_OAK_SAPLING = BLOCKS.register("potted_autumnal_oak_sapling",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), NMLBlocks.AUTUMNAL_OAK_SAPLING,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING).noOcclusion()));

    public static final RegistryObject<Block> PALE_CHERRY_LEAVES = registerBlock("pale_cherry_leaves",
            () -> new ParticleLeavesBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_LEAVES), NMLParticleTypes.PALE_CHERRY_LEAVES));
    public static final RegistryObject<Block> PALE_CHERRY_SAPLING = registerBlock("pale_cherry_sapling",
            () -> new SaplingBlock((new PaleCherryTreeGrower()), BlockBehaviour.Properties.copy(Blocks.CHERRY_SAPLING)));
    public static final RegistryObject<Block> POTTED_PALE_CHERRY_SAPLING = BLOCKS.register("potted_pale_cherry_sapling",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), NMLBlocks.PALE_CHERRY_SAPLING,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_CHERRY_SAPLING).noOcclusion()));

//    public static final RegistryObject<Block> SHRUB = registerBlock("shrub",
//            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_LEAVES)));

    public static final RegistryObject<Block> ACONITE = registerBlock("aconite",
            () -> new FlowerBlock(MobEffects.MOVEMENT_SLOWDOWN, 20,BlockBehaviour.Properties.copy(Blocks.POPPY)));
    public static final RegistryObject<Block> POTTED_ACONITE = BLOCKS.register("potted_aconite",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), NMLBlocks.ACONITE,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY).noOcclusion()));
    public static final RegistryObject<Block> BLUE_LUPINE = registerBlock("blue_lupine",
            () -> new FlowerBlock(MobEffects.ABSORPTION, 5,BlockBehaviour.Properties.copy(Blocks.POPPY)));
    public static final RegistryObject<Block> POTTED_BLUE_LUPINE = BLOCKS.register("potted_blue_lupine",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), NMLBlocks.BLUE_LUPINE,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY).noOcclusion()));
    public static final RegistryObject<Block> RED_LUPINE = registerBlock("red_lupine",
            () -> new FlowerBlock(MobEffects.ABSORPTION, 5,BlockBehaviour.Properties.copy(Blocks.POPPY)));
    public static final RegistryObject<Block> POTTED_RED_LUPINE = BLOCKS.register("potted_red_lupine",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), NMLBlocks.RED_LUPINE,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY).noOcclusion()));
    public static final RegistryObject<Block> YELLOW_LUPINE = registerBlock("yellow_lupine",
            () -> new FlowerBlock(MobEffects.ABSORPTION, 5,BlockBehaviour.Properties.copy(Blocks.POPPY)));
    public static final RegistryObject<Block> POTTED_YELLOW_LUPINE = BLOCKS.register("potted_yellow_lupine",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), NMLBlocks.YELLOW_LUPINE,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY).noOcclusion()));
    public static final RegistryObject<Block> PINK_LUPINE = registerBlock("pink_lupine",
            () -> new FlowerBlock(MobEffects.ABSORPTION, 5,BlockBehaviour.Properties.copy(Blocks.POPPY)));
    public static final RegistryObject<Block> POTTED_PINK_LUPINE = BLOCKS.register("potted_pink_lupine",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), NMLBlocks.PINK_LUPINE,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY).noOcclusion()));
    public static final RegistryObject<Block> AUTUMN_CROCUS = registerBlock("autumn_crocus",
            () -> new FlowerBlock(MobEffects.BLINDNESS, 10,BlockBehaviour.Properties.copy(Blocks.POPPY)));
    public static final RegistryObject<Block> POTTED_AUTUMN_CROCUS = BLOCKS.register("potted_autumn_crocus",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), NMLBlocks.AUTUMN_CROCUS,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY).noOcclusion()));
    public static final RegistryObject<Block> WILD_MINT = registerBlock("wild_mint",
            () -> new FlowerBlock(MobEffects.SATURATION, 1,BlockBehaviour.Properties.copy(Blocks.POPPY)));
    public static final RegistryObject<Block> POTTED_WILD_MINT = BLOCKS.register("potted_wild_mint",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), NMLBlocks.WILD_MINT,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY).noOcclusion()));
    public static final RegistryObject<Block> RAFFLESIA = registerBlock("rafflesia",
            () -> new FlatFlowerBlock(BlockBehaviour.Properties.copy(Blocks.POPPY)));
    public static final RegistryObject<Block> BARREL_CACTUS = registerBlock("barrel_cactus",
            () -> new DesertPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.BIG_DRIPLEAF).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> POTTED_BARREL_CACTUS = BLOCKS.register("potted_barrel_cactus",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), NMLBlocks.BARREL_CACTUS,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY).noOcclusion()));
    public static final RegistryObject<Block> SUCCULENT = registerBlock("succulent",
            () -> new DesertPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.FLOWERING_AZALEA).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> POTTED_SUCCULENT = BLOCKS.register("potted_succulent",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), NMLBlocks.SUCCULENT,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY).noOcclusion()));
    public static final RegistryObject<Block> CUT_VINE = BLOCKS.register("cut_vine",
            () -> new VineBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).replaceable().noCollission().strength(0.2F).sound(SoundType.VINE).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> CUT_SUGAR_CANE = BLOCKS.register("cut_sugar_cane",
            () -> new CutSugarCaneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> CLOVER_PATCH = registerBlock("clover_patch",
            () -> new FlowerbedBlock(Block.Properties.of().mapColor(MapColor.PLANT).replaceable().noCollission().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WHITE_FLOWERBED = registerBlock("white_flowerbed",
            () -> new FlowerbedBlock(Block.Properties.of().mapColor(MapColor.PLANT).replaceable().noCollission().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> YELLOW_FLOWERBED = registerBlock("yellow_flowerbed",
            () -> new FlowerbedBlock(Block.Properties.of().mapColor(MapColor.PLANT).replaceable().noCollission().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> RED_FLOWERBED = registerBlock("red_flowerbed",
            () -> new FlowerbedBlock(Block.Properties.of().mapColor(MapColor.PLANT).replaceable().noCollission().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> BLUE_FLOWERBED = registerBlock("blue_flowerbed",
            () -> new FlowerbedBlock(Block.Properties.of().mapColor(MapColor.PLANT).replaceable().noCollission().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> VIOLET_FLOWERBED = registerBlock("violet_flowerbed",
            () -> new FlowerbedBlock(Block.Properties.of().mapColor(MapColor.PLANT).replaceable().noCollission().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    //Underground
    public static final RegistryObject<Block> QUARTZITE = registerBlock("quartzite",
            () -> new AmethystBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).strength(1.3F).sound(SoundType.NETHER_GOLD_ORE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BUDDING_QUARTZITE = registerBlock("budding_quartzite",
            () -> new BuddingQuartziteBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).randomTicks().strength(1.3F).sound(SoundType.NETHER_GOLD_ORE).requiresCorrectToolForDrops().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> QUARTZITE_CLUSTER = registerBlock("quartzite_cluster",
            () -> new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).forceSolidOn().noOcclusion().randomTicks().sound(SoundType.NETHER_GOLD_ORE).strength(1.3F).lightLevel((p_152632_) -> {
                return 5;
            }).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> SMALL_QUARTZITE_BUD = registerBlock("small_quartzite_bud",
            () -> new AmethystClusterBlock(3, 4, BlockBehaviour.Properties.copy(NMLBlocks.QUARTZITE_CLUSTER.get()).sound(SoundType.NETHER_GOLD_ORE).forceSolidOn().lightLevel((p_187409_) -> {
                return 1;
            }).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> MEDIUM_QUARTZITE_BUD = registerBlock("medium_quartzite_bud",
            () -> new AmethystClusterBlock(4, 3, BlockBehaviour.Properties.copy(NMLBlocks.QUARTZITE_CLUSTER.get()).sound(SoundType.NETHER_GOLD_ORE).forceSolidOn().lightLevel((p_152617_) -> {
                return 2;
            }).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> LARGE_QUARTZITE_BUD = registerBlock("large_quartzite_bud",
            () -> new AmethystClusterBlock(5, 3, BlockBehaviour.Properties.copy(NMLBlocks.QUARTZITE_CLUSTER.get()).sound(SoundType.NETHER_GOLD_ORE).forceSolidOn().lightLevel((p_152629_) -> {
                return 4;
            }).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> PETRIFIED_LOG = registerBlock("petrified_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final RegistryObject<Block> PETRIFIED_WOOD = registerBlock("petrified_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)));

    //Paths
    public static final RegistryObject<Block> DIRT_PATH = registerBlock("dirt_path",
            () -> new PathBlock(BlockBehaviour.Properties.copy(Blocks.DIRT), Blocks.DIRT, false));
    public static final RegistryObject<Block> MYCELIUM_PATH = registerBlock("mycelium_path",
            () -> new PathBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).strength(0.6F).sound(SoundType.GRASS), Blocks.DIRT, false));
    public static final RegistryObject<Block> PODZOL_PATH = registerBlock("podzol_path",
            () -> new PathBlock(BlockBehaviour.Properties.copy(Blocks.PODZOL), Blocks.PODZOL, false));
    public static final RegistryObject<Block> SNOWY_GRASS_PATH = registerBlock("snowy_grass_path",
            () -> new PathBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).strength(0.6F).sound(SoundType.GRASS), Blocks.DIRT, false));
    public static final RegistryObject<Block> SNOW_PATH = registerBlock("snow_path",
            () -> new PathBlock(BlockBehaviour.Properties.copy(Blocks.SNOW_BLOCK), Blocks.SNOW_BLOCK, false));
    public static final RegistryObject<Block> GRAVEL_PATH = registerBlock("gravel_path",
            () -> new PathBlock(BlockBehaviour.Properties.copy(Blocks.GRAVEL), Blocks.GRAVEL, true));
    public static final RegistryObject<Block> SAND_PATH = registerBlock("sand_path",
            () -> new PathBlock(BlockBehaviour.Properties.copy(Blocks.SAND), Blocks.SAND, true));
    public static final RegistryObject<Block> RED_SAND_PATH = registerBlock("red_sand_path",
            () -> new PathBlock(BlockBehaviour.Properties.copy(Blocks.RED_SAND), Blocks.RED_SAND, true));

    //Decorations
    public static final RegistryObject<Block> SCONCE_TORCH = BLOCKS.register("sconce_torch",
            () -> new SconceTorchBlock(BlockBehaviour.Properties.copy(Blocks.TORCH).sound(SoundType.LANTERN), ParticleTypes.FLAME));
    public static final RegistryObject<Block> SCONCE_WALL_TORCH = BLOCKS.register("sconce_wall_torch",
            () -> new SconceWallTorchBlock(BlockBehaviour.Properties.copy(Blocks.WALL_TORCH).sound(SoundType.LANTERN), ParticleTypes.FLAME));
    public static final RegistryObject<Block> SCONCE_SOUL_TORCH = BLOCKS.register("sconce_soul_torch",
            () -> new SconceTorchBlock(BlockBehaviour.Properties.copy(Blocks.SOUL_TORCH).sound(SoundType.LANTERN), ParticleTypes.SOUL_FIRE_FLAME));
    public static final RegistryObject<Block> SCONCE_SOUL_WALL_TORCH = BLOCKS.register("sconce_soul_wall_torch",
            () -> new SconceWallTorchBlock(BlockBehaviour.Properties.copy(Blocks.SOUL_WALL_TORCH).sound(SoundType.LANTERN), ParticleTypes.SOUL_FIRE_FLAME));

    public static final RegistryObject<Block> EXTINGUISHED_TORCH = BLOCKS.register("extinguished_torch",
            () -> new ExtinguishedTorchBlock(BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY), Blocks.TORCH, ParticleTypes.FLAME));
    public static final RegistryObject<Block> EXTINGUISHED_WALL_TORCH = BLOCKS.register("extinguished_wall_torch",
            () -> new ExtinguishedWallTorchBlock(BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY), Blocks.WALL_TORCH, ParticleTypes.FLAME));
    public static final RegistryObject<Block> EXTINGUISHED_SOUL_TORCH = BLOCKS.register("extinguished_soul_torch",
            () -> new ExtinguishedTorchBlock(BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY), Blocks.SOUL_TORCH, ParticleTypes.SOUL_FIRE_FLAME));
    public static final RegistryObject<Block> EXTINGUISHED_SOUL_WALL_TORCH = BLOCKS.register("extinguished_soul_wall_torch",
            () -> new ExtinguishedWallTorchBlock(BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY), Blocks.SOUL_WALL_TORCH, ParticleTypes.SOUL_FIRE_FLAME));
    public static final RegistryObject<Block> EXTINGUISHED_SCONCE_TORCH = BLOCKS.register("extinguished_sconce_torch",
            () -> new ExtinguishedSconceTorchBlock(BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.LANTERN).pushReaction(PushReaction.DESTROY), NMLBlocks.SCONCE_TORCH.get(), ParticleTypes.FLAME));
    public static final RegistryObject<Block> EXTINGUISHED_SCONCE_WALL_TORCH = BLOCKS.register("extinguished_sconce_wall_torch",
            () -> new ExtinguishedSconceWallTorchBlock(BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.LANTERN).pushReaction(PushReaction.DESTROY), NMLBlocks.SCONCE_WALL_TORCH.get(), ParticleTypes.FLAME));
    public static final RegistryObject<Block> EXTINGUISHED_SCONCE_SOUL_TORCH = BLOCKS.register("extinguished_sconce_soul_torch",
            () -> new ExtinguishedSconceTorchBlock(BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.LANTERN).pushReaction(PushReaction.DESTROY), NMLBlocks.SCONCE_SOUL_TORCH.get(), ParticleTypes.SOUL_FIRE_FLAME));
    public static final RegistryObject<Block> EXTINGUISHED_SCONCE_SOUL_WALL_TORCH = BLOCKS.register("extinguished_sconce_soul_wall_torch",
            () -> new ExtinguishedSconceWallTorchBlock(BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.LANTERN).pushReaction(PushReaction.DESTROY), NMLBlocks.SCONCE_SOUL_WALL_TORCH.get(), ParticleTypes.SOUL_FIRE_FLAME));
    public static final RegistryObject<Block> WOODEN_SCAFFOLDING = BLOCKS.register("wooden_scaffolding",
            () -> new WoodenScaffoldingBlock(Block.Properties.copy(Blocks.SCAFFOLDING).sound(SoundType.CHERRY_WOOD)));
    //Dungeon
    public static final RegistryObject<Block> REMAINS = registerBlock("remains",
            () -> new RemainsBlock(Blocks.COARSE_DIRT, BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).instrument(NoteBlockInstrument.SNARE).strength(0.25F).sound(SoundType.SUSPICIOUS_SAND).pushReaction(PushReaction.DESTROY), SoundEvents.BRUSH_SAND, SoundEvents.BRUSH_SAND_COMPLETED));
    //Tiles
    public static final RegistryObject<Block> MUNDANE_TILES = registerBlock("mundane_tiles",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));
    public static final RegistryObject<Block> EARTHEN_TILES = registerBlock("earthen_tiles",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));
    //Stone
    public static final RegistryObject<Block> FADED_STONE_BRICKS = registerBlock("faded_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));
    public static final RegistryObject<Block> POLISHED_STONE = registerBlock("polished_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));
    public static final RegistryObject<Block> POLISHED_STONE_STAIRS = registerBlock("polished_stone_stairs",
            () -> new StairBlock(() -> POLISHED_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(NMLBlocks.POLISHED_STONE.get())));
    public static final RegistryObject<Block> POLISHED_STONE_SLAB = registerBlock("polished_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(NMLBlocks.POLISHED_STONE.get())));

    public static final RegistryObject<Block> COBBLESTONE_BRICKS = registerBlock("cobblestone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> COBBLESTONE_BRICK_STAIRS = registerBlock("cobblestone_brick_stairs",
            () -> new StairBlock(() -> COBBLESTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(NMLBlocks.COBBLESTONE_BRICKS.get())));
    public static final RegistryObject<Block> COBBLESTONE_BRICK_SLAB = registerBlock("cobblestone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(NMLBlocks.COBBLESTONE_BRICKS.get())));
    public static final RegistryObject<Block> COBBLESTONE_BRICK_WALL = registerBlock("cobblestone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(NMLBlocks.COBBLESTONE_BRICKS.get())));

    public static final RegistryObject<Block> MOSSY_COBBLESTONE_BRICKS = registerBlock("mossy_cobblestone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE)));
    public static final RegistryObject<Block> MOSSY_COBBLESTONE_BRICK_STAIRS = registerBlock("mossy_cobblestone_brick_stairs",
            () -> new StairBlock(() -> MOSSY_COBBLESTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(NMLBlocks.MOSSY_COBBLESTONE_BRICKS.get())));
    public static final RegistryObject<Block> MOSSY_COBBLESTONE_BRICK_SLAB = registerBlock("mossy_cobblestone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(NMLBlocks.MOSSY_COBBLESTONE_BRICKS.get())));
    public static final RegistryObject<Block> MOSSY_COBBLESTONE_BRICK_WALL = registerBlock("mossy_cobblestone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(NMLBlocks.MOSSY_COBBLESTONE_BRICKS.get())));


    //Trimmed Planks and Bookshelves
    public static final RegistryObject<Block> TRIMMED_OAK_PLANKS = registerBlock("trimmed_oak_planks",
            () -> new TrimmedPlankBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> SPRUCE_BOOKSHELF = registerBlock("spruce_bookshelf",
            () -> new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF)));
    public static final RegistryObject<Block> TRIMMED_SPRUCE_PLANKS = registerBlock("trimmed_spruce_planks",
            () -> new TrimmedPlankBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final RegistryObject<Block> BIRCH_BOOKSHELF = registerBlock("birch_bookshelf",
            () -> new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF)));
    public static final RegistryObject<Block> TRIMMED_BIRCH_PLANKS = registerBlock("trimmed_birch_planks",
            () -> new TrimmedPlankBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final RegistryObject<Block> JUNGLE_BOOKSHELF = registerBlock("jungle_bookshelf",
            () -> new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF)));
    public static final RegistryObject<Block> TRIMMED_JUNGLE_PLANKS = registerBlock("trimmed_jungle_planks",
            () -> new TrimmedPlankBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final RegistryObject<Block> DARK_OAK_BOOKSHELF = registerBlock("dark_oak_bookshelf",
            () -> new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF)));
    public static final RegistryObject<Block> TRIMMED_DARK_OAK_PLANKS = registerBlock("trimmed_dark_oak_planks",
            () -> new TrimmedPlankBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final RegistryObject<Block> ACACIA_BOOKSHELF = registerBlock("acacia_bookshelf",
            () -> new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF)));
    public static final RegistryObject<Block> TRIMMED_ACACIA_PLANKS = registerBlock("trimmed_acacia_planks",
            () -> new TrimmedPlankBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final RegistryObject<Block> MANGROVE_BOOKSHELF = registerBlock("mangrove_bookshelf",
            () -> new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF)));
    public static final RegistryObject<Block> TRIMMED_MANGROVE_PLANKS = registerBlock("trimmed_mangrove_planks",
            () -> new TrimmedPlankBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final RegistryObject<Block> CHERRY_BOOKSHELF = registerBlock("cherry_bookshelf",
            () -> new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF)));
    public static final RegistryObject<Block> TRIMMED_CHERRY_PLANKS = registerBlock("trimmed_cherry_planks",
            () -> new TrimmedPlankBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final RegistryObject<Block> WARPED_BOOKSHELF = registerBlock("warped_bookshelf",
            () -> new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF)));
    public static final RegistryObject<Block> TRIMMED_WARPED_PLANKS = registerBlock("trimmed_warped_planks",
            () -> new TrimmedPlankBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final RegistryObject<Block> CRIMSON_BOOKSHELF = registerBlock("crimson_bookshelf",
            () -> new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF)));
    public static final RegistryObject<Block> TRIMMED_CRIMSON_PLANKS = registerBlock("trimmed_crimson_planks",
            () -> new TrimmedPlankBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final RegistryObject<Block> BAMBOO_BOOKSHELF = registerBlock("bamboo_bookshelf",
            () -> new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF)));
    public static final RegistryObject<Block> TRIMMED_BAMBOO_PLANKS = registerBlock("trimmed_bamboo_planks",
            () -> new TrimmedPlankBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS)));

    //Pine
    public static final RegistryObject<Block> PINE_PLANKS = registerBlock("pine_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> PINE_STAIRS = registerBlock("pine_stairs",
            () -> new StairBlock(() -> PINE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(NMLBlocks.PINE_PLANKS.get())));
    public static final RegistryObject<Block> PINE_SLAB = registerBlock("pine_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(NMLBlocks.PINE_PLANKS.get())));
    public static final RegistryObject<Block> PINE_LOG = registerBlock("pine_log",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> PINE_WOOD = registerBlock("pine_wood",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_PINE_LOG = registerBlock("stripped_pine_log",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_PINE_WOOD = registerBlock("stripped_pine_wood",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> PINE_FENCE = registerBlock("pine_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<Block> PINE_FENCE_GATE = registerBlock("pine_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), NMLWoodTypes.PINE));
    public static final RegistryObject<Block> PINE_LEAVES = registerBlock("pine_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> PINE_SAPLING = registerBlock("pine_sapling",
            () -> new SaplingBlock((new PineTreeGrower()), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_PINE_SAPLING = BLOCKS.register("potted_pine_sapling",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), NMLBlocks.PINE_SAPLING,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING).noOcclusion()));
    public static final RegistryObject<Block> PINE_BUTTON = registerBlock("pine_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON),
                    NMLBlockSetTypes.PINE, 15, true));
    public static final RegistryObject<Block> PINE_PRESSURE_PLATE = registerBlock("pine_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), NMLBlockSetTypes.PINE));
    public static final RegistryObject<Block> PINE_DOOR = registerBlock("pine_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), NMLBlockSetTypes.PINE));
    public static final RegistryObject<Block> PINE_TRAPDOOR = registerBlock("pine_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), NMLBlockSetTypes.PINE));
    public static final RegistryObject<Block> PINE_SIGN = BLOCKS.register("pine_sign",
            () -> new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), NMLWoodTypes.PINE));
    public static final RegistryObject<Block> PINE_WALL_SIGN = BLOCKS.register("pine_wall_sign",
            () -> new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), NMLWoodTypes.PINE));
    public static final RegistryObject<Block> PINE_HANGING_SIGN = BLOCKS.register("pine_hanging_sign",
            () -> new HangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), NMLWoodTypes.PINE));
    public static final RegistryObject<Block> PINE_HANGING_WALL_SIGN = BLOCKS.register("pine_wall_hanging_sign",
            () -> new WallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), NMLWoodTypes.PINE));
    public static final RegistryObject<Block> PINE_BOOKSHELF = registerBlock("pine_bookshelf",
            () -> new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF)));
    public static final RegistryObject<Block> TRIMMED_PINE_PLANKS = registerBlock("trimmed_pine_planks",
            () -> new TrimmedPlankBlock(BlockBehaviour.Properties.copy(NMLBlocks.PINE_PLANKS.get())));
    public static final RegistryObject<Block> PINE_CABINET = registerIntegrationBlock("pine_cabinet",
            !ModList.get().isLoaded("farmersdelight") ?
                    () -> new Block(BlockBehaviour.Properties.copy(Blocks.BARREL)) : FDIntegration.cabinetBlock(), "farmersdelight", true);

    //Maple
    public static final RegistryObject<Block> MAPLE_PLANKS = registerBlock("maple_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> MAPLE_STAIRS = registerBlock("maple_stairs",
            () -> new StairBlock(() -> MAPLE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(NMLBlocks.MAPLE_PLANKS.get())));
    public static final RegistryObject<Block> MAPLE_SLAB = registerBlock("maple_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(NMLBlocks.MAPLE_PLANKS.get())));
    public static final RegistryObject<Block> MAPLE_LOG = registerBlock("maple_log",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> MAPLE_WOOD = registerBlock("maple_wood",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_MAPLE_LOG = registerBlock("stripped_maple_log",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_MAPLE_WOOD = registerBlock("stripped_maple_wood",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> MAPLE_FENCE = registerBlock("maple_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<Block> MAPLE_FENCE_GATE = registerBlock("maple_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), NMLWoodTypes.MAPLE));
    public static final RegistryObject<Block> MAPLE_LEAVES = registerBlock("maple_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> MAPLE_SAPLING = registerBlock("maple_sapling",
            () -> new SaplingBlock((new MapleTreeGrower()), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_MAPLE_SAPLING = BLOCKS.register("potted_maple_sapling",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), NMLBlocks.MAPLE_SAPLING,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING).noOcclusion()));
    public static final RegistryObject<Block> RED_MAPLE_LEAVES = registerBlock("red_maple_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> RED_MAPLE_SAPLING = registerBlock("red_maple_sapling",
            () -> new SaplingBlock((new RedMapleTreeGrower()), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_RED_MAPLE_SAPLING = BLOCKS.register("potted_red_maple_sapling",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), NMLBlocks.RED_MAPLE_SAPLING,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING).noOcclusion()));
    public static final RegistryObject<Block> MAPLE_BUTTON = registerBlock("maple_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON),
                    NMLBlockSetTypes.MAPLE, 15, true));
    public static final RegistryObject<Block> MAPLE_PRESSURE_PLATE = registerBlock("maple_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), NMLBlockSetTypes.MAPLE));
    public static final RegistryObject<Block> MAPLE_DOOR = registerBlock("maple_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), NMLBlockSetTypes.MAPLE));
    public static final RegistryObject<Block> MAPLE_TRAPDOOR = registerBlock("maple_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), NMLBlockSetTypes.MAPLE));
    public static final RegistryObject<Block> MAPLE_SIGN = BLOCKS.register("maple_sign",
            () -> new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), NMLWoodTypes.MAPLE));
    public static final RegistryObject<Block> MAPLE_WALL_SIGN = BLOCKS.register("maple_wall_sign",
            () -> new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), NMLWoodTypes.MAPLE));
    public static final RegistryObject<Block> MAPLE_HANGING_SIGN = BLOCKS.register("maple_hanging_sign",
            () -> new HangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), NMLWoodTypes.MAPLE));
    public static final RegistryObject<Block> MAPLE_HANGING_WALL_SIGN = BLOCKS.register("maple_wall_hanging_sign",
            () -> new WallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), NMLWoodTypes.MAPLE));
    public static final RegistryObject<Block> MAPLE_BOOKSHELF = registerBlock("maple_bookshelf",
            () -> new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF)));
    public static final RegistryObject<Block> TRIMMED_MAPLE_PLANKS = registerBlock("trimmed_maple_planks",
            () -> new TrimmedPlankBlock(BlockBehaviour.Properties.copy(NMLBlocks.MAPLE_PLANKS.get())));
    public static final RegistryObject<Block> MAPLE_CABINET = registerIntegrationBlock("maple_cabinet",
            ModList.get().isLoaded("farmersdelight") == false ?
                    () -> new Block(BlockBehaviour.Properties.copy(Blocks.BARREL)) : FDIntegration.cabinetBlock(), "farmersdelight", true);

    //Walnut
    public static final RegistryObject<Block> WALNUT_PLANKS = registerBlock("walnut_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> WALNUT_STAIRS = registerBlock("walnut_stairs",
            () -> new StairBlock(() -> WALNUT_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(NMLBlocks.WALNUT_PLANKS.get())));
    public static final RegistryObject<Block> WALNUT_SLAB = registerBlock("walnut_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(NMLBlocks.WALNUT_PLANKS.get())));
    public static final RegistryObject<Block> WALNUT_LOG = registerBlock("walnut_log",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> WALNUT_WOOD = registerBlock("walnut_wood",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_WALNUT_LOG = registerBlock("stripped_walnut_log",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_WALNUT_WOOD = registerBlock("stripped_walnut_wood",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> WALNUT_FENCE = registerBlock("walnut_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<Block> WALNUT_FENCE_GATE = registerBlock("walnut_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), NMLWoodTypes.WALNUT));
    public static final RegistryObject<Block> WALNUT_LEAVES = registerBlock("walnut_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> WALNUT_SAPLING = registerBlock("walnut_sapling",
            () -> new SaplingBlock((new WalnutTreeGrower()), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_WALNUT_SAPLING = BLOCKS.register("potted_walnut_sapling",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), NMLBlocks.WALNUT_SAPLING,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING).noOcclusion()));
    public static final RegistryObject<Block> WALNUT_BUTTON = registerBlock("walnut_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON),
                    NMLBlockSetTypes.WALNUT, 15, true));
    public static final RegistryObject<Block> WALNUT_PRESSURE_PLATE = registerBlock("walnut_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), NMLBlockSetTypes.WALNUT));
    public static final RegistryObject<Block> WALNUT_DOOR = registerBlock("walnut_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), NMLBlockSetTypes.WALNUT));
    public static final RegistryObject<Block> WALNUT_TRAPDOOR = registerBlock("walnut_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), NMLBlockSetTypes.WALNUT));
    public static final RegistryObject<Block> WALNUT_SIGN = BLOCKS.register("walnut_sign",
            () -> new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), NMLWoodTypes.WALNUT));
    public static final RegistryObject<Block> WALNUT_WALL_SIGN = BLOCKS.register("walnut_wall_sign",
            () -> new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), NMLWoodTypes.WALNUT));
    public static final RegistryObject<Block> WALNUT_HANGING_SIGN = BLOCKS.register("walnut_hanging_sign",
            () -> new HangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), NMLWoodTypes.WALNUT));
    public static final RegistryObject<Block> WALNUT_HANGING_WALL_SIGN = BLOCKS.register("walnut_wall_hanging_sign",
            () -> new WallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), NMLWoodTypes.WALNUT));
    public static final RegistryObject<Block> WALNUT_BOOKSHELF = registerBlock("walnut_bookshelf",
            () -> new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF)));
    public static final RegistryObject<Block> TRIMMED_WALNUT_PLANKS = registerBlock("trimmed_walnut_planks",
            () -> new TrimmedPlankBlock(BlockBehaviour.Properties.copy(NMLBlocks.WALNUT_PLANKS.get())));
    public static final RegistryObject<Block> WALNUT_CABINET = registerIntegrationBlock("walnut_cabinet",
            !ModList.get().isLoaded("farmersdelight") ?
                    () -> new Block(BlockBehaviour.Properties.copy(Blocks.BARREL)) : FDIntegration.cabinetBlock(), "farmersdelight", true);

    //Tapping
    public static final RegistryObject<Block> TAP = registerBlock("tap",
            () -> new TapBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).noOcclusion().strength(2.0F).randomTicks().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> RESIN_CAULDRON = BLOCKS.register("resin_cauldron",
            () -> new ResinCauldronBlock(BlockBehaviour.Properties.copy(Blocks.CAULDRON), null, CauldronInteraction.EMPTY));


    //Storage
    public static final RegistryObject<Block> COD_BARREL = registerBlock("cod_barrel",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> SALMON_BARREL = registerBlock("salmon_barrel",
            () -> new Block(BlockBehaviour.Properties.copy(NMLBlocks.COD_BARREL.get())));
    public static final RegistryObject<Block> PUFFERFISH_BARREL = registerBlock("pufferfish_barrel",
            () -> new Block(BlockBehaviour.Properties.copy(NMLBlocks.COD_BARREL.get())));
    public static final RegistryObject<Block> TROPICAL_FISH_BARREL = registerBlock("tropical_fish_barrel",
            () -> new Block(BlockBehaviour.Properties.copy(NMLBlocks.COD_BARREL.get())));

    //Mushrooms
    public static final RegistryObject<Block> FIELD_MUSHROOM = registerBlock("field_mushroom",
            () -> new SurfaceMushroomBlock((BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM).mapColor(MapColor.TERRACOTTA_WHITE)), HugeMushrooms.HUGE_FIELD_MUSHROOM));
    public static final RegistryObject<Block> FIELD_MUSHROOM_COLONY = registerIntegrationBlock("field_mushroom_colony",
            !ModList.get().isLoaded("farmersdelight") ? () -> new Block(BlockBehaviour.Properties.copy(NMLBlocks.FIELD_MUSHROOM.get()))
                    : FDIntegration.mushroomColony(), "farmersdelight", false);

    public static final RegistryObject<Block> FIELD_MUSHROOM_BLOCK = registerBlock("field_mushroom_block",
            () -> new HugeMushroomBlock((BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM_BLOCK))));
    public static final RegistryObject<Block> POTTED_FIELD_MUSHROOM = BLOCKS.register("potted_field_mushroom",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), NMLBlocks.FIELD_MUSHROOM,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        CREATIVE_TAB_ITEMS.add(registerBlockItem(name, toReturn));
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerIntegrationBlock(String name, Supplier<T> block, String modId, Boolean blockItem) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        if (ModList.get().isLoaded(modId) && blockItem == true) {
            CREATIVE_TAB_ITEMS.add(registerIntegrationBlockItem(name, toReturn));
        }
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return NMLItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> RegistryObject<Item> registerIntegrationBlockItem(String name, RegistryObject<T> block) {
        return NMLItems.ITEMS.register(name, !ModList.get().isLoaded("farmersdelight") ? () -> new MissingIntegrationBlock(block.get(), new Item.Properties()) : () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
