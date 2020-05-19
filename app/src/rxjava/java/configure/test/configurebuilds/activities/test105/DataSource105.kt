package configure.test.configurebuilds.activities.test105

/**
 * Created by Pankaj Nimgade on 5/19/2020.
 */
class DataSource105 {

    companion object {

        @JvmStatic
        fun createTaskList(): List<Task105> {
            val taskList = mutableListOf<Task105>()
            taskList.add(Task105("Take out the trash", true, 3))
            taskList.add(Task105("Walk the dog", false, 2))
            taskList.add(Task105("Make my bed", true, 1))
            taskList.add(Task105("Unload the dishwasher", false, 0))
            taskList.add(Task105("Make Dinner", true, 5))
            return taskList
        }
    }
}