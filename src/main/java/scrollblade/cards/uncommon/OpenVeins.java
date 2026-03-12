package scrollblade.cards.uncommon;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import scrollblade.cards.BaseCard;
import scrollblade.character.ScrollbladeCharacter;
import scrollblade.powers.BleedPower;
import scrollblade.util.CardStats;

public class OpenVeins extends BaseCard {
    public static final String ID = makeID("OpenVeins");
    private static final CardStats info = new CardStats(
            ScrollbladeCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.UNCOMMON,
            CardTarget.SELF,
            2
    );
    private static final int MAGIC = 16;
    private static final int UPG_MAGIC = 8;

    public OpenVeins() {
        super(ID, info);

        setMagic(MAGIC, UPG_MAGIC);
        setExhaust(true);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, new BleedPower((AbstractCreature)m, this.magicNumber), this.magicNumber));
    }
}