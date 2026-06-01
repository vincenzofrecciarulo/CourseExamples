package org.generation.italy.examples.oo.mud;

public class CombatAction {
    private final CombatActionType type;
    private final String payload;

    private CombatAction(CombatActionType type, String payload) {
        this.type = type;
        this.payload = payload;
    }

    public static CombatAction attack() {
        return new CombatAction(CombatActionType.ATTACK, "");
    }

    public static CombatAction useAbility(String payload) {
        return new CombatAction(CombatActionType.USE_ABILITY, payload == null ? "" : payload);
    }

    public static CombatAction flee() {
        return new CombatAction(CombatActionType.FLEE, "");
    }

    public static CombatAction waitTurn() {
        return new CombatAction(CombatActionType.WAIT, "");
    }

    public CombatActionType getType() {
        return type;
    }

    public String getPayload() {
        return payload;
    }
}
