#include <iostream>
#define MAX_N 100
using namespace std;
int n, m;
int x = 0, y = -1;         // 시작 전 좌표
int d, plus_cnt;          // 현재 방향, 'A'에서 얼마를 더하는지

char arr[MAX_N][MAX_N];

int dirs[4][2] = {{0,1},{1,0},{0,-1},{-1,0}}; // 우,하,좌,상

bool InRange(int x, int y){
    return 0 <= x && x < n && 0 <= y && y < m;
}

int main() {
    cin >> n >> m;
    int cnt = n*m;
    while(cnt--){
        int nx = x+dirs[d][0], ny = y+dirs[d][1]; // 확인할 다음 좌표
        if(!InRange(nx,ny) || arr[nx][ny] != '\0'){ // 범위 안에 없거나, 이미 채워져 있다면
            d = (d+1) % 4; // 방향 1 증가
        }
        x = x+dirs[d][0], y = y+dirs[d][1]; // 좌표 이동
        
        if(plus_cnt == 26) // 만약 Z를 넘었다면 다시 A로 바꿔주기
            plus_cnt=0;
        arr[x][y] = 'A'+plus_cnt; // 알파벳 채워넣기
        plus_cnt++; // 카운트 증가
        
    }
    // 출력
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            cout<<arr[i][j] << ' ';
        }
        cout<<'\n';
    }

    return 0;
}