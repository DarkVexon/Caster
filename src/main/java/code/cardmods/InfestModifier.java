package code.cardmods;

import basemod.abstracts.AbstractCardModifier;
import basemod.helpers.CardModifierManager;
import code.cards.OnInfestCard;
import code.util.TexLoader;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.FontHelper;

import java.util.ArrayList;

public class InfestModifier extends AbstractCardModifier {

    public static String MOD_ID = "caster:Infest";

    private int infestCounter = 0;
    private static final Texture infestIcon = TexLoader.getTexture("casterResources/images/ui/infestIcon.png");

    @Override
    public boolean isInherent(AbstractCard card) {
        return true;
    }

    @Override
    public void atEndOfTurn(AbstractCard card, CardGroup group) {
        if (group.equals(AbstractDungeon.player.hand)) {
            AbstractDungeon.player.hand.moveToDeck(card, true);
            infestCounter += 1;
            if (card instanceof OnInfestCard) {
                ((OnInfestCard) card).onInfest(infestCounter);
            }
        }
    }

    @Override
    public void onRender(AbstractCard card, SpriteBatch sb) {
        sb.draw(infestIcon, card.current_x - (133.0F * card.drawScale * Settings.scale), card.current_y + (133.0F * card.drawScale * Settings.scale), 0, 0, 64F, 64F, Settings.xScale, Settings.yScale, card.angle, 0, 0, 64, 64, false, false);
        FontHelper.renderRotatedText(sb, FontHelper.cardEnergyFont_L, Integer.toString(infestCounter), card.current_x, card.current_y, -133.0F * card.drawScale * Settings.scale, 133.0F * card.drawScale * Settings.scale, card.angle, false, Color.WHITE.cpy());
    }

    @Override
    public String identifier(AbstractCard card) {
        return MOD_ID;
    }

    @Override
    public boolean shouldApply(AbstractCard card) {
        return !CardModifierManager.hasModifier(card, InfestModifier.MOD_ID);
    }

    @Override
    public AbstractCardModifier makeCopy() {
        return new InfestModifier();
    }

    public static int getInfestCount(AbstractCard card) {
        if (CardModifierManager.hasModifier(card, MOD_ID)) {
            ArrayList<AbstractCardModifier> mods = CardModifierManager.getModifiers(card, MOD_ID);
            AbstractCardModifier mod = mods.get(0);
            if (mod instanceof InfestModifier) {
                return ((InfestModifier) mod).infestCounter;
            }
        }
        return -1;
    }
}
