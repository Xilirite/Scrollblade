package scrollblade.powers;

import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static scrollblade.ScrollbladeMod.makeID;

public class Dictum extends BasePower {
    public static final String POWER_ID = makeID("Dictum");
    private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;
    private static final boolean TURN_BASED = true;

    public Dictum(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

        public float atDamageGive(float damage, DamageInfo.DamageType type) {
        //If NORMAL (attack) damage, modify damage by this power's amount
        return type == DamageInfo.DamageType.NORMAL ? damage + this.amount : damage;
    }

    public float modifyBlock(float blockAmount) {
        if ((blockAmount += (float)this.amount) <0.0F)
            return 0.0F;
        return blockAmount;
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1] + amount +DESCRIPTIONS[2];
    }

    public void atEndOfRound() {
        flash();
        if (this.amount == 0) {
            addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, this));
        } else
            addToBot(new ReducePowerAction(this.owner, this.owner, this, 1));
    }
}
