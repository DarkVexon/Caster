package code.cards;

import code.cards.AbstractCasterCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class VexingDeal2 extends AbstractCasterCard {
    public final static String ID = makeID(VexingDeal2.class.getSimpleName());
    // intellij stuff power, self, rare, , , , , 3, 2

    public VexingDeal2() {
        super(ID, 0, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        baseMagicNumber = magicNumber = 3;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new StrengthPower(p, magicNumber));
    }

    public void upp() {
        upgradeMagicNumber(2);
    }
}