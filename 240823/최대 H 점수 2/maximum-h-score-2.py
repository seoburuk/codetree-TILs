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
    # 수열을 작은 값 순으로 정렬합니다.
    arr.sort()
    
    # L번 기회를 사용하여 가능한 가장 작은 값들을 1씩 증가시킵니다.
    for _ in range(L):
        # 가장 작은 값을 찾아서 증가시킵니다.
        arr[0] += 1
        # 다시 정렬해서 가장 작은 값이 앞으로 오도록 합니다.
        arr.sort()

    # 최종적으로 계산된 배열의 최대 H 점수를 구합니다.
    return calculate_H_score(arr)

# 입력 받기
N, L = map(int, input().split())
arr = list(map(int, input().split()))

# 최대 H 점수 출력
print(max_H_score(N, L, arr))