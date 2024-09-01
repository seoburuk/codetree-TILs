#include <bits/stdc++.h>
using namespace std;
int n, a[20][20], ans;
int dy[]={-1,-1,1,1}, dx[]={1,-1,-1,1}; // 우상향-왼상향-왼하향-우하향

int calc(int y, int x, int s1, int s2){
    int sum=0, ny=y, nx=x;

    for(int i=1; i<=s1; i++){
        ny += dy[0];
        nx += dx[0];
        if(ny<0 || nx<0 || ny>=n || nx>=n) return -1;
        sum += a[ny][nx];
    }
    for(int i=1; i<=s2; i++){
        ny += dy[1];
        nx += dx[1];
        if(ny<0 || nx<0 || ny>=n || nx>=n) return -1;    
        sum += a[ny][nx]; 
    }    
    for(int i=1; i<=s1; i++){
        ny += dy[2];
        nx += dx[2];
        if(ny<0 || nx<0 || ny>=n || nx>=n) return -1;       
        sum += a[ny][nx]; 
    }
    for(int i=1; i<=s2; i++){
        ny += dy[3];
        nx += dx[3];
        if(ny<0 || nx<0 || ny>=n || nx>=n) return -1;     
        sum += a[ny][nx];    
    }
    return sum;
}

int main() {
    ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cin >> n;
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            cin >> a[i][j];
        }
    }

    // 시작점 (i,j)
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            // 순회
            for(int step1 = 1; step1 <= n-2; step1++){
                for(int step2 = 1; step2 <= n-1 - step1; step2++){
                    int cnt = calc(i,j,step1, step2);
                    ans = max(ans, cnt);
                }                
            }
        }
    }

    cout << ans << "\n";
    return 0;
}