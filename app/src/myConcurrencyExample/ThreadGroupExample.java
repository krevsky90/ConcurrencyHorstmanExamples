package myConcurrencyExample;

public class ThreadGroupExample {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("groupName");
        Thread t1 = new Thread(threadGroup, "t1");
        Thread t2 = new Thread(threadGroup, "t2");

        threadGroup.interrupt();    //for all threads of this group

        if(threadGroup.activeCount() == 0) {
            //all threads of current group are stoped
        }




    }
}
