package ru.imatveev.application;

import org.reflections.Reflections;
import ru.imatveev.application.command.AbstractCommand;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>please, print new commands in package <b>ru.imatveev.application.command</b></p>
 */
public class CommandScanner {
    List<AbstractCommand> getCommands() {
        Reflections reflections = new Reflections("ru.imatveev.application.command");
        return reflections.getSubTypesOf(AbstractCommand.class)
                .stream()
                .map(getClassFunction())
                .collect(Collectors.toList());
    }

    private Function<Class<? extends AbstractCommand>, ? extends AbstractCommand> getClassFunction() {
        return clazz -> {
            try {
                return clazz.getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
            throw new CustomException(
                    "there are no commands for application" +
                            "please, inherits your command from AbstractCommand.class"
            );
        };
    }
}
