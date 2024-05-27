#include <iostream>
#define MAX 100
using namespace std;
int n;
int arr[MAX][MAX];
bool InRange(int x, int y){
    return x >= 0 && x < n  && y >= 0 && y < n;
}
int main() {
    cin>> n;
    int nx = n - 1, ny = n - 1;
    int dy[4] = {-1, 0, 1, 0};
    int dx[4] = {0, -1, 0, 1};
    int dir = 0;    
    //arr[n - 1][n - 1]부터 시작해서 값 채워넣기
    for(int i = n * n; i >= 1; i--){
        arr[nx][ny] = i;
        for(int j = 0; j < 4; j++){
            if(InRange(nx + dx[dir], ny + dy[dir]) && arr[nx + dx[dir]][ny + dy[dir]] == 0) break;
            else dir = (dir + 1) % 4;
        }
        nx += dx[dir];
        ny += dy[dir];    
    }
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cout<< arr[i][j]<<  ' ';
        }
        cout<< '\n';
    }
    return 0;
}