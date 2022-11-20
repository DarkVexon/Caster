package code.ui;

import basemod.BaseMod;
import basemod.helpers.TooltipInfo;
import code.util.TexLoader;
import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.mod.stslib.icons.AbstractCustomIcon;

import java.util.Arrays;
import java.util.List;

import static code.ModFile.makeID;

public class InfestIcon extends AbstractCustomIcon {
    public static final String ID = "bug";
    private static InfestIcon singleton;
    private static final Texture iconTex = TexLoader.getTexture("casterResources/images/ui/SmallInfestIcon.png");

    public InfestIcon() {
        super(ID, iconTex);
    }

    public static InfestIcon get() {
        if (singleton == null) {
            singleton = new InfestIcon();
        }
        return singleton;
    }

    public List<TooltipInfo> getCustomTooltips() {
        return Arrays.asList(new TooltipInfo(BaseMod.getKeywordTitle(makeID("infest")), BaseMod.getKeywordDescription(makeID("infest"))));
    }
}
