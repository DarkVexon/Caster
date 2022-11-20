package code.cards;

import code.cards.AbstractCasterCard;
import code.powers.SorcererSupremePower;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class SorcererSupreme extends AbstractCasterCard {
    public final static String ID = makeID(SorcererSupreme.class.getSimpleName());
    // intellij stuff power, self, rare, , , , , 6, 4

    public SorcererSupreme() {
        super(ID, 2, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        baseMagicNumber = magicNumber = 6;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new SorcererSupremePower(magicNumber));
    }

    public void upp() {
        upgradeMagicNumber(4);
    }
}