package code.cards;

import code.actions.ConjureAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.atb;

public class PiercingParasol extends AbstractCasterCard {
    public final static String ID = makeID(PiercingParasol.class.getSimpleName());
    // intellij stuff attack, all_enemy, uncommon, 16, 4, , , 1, 1

    public PiercingParasol() {
        super(ID, 2, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ALL_ENEMY);
        baseDamage = 16;
        baseMagicNumber = magicNumber = 1;
        isMultiDamage = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        allDmg(AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
        atb(new ConjureAction(magicNumber));
    }

    public void upp() {
        upgradeDamage(4);
        upgradeMagicNumber(1);
    }
}