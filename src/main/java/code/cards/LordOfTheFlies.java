package code.cards;

import code.cards.other.Bug;
import code.powers.LordOfTheFliesPower;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.applyToSelf;

public class LordOfTheFlies extends AbstractCasterCard {
    public final static String ID = makeID(LordOfTheFlies.class.getSimpleName());
    // intellij stuff power, self, rare, , , , , , 

    public LordOfTheFlies() {
        super(ID, 1, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        cardsToPreview = new Bug();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new LordOfTheFliesPower(1));
    }

    public void upp() {
        isInnate = true;
    }
}