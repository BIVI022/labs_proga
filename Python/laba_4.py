import timeit
import random


def seeTime(cb):
    return timeit.timeit("cb()", globals=locals(), number=1)


# Laba 3.4
def laba34():
    n = 3
    m = 3
    matrix = []
    i = 0
    while(i < m):
        j = 0
        matrix.append([])
        while(j < n):
            matrix[i].append(random.randint(0, 100))
            j += 1
        i += 1
    # print(matrix)

    x = 0
    while(x < n):
        averageColumnValue = 0
        y = 0

        while(y < m):
            averageColumnValue += matrix[y][x]
            y += 1

        averageColumnValue /= m
        # print("Column " + str(x+1) + " average value: ", averageColumnValue)
        x += 1

# Laba 3.3
a = 17
numArr = [1, 6, 3, 8, 23, 9, 2]
def findNums():
    i = 0
    while(i < len(numArr)):
        j = i + 1
        while(j < len(numArr)):
            k = j + 1
            while(k < len(numArr)):
                if(numArr[i] + numArr[j] + numArr[k] == a):
                    return [numArr[i], numArr[j], numArr[k]]
                k += 1
            j += 1
        i += 1

    return "Not found"

i = 0
repeats = 5
while(i < repeats):
    print(str(i) + "): ", seeTime(laba34))
    i += 1

print("________________________________________\n")
i = 0
while(i < repeats):
    print(str(i) + "): ", seeTime(findNums))
    i += 1


input("end")