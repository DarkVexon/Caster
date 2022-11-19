package code.cards;

import basemod.helpers.CardModifierManager;
import code.cardmods.InfestModifier;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.atb;

public class Swarmblade extends AbstractCasterCard {
    public final static String ID = makeID(Swarmblade.class.getSimpleName());
    // intellij stuff attack, enemy, common, 9, 3, , , , 

    public Swarmblade() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 9;
        CardModifierManager.addModifier(this, new InfestModifier());
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
        int draws = InfestModifier.getInfestCount(this);
        if (draws > 0) {
            atb(new DrawCardAction(draws));
        }
    }

    public void upp() {
        upgradeDamage(3);
    }
}