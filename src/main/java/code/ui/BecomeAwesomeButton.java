package code.ui;

import basemod.ClickableUIElement;
import code.powers.AwesomePower;
import code.util.ImageHelper;
import code.util.TexLoader;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;

import static code.util.Wiz.applyToSelf;

public class BecomeAwesomeButton extends ClickableUIElement {

    private static final Texture tex = TexLoader.getTexture("casterResources/images/ui/BecomeAwesomeButton.png");
    private static final Texture tex_hovered = TexLoader.getTexture("casterResources/images/ui/BecomeAwesomeButton_hovered.png");

    public BecomeAwesomeButton() {
        super(tex, 750, 750, 150 * Settings.scale, 150 * Settings.scale);
    }

    @Override
    public void update() {
        super.update();
        if (hitbox.hovered) {
            ImageHelper.tipBoxAtMousePos("#yAwesome", "Click this to spend all your [E] and become that #yAwesome."); //TODO: Loc
        }
    }

    @Override
    protected void onHover() {
        this.image = tex_hovered;
    }

    @Override
    protected void onUnhover() {
        this.image = tex;
    }

    @Override
    protected void onClick() {
        if (canBeClicked() && EnergyPanel.totalCount > 0) {
            int amount = EnergyPanel.totalCount;
            AbstractDungeon.player.energy.use(amount);
            applyToSelf(new AwesomePower(amount));
        }
    }

    private boolean canBeClicked() {
        return !AbstractDungeon.isScreenUp && AbstractDungeon.actionManager.actions.isEmpty() && AbstractDungeon.actionManager.currentAction == null;
    }

}
