package code.ui;

import code.cards.spells.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.CardLibrary;

import java.util.ArrayList;

public class OrbitingSpells {

    private static final float X_DIST = 300F;
    private static final float Y_DIST = 80F;
    private static final float DIST_BETWEEN_CARDS = MathUtils.PI2;
    private static final float TIME_MULT = 0.5F;
    private static final float SPELL_SIZE = 0.5F;
    private static final float SPELL_TRANSPARENCY = 0.5F;

    private static ArrayList<String> spells = new ArrayList<>();
    private static ArrayList<CardRenderInfo> spellCards = new ArrayList<>();

    static {
        spells.add(BurningStudy.ID);
        spells.add(Cryostasis.ID);
        spells.add(Thunderbolt.ID);
        spells.add(Withervine.ID);
        spells.add(Brightblind.ID);
        spells.add(Darkleech.ID);
    }

    public static void atBattleStart() {
        for (int i = 0; i < spells.size(); i++) {
            AbstractCard card = CardLibrary.getCard(spells.get(i)).makeCopy();
            float idx = ((float) i / (float) spells.size()) * DIST_BETWEEN_CARDS;
            spellCards.add(new CardRenderInfo(card, idx));
        }
    }

    public static void update() {
        for (CardRenderInfo c : spellCards) {
            c.time += Gdx.graphics.getDeltaTime() * TIME_MULT;
            c.updateXPos();
            c.updateYPos();
            c.card.update();
        }
    }

    public static void prePlayerRender(SpriteBatch sb) {
        for (CardRenderInfo c : spellCards) {
            if (c.renderBehind) {
                c.card.render(sb);
            }
        }
    }

    public static void postPlayerRender(SpriteBatch sb) {
        for (CardRenderInfo c : spellCards) {
            if (!c.renderBehind) {
                c.card.render(sb);
            }
        }
    }

    public static class CardRenderInfo {
        public boolean renderBehind;
        private float time;
        public AbstractCard card;

        public CardRenderInfo(AbstractCard card, float time) {
            card.targetDrawScale = card.drawScale = SPELL_SIZE;
            card.targetTransparency = card.transparency = SPELL_TRANSPARENCY;
            this.card = card;
            this.time = time;
            updateXPos();
            updateYPos();
        }

        public void updateXPos() {
            card.target_x = (float) (X_DIST * Math.cos(time)) + (AbstractDungeon.player.drawX + (AbstractDungeon.player.hb.width / 3));
        }

        public void updateYPos() {
            card.target_y = (float) (Y_DIST * Math.sin(time)) + (AbstractDungeon.player.drawY + (AbstractDungeon.player.hb.height / 2));
            renderBehind = (time / MathUtils.PI) % 2 < 1;
        }
    }
}
