package configure.test.configurebuilds.activities.test104

/**
 * Created by Pankaj Nimgade on 5/18/2020.
 */
class DataSource104 {

    companion object {

        @JvmStatic
        fun createTaskList(): List<Task104> {
            val taskList = mutableListOf<Task104>()
            taskList.add(Task104("Take out the trash", true, 3))
            taskList.add(Task104("Walk the dog", false, 2))
            taskList.add(Task104("Make my bed", true, 1))
            taskList.add(Task104("Unload the dishwasher", false, 0))
            taskList.add(Task104("Make Dinner", true, 5))
            return taskList
        }
    }
}