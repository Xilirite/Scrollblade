package scrollblade.cards.uncommon;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import scrollblade.cards.BaseCard;
import scrollblade.character.ScrollbladeCharacter;
import scrollblade.powers.SickThrillsPower;
import scrollblade.util.CardStats;

public class SickThrills extends BaseCard {
    public static final String ID = makeID("SickThrills");
    private static final CardStats info = new CardStats(
            ScrollbladeCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.UNCOMMON,
            CardTarget.SELF,
            2
    );
    private static final int MAGIC = 3;
    private static final int UPG_MAGIC = 2;

    public SickThrills() {
        super(ID, info);

        setMagic(MAGIC, UPG_MAGIC);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster M) {
        addToBot(new ApplyPowerAction((AbstractCreature) p, (AbstractCreature) p, new SickThrillsPower((AbstractCreature) p, magicNumber), magicNumber));
    }
}