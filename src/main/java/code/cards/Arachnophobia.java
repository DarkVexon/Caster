package code.cards;

import basemod.helpers.CardModifierManager;
import code.cardmods.InfestModifier;
import code.cards.other.Bug;
import code.powers.ArachnophobiaPower;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.applyToSelf;

public class Arachnophobia extends AbstractCasterCard {
    public final static String ID = makeID(Arachnophobia.class.getSimpleName());
    // intellij stuff power, self, uncommon, , , , , 2, 1

    public Arachnophobia() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        baseMagicNumber = magicNumber = 2;
        CardModifierManager.addModifier(this, new InfestModifier());
        cardsToPreview = new Bug();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new ArachnophobiaPower(magicNumber));
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}