package scrollblade.cards.common;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import scrollblade.cards.BaseCard;
import scrollblade.character.ScrollbladeCharacter;
import scrollblade.powers.DictumPower;
import scrollblade.powers.MomentumPower;
import scrollblade.util.CardStats;

public class Inhale extends BaseCard {
    public static final String ID = makeID("Inhale");
    private static final CardStats info = new CardStats(
            ScrollbladeCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.SELF,
            0
    );

    public Inhale() {
        super(ID, info);{
            setExhaust(true, false);
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster M) {
        addToBot(new DrawCardAction(p.getPower(MomentumPower.POWER_ID).amount));
    }
}
