package code.cards.other.spells;

import code.cards.AbstractCasterCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.UIStrings;

import java.util.Arrays;
import java.util.List;

import static code.ModFile.makeID;

public abstract class AbstractSpellCard extends AbstractCasterCard {
    private static final UIStrings uiStrings = CardCrawlGame.languagePack.getUIString(makeID("SpellDescriptor"));

    public AbstractSpellCard(String cardID, int cost, CardType type, CardTarget target) {
        super(cardID, cost, type, CardRarity.SPECIAL, target, CardColor.COLORLESS);
        exhaust = true;
    }

    @Override
    public List<String> getCardDescriptors() {
        return Arrays.asList(uiStrings.TEXT[0]);
    }
}
