package code.powers;

import code.cards.Arachnophobia;
import code.cards.other.Bug;
import code.powers.AbstractCasterPower;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ArachnophobiaPower extends AbstractCasterPower {
    // intellij stuff buff
    public static final String ID = makeID(ArachnophobiaPower.class.getSimpleName());
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(ID);

    public ArachnophobiaPower(int amount) {
        super(ID, powerStrings.NAME, PowerType.BUFF, false, AbstractDungeon.player, amount);
    }

    @Override
    public void onUseCard(AbstractCard card, UseCardAction action) {
        if (card.cardID.equals(Bug.ID)) {
            flash();
            applyToEnemy((AbstractMonster) action.target, new PoisonPower(action.target, owner, amount));
        }
    }

    @Override
    public void updateDescription() {
        description = powerStrings.DESCRIPTIONS[0] + amount + powerStrings.DESCRIPTIONS[1];
    }
}