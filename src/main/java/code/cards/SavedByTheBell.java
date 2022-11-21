package code.cards;

import code.cards.AbstractCasterCard;
import com.megacrit.cardcrawl.cards.curses.CurseOfTheBell;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.BlurPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class SavedByTheBell extends AbstractCasterCard {
    public final static String ID = makeID(SavedByTheBell.class.getSimpleName());
    // intellij stuff skill, self, uncommon, , , 13, , , 

    public SavedByTheBell() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseBlock = 13;
        cardsToPreview = new CurseOfTheBell();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
        applyToSelf(new BlurPower(p, 1));
        topDeck(new CurseOfTheBell(), 2);
    }

    public void upp() {
        isEthereal = true;
    }
}