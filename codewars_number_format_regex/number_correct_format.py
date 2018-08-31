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
  