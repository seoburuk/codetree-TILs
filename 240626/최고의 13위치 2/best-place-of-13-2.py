def max_coins(grid, N):
    # 모든 가능한 1x3 격자(가로)를 찾는 함수
    def find_all_1x3_horizontal(grid, N):
        positions = []
        for i in range(N):
            for j in range(N - 2):
                positions.append((i, j, i, j+1, i, j+2))
        return positions

    # 모든 가능한 1x3 격자(세로)를 찾는 함수
    def find_all_1x3_vertical(grid, N):
        positions = []
        for i in range(N - 2):
            for j in range(N):
                positions.append((i, j, i+1, j, i+2, j))
        return positions

    # 1x3 격자 내의 동전 개수를 세는 함수
    def count_coins(grid, pos):
        return grid[pos[0]][pos[1]] + grid[pos[2]][pos[3]] + grid[pos[4]][pos[5]]

    # 1x3 격자 두 개가 겹치는지 확인하는 함수
    def are_non_overlapping(pos1, pos2):
        cells1 = set((pos1[i], pos1[i+1]) for i in range(0, 6, 2))
        cells2 = set((pos2[i], pos2[i+1]) for i in range(0, 6, 2))
        return cells1.isdisjoint(cells2)

    # 모든 가능한 1x3 격자 찾기
    horizontal_positions = find_all_1x3_horizontal(grid, N)
    vertical_positions = find_all_1x3_vertical(grid, N)

    max_coins_count = 0

    # 모든 가능한 격자 쌍을 고려
    for i in range(len(horizontal_positions)):
        for j in range(i + 1, len(horizontal_positions)):
            if are_non_overlapping(horizontal_positions[i], horizontal_positions[j]):
                coins = count_coins(grid, horizontal_positions[i]) + count_coins(grid, horizontal_positions[j])
                max_coins_count = max(max_coins_count, coins)

    for i in range(len(vertical_positions)):
        for j in range(i + 1, len(vertical_positions)):
            if are_non_overlapping(vertical_positions[i], vertical_positions[j]):
                coins = count_coins(grid, vertical_positions[i]) + count_coins(grid, vertical_positions[j])
                max_coins_count = max(max_coins_count, coins)

    for i in range(len(horizontal_positions)):
        for j in range(len(vertical_positions)):
            if are_non_overlapping(horizontal_positions[i], vertical_positions[j]):
                coins = count_coins(grid, horizontal_positions[i]) + count_coins(grid, vertical_positions[j])
                max_coins_count = max(max_coins_count, coins)

    return max_coins_count

# 입력 처리
N = int(input().strip())
grid = []
for _ in range(N):
    grid.append(list(map(int, input().strip().split())))

# 최대 동전의 수 계산
result = max_coins(grid, N)
print(result)