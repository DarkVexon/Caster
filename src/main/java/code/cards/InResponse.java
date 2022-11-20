package code.cards;

import code.actions.ConjureAction;
import code.powers.InResponsePower;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.applyToSelf;
import static code.util.Wiz.atb;

public class InResponse extends AbstractCasterCard {
    public final static String ID = makeID(InResponse.class.getSimpleName());
    // intellij stuff power, self, uncommon, , , , , 3, 1

    public InResponse() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        baseMagicNumber = magicNumber = 3;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new ConjureAction(magicNumber));
        applyToSelf(new InResponsePower(magicNumber));
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}