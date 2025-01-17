package cwq.command;

import java.util.ArrayList;

import cwq.storage.Storage;
import cwq.task.Task;
import cwq.task.TasksController;

/**
 * Remind users wof their upcoming deadline
 */
public class RemindDeadlineCommand extends Command {
    /**
     * Execute RemindDeadlineCommand
     * @param controller Duke task controller
     * @param taskText content of a task (if any)
     * @param taskTime time of a task (if any)
     * @param taskIndex index of a task (if any)
     * @param keywords keywords for finding (if any)
     * @param storage Duke IO processor
     */
    public String execute(TasksController controller, String taskText, String taskTime, int taskIndex,
                          Storage storage, String ...keywords) {
        assert taskTime.length() == 0 : "The taskTime of should not be used for RemindDeadlineCommand";
        assert taskText.length() == 0 : "The taskText should not be used for RemindDeadlineCommand";
        assert taskIndex == -1 : "The taskIndex should not be used for RemindDeadlineCommand";
        assert keywords[0].equals("") : "The keywords should not be used for RemindDeadlineCommand";

        ArrayList<Task> deadlines = controller.getDeadlines();
        String response = "";
        if (deadlines.size() == 0) {
            response = "Congratulations! You have no deadlines ahead.";
        } else {
            response += "Here are all your upcoming deadlines:\n";
            response += controller.getTasksString(deadlines);
        }
        return response;
    }
}
