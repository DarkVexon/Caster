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
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseBlock = 6;
        baseMagicNumber = magicNumber = 2;
        CardModifierManager.addModifier(this, new InfestModifier());
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
    }

    @Override
    protected void applyPowersToBlock() {
        int realBaseBlock = this.baseBlock;
        baseBlock += magicNumber * InfestModifier.getInfestCount(this);
        super.applyPowersToBlock();
        this.baseBlock = realBaseBlock;
        this.isBlockModified = realBaseBlock != this.baseBlock;
    }

    public void upp() {
        upgradeBlock(2);
        upgradeMagicNumber(1);
    }
}