package code.ui;

import basemod.BaseMod;
import basemod.helpers.TooltipInfo;
import code.util.TexLoader;
import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.mod.stslib.icons.AbstractCustomIcon;

import java.util.Arrays;
import java.util.List;

import static code.ModFile.makeID;

public class AwesomeIcon extends AbstractCustomIcon {
    public static final String ID = "awesome";
    private static AwesomeIcon singleton;
    private static final Texture iconTex = TexLoader.getTexture("casterResources/images/ui/AwesomeIcon.png");

    public AwesomeIcon() {
        super(ID, iconTex);
    }

    public static AwesomeIcon get() {
        if (singleton == null) {
            singleton = new AwesomeIcon();
        }
        return singleton;
    }

    public List<TooltipInfo> getCustomTooltips() {
        return Arrays.asList(new TooltipInfo(BaseMod.getKeywordTitle(makeID("awesome")), BaseMod.getKeywordDescription(makeID("awesome"))));
    }
}
