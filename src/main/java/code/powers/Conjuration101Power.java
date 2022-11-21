package code.powers;

import code.actions.ConjureAction;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;

import static code.ModFile.makeID;
import static code.util.Wiz.atb;

public class Conjuration101Power extends AbstractCasterPower {
    // intellij stuff buff
    public static final String ID = makeID(Conjuration101Power.class.getSimpleName());
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(ID);

    public Conjuration101Power(int amount) {
        super(ID, powerStrings.NAME + amount, PowerType.BUFF, false, AbstractDungeon.player, amount);
    }

    @Override
    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        this.name = powerStrings.NAME + amount;
    }

    @Override
    public void atStartOfTurnPostDraw() {
        flash();
        atb(new ConjureAction(amount));
    }

    @Override
    public void updateDescription() {
        description = powerStrings.DESCRIPTIONS[0] + amount + powerStrings.DESCRIPTIONS[1];
    }
}