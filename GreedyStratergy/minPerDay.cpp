#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;
bool isValid(int tasksPerDay, vector<int>& taskTimes, int days) {
    int totalDaysNeeded = 0;
    for (int task : taskTimes) {
        totalDaysNeeded += ceil((double)task / tasksPerDay);
        if (totalDaysNeeded > days) {
            return false;
        }
    }
    return true;
}
int findMinimumTasksPerDay(vector<int>& taskTimes, int days) {
    int left = 1;
    int right = *max_element(taskTimes.begin(), taskTimes.end());
    int answer = right;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (isValid(mid, taskTimes, days)) {
            answer = mid;  // Store the possible answer
            right = mid - 1;  // Try for a smaller number
        } else {
            left = mid + 1;  // Try for a larger number
        }
    }
    return answer;
}
int main() {
    vector<int> taskTimes = {3, 4, 7, 15};
    int days = 10;

    cout << "Minimum tasks per day: " << findMinimumTasksPerDay(taskTimes, days) << endl;
    return 0;
} i
