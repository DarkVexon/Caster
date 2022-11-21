package code.cardmods;

import basemod.abstracts.AbstractCardModifier;
import basemod.helpers.CardModifierManager;
import code.cards.other.Bug;
import code.powers.OnInfestPower;
import code.util.Wiz;
import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndAddToHandEffect;

public class InfestModifier extends AbstractCardModifier {

    public static String MOD_ID = "caster:Infest";

    // private static final TextureAtlas.AtlasRegion infestImage = ImageHelper.asAtlasRegion(TexLoader.getTexture("casterResources/images/ui/infestIcon.png"));

    @Override
    public boolean isInherent(AbstractCard card) {
        return true;
    }

    @Override
    public void atEndOfTurn(AbstractCard card, CardGroup group) {
        if (group.equals(AbstractDungeon.player.hand)) {
            Wiz.atb(new AbstractGameAction() {
                @Override
                public void update() {
                    isDone = true;
                    card.superFlash(Color.GREEN.cpy());
                    AbstractDungeon.player.hand.moveToDeck(card, true);
                    for (AbstractPower p : AbstractDungeon.player.powers) {
                        if (p instanceof OnInfestPower) {
                            ((OnInfestPower) p).onInfest(card); //TODO: Clean this gross up
                        }
                    }
                    AbstractDungeon.effectList.add(new ShowCardAndAddToHandEffect(new Bug()));
                }
            });
        }
    }

//    @Override
//    public void onRender(AbstractCard card, SpriteBatch sb) {
//        if (Wiz.isInCombat()) {
//            Color color = Color.WHITE.cpy();
//            color.a = card.transparency;
//            sb.setColor(color);
//            sb.draw(infestImage, card.current_x + infestImage.offsetX - (float) infestImage.originalWidth / 2.0F, card.current_y + infestImage.offsetY - (float) infestImage.originalHeight / 2.0F, (float) infestImage.originalWidth / 2.0F - infestImage.offsetX, (float) infestImage.originalHeight / 2.0F - infestImage.offsetY, (float) infestImage.packedWidth, (float) infestImage.packedHeight, card.drawScale * Settings.scale, card.drawScale * Settings.scale, card.angle);
//            FontHelper.cardEnergyFont_L.getData().setScale(card.drawScale);
//            FontHelper.renderRotatedText(sb, FontHelper.cardEnergyFont_L, Integer.toString(infestCounter), card.current_x, card.current_y, -133.0F * card.drawScale * Settings.scale, 115.0F * card.drawScale * Settings.scale, card.angle, false, Color.WHITE.cpy());
//        }
//    }

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
}
