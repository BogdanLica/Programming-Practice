[Link to exercise](https://www.codewars.com/kata/ip-address-finder-code-golf)


##### The output should be presented as a list
--> a list is needed
##### Calculate the value of each ASCII character
--> a variable that holds the sum is needed
--> Python uses the ord('char') to go from char to int
##### A sequence of number can be spotted
* **first** is the **sum** mod 256
* **second** is **2 * sum** mod 256
* **third** is **3 * sum** mod 256
* **forth** is **4 * sum** mod 256
--> a variable which increases up to 4 is needed

```Python
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



if __name__ == "__main__":
    main()
```


##### Unfortunately, the code is too long (there is a restriction of 53 characters max)


```Python

def f(URL):
    sum=0
    for j in URL:
        sum+=ord(j)
    
    return [i*sum%256 for i in range(1,5)]
      
    
        
    
    
```
##### Using a shorthand version for a for loop from 1 to 5 where each element of the list is returned


```Python


def f(URL):
    s = sum([ord(j) for j in URL])
    return [i*s%256 for i in range(1,5)]
    

```

```Python
def f(URL):return [i*sum([ord(j) for j in URL])%256 for i in range(1,5)]

```

```Python

def f(U):return[i*sum(list(map(ord,U)))%256for i in range(1,5)]


```

### SOLUTION

```Python
def f(U):return[i*sum(map(ord,U))%256for i in range(1,5)]
```