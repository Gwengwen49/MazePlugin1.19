package fr.gwengwen49.mazeplugin.maze.parts.components;

import fr.gwengwen49.mazeplugin.maze.parts.Part;
import org.checkerframework.checker.index.qual.EnsuresLTLengthOfIf;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ComponentOf {

    Of of();

   @interface Of
    {
        Class<? extends Part> part();
    }
}


