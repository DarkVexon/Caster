package code.cards;

import basemod.helpers.CardModifierManager;
import code.cardmods.InfestModifier;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;

public class Bees extends AbstractCasterCard implements OnInfestCard {
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

    @Override
    public void onInfest(int newAmt) {
        //TODO: Loc
        StringBuilder sb = new StringBuilder();
        sb.append("BEE");
        for (int i = 0; i < newAmt; i++) {
            sb.append("E");
        }
        sb.append("S!!!");
        this.name = sb.toString();
        this.initializeTitle();
    }

    public void calculateCardDamage(AbstractMonster mo) {
        int realBaseDamage = this.baseDamage;
        this.baseDamage += InfestModifier.getInfestCount(this);
        super.calculateCardDamage(mo);
        this.baseDamage = realBaseDamage;
        this.isDamageModified = this.damage != this.baseDamage;
    }

    public void applyPowers() {
        int realBaseDamage = this.baseDamage;
        this.baseDamage += InfestModifier.getInfestCount(this);
        super.applyPowers();
        this.baseDamage = realBaseDamage;
        this.isDamageModified = this.damage != this.baseDamage;
    }
}