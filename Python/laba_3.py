import random

# >--------- 1 ---------<
numArr = [5, 2, 7, 1, 1, 4]
print("Origin:", numArr)
numArr.sort()
print("Sorted:", numArr)
# <--------- 1 --------->

# >--------- 2 ---------<
distArr = [123, 63, 67]
speedArr = [100, 40, 60]

i = 0
averageSpeed = 0
while(i < len(distArr)):
    print("Car " + str(i) + ": \n Travel time: " + str(distArr[i]/speedArr[i]))
    averageSpeed += speedArr[i]
    i += 1
averageSpeed /= len(distArr)
print("Average speed: ", averageSpeed)
i = 0
while(i < len(speedArr)):
    if(speedArr[i] > averageSpeed):
        print("Car " + str(i) + " exceeded average speed: " + str(speedArr[i]))
    i += 1
# >--------- 2 ---------<


# >--------- 3 ---------<
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
print(findNums())
# <--------- 3 --------->


# >--------- 4 ---------<
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
print(matrix)

x = 0
while(x < n):
    averageColumnValue = 0
    y = 0

    while(y < m):
        averageColumnValue += matrix[y][x]
        y += 1

    averageColumnValue /= m
    print("Column " + str(x) + " average value: ", averageColumnValue)
    x += 1
# <--------- 4 --------->


input('end')