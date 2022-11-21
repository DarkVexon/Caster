package code.cards;

import code.cards.AbstractCasterCard;
import code.powers.BlightbladePower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class Blightblade extends AbstractCasterCard {
    public final static String ID = makeID(Blightblade.class.getSimpleName());
    // intellij stuff attack, enemy, common, 15, 3, , , 2, 1

    public Blightblade() {
        super(ID, 2, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 15;
        baseMagicNumber = magicNumber = 2;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
        applyToSelf(new BlightbladePower(magicNumber));
    }

    public void upp() {
        upgradeDamage(3);
        upgradeMagicNumber(1);
    }
}