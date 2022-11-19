package code.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.actions.GameActionManager;

@SpirePatch(
        clz = GameActionManager.class,
        method = "callEndOfTurnActions"
)
public class ResetEnchantsAtTurnEnd {
    public static void Postfix(GameActionManager __instance) {
        EnchantedCardsPatch.resetEnchantedCards();
    }
}