package code.cards;

import code.util.Wiz;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.atb;

public class StylinStrike extends AbstractCasterCard {
    public final static String ID = makeID(StylinStrike.class.getSimpleName());
    // intellij stuff attack, enemy, common, 7, 1, , , 1, 1

    public StylinStrike() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 7;
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.SLASH_DIAGONAL);
        atb(new DrawCardAction(1, new AbstractGameAction() {
            @Override
            public void update() {
                isDone = true;
                int amt = Wiz.awesomeAmt();
                if (amt >= 1) {
                    DrawCardAction.drawnCards.forEach(q -> {
                        q.upgrade();
                        q.superFlash();
                    });
                }
                if (amt >= 3) {
                    DrawCardAction.drawnCards.forEach(q -> q.setCostForTurn(0));
                }
            }
        }));
    }

    public void upp() {
        upgradeDamage(1);
        upgradeMagicNumber(1);
    }
}