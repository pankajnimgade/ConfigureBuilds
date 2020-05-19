package configure.test.configurebuilds.activities.test106.buffer

/**
 * Created by Pankaj Nimgade on 5/19/2020.
 */
class DataSource106 {

    companion object {

        @JvmStatic
        fun createTaskList(): List<Task106> {
            val taskList = mutableListOf<Task106>()
            taskList.add(Task106("Take out the trash", true, 3))
            taskList.add(Task106("Walk the dog", false, 2))
            taskList.add(Task106("Make my bed", true, 1))
            taskList.add(Task106("Unload the dishwasher", false, 0))
            taskList.add(Task106("Make Dinner", true, 5))
            return taskList
        }
    }
}