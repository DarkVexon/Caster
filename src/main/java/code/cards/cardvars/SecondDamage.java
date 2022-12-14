package code.cards.cardvars;

import basemod.abstracts.DynamicVariable;
import code.cards.AbstractCasterCard;
import com.megacrit.cardcrawl.cards.AbstractCard;

import static code.ModFile.makeID;

public class SecondDamage extends DynamicVariable {

    @Override
    public String key() {
        return makeID("sd");
    }

    @Override
    public boolean isModified(AbstractCard card) {
        if (card instanceof AbstractCasterCard) {
            return ((AbstractCasterCard) card).isSecondDamageModified;
        }
        return false;
    }

    public void setIsModified(AbstractCard card, boolean v) {
        if (card instanceof AbstractCasterCard) {
            ((AbstractCasterCard) card).isSecondDamageModified = v;
        }
    }

    @Override
    public int value(AbstractCard card) {
        if (card instanceof AbstractCasterCard) {
            return ((AbstractCasterCard) card).secondDamage;
        }
        return -1;
    }

    @Override
    public int baseValue(AbstractCard card) {
        if (card instanceof AbstractCasterCard) {
            return ((AbstractCasterCard) card).baseSecondDamage;
        }
        return -1;
    }

    @Override
    public boolean upgraded(AbstractCard card) {
        if (card instanceof AbstractCasterCard) {
            return ((AbstractCasterCard) card).upgradedSecondDamage;
        }
        return false;
    }
}