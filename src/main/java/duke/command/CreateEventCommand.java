package duke.command;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.TasksController;
import duke.Ui;
import duke.Storage;
import duke.exception.EmptyContentException;
import duke.exception.InvalidTimeException;
/**
 * CreatEventCommand will execute the command of creating a new event.
 */
public class CreateEventCommand extends Command {

    /**
     * An abstract method that every child class needs to implement
     * @param controller Duke task controller
     * @param taskText if it's add task command, then pass the context of the task.
     * @param taskTime if it's add Event or Deadline, then pass the time
     * @param taskIndex if it's mark or unmark command, then pass the task number
     * @param keyword if it's find command, then pass the keyword
     * @param storage Duke IO processor
     */
    public String execute(TasksController controller, String taskText, String taskTime, int taskIndex,
                          String keyword, Storage storage) {
        String response = "";
        Event event = new Event(taskText, taskTime);
        controller.addToList(event);
        response += "Successfully added! You can see it in your task list as follows:\n";
        response += event.toString();
        return response;

    }
}