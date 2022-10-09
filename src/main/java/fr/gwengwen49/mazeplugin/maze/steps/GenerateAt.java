package fr.gwengwen49.mazeplugin.maze.steps;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;
import java.util.Optional;

@Target(ElementType.TYPE)
public @interface GenerateAt
{
    Class<? extends GenStep> step() default WallStep.class;
}
