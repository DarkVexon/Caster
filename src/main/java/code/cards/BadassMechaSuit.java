package code.cards;

import code.cards.AbstractCasterCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ArtifactPower;
import com.megacrit.cardcrawl.powers.PlatedArmorPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.powers.ThornsPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class BadassMechaSuit extends AbstractCasterCard {
    public final static String ID = makeID(BadassMechaSuit.class.getSimpleName());
    // intellij stuff power, self, uncommon, , , , , , 

    public BadassMechaSuit() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        baseMagicNumber = magicNumber = 4;
        baseSecondMagic = secondMagic = 2;
        baseThirdMagic = thirdMagic = 6;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new PlatedArmorPower(p, magicNumber));
        int awe = awesomeAmt();
        if (awe >= 2) {
            applyToSelf(new ArtifactPower(p, secondMagic));
        }
        if (awe >= 4) {
            applyToSelf(new ThornsPower(p, thirdMagic));
        }
    }

    public void upp() {
        upgradeMagicNumber(2);
        upgradeSecondMagic(1);
        upgradeThirdMagic(3);
    }
}