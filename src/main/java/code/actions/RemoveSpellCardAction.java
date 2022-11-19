package code.actions;

import code.ui.OrbitingSpells;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class RemoveSpellCardAction extends AbstractGameAction {
    private AbstractCard card;

    public RemoveSpellCardAction(AbstractCard card) {
        this.card = card;
    }

    @Override
    public void update() {
        isDone = true;
        OrbitingSpells.removeSpellCard(card);
    }
}
