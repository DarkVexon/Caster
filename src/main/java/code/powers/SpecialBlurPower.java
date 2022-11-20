package code.powers;

import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.BlurPower;

public class SpecialBlurPower extends BlurPower {
    public SpecialBlurPower(AbstractCreature owner, int amount) {
        super(owner, amount);
    }

    @Override
    public void atStartOfTurn() {
        addToBot(new RemoveSpecificPowerAction(owner, owner, this));
    }
}
