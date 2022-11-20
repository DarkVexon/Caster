package code.cards;

import code.actions.ConjureAction;
import code.cards.AbstractCasterCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class RainbowMastery extends AbstractCasterCard {
    public final static String ID = makeID(RainbowMastery.class.getSimpleName());
    // intellij stuff skill, self, rare, , , , , , 

    public RainbowMastery() {
        super(ID, 0, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new ConjureAction(6));
    }

    public void upp() {
        selfRetain = true;
    }
}