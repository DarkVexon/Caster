package code.util;

import code.cards.spells.*;
import code.patches.EnchantedCardsPatch;
import com.badlogic.gdx.graphics.Color;
import com.blanktheevil.rarecardssparkle.RareCardsSparkle;
import com.blanktheevil.rarecardssparkle.SparkleTimer;
import com.megacrit.cardcrawl.helpers.ImageMaster;

import static code.ModFile.makeID;

public class SparkleHandler {
    public static final float TIMER_START = 0.1F;
    public static final float TIMER_END = 0.15F;

    public static void init() {
        RareCardsSparkle.addSparkleRule(
                makeID("FireSparkle"),
                "Spell Sparkles - Fire",
                new Color(1f, 0.2f, 0.2f, 0f),
                ImageMaster.GLOW_SPARK_2,
                true,
                new SparkleTimer(TIMER_START, TIMER_END),
                card -> card.cardID.equals(BurningStudy.ID));
        RareCardsSparkle.addSparkleRule(
                makeID("BrightSparkle"),
                "Spell Sparkles - Light",
                new Color(1f, 1f, 1f, 0f),
                ImageMaster.GLOW_SPARK_2,
                true,
                new SparkleTimer(TIMER_START, TIMER_END),
                card -> card.cardID.equals(Brightblind.ID));
        RareCardsSparkle.addSparkleRule(
                makeID("IceSparkle"),
                "Spell Sparkles - Ice",
                new Color(0.2f, 0.2f, 1f, 0f),
                ImageMaster.GLOW_SPARK_2,
                true,
                new SparkleTimer(TIMER_START, TIMER_END),
                card -> card.cardID.equals(Cryostasis.ID));
        RareCardsSparkle.addSparkleRule(
                makeID("DarkSparkle"),
                "Spell Sparkles - Dark",
                new Color(0.66f, 0.0f, 0.66f, 0f),
                ImageMaster.GLOW_SPARK_2,
                true,
                new SparkleTimer(TIMER_START, TIMER_END),
                card -> card.cardID.equals(Darkleech.ID));
        RareCardsSparkle.addSparkleRule(
                makeID("ElectroSparkle"),
                "Spell Sparkles - Electric",
                new Color(1f, 1f, 0.2f, 0f),
                ImageMaster.GLOW_SPARK_2,
                true,
                new SparkleTimer(TIMER_START, TIMER_END),
                card -> card.cardID.equals(Thunderbolt.ID));
        RareCardsSparkle.addSparkleRule(
                makeID("EarthSparkle"),
                "Spell Sparkles - Earth",
                new Color(0.0f, 1f, 0.2f, 0f),
                ImageMaster.GLOW_SPARK_2,
                true,
                new SparkleTimer(TIMER_START, TIMER_END),
                card -> card.cardID.equals(Withervine.ID));
        RareCardsSparkle.addSparkleRule(
                makeID("EnchantedSparkle"),
                "Enchanted Card Sparkles",
                new Color(0.8F, 0.0F, 0.5F, 0F),
                ImageMaster.GLOW_SPARK,
                true,
                new SparkleTimer(TIMER_START, TIMER_END),
                card -> EnchantedCardsPatch.isEnchanted(card));
    }
}
