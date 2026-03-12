package scrollblade.cards.rare;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import scrollblade.cards.BaseCard;
import scrollblade.character.ScrollbladeCharacter;
import scrollblade.powers.DictumPower;
import scrollblade.util.CardStats;

public class Revelation extends BaseCard {
    public static final String ID = makeID("Revelation");
    private static final CardStats info = new CardStats(
            ScrollbladeCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.RARE,
            CardTarget.SELF,
            1
    );

    public Revelation() {
        super(ID, info);
        {
            setExhaust(true);
            setCostUpgrade(0);
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster M) {
        addToBot(new GainEnergyAction(p.getPower(DictumPower.POWER_ID).amount));
        addToBot(new DrawCardAction(p.getPower(DictumPower.POWER_ID).amount));
        flash();
        addToBot(new RemoveSpecificPowerAction(p, p, DictumPower.POWER_ID));
    }
}