package code.ui;

import code.util.TexLoader;
import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.mod.stslib.icons.AbstractCustomIcon;

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
}
