package code.cards.spells;

import com.megacrit.cardcrawl.actions.common.RemoveAllBlockAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ArtifactPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

import static code.ModFile.makeID;
import static code.util.Wiz.applyToEnemy;
import static code.util.Wiz.atb;

public class Withervine extends AbstractSpellCard {
    public final static String ID = makeID(Withervine.class.getSimpleName());
    // intellij stuff skill, enemy, , , , , 1, 1

    public Withervine() {
        super(ID, 1, CardType.SKILL, CardTarget.ENEMY);
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new RemoveSpecificPowerAction(m, p, ArtifactPower.POWER_ID));
        atb(new RemoveAllBlockAction(m, p));
        applyToEnemy(m, new StrengthPower(m, -1));
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}