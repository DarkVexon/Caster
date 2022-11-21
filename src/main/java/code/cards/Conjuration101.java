package code.cards;

import code.cards.AbstractCasterCard;
import code.powers.Conjuration101Power;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class Conjuration101 extends AbstractCasterCard {
    public final static String ID = makeID(Conjuration101.class.getSimpleName());
    // intellij stuff power, self, uncommon, , , , , , 

    public Conjuration101() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new Conjuration101Power(1));
    }

    public void upp() {
        isInnate = true;
    }
}