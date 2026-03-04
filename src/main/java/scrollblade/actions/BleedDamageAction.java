package scrollblade.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class BleedDamageAction extends AbstractGameAction {
    private final int amount;
    private final AbstractPower callingPower;
    private final boolean shouldReduce;

    public BleedDamageAction(AbstractCreature target, AbstractPower callingPower, boolean shouldReduce) {
        this.target = target;
        this.amount = callingPower.amount;
        this.callingPower = callingPower;
        this.shouldReduce = shouldReduce;
        this.duration = this.startDuration = Settings.ACTION_DUR_FAST;
    }

    public BleedDamageAction(AbstractCreature target, AbstractPower callingPower) {
        this(target, callingPower, true);
    }

    @Override
    public void update() {
        if(shouldCancelAction()) {
            this.isDone = true;
        } else {
            tickDuration();
            if (this.isDone) {

                callingPower.flashWithoutSound();
                CardCrawlGame.sound.play("POWER_POISON", 0.05F);
                this.target.damage(new DamageInfo(this.source, this.amount, DamageInfo.DamageType.HP_LOSS));
                if (shouldReduce) {
                    addToBot(new ReducePowerAction(target, AbstractDungeon.player, callingPower,
                            (callingPower.amount / 2) + (callingPower.amount % 2)
                    ));
                }
            }
        }
    }
}