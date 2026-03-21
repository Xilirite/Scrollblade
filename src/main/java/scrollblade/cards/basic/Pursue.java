package scrollblade.cards.basic;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import scrollblade.cards.BaseCard;
import scrollblade.character.ScrollbladeCharacter;
import scrollblade.util.CardStats;

public class Pursue extends BaseCard {
    public static final String ID = makeID("Pursue");
    private static final CardStats info = new CardStats(
            ScrollbladeCharacter.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.BASIC,
            CardTarget.ENEMY,
            1
    );
    private static final int DAMAGE = 7;
    private static final int UPG_DAMAGE = 1;

    public Pursue() {
        super(ID, info);

        setDamage(DAMAGE, UPG_DAMAGE);
        setExhaust(true, false);
        isReplay = false;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
    }
}