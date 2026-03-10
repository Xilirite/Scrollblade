package scrollblade.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static scrollblade.ScrollbladeMod.makeID;

public class SickThrillsPower extends BasePower {
    public static final String POWER_ID = makeID("SickThrillsPower");
    private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;
    private static final boolean TURN_BASED = false;

    public SickThrillsPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1];
    }

    public void onAttack(DamageInfo info, int damageAmount, AbstractCreature target) {
        if (damageAmount > 0 && target != this.owner && info.type == DamageInfo.DamageType.NORMAL) {
            if (target.hasPower(Bleed.POWER_ID)) {
                flash();
                addToTop(new ApplyPowerAction(target, this.owner, new Bleed(target, this.amount), this.amount, true));
            }
        }
    }
}