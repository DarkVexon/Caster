package code.powers;

import code.cardmods.InfestModifier;
import code.cards.other.Bug;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndAddToHandEffect;

import static code.ModFile.makeID;

public class LordOfTheFliesPower extends AbstractCasterPower implements OnInfestPower {
    // intellij stuff buff
    public static final String ID = makeID(LordOfTheFliesPower.class.getSimpleName());
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(ID);

    public LordOfTheFliesPower(int amount) {
        super(ID, powerStrings.NAME, PowerType.BUFF, false, AbstractDungeon.player, amount);
    }

    @Override
    public void onInfest(AbstractCard card) {
        for (int i = 0; i < amount; i++)
            AbstractDungeon.effectList.add(new ShowCardAndAddToHandEffect(new Bug()));
    }

    @Override
    public void updateDescription() {
        description = amount == 1 ? powerStrings.DESCRIPTIONS[0] + amount + powerStrings.DESCRIPTIONS[1] : powerStrings.DESCRIPTIONS[0] + amount + powerStrings.DESCRIPTIONS[2];
    }
}