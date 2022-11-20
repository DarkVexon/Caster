package code.cards;

import code.cards.AbstractCasterCard;
import code.powers.DeEnergizedPower;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class PaidInAdvance extends AbstractCasterCard {
    public final static String ID = makeID(PaidInAdvance.class.getSimpleName());
    // intellij stuff skill, self, common, , , 8, 3, , 

    public PaidInAdvance() {
        super(ID, 0, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        baseBlock = 8;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
        applyToSelf(new DeEnergizedPower(1));
    }

    public void upp() {
        upgradeBlock(3);
    }
}