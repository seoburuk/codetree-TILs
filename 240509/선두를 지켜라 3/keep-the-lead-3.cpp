#include <algorithm>
#include <climits>
#include <iostream>
#include <string>
#define MAX_RANGE 1000000
using namespace std;
int a_pos[MAX_RANGE + 1];
int b_pos[MAX_RANGE + 1];
int n, m, cnt;
string last_winner, curr_winner;

void Initialize() {
  for (int i = 0; i <= MAX_RANGE; i++)
    a_pos[i] = b_pos[i] = INT_MIN;
  a_pos[0] = b_pos[0] = 0;
}

int main() {
  cin >> n >> m;
  
  Initialize();
  
  int a_idx = 0, b_idx = 0;
  for (int i = 1; i <= n; i++) {
    int v, t;
    cin >> v >> t;
    for (int j = 1; j <= t; j++) {
      a_idx++;
      a_pos[a_idx] = a_pos[a_idx - 1] + v;
    }
  }
  
  for (int i = 1; i <= m; i++) {
    int v, t;
    cin >> v >> t;
    for (int j = 1; j <= t; j++) {
      b_idx++;
      b_pos[b_idx] = b_pos[b_idx - 1] + v;
    }
  }
  
  for (int i = 1; i <= max(a_idx, b_idx); i++) {
    if (a_pos[i] == INT_MIN)
      a_pos[i] = a_pos[i - 1];
    if (b_pos[i] == INT_MIN)
      b_pos[i] = b_pos[i - 1];
  }
  
  for (int i = 1; i <= max(a_idx, b_idx); i++) {
    if (a_pos[i] < b_pos[i])
      curr_winner = "b";
    else if (a_pos[i] > b_pos[i])
      curr_winner = "a";
    else
      curr_winner = "ab";

    if (last_winner != curr_winner) {
      cnt++;
      last_winner = curr_winner;
    }
  }
  
  cout << cnt;
  return 0;
}