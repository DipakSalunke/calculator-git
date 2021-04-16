# calculator-spring-boot
 spring-boot assignment

- server port : 8888
 > Check Out API by hitting this url 
 - http://localhost:8888/swagger-ui.html

> **Assignment**  


 Allow user to post 2 numbers and an operation(ADD, SUBTRACT, DIVIDE, MULTIPLY, MODULO), that returns the outcome of operation
- eg payload: {“number1” : 3.0, “number2” : 1.0, operation: “ADD”} , response: {“result” : “Sum of 3.0 and 1.0 is 4.0”}
- eg payload: {“number1” : 3.1, “number2” : 2.0, operation: “ADD”} , response: {“result” : “Sum of 3.1 and 2.0 is 5.1”}
- eg payload: {“number1” :”a” , “number2” : 2.0, operation: “ADD”} , response: {“result” : “Invalid number a”}
 

Allow the user to list all operations performed in the current session, for the user. 
Eg response
                                                               
- i.      ADD numbers, number1=3.0 and number2=1.0

- ii.      ADD numbers, number1=3.1 and number2=2.0

- iii.      ADD numbers, number1=a and number2=2.0

 

Allow the user to replay the specified operation, by passing the number of the operation
Eg: payload: {“replaySeq”: 2}, response: {“result”: “Sum of 3.1 and 2.0 is 5.1”}
