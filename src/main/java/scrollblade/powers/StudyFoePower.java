package scrollblade.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static scrollblade.ScrollbladeMod.makeID;

public class StudyFoePower extends BasePower {
    public static final String POWER_ID = makeID("StudyFoePower");
    private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;
    private static final boolean TURN_BASED = true;

    public StudyFoePower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    public void atStartOfTurn() {
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            flash();
            addToBot(new ApplyPowerAction(this.owner, this.owner, new MomentumPower(this.owner, 1)));
            addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, this));
        }
    }
    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }
}