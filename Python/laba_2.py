import math

# >--------- 1 ---------<
def getFibSum(index: int):
    i = 0
    sum = 0
    fibNum = 1
    prevFibNum = fibNum
    while(i < index):
        
        if(i != 0 and i != 1):
            temp = fibNum
            fibNum += prevFibNum
            prevFibNum = temp

        sum += fibNum
        i += 1
            
    return sum

print("1) Sum: ", getFibSum(4))

# <--------- 1 --------->


# >--------- 2 ---------<
def getArea(radius):
    return  math.pow(radius, 2) * math.pi

r1 = 5
r2 = 12
s1 = getArea(r1)
s2 = getArea(r2)
deltaS = math.fabs(s2 - s1)
print("2) Result: ", deltaS)
# <--------- 2 --------->


# >--------- 3 ---------<
print('3)')
def findNumber():
    max = 25
    step = int(max / 2)
    currentRange = step
    i = 0
    rangeArr = []
    range = {
        12: None,
    }

    def find():
        nonlocal step, range, currentRange, i

        i += 1
        isGreater = input(str(i) + ") Your number is greater than " + str(currentRange) + '(y/n)') == 'y'

        rangeArr.append(currentRange)
        step = step / 2
        if(step == 1.5):
            step = 2
        elif(step == 0.5):
            step = 1

        if(isGreater):
            currentRange = int(currentRange + step)
            if(currentRange > 24):
                return 25
        else:
            currentRange = int(currentRange - step)
            if(currentRange < 0):
                return 0

        range[rangeArr[-1]] = isGreater
        if(i >= 4):
            if(range[rangeArr[-1]] and not range[rangeArr[-2]] and range[rangeArr[-3]] and i > 4):
                return rangeArr[-2]
            elif(not range[rangeArr[-1]] and range[rangeArr[-2]] and i > 4):
                return rangeArr[-1]
            elif(not range[rangeArr[-1]] and not range[rangeArr[-2]] and range[rangeArr[-3]]):
                return rangeArr[-1]
            elif(range[rangeArr[-1]] and range[rangeArr[-2]] and not range[rangeArr[-3]]):
                return rangeArr[-3]

        return find()

    return find()
    
print(findNumber())
# <--------- 3 --------->


# >--------- 4 ---------<
print("4)")
a = int(input("Enter first number: "))
b = int(input("Enter second number: "))
c = int(input("Enter third number: "))
d = int(input("Enter fourth number: "))

def getSqrt(num: int):
    if(num < 0):
        return '±' + str(math.sqrt(-num)) + 'i'

    return '±' + str(math.sqrt(num))

print('First num: ', getSqrt(a))
print('Second num: ', getSqrt(b))
print('Third num: ', getSqrt(c))
print('Fourth num: ', getSqrt(d))
# <--------- 4 --------->

input("End")
