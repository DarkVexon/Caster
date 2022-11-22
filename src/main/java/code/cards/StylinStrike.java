package code.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.awesomeAmt;

public class StylinStrike extends AbstractCasterCard {
    public final static String ID = makeID(StylinStrike.class.getSimpleName());
    // intellij stuff attack, enemy, common, 7, 1, , , 1, 1

    public StylinStrike() {
        super(ID, 0, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 5;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        int amt = awesomeAmt();
        if (amt == 0) {
            dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
        } else {
            allDmg(AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
            if (amt >= 3) {
                allDmg(AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
            }
        }
    }

    public void upp() {
        upgradeDamage(3);
    }
}