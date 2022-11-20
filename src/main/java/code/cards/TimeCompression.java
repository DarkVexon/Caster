package code.cards;

import code.powers.NoEnergyNextTurnPower;
import code.powers.SpecialBlurPower;
import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.watcher.PressEndTurnButtonAction;
import com.megacrit.cardcrawl.actions.watcher.SkipEnemiesTurnAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.BorderFlashEffect;
import com.megacrit.cardcrawl.vfx.combat.TimeWarpTurnEndEffect;

import static code.ModFile.makeID;
import static code.util.Wiz.applyToSelf;
import static code.util.Wiz.atb;

public class TimeCompression extends AbstractCasterCard {
    public final static String ID = makeID(TimeCompression.class.getSimpleName());
    // intellij stuff skill, self, rare, , , , , , 

    public TimeCompression() {
        super(ID, 1, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new NoEnergyNextTurnPower());
        applyToSelf(new SpecialBlurPower(p, 1));

        atb(new AbstractGameAction() {
            @Override
            public void update() {
                isDone = true;
                CardCrawlGame.sound.play("POWER_TIME_WARP", 0.05F);
                AbstractDungeon.effectsQueue.add(new BorderFlashEffect(Color.GOLD, true));
                AbstractDungeon.topLevelEffectsQueue.add(new TimeWarpTurnEndEffect());
            }
        });

        atb(new SkipEnemiesTurnAction());
        atb(new PressEndTurnButtonAction());
    }

    public void upp() {
        upgradeBaseCost(0);
    }
}