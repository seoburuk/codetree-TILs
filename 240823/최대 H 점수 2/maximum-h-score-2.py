import itertools

def calculate_H_score(arr):
    arr.sort(reverse=True)
    H = 0
    for i in range(len(arr)):
        if arr[i] >= i + 1:
            H = i + 1
        else:
            break
    return H

def max_H_score(N, L, arr):
    unique_elements = set(arr)
    if L == 0:
        # L이 0일 경우 값을 증가시킬 수 없으므로, 단순히 수열의 H 점수를 계산한다.
        return calculate_H_score(arr)
    
    max_H = 0
    
    # 서로 다른 원소를 최대 L개 선택하여 1씩 증가시킬 수 있음
    for to_increase in itertools.combinations(unique_elements, min(L, len(unique_elements))):
        new_arr = arr.copy()
        for num in to_increase:
            for i in range(len(new_arr)):
                if new_arr[i] == num:
                    new_arr[i] += 1
        # 이 경우의 H 점수 계산
        max_H = max(max_H, calculate_H_score(new_arr))
    
    return max_H

# 입력 받기
N, L = map(int, input().split())
arr = list(map(int, input().split()))

# 최대 H 점수 출력
print(max_H_score(N, L, arr))