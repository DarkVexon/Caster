package code.ui;

import code.util.TexLoader;
import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.mod.stslib.icons.AbstractCustomIcon;

import java.util.Arrays;
import java.util.List;

import static code.ModFile.makeID;

public class AscensionIcon extends AbstractCustomIcon {
    public static final String ID = "ascension";
    private static AscensionIcon singleton;
    private static final Texture iconTex = TexLoader.getTexture("casterResources/images/ui/ascensionIcon.png");

    public AscensionIcon() {
        super(ID, iconTex);
    }

    public static AscensionIcon get() {
        if (singleton == null) {
            singleton = new AscensionIcon();
        }
        return singleton;
    }

    @Override
    public List<String> keywordLinks() {
        return Arrays.asList(makeID("ascension"));
    }
}
