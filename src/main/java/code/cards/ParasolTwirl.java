package code.cards;

import code.cards.AbstractCasterCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.EnergizedPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ParasolTwirl extends AbstractCasterCard {
    public final static String ID = makeID(ParasolTwirl.class.getSimpleName());
    // intellij stuff skill, self, basic, , , , , 1, 1

    public ParasolTwirl() {
        super(ID, 0, CardType.SKILL, CardRarity.BASIC, CardTarget.SELF);
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new EnergizedPower(p, magicNumber));
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}