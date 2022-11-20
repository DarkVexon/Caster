package code.cards.cardvars;

import basemod.abstracts.DynamicVariable;
import code.cards.AbstractCasterCard;
import com.megacrit.cardcrawl.cards.AbstractCard;

import static code.ModFile.makeID;

public class ThirdMagicNumber extends DynamicVariable {

    @Override
    public String key() {
        return makeID("m3");
    }

    @Override
    public boolean isModified(AbstractCard card) {
        if (card instanceof AbstractCasterCard) {
            return ((AbstractCasterCard) card).isThirdMagicModified;
        }
        return false;
    }

    @Override
    public int value(AbstractCard card) {
        if (card instanceof AbstractCasterCard) {
            return ((AbstractCasterCard) card).thirdMagic;
        }
        return -1;
    }

    public void setIsModified(AbstractCard card, boolean v) {
        if (card instanceof AbstractCasterCard) {
            ((AbstractCasterCard) card).isThirdMagicModified = v;
        }
    }

    @Override
    public int baseValue(AbstractCard card) {
        if (card instanceof AbstractCasterCard) {
            return ((AbstractCasterCard) card).baseThirdMagic;
        }
        return -1;
    }

    @Override
    public boolean upgraded(AbstractCard card) {
        if (card instanceof AbstractCasterCard) {
            return ((AbstractCasterCard) card).upgradedThirdMagic;
        }
        return false;
    }
}