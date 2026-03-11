package scrollblade.cards.common;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import scrollblade.cards.BaseCard;
import scrollblade.character.ScrollbladeCharacter;
import scrollblade.powers.DictumPower;
import scrollblade.util.CardStats;

public class Recitation extends BaseCard {
    public static final String ID = makeID("Recitation");
    private static final CardStats info = new CardStats(
            ScrollbladeCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.SELF,
            1
    );
    private static final int MAGIC = 2;
    private static final int UPG_MAGIC = 1;

    public Recitation() {
        super(ID, info);
        {

            setMagic(MAGIC, UPG_MAGIC);
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster M) {
        addToBot(new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, new DictumPower((AbstractCreature)p, magicNumber)));
    }
}
