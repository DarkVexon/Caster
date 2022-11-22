package code.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.status.VoidCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.topDeck;

public class PaidInAdvance extends AbstractCasterCard {
    public final static String ID = makeID(PaidInAdvance.class.getSimpleName());
    // intellij stuff skill, self, common, , , 8, 3, , 

    public PaidInAdvance() {
        super(ID, 0, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = 11;
        cardsToPreview = new VoidCard();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.SLASH_DIAGONAL);
        topDeck(new VoidCard());
    }

    public void upp() {
        upgradeDamage(4);
    }
}