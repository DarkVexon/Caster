package code.cards.spells;

import code.cards.AbstractCasterCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ArtifactPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class Cryostasis extends AbstractSpellCard {
    public final static String ID = makeID("Cryostasis");
    // intellij stuff skill, self, , , 7, 1, 1, 1

    public Cryostasis() {
        super(ID, 1, CardType.SKILL, CardTarget.SELF);
        baseBlock = 7;
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
        applyToSelf(new ArtifactPower(p, magicNumber));
    }

    public void upp() {
        upgradeBlock(1);
        upgradeMagicNumber(1);
    }
}