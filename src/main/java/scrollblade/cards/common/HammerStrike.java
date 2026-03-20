package scrollblade.cards.common;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import scrollblade.cards.BaseCard;
import scrollblade.character.ScrollbladeCharacter;
import scrollblade.powers.MomentumPower;
import scrollblade.util.CardStats;

public class HammerStrike extends BaseCard {
    public static final String ID = makeID("HammerStrike");
    private static final CardStats info = new CardStats(
            ScrollbladeCharacter.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ALL_ENEMY,
            3
    );
    private static final int DAMAGE = 18;
    private static final int UPG_DAMAGE = 6;
    private static final int MAGIC = 1;

    public HammerStrike() {
        super(ID, info);

        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGIC);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.BLUNT_HEAVY));
        if (p.hasPower(MomentumPower.POWER_ID)) {
            if (p.getPower(MomentumPower.POWER_ID).amount == cost) {
                addToBot(new DrawCardAction(this.magicNumber));
            }
        }
    }
}