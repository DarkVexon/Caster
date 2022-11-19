package code.patches;

import code.ModFile;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.ui.panels.DrawPilePanel;

@SpirePatch(
        clz = DrawPilePanel.class,
        method = "render"
)
public class RenderBecomeAwesomeButton {
    public static void Postfix(DrawPilePanel __instance, SpriteBatch spriteBatch) {
        ModFile.renderCombatUiElements(spriteBatch);
    }
}
