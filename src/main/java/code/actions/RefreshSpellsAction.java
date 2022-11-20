package code.actions;

import code.ui.OrbitingSpells;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class RefreshSpellsAction extends AbstractGameAction {
    @Override
    public void update() {
        isDone = true;
        OrbitingSpells.refreshSpells();
    }
}
