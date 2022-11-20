package code.cards;

import code.cards.AbstractCasterCard;
import com.megacrit.cardcrawl.actions.unique.DiscardPileToTopOfDeckAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class CoolMagnet extends AbstractCasterCard {
    public final static String ID = makeID(CoolMagnet.class.getSimpleName());
    // intellij stuff skill, enemy, uncommon, , , , , 2, 1

    public CoolMagnet() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseMagicNumber = magicNumber = 2;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToEnemy(m, new WeakPower(m, magicNumber, false));
        applyToEnemy(m, new VulnerablePower(m, magicNumber, false));
        atb(new DiscardPileToTopOfDeckAction(p));
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}