package code.relics;

import code.CharacterFile;

import static code.ModFile.makeID;

public class TodoItem extends AbstractCasterRelic {
    public static final String ID = makeID("TodoItem");

    public TodoItem() {
        super(ID, RelicTier.STARTER, LandingSound.FLAT, CharacterFile.Enums.CASTER_SQUOORP);
    }
}
