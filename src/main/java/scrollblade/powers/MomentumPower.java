package scrollblade.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static scrollblade.ScrollbladeMod.makeID;

public class MomentumPower extends BasePower {
    public static final String POWER_ID = makeID("MomentumPower");
    private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;
    private static final boolean TURN_BASED = true;

    public MomentumPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    public void onUseCard (AbstractCard card, UseCardAction action) {
        if (card.cost == this.amount || card.cost == -1 && card.energyOnUse == this.amount) {
            addToBot(new GainEnergyAction(1));
            addToBot(new ApplyPowerAction((AbstractCreature)this.owner, (AbstractCreature)this.owner, new MomentumPower((AbstractCreature)this.owner, 1)));
        }
        else {
            flash();
            addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, this));
        }
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1];
    }

    public void atEndOfRound() {
        flash();
        addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, this));
    }
}
