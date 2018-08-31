def f(URL):
    sum=0
    i=1
    list=[]
    for character in URL:
        sum+=ord(character)
    print(sum)
    while i<5:
        list.append(i*sum%256)
        i=i+1
    return list


def main():
    URL='www.codewars.com'
    print(f(URL))


# This is for Python2
if __name__ == "__main__":
    main()


# For Python3
#main()