package code.cards;

import com.megacrit.cardcrawl.cards.tempCards.Miracle;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.topDeck;

public class MiracleWorker extends AbstractCasterCard {
    public final static String ID = makeID(MiracleWorker.class.getSimpleName());
    // intellij stuff skill, self, common, , , 7, 1, , 

    public MiracleWorker() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        baseBlock = 7;
        cardsToPreview = new Miracle();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
        topDeck(cardForGen(Miracle.ID));
    }

    public void upp() {
        upgradeBlock(1);
        cardsToPreview.upgrade();
    }
}