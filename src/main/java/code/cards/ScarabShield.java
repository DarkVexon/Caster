package code.cards;

import basemod.helpers.CardModifierManager;
import code.cardmods.InfestModifier;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;

public class ScarabShield extends AbstractCasterCard {
    public final static String ID = makeID("ScarabShield");
    // intellij stuff skill, self, uncommon, , , 6, 2, 2, 1

    public ScarabShield() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        baseBlock = 8;
        CardModifierManager.addModifier(this, new InfestModifier());
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
    }

    public void upp() {
        upgradeBlock(2);
    }
}