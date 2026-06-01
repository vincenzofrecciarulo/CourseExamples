package org.generation.italy.examples.oo.mud.roles;

import org.generation.italy.examples.oo.mud.GameContext;
import org.generation.italy.examples.oo.mud.commands.CommandOutcome;

public interface SpecialAbility {
    String getName();
    String getDescription();
    CommandOutcome use(GameContext context, String targetName);
}
