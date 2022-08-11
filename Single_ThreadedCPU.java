class Solution {
    public int[] getOrder(int[][] tasks) {
        // Simply use a priorityQueue <sort by processingTime[i] and if equal processing time then sort by smallest i-index
        // Add all processes to Priority.Queue at once
        // Then simply add in-order of pop() from pq to int[]

        int res[] = new int[tasks.length];

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> (a[1] != b[1] ? (a[1] - b[1]) : (a[2] - b[2])));
        int sortedTasks[][] = new int[tasks.length][3];

        for(int i = 0; i < tasks.length; i++){
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i;  //Since i is needed for Output
        }

        Arrays.sort(sortedTasks, (a,b) -> Integer.compare(a[0], b[0]));
        
        long currTime = 0;
        int taskIndex = 0;
        int ansIndex = 0;

        //Stop when no tasks are left in array and heap
        while(taskIndex < tasks.length || !pq.isEmpty()){
            if(pq.isEmpty() && currTime < sortedTasks[taskIndex][0]){
                //When pq is empty, try updating currTime to next task's enqueue time
                currTime = sortedTasks[taskIndex][0];
            }

            //Push all task whose enqueueTime  <= currTime into heap
            while(taskIndex < tasks.length && currTime >= sortedTasks[taskIndex][0]){
                pq.add(sortedTasks[taskIndex]);
                ++taskIndex;
            }

            int processTime = pq.peek()[1];
            int index = pq.peek()[2];
            pq.remove();

            //Complete this task and increment currTime
            currTime += processTime;
            res[ansIndex++] = index;
        }

        return res;
    }
}