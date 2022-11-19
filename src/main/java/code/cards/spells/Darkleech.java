package code.cards.spells;

import code.actions.AllEnemyLoseHPAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.atb;

public class Darkleech extends AbstractSpellCard {
    public final static String ID = makeID(Darkleech.class.getSimpleName());
    // intellij stuff skill, all_enemy, , , , , 7, 2

    public Darkleech() {
        super(ID, 1, CardType.SKILL, CardTarget.ALL_ENEMY);
        baseMagicNumber = magicNumber = 7;
        baseSecondMagic = secondMagic = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new AllEnemyLoseHPAction(magicNumber));
        atb(new DrawCardAction(secondMagic));
    }

    public void upp() {
        upgradeMagicNumber(2);
        upgradeSecondMagic(1);
        uDesc();
    }
}