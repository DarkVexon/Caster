package code.patches;

import basemod.ReflectionHacks;
import code.powers.BrellaBouncePower;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAndDeckAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class BrellaBouncePatches {
    @SpirePatch(clz = MakeTempCardInDrawPileAction.class, method = "update")
    public static class NoStatusShuffleIn {
        public static SpireReturn Prefix(MakeTempCardInDrawPileAction __instance) {
            AbstractCard card = ReflectionHacks.getPrivate(__instance, MakeTempCardInDrawPileAction.class, "cardToMake");
            if (card.type == AbstractCard.CardType.STATUS) {
                AbstractPower p = AbstractDungeon.player.getPower(BrellaBouncePower.ID);
                if (p != null) {
                    p.flash();
                    __instance.isDone = true;
                    return SpireReturn.Return();
                }
            }
            return SpireReturn.Continue();
        }
    }

    @SpirePatch(clz = MakeTempCardInDiscardAction.class, method = "update")
    public static class NoStatusShuffleIntoDiscard {
        public static SpireReturn Prefix(MakeTempCardInDiscardAction __instance) {
            AbstractCard card = ReflectionHacks.getPrivate(__instance, MakeTempCardInDiscardAction.class, "c");
            if (card.type == AbstractCard.CardType.STATUS) {
                AbstractPower p = AbstractDungeon.player.getPower(BrellaBouncePower.ID);
                if (p != null) {
                    p.flash();
                    __instance.isDone = true;
                    return SpireReturn.Return();
                }
            }
            return SpireReturn.Continue();
        }
    }

    @SpirePatch(clz = MakeTempCardInDiscardAndDeckAction.class, method = "update")
    public static class NoStatusShuffleOrbWalker {
        public static SpireReturn Prefix(MakeTempCardInDiscardAndDeckAction __instance) {
            AbstractCard card = ReflectionHacks.getPrivate(__instance, MakeTempCardInDiscardAndDeckAction.class, "cardToMake");
            if (card.type == AbstractCard.CardType.STATUS) {
                AbstractPower p = AbstractDungeon.player.getPower(BrellaBouncePower.ID);
                if (p != null) {
                    p.flash();
                    __instance.isDone = true;
                    return SpireReturn.Return();
                }
            }
            return SpireReturn.Continue();
        }
    }
}
