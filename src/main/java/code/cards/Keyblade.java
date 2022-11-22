package code.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.relics.CursedKey;

import static code.ModFile.makeID;

public class Keyblade extends AbstractCasterCard {
    public final static String ID = makeID(Keyblade.class.getSimpleName());
    // intellij stuff attack, enemy, uncommon, 8, 2, , , 2, 

    public Keyblade() {
        super(ID, 1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = 8;
        baseMagicNumber = magicNumber = 2;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {

    }

    private static int countKeys() {
        int keyAmt = 0;
        if (Settings.hasRubyKey) keyAmt += 1;
        if (Settings.hasSapphireKey) keyAmt += 1;
        if (Settings.hasEmeraldKey) keyAmt += 1;
        if (AbstractDungeon.player.hasRelic(CursedKey.ID)) keyAmt += 1;
        return keyAmt;
    }

    public void upp() {
        upgradeDamage(2);
    }
}