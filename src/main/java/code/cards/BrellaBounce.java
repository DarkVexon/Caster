package code.cards;

import code.powers.BrellaBouncePower;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.applyToSelf;

public class BrellaBounce extends AbstractCasterCard {
    public final static String ID = makeID(BrellaBounce.class.getSimpleName());
    // intellij stuff skill, self, uncommon, , , 11, 4, , 

    public BrellaBounce() {
        super(ID, 2, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseBlock = 11;
        selfRetain = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
        applyToSelf(new BrellaBouncePower(1));
    }

    public void upp() {
        upgradeBlock(4);
    }
}