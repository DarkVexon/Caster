package code.patches;

import code.cards.spells.AbstractSpellCard;
import code.powers.SorcererSupremePower;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

@SpirePatch(clz = AbstractCard.class, method = "freeToPlay")
public class SorcererSupremePatch {
    public static boolean Postfix(boolean __result, AbstractCard __instance) {
        if (AbstractDungeon.player != null && AbstractDungeon.currMapNode != null &&
                (AbstractDungeon.getCurrRoom()).phase == AbstractRoom.RoomPhase.COMBAT &&
                AbstractDungeon.player.hasPower(SorcererSupremePower.ID) && __instance instanceof AbstractSpellCard)
            return true;
        return __result;
    }
}
