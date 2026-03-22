package scrollblade.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import scrollblade.cards.uncommon.EchoingStrike;

public class ReplayPreviousCardAction extends AbstractGameAction {
    public void update() {
        AbstractCard c = AbstractDungeon.actionManager.cardsPlayedThisCombat.get(AbstractDungeon.actionManager.cardsPlayedThisCombat.size()-2);
        if (c instanceof EchoingStrike) {
            ((EchoingStrike) c).isReplay = true;
        }
        if (AbstractDungeon.actionManager.cardsPlayedThisCombat.size() >= 2 && c.type != AbstractCard.CardType.POWER) {
            AbstractCard tmp = c.makeSameInstanceOf();
            tmp.purgeOnUse = true;
            addToTop(new NewQueueCardAction(tmp, true, false, true));
        }
        this.isDone = true;
    }
}