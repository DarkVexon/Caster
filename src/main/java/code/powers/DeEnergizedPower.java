package code.powers;

import code.powers.AbstractCasterPower;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class DeEnergizedPower extends AbstractCasterPower {
    // intellij stuff debuff
    public static final String ID = makeID(DeEnergizedPower.class.getSimpleName());
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(ID);

    public DeEnergizedPower(int amount) {
        super(ID, powerStrings.NAME, PowerType.DEBUFF, true, AbstractDungeon.player, amount);
    }

    @Override
    public void onEnergyRecharge() {
        flash();
        AbstractDungeon.player.loseEnergy(amount);
        atb(new RemoveSpecificPowerAction(owner, owner, this));
    }

    @Override
    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1];
    }
}