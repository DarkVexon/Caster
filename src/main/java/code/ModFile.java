package code;

import basemod.AutoAdd;
import basemod.BaseMod;
import basemod.ModPanel;
import basemod.helpers.RelicType;
import basemod.interfaces.*;
import code.cards.AbstractCasterCard;
import code.cards.cardvars.SecondDamage;
import code.cards.cardvars.SecondMagicNumber;
import code.cards.cardvars.ThirdMagicNumber;
import code.relics.AbstractCasterRelic;
import code.ui.AscensionIcon;
import code.ui.AwesomeIcon;
import code.ui.BecomeAwesomeButton;
import code.ui.OrbitingSpells;
import code.util.SparkleHandler;
import code.util.TexLoader;
import code.util.Wiz;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.mod.stslib.Keyword;
import com.evacipated.cardcrawl.mod.stslib.icons.CustomIconHelper;
import com.evacipated.cardcrawl.modthespire.Loader;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.google.gson.Gson;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.*;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.unlock.UnlockTracker;

import java.nio.charset.StandardCharsets;

import static code.util.Wiz.atb;

@SuppressWarnings({"unused", "WeakerAccess"})
@SpireInitializer
public class ModFile implements
        EditCardsSubscriber,
        EditRelicsSubscriber,
        EditStringsSubscriber,
        EditKeywordsSubscriber,
        EditCharactersSubscriber, OnStartBattleSubscriber,
        PostPlayerUpdateSubscriber, PostDungeonUpdateSubscriber,
        StartGameSubscriber, OnPlayerTurnStartPostDrawSubscriber, PostUpdateSubscriber,
        PostInitializeSubscriber {

    public static final String modID = "caster";

    public static final String SHOULDER1 = modID + "Resources/images/char/mainChar/shoulder.png";
    public static final String SHOULDER2 = modID + "Resources/images/char/mainChar/shoulder2.png";
    public static final String CORPSE = modID + "Resources/images/char/mainChar/corpse.png";
    public static final String ATTACK_S_ART = modID + "Resources/images/512/attack.png";
    public static final String SKILL_S_ART = modID + "Resources/images/512/skill.png";
    public static final String POWER_S_ART = modID + "Resources/images/512/power.png";
    public static final String CARD_ENERGY_S = modID + "Resources/images/512/energy.png";
    public static final String TEXT_ENERGY = modID + "Resources/images/512/text_energy.png";
    public static final String ATTACK_L_ART = modID + "Resources/images/1024/attack.png";
    public static final String SKILL_L_ART = modID + "Resources/images/1024/skill.png";
    public static final String POWER_L_ART = modID + "Resources/images/1024/power.png";
    public static final String CARD_ENERGY_L = modID + "Resources/images/1024/energy.png";
    public static final String CHARSELECT_BUTTON = modID + "Resources/images/charSelect/charButton.png";
    public static final String CHARSELECT_PORTRAIT = modID + "Resources/images/charSelect/charBG.png";

    public static Color characterColor = new Color(0.444F, 0.888F, 0.333F, 1);

    public static String makeID(String idText) {
        return modID + ":" + idText;
    }

    public static Settings.GameLanguage[] SupportedLanguages = {
            Settings.GameLanguage.ENG,
    };

    private String getLangString() {
        for (Settings.GameLanguage lang : SupportedLanguages) {
            if (lang.equals(Settings.language)) {
                return Settings.language.name().toLowerCase();
            }
        }
        return "eng";
    }

    public ModFile() {
        BaseMod.subscribe(this);

        BaseMod.addColor(CharacterFile.Enums.CASTER_SQUOORP, characterColor, characterColor, characterColor,
                characterColor, characterColor, characterColor, characterColor,
                ATTACK_S_ART, SKILL_S_ART, POWER_S_ART, CARD_ENERGY_S,
                ATTACK_L_ART, SKILL_L_ART, POWER_L_ART,
                CARD_ENERGY_L, TEXT_ENERGY);
    }

    public static void initialize() {
        ModFile thismod = new ModFile();
    }

    @Override
    public void receiveEditCharacters() {
        BaseMod.addCharacter(new CharacterFile(CharacterFile.characterStrings.NAMES[1], CharacterFile.Enums.THE_CASTER),
                CHARSELECT_BUTTON, CHARSELECT_PORTRAIT, CharacterFile.Enums.THE_CASTER);
    }

    @Override
    public void receiveEditRelics() {
        new AutoAdd(modID)
                .packageFilter(AbstractCasterRelic.class)
                .any(AbstractCasterRelic.class, (info, relic) -> {
                    if (relic.color == null) {
                        BaseMod.addRelic(relic, RelicType.SHARED);
                    } else {
                        BaseMod.addRelicToCustomPool(relic, relic.color);
                    }
                    if (!info.seen) {
                        UnlockTracker.markRelicAsSeen(relic.relicId);
                    }
                });
    }

    @Override
    public void receiveEditCards() {
        CustomIconHelper.addCustomIcon(AwesomeIcon.get());
        CustomIconHelper.addCustomIcon(AscensionIcon.get());

        BaseMod.addDynamicVariable(new SecondMagicNumber());
        BaseMod.addDynamicVariable(new ThirdMagicNumber());
        BaseMod.addDynamicVariable(new SecondDamage());

        new AutoAdd(modID)
                .packageFilter(AbstractCasterCard.class)
                .setDefaultSeen(true)
                .cards();
    }

    @Override
    public void receiveEditStrings() {
        BaseMod.loadCustomStringsFile(CardStrings.class, modID + "Resources/localization/" + getLangString() + "/Cardstrings.json");

        BaseMod.loadCustomStringsFile(RelicStrings.class, modID + "Resources/localization/" + getLangString() + "/Relicstrings.json");

        BaseMod.loadCustomStringsFile(CharacterStrings.class, modID + "Resources/localization/" + getLangString() + "/Charstrings.json");

        BaseMod.loadCustomStringsFile(PowerStrings.class, modID + "Resources/localization/" + getLangString() + "/Powerstrings.json");

        BaseMod.loadCustomStringsFile(UIStrings.class, modID + "Resources/localization/" + getLangString() + "/UIStrings.json");
    }

    @Override
    public void receiveEditKeywords() {
        Gson gson = new Gson();
        String json = Gdx.files.internal(modID + "Resources/localization/eng/Keywordstrings.json").readString(String.valueOf(StandardCharsets.UTF_8));
        com.evacipated.cardcrawl.mod.stslib.Keyword[] keywords = gson.fromJson(json, com.evacipated.cardcrawl.mod.stslib.Keyword[].class);

        if (keywords != null) {
            for (Keyword keyword : keywords) {
                BaseMod.addKeyword(modID, keyword.PROPER_NAME, keyword.NAMES, keyword.DESCRIPTION);
            }
        }
    }

    @Override
    public void receiveOnBattleStart(AbstractRoom abstractRoom) {
        OrbitingSpells.atBattleStart();
    }

    @Override
    public void receivePostPlayerUpdate() {
        OrbitingSpells.update();
    }

    private static BecomeAwesomeButton becomeAwesomeButton;

    public static void renderCombatUiElements(SpriteBatch sb) {
        if (Wiz.isInCombat() && AbstractDungeon.player.chosenClass.equals(CharacterFile.Enums.THE_CASTER)) {
            becomeAwesomeButton.render(sb);
        }
    }

    @Override
    public void receivePostDungeonUpdate() {
        becomeAwesomeButton.update();
    }

    @Override
    public void receiveStartGame() {
        becomeAwesomeButton = new BecomeAwesomeButton();
    }

    private static final Color ENCHANT_MAGENTA = new Color(0.8F, 0.0F, 0.5F, 0F);

    @Override
    public void receivePostInitialize() {
        // Create the Mod Menu
        ModPanel settingsPanel = new ModPanel();

        // Load the Mod Badge
        Texture modBadgeTexture = TexLoader.getTexture(modID + "Resources/images/ui/modBadge.png");
        BaseMod.registerModBadge(modBadgeTexture, "", "", "", settingsPanel);

        if (Loader.isModLoaded("rare-cards-sparkle")) {
            SparkleHandler.init();
        }
    }
}
