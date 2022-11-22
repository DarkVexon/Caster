package code.cards;

import code.actions.AllEnemyLoseHPAction;
import code.cards.AbstractCasterCard;
import code.powers.AwesomePower;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class Supernova extends AbstractCasterCard {
    public final static String ID = makeID(Supernova.class.getSimpleName());
    // intellij stuff skill, all_enemy, rare, , , , , 50, 10

    public Supernova() {
        super(ID, 6, CardType.SKILL, CardRarity.RARE, CardTarget.ALL_ENEMY);
        baseMagicNumber = magicNumber = 50;
        baseSecondMagic = secondMagic = 3;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new AllEnemyLoseHPAction(magicNumber));
        applyToSelf(new AwesomePower(secondMagic));
    }

    public void upp() {
        upgradeMagicNumber(10);
        upgradeSecondMagic(2);
    }
}