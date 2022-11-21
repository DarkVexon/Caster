package code.cards;

import code.powers.DeEnergizedPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.applyToSelf;

public class PaidInAdvance extends AbstractCasterCard {
    public final static String ID = makeID(PaidInAdvance.class.getSimpleName());
    // intellij stuff skill, self, common, , , 8, 3, , 

    public PaidInAdvance() {
        super(ID, 0, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 10;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.SLASH_DIAGONAL);
        applyToSelf(new DeEnergizedPower(1));
    }

    public void upp() {
        upgradeDamage(3);
    }
}