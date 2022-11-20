package code.cards;

import basemod.helpers.TooltipInfo;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.Arrays;
import java.util.List;

import static code.ModFile.makeID;
import static code.util.Wiz.atb;
import static code.util.Wiz.awesomeAmt;

public class Flourish extends AbstractCasterCard {
    public final static String ID = makeID(Flourish.class.getSimpleName());
    // intellij stuff skill, self, uncommon, , , , , 3, 1

    public Flourish() {
        super(ID, 0, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseMagicNumber = magicNumber = 3;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (awesomeAmt() >= 2) {
            atb(new DrawCardAction(magicNumber));
        }
    }

    @Override
    public void triggerOnGlowCheck() {
        glowColor = awesomeAmt() >= 2 ? GOLD_BORDER_GLOW_COLOR : BLUE_BORDER_GLOW_COLOR;
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}