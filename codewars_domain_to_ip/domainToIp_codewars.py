def f(U):return[i*sum(map(ord,U))%256for i in range(1,5)]

def main():
    URL='www.codewars.com'
    print(f(URL))


# This is for Python2
if __name__ == "__main__":
    main()


# For Python3
#main()