def calculate_overlap(n, commands):
    visited = [0] * 201  # Initialize an array to record visited areas
    current_position = 100  # Start position at index 100
    overlap_count = 0  # Counter for areas visited more than once

    for command in commands:
        x, direction = command.split()
        x = int(x)
        
        # Move left
        if direction == 'L':
            for i in range(current_position, current_position - x, -1):
                visited[i] += 1
                if visited[i] >= 2:
                    overlap_count += 1
            current_position -= x
        # Move right
        else:
            for i in range(current_position, current_position + x):
                visited[i] += 1
                if visited[i] >= 2:
                    overlap_count += 1
            current_position += x

    return overlap_count

# Input
n = int(input())  # Number of commands
commands = [input() for _ in range(n)]  # List of commands

# Calculate and output the overlap count
print(calculate_overlap(n, commands))