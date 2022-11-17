package code.cards.cardvars;

import basemod.abstracts.DynamicVariable;
import code.cards.AbstractCasterCard;
import com.megacrit.cardcrawl.cards.AbstractCard;

import static code.ModFile.makeID;

public class SecondMagicNumber extends DynamicVariable {

    @Override
    public String key() {
        return makeID("m2");
    }

    @Override
    public boolean isModified(AbstractCard card) {
        if (card instanceof AbstractCasterCard) {
            return ((AbstractCasterCard) card).isSecondMagicModified;
        }
        return false;
    }

    @Override
    public int value(AbstractCard card) {
        if (card instanceof AbstractCasterCard) {
            return ((AbstractCasterCard) card).secondMagic;
        }
        return -1;
    }

    public void setIsModified(AbstractCard card, boolean v) {
        if (card instanceof AbstractCasterCard) {
            ((AbstractCasterCard) card).isSecondMagicModified = v;
        }
    }

    @Override
    public int baseValue(AbstractCard card) {
        if (card instanceof AbstractCasterCard) {
            return ((AbstractCasterCard) card).baseSecondMagic;
        }
        return -1;
    }

    @Override
    public boolean upgraded(AbstractCard card) {
        if (card instanceof AbstractCasterCard) {
            return ((AbstractCasterCard) card).upgradedSecondMagic;
        }
        return false;
    }
}