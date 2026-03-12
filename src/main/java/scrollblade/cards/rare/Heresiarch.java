package scrollblade.cards.rare;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import scrollblade.cards.BaseCard;
import scrollblade.character.ScrollbladeCharacter;
import scrollblade.powers.HeresiarchPower;
import scrollblade.util.CardStats;

public class Heresiarch extends BaseCard {
    public static final String ID = makeID("Heresiarch");
    private static final CardStats info = new CardStats(
            ScrollbladeCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.RARE,
            CardTarget.SELF,
            3
    );

    public Heresiarch() {
        super(ID, info);
        setCostUpgrade(2);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster M) {
        addToBot(new ApplyPowerAction(p, p, new HeresiarchPower(p, 1), 1));
    }
}