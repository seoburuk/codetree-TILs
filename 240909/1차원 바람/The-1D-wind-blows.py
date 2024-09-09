n, m, q = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

# 오른쪽 바람
def right_wind(r: int):
    row = board[r]
    temp = row[0]
    for i in range(m - 1):
        row[i] = row[i + 1]
    row[-1] = temp
    return row

# 왼쪽 바람
def left_wind(r: int):
    row = board[r]
    temp = row[-1]
    for i in range(m - 1, 0, -1):
        row[i] = row[i - 1]
    row[0] = temp
    return row

# in_range(현재행, 다음행)
def in_range(cr: int, nr: int):
    if nr < 0 or nr >= n:
        return False

    for i in range(m):
        if board[cr][i] == board[nr][i]:
            return True

    return False

# 바람에 따른 이동  
def simulate(r:int, d: int):
    if d == 0:
        board[r] = left_wind(r)
    else:
        board[r] = right_wind(r)
        
# 시뮬레이션
for _ in range(q):
    r, d = list(input().split())
    # 1base
    r = int(r) - 1
    # right_wind = R = 1 / left_wind = L = 0
    d = 1 if d == 'R' else 0
    du = dd = d
    # 처음 명령 수행
    simulate(r, d)
    # 위 방향 영향 확인
    # up : index : r - 1 ~ 0
    for cr in range(r, 0, -1):
        du ^= 1
        if in_range(cr, cr - 1):
            simulate(cr - 1, du)
        else:
            break
    # 아래 방향 영향 확인
    # down : index : r + 1 ~ n - 1
    for cr in range(r, n - 1):
        dd ^= 1
        if in_range(cr, cr + 1):
            simulate(cr + 1, dd)
        else:
            break

for row in board:
    print(*row)