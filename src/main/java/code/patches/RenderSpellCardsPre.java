package code.patches;

import code.CharacterFile;
import code.ui.OrbitingSpells;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

@SpirePatch(clz = AbstractPlayer.class, method = "render")
public class RenderSpellCardsPre {
    public static void Prefix(AbstractPlayer obj, SpriteBatch sb) {
        if (AbstractDungeon.player.chosenClass.equals(CharacterFile.Enums.THE_CASTER)) {
            OrbitingSpells.prePlayerRender(sb);
        }
    }
}
