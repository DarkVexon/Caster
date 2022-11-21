package code.relics;

import basemod.abstracts.CustomRelic;
import code.util.TexLoader;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import static code.ModFile.modID;

public abstract class AbstractCasterRelic extends CustomRelic {
    public AbstractCard.CardColor color;

    public AbstractCasterRelic(String setId, AbstractRelic.RelicTier tier, AbstractRelic.LandingSound sfx) {
        this(setId, tier, sfx, null);
    }

    public AbstractCasterRelic(String setId, AbstractRelic.RelicTier tier, AbstractRelic.LandingSound sfx, AbstractCard.CardColor color) {
        super(setId, TexLoader.getTexture("casterResources/images/relics/" + setId.replace(modID + ":", "") + ".png"), tier, sfx);
        outlineImg = TexLoader.getTexture("casterResources/images/relics/" + setId.replace(modID + ":", "") + "Outline.png");
        this.color = color;
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }
}