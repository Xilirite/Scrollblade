package scrollblade.cards.rare;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import scrollblade.cards.BaseCard;
import scrollblade.character.ScrollbladeCharacter;
import scrollblade.powers.DictumPower;
import scrollblade.powers.SacrilegePower;
import scrollblade.util.CardStats;

public class PurgeDoubt extends BaseCard {
    public static final String ID = makeID("PurgeDoubt");
    private static final CardStats info = new CardStats(
            ScrollbladeCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.RARE,
            CardTarget.SELF,
            0
    );

    public PurgeDoubt() {
        super(ID, info);
        {
            setExhaust(true, false);
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster M) {
        addToBot(new ApplyPowerAction(p, p, new DictumPower(p, p.getPower(SacrilegePower.POWER_ID).amount)));
    }
}