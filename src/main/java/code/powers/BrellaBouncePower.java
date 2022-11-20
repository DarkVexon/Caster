package code.powers;

import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;

import static code.ModFile.makeID;
import static code.util.Wiz.atb;

public class BrellaBouncePower extends AbstractCasterPower {
    // intellij stuff buff
    public static final String ID = makeID(BrellaBouncePower.class.getSimpleName());
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(ID);

    public BrellaBouncePower(int amount) {
        super(ID, powerStrings.NAME, PowerType.BUFF, true, AbstractDungeon.player, amount);
    }

    @Override
    public void atStartOfTurn() {
        atb(new ReducePowerAction(owner, owner, this, 1));
    }

    @Override
    public void updateDescription() {
        description = amount == 1 ? powerStrings.DESCRIPTIONS[0] : powerStrings.DESCRIPTIONS[1] + amount + powerStrings.DESCRIPTIONS[2];
    }
}