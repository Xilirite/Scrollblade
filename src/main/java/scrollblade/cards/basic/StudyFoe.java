package scrollblade.cards.basic;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import scrollblade.cards.BaseCard;
import scrollblade.character.ScrollbladeCharacter;
import scrollblade.powers.StudyFoePower;
import scrollblade.util.CardStats;

public class StudyFoe extends BaseCard {
    public static final String ID = makeID("StudyFoe");
    private static final CardStats info = new CardStats(
            ScrollbladeCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.BASIC,
            CardTarget.SELF,
            2
    );
    private static final int BLOCK = 11;
    private static final int UPG_BLOCK = 3;

    public StudyFoe() {
        super(ID, info);

        setBlock(BLOCK, UPG_BLOCK);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, this.block));
        addToBot(new ApplyPowerAction(p, p, new StudyFoePower(p, 1)));
    }
}
