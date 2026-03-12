package scrollblade.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static scrollblade.ScrollbladeMod.makeID;

public class HeresiarchPower extends BasePower {
    public static final String POWER_ID = makeID("HeresiarchPower");
    private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;
    private static final boolean TURN_BASED = true;

    public HeresiarchPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    public void atStartOfTurn() {
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            flash();
            for (int i = 0; i < this.amount; i++)
                addToBot(new GainEnergyAction(owner.getPower(SacrilegePower.POWER_ID).amount));
                addToBot(new DrawCardAction(owner.getPower(SacrilegePower.POWER_ID).amount));
        }
    }
    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + owner.getPower(SacrilegePower.POWER_ID).amount + DESCRIPTIONS[1] + owner.getPower(SacrilegePower.POWER_ID).amount + DESCRIPTIONS[2] + amount + DESCRIPTIONS[3];
    }
}