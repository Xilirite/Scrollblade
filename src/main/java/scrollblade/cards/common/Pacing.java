package scrollblade.cards.common;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;
import scrollblade.cards.BaseCard;
import scrollblade.character.ScrollbladeCharacter;
import scrollblade.powers.MomentumPower;
import scrollblade.util.CardStats;

public class Pacing extends BaseCard {
    public static final String ID = makeID("Pacing");
    private static final CardStats info = new CardStats(
            ScrollbladeCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            1
    );
    private static final int BLOCK = 3;
    private static final int UPG_BLOCK = 2;
    private static final int MAGIC = 7;
    private static final int UPG_MAGIC = 2;

    public Pacing() {
        super(ID, info);

        setBlock(BLOCK, UPG_BLOCK);
        setMagic(MAGIC, UPG_MAGIC);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, this.block));
        if (p.hasPower(MomentumPower.POWER_ID)) {
            addToBot(new GainBlockAction(p, p, this.magicNumber));}
        else {
            addToBot(new ApplyPowerAction(p, p, new MomentumPower(p, 1), 1));
        }
    }
}