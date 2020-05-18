package configure.test.configurebuilds.activities.test101

/**
 * Created by Pankaj Nimgade on 5/18/2020.
 */
class DataSource {

    companion object {

        @JvmStatic
        fun createTaskList(): List<Task> {
            val taskList = mutableListOf<Task>()
            taskList.add(Task("Take out the trash", true, 3))
            taskList.add(Task("Walk the dog", false, 2))
            taskList.add(Task("Make my bed", true, 1))
            taskList.add(Task("Unload the dishwasher", false, 0))
            taskList.add(Task("Make Dinner", true, 5))
            return taskList
        }
    }
}