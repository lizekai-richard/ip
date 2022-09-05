package duke.command;

import duke.storage.Storage;
import duke.task.TasksController;
import duke.exception.NoSuchTaskException;
/**
 * DeleteCommand will execute the command of deleting a task.
 */
public class DeleteTaskCommand extends Command {

    /**
     * Execute DeleteTaskCommand
     * @param controller Duke task controller
     * @param taskText content of a task (if any)
     * @param taskTime time of a task (if any)
     * @param taskIndex index of a task (if any)
     * @param keywords keywords for finding (if any)
     * @param storage Duke IO processor
     */
    public String execute(TasksController controller, String taskText, String taskTime, int taskIndex,
                          Storage storage, String ...keywords) {
        assert taskTime.length() == 0 : "The taskTime of should not be used for DeleteTaskCommand";
        assert taskText.length() == 0 : "The taskText should not be used for DeleteTaskCommand";
        assert taskIndex != -1 : "The taskIndex should not be -1";
        assert keywords == null : "The keywords should not be used for DeleteTaskCommand";
        String response = "";
        try {
            controller.deleteFromList(taskIndex);
            response = "Successfully deleted! You can use list command to check your tasks.\n";
        } catch (NoSuchTaskException nte) {
            response = "Your target task doesn't exist. Please try again...";
        }
        return response;
    }

}
