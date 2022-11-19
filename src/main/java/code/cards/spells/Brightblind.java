package code.cards.spells;

import code.cards.AbstractCasterCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class Brightblind extends AbstractSpellCard {
    public final static String ID = makeID(Brightblind.class.getSimpleName());
    // intellij stuff attack, enemy, 5, 1, , , 1, 1

    public Brightblind() {
        super(ID, 1, CardType.ATTACK, CardTarget.ENEMY);
        baseDamage = 5;
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.FIRE);
        applyToEnemy(m, new WeakPower(m, magicNumber, false));
        applyToEnemy(m, new VulnerablePower(m, magicNumber, false));
    }

    public void upp() {
        upgradeDamage(1);
        upgradeMagicNumber(1);
    }
}