package code.patches;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.evacipated.cardcrawl.modthespire.lib.SpireField;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;

import java.util.ArrayList;

public class EnchantedCardsPatch {
    private static ArrayList<AbstractCard> enchantedCards = new ArrayList<>();

    @SpirePatch(
            clz = AbstractCard.class,
            method = SpirePatch.CLASS
    )
    public static class EnchantedField {
        public static SpireField<Boolean> enchanted = new SpireField<>(() -> false);
    }

    public static boolean isEnchanted(AbstractCard card) {
        return EnchantedField.enchanted.get(card);
    }

    public static void enchant(AbstractCard card) {
        EnchantedField.enchanted.set(card, true);
        enchantedCards.add(card);
    }

    public static void resetEnchantedCards() {
        enchantedCards.forEach(q -> EnchantedField.enchanted.set(q, false));
        enchantedCards.clear();
    }

    @SpirePatch(
            clz = AbstractCard.class,
            method = "makeStatEquivalentCopy"
    )
    public static class FoilCopies {
        public static AbstractCard Postfix(AbstractCard __result, AbstractCard __instance) {
            if (isEnchanted(__instance)) {
                enchant(__result);
            }

            return __result;
        }
    }

    public static float time = 0.0F;
    private static ShaderProgram shader = null;

    private static void initShader() {
        try {
            shader = new ShaderProgram(
                    Gdx.files.internal("casterResources/shaders/vertex.vs"),
                    Gdx.files.internal("casterResources/shaders/fragment.fs"));
            if (!shader.isCompiled()) {
                System.err.println(shader.getLog());
            }
            if (shader.getLog().length() > 0) {
                System.out.println(shader.getLog());
            }
        } catch (GdxRuntimeException e) {
            System.out.println("ERROR: Failed to rainbow Enchanted card");
            e.printStackTrace();
        }
    }

    @SpirePatch(clz = AbstractCard.class,
            method = "renderTitle")
    public static class RainbowEnchantedCards {
        private static ShaderProgram oldShader;

        public static void Prefix(AbstractCard __instance, SpriteBatch sb) {
            if (isEnchanted(__instance)) {
                if (shader == null) {
                    initShader();
                }
                oldShader = sb.getShader();
                sb.setShader(shader);
                shader.setUniformf("u_time", time);
                shader.setUniformf("u_strength", 0.4F);
                shader.setUniformf("u_speed", 0.25F);
                shader.setUniformf("u_angle", 0.0F);
                shader.setUniformf("u_width", 0.05F);
            }
        }

        public static void Postfix(AbstractCard __instance, SpriteBatch sb) {
            if (isEnchanted(__instance)) {
                sb.setShader(oldShader);
            }
        }
    }
}
