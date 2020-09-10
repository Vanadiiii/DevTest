package ru.imatveev.application;

import org.reflections.Reflections;
import ru.imatveev.application.command.ICommand;
import ru.imatveev.application.exceptions.IllegalCommandNameException;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>please, write new commands in package <b>ru.imatveev.application.command</b></p>
 */
public class CommandScanner {
    List<ICommand> getCommands() {
        Reflections reflections = new Reflections("ru.imatveev.application.command");
        return reflections.getSubTypesOf(ICommand.class)
                .stream()
                .map(getClassFunction())
                .collect(Collectors.toList());
    }

    private Function<Class<? extends ICommand>, ? extends ICommand> getClassFunction() {
        return clazz -> {
            try {
                return clazz.getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
            throw new IllegalCommandNameException(
                    "there are no available commands for application\n" +
                            "please, inherit your command from AbstractCommand.class"
            );
        };
    }
}
