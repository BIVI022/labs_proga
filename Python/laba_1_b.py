
number = str(input("Enter number in 2: "))

decimal = int(number, 2)
def to8(num: int):
    result = ''
    while num > 0:
        result = str(num % 8) + result
        num //= 8
    return result

def toHex(num: int):
    symbols = '0123456789ABCDEF'   
    def convert(num: int):
        result = ''
        x, y = divmod(num, 16)
        result += symbols[y]
        if(x != 0):
            return result + convert(x)
        return result
    return convert(num)[::-1]

print("Origin number", number)
print("Decimal number", decimal)
print("8 number", to8(decimal))
print("16 number", toHex(decimal))
input("End")