package code.cards;

import basemod.helpers.CardModifierManager;
import code.cardmods.InfestModifier;
import code.cards.other.Bug;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;

public class Bees extends AbstractCasterCard {
    public final static String ID = makeID(Bees.class.getSimpleName());
    // intellij stuff attack, enemy, rare, 1, , , , 1, 1

    public Bees() {
        super(ID, 2, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        baseDamage = 1;
        baseMagicNumber = magicNumber = 8;
        CardModifierManager.addModifier(this, new InfestModifier());
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        for (int i = 0; i < magicNumber; i++) {
            dmg(m, AbstractGameAction.AttackEffect.BLUNT_LIGHT);
        }
    }

    public void upp() {
        upgradeMagicNumber(2);
    }

    public void calculateCardDamage(AbstractMonster mo) {
        int realBaseDamage = this.baseDamage;
        this.baseDamage += getCount();
        super.calculateCardDamage(mo);
        this.baseDamage = realBaseDamage;
        this.isDamageModified = this.damage != this.baseDamage;
    }

    public void applyPowers() {
        int realBaseDamage = this.baseDamage;
        this.baseDamage += getCount();
        super.applyPowers();
        this.baseDamage = realBaseDamage;
        this.isDamageModified = this.damage != this.baseDamage;
    }

    private static int getCount() {
        return (int) AbstractDungeon.actionManager.cardsPlayedThisTurn.stream().filter(q -> q.cardID.equals(Bug.ID)).count();
    }
}