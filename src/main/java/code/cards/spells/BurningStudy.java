package code.cards.spells;

import code.cards.AbstractCasterCard;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class BurningStudy extends AbstractSpellCard {
    public final static String ID = makeID("BurningStudy");
    // intellij stuff skill, self, , , , , 2, 1

    public BurningStudy() {
        super(ID, 1, CardType.SKILL, CardTarget.SELF);
        baseMagicNumber = magicNumber = 2;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new ExhaustAction(1, false));
        applyToSelf(new StrengthPower(p, magicNumber));
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}