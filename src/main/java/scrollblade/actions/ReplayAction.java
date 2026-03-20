package scrollblade.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class ReplayAction extends AbstractGameAction {
    public void update() {
        AbstractCard c = AbstractDungeon.actionManager.cardsPlayedThisCombat.get(AbstractDungeon.actionManager.cardsPlayedThisCombat.size()-2);
        if (c instanceof CardReplayCheck) {
            ((CardReplayCheck) c).isReplay = true; // works :)
        }
        if (AbstractDungeon.actionManager.cardsPlayedThisCombat.size() >= 2 && (AbstractDungeon.actionManager.cardsPlayedThisCombat.get(AbstractDungeon.actionManager.cardsPlayedThisCombat.size() - 2)).type != AbstractCard.CardType.POWER) {
            AbstractCard tmp = c.makeSameInstanceOf();
            tmp.purgeOnUse = true;
            addToBot(new NewQueueCardAction(tmp, true, false, true));
        }
        this.isDone = true;
    }
}