package code.cards;

import basemod.BaseMod;
import code.actions.ConjureAction;
import code.cards.AbstractCasterCard;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class Chromatics extends AbstractCasterCard {
    public final static String ID = makeID(Chromatics.class.getSimpleName());

    public Chromatics() {
        super(ID, 1, CardType.SKILL, CardRarity.BASIC, CardTarget.SELF);
        baseBlock = 6;
        baseMagicNumber = magicNumber = 2;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
        atb(new DiscardAction(p, p, BaseMod.MAX_HAND_SIZE, true));
        atb(new ConjureAction(magicNumber));
    }

    public void upp() {
        upgradeBlock(2);
        upgradeMagicNumber(1);
    }
}