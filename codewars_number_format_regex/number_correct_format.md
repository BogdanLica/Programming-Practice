[Link to exercise](https://www.codewars.com/kata/number-format/train/python)



#### Thoughts

* First, I need to create a regex to catch every group of 3 digits
* It is easier if I reverse the string and add the comma after every 3 characters

> ([\d]{3})

##### So far, after each group of 3 characters, the "," is added
```Python
import re
def number_format(n):
    string_of_number = str(n)
    
    
    if(n % 2 != 0):
        string_of_number = string_of_number[:1] + ',' + string_of_number[1:]
    
    result = re.sub(r'([\d]{3})',r'\1,',string_of_number)
    return result
```

##### Wrong cases when the format is "-,323,134,534" or ",435,542,234"

### Solution
```Python

import re
def number_format(n):
    string_of_number = str(n)
    reversed_number = string_of_number[::-1]
    
    reversed_result = re.sub(r'([\d]{3})',r'\1,',reversed_number)
    
    result=reversed_result[::-1]
    
    if result[0] == ",":
        new_result = result[1:]
        return new_result
        
    if result[0] == "-" and result[1] == ",":
        new_result = result[0] + result[2:]
        return new_result
    return result
  

```