package code.powers;

import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;

import static code.ModFile.makeID;
import static code.util.Wiz.atb;

public class NoEnergyNextTurnPower extends AbstractCasterPower {
    // intellij stuff debuff
    public static final String ID = makeID(NoEnergyNextTurnPower.class.getSimpleName());
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(ID);

    public NoEnergyNextTurnPower() {
        super(ID, powerStrings.NAME, PowerType.DEBUFF, true, AbstractDungeon.player, -1);
        canGoNegative = false;
    }

    @Override
    public void onEnergyRecharge() {
        flash();
        AbstractDungeon.player.loseEnergy(99);
        atb(new RemoveSpecificPowerAction(owner, owner, this));
    }

    @Override
    public void updateDescription() {
        this.description = powerStrings.DESCRIPTIONS[0];
    }
}