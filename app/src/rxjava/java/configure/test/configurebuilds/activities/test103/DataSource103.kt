package configure.test.configurebuilds.activities.test103

/**
 * Created by Pankaj Nimgade on 5/18/2020.
 */
class DataSource103 {

    companion object {

        @JvmStatic
        fun createTaskList(): List<Task103> {
            val taskList = mutableListOf<Task103>()
            taskList.add(Task103("Take out the trash", true, 3))
            taskList.add(Task103("Walk the dog", false, 2))
            taskList.add(Task103("Make my bed", true, 1))
            taskList.add(Task103("Unload the dishwasher", false, 0))
            taskList.add(Task103("Make Dinner", true, 5))
            return taskList
        }
    }
}