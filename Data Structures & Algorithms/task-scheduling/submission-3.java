class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequences = new int[26];
        for (char t : tasks) {
            frequences[t-'A']++;
        }
        List<TaskWithPriority> list = new ArrayList<>();
        for (int i = 0; i < frequences.length; i++) {
            if (frequences[i] > 0) {
                list.add(new TaskWithPriority(i, frequences[i]));
            }
        }
        Queue<TaskWithPriority> maxHeap = new PriorityQueue<>(Comparator.comparingInt(TaskWithPriority::getExecsLeft).reversed());
        maxHeap.addAll(list);
        List<TaskWithPriority> tmpHoldOff = new LinkedList<>();

        int res = 0;
        while (!maxHeap.isEmpty()) {
            for (int i = 0; i < n + 1; i++) {
                res++; // tick
                if (maxHeap.isEmpty()) {
                    if (tmpHoldOff.isEmpty()) {
                        return res - 1;
                    }
                    continue;
                }
                TaskWithPriority polled = maxHeap.poll();
                if (polled.execsLeft-- > 1) {
                    tmpHoldOff.add(polled);
                }
            }
            
            for (TaskWithPriority twp : tmpHoldOff) {
                maxHeap.offer(twp);
            }
            tmpHoldOff.clear();
        }
        return res;
    }

    class TaskWithPriority {
        int task;
        int execsLeft;

        TaskWithPriority(int task, int execsLeft) {
            this.task = task;
            this.execsLeft = execsLeft;
        }

        int getExecsLeft() {
            return this.execsLeft;
        }
    }
}
