package code.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.BerserkPower;
import com.megacrit.cardcrawl.powers.DrawPower;
import com.megacrit.cardcrawl.powers.IntangiblePlayerPower;
import com.megacrit.cardcrawl.powers.ThousandCutsPower;
import com.megacrit.cardcrawl.powers.watcher.OmegaPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class FinalForm extends AbstractCasterCard {
    public final static String ID = makeID(FinalForm.class.getSimpleName());
    // intellij stuff power, self, rare, , , , , , 

    public FinalForm() {
        super(ID, 3, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new IntangiblePlayerPower(p, magicNumber));
        int amt = awesomeAmt();
        switch (amt) {
            case 1:
                applyToSelf(new BerserkPower(p, 1));
                break;
            case 3:
                applyToSelf(new DrawPower(p, 2));
                break;
            case 5:
                applyToSelf(new OmegaPower(p, 15));
                break;
            case 10:
                //TODO: Final Form Power (cards are played twice)
        }
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}