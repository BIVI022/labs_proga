number = int(input("Enter number: "))

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

print("2:", bin(number))
print("8:", to8(number))
print("16:", toHex(number))
input("End")