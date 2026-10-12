# Assignment 2 - cURL Test Cases and Expected Output

## Test Case 1: Add a Student Successfully

**cURL**

curl -i -X POST http://localhost:8080/students \
-H "Content-Type: application/json" \
-d '{"name":"Amit","age":21,"address":"Mumbai","rollNumber":102,"courses":["A","B","D","E"]}'

**Expected Output**
```text
HTTP/1.1 201
Student added successfully
```

## Test Case 2: Add Another Student

**cURL**

curl -i -X POST http://localhost:8080/students \
-H "Content-Type: application/json" \
-d '{"name":"Nishant","age":22,"address":"Delhi","rollNumber":101,"courses":["A","B","C","D"]}'


**Expected Output**
```text
HTTP/1.1 201
Student added successfully
```

## Test Case 3: Add a Student with a Different Name

**cURL**

curl -i -X POST http://localhost:8080/students \
-H "Content-Type: application/json" \
-d '{"name":"Rahul","age":20,"address":"Pune","rollNumber":103,"courses":["B","C","D","F"]}'


**Expected Output**
```text
HTTP/1.1 201
Student added successfully
```

## Test Case 4: Add a Fourth Student

**cURL**

curl -i -X POST http://localhost:8080/students \
-H "Content-Type: application/json" \
-d '{"name":"Priya","age":23,"address":"Bangalore","rollNumber":104,"courses":["A","C","E","F"]}'


**Expected Output**
```text
HTTP/1.1 201
Student added successfully
```

## Test Case 5: Display All Students

**cURL**
```bash
curl -i http://localhost:8080/students
```

**Expected Output**
```text
HTTP/1.1 200
[
  {"name":"Amit","age":21,"address":"Mumbai","rollNumber":102,"courses":["A","B","D","E"]},
  {"name":"Nishant","age":22,"address":"Delhi","rollNumber":101,"courses":["A","B","C","D"]},
  {"name":"Priya","age":23,"address":"Bangalore","rollNumber":104,"courses":["A","C","E","F"]},
  {"name":"Rahul","age":20,"address":"Pune","rollNumber":103,"courses":["B","C","D","F"]}
]
```

## Test Case 6: Sort Students by Name in Ascending Order

**cURL**
```bash
curl -i "http://localhost:8080/students?sortType=NAME&sortOrder=ASC"
```

**Expected Output**
```text
HTTP/1.1 200
Amit, Nishant, Priya, Rahul
```

## Test Case 7: Sort Students by Name in Descending Order

**cURL**
```bash
curl -i "http://localhost:8080/students?sortType=NAME&sortOrder=DESC"
```

**Expected Output**
```text
HTTP/1.1 200
Rahul, Priya, Nishant, Amit
```

## Test Case 8: Sort Students by Roll Number in Ascending Order

**cURL**
```bash
curl -i "http://localhost:8080/students?sortType=ROLL_NUMBER&sortOrder=ASC"
```

**Expected Output**
```text
HTTP/1.1 200
101, 102, 103, 104
```

## Test Case 9: Sort Students by Roll Number in Descending Order

**cURL**
```bash
curl -i "http://localhost:8080/students?sortType=ROLL_NUMBER&sortOrder=DESC"
```

**Expected Output**
```text
HTTP/1.1 200
104, 103, 102, 101
```

## Test Case 10: Sort Students by Age in Ascending Order

**cURL**
```bash
curl -i "http://localhost:8080/students?sortType=AGE&sortOrder=ASC"
```

**Expected Output**
```text
HTTP/1.1 200
20, 21, 22, 23
```

## Test Case 11: Sort Students by Age in Descending Order

**cURL**
```bash
curl -i "http://localhost:8080/students?sortType=AGE&sortOrder=DESC"
```

**Expected Output**
```text
HTTP/1.1 200
23, 22, 21, 20
```

## Test Case 12: Sort Students by Address in Ascending Order

**cURL**
```bash
curl -i "http://localhost:8080/students?sortType=ADDRESS&sortOrder=ASC"
```

**Expected Output**
```text
HTTP/1.1 200
Bangalore, Delhi, Mumbai, Pune
```

## Test Case 13: Sort Students by Address in Descending Order

**cURL**
```bash
curl -i "http://localhost:8080/students?sortType=ADDRESS&sortOrder=DESC"
```

**Expected Output**
```text
HTTP/1.1 200
Pune, Mumbai, Delhi, Bangalore
```

## Test Case 14: Add a Student with an Existing Roll Number

**cURL**
```bash
curl -i -X POST http://localhost:8080/students \
-H "Content-Type: application/json" \
-d '{"name":"Duplicate Student","age":24,"address":"Chennai","rollNumber":102,"courses":["A","B","C","D"]}'
```

**Expected Output**
```text
Roll number already exists
```

## Test Case 15: Add a Student with a Missing Name

**cURL**
```bash
curl -i -X POST http://localhost:8080/students \
-H "Content-Type: application/json" \
-d '{"age":21,"address":"Mumbai","rollNumber":105,"courses":["A","B","C","D"]}'
```

**Expected Output**
```text
Request rejected: name is required
```

## Test Case 16: Add a Student with a Blank Name

**cURL**
```bash
curl -i -X POST http://localhost:8080/students \
-H "Content-Type: application/json" \
-d '{"name":"   ","age":21,"address":"Mumbai","rollNumber":105,"courses":["A","B","C","D"]}'
```

**Expected Output**
```text
Request rejected: name cannot be blank
```

## Test Case 17: Add a Student with an Invalid Age

**cURL**
```bash
curl -i -X POST http://localhost:8080/students \
-H "Content-Type: application/json" \
-d '{"name":"Invalid Age","age":0,"address":"Mumbai","rollNumber":105,"courses":["A","B","C","D"]}'
```

**Expected Output**
```text
Request rejected: age must be positive
```

## Test Case 18: Add a Student with a Missing Address

**cURL**
```bash
curl -i -X POST http://localhost:8080/students \
-H "Content-Type: application/json" \
-d '{"name":"Invalid Address","age":21,"rollNumber":105,"courses":["A","B","C","D"]}'
```

**Expected Output**
```text
Request rejected: address is required
```

## Test Case 19: Add a Student with an Invalid Roll Number

**cURL**
```bash
curl -i -X POST http://localhost:8080/students \
-H "Content-Type: application/json" \
-d '{"name":"Invalid Roll","age":21,"address":"Mumbai","rollNumber":0,"courses":["A","B","C","D"]}'
```

**Expected Output**
```text
Request rejected: roll number must be positive
```

## Test Case 20: Add a Student with Fewer Than Four Courses

**cURL**
```bash
curl -i -X POST http://localhost:8080/students \
-H "Content-Type: application/json" \
-d '{"name":"Few Courses","age":21,"address":"Mumbai","rollNumber":105,"courses":["A","B","C"]}'
```

**Expected Output**
```text
Request rejected: exactly four courses are required
```

## Test Case 21: Add a Student with More Than Four Courses

**cURL**
```bash
curl -i -X POST http://localhost:8080/students \
-H "Content-Type: application/json" \
-d '{"name":"Many Courses","age":21,"address":"Mumbai","rollNumber":105,"courses":["A","B","C","D","E"]}'
```

**Expected Output**
```text
Request rejected: exactly four courses are required
```

## Test Case 22: Add a Student with Duplicate Courses

**cURL**
```bash
curl -i -X POST http://localhost:8080/students \
-H "Content-Type: application/json" \
-d '{"name":"Duplicate Courses","age":21,"address":"Mumbai","rollNumber":105,"courses":["A","A","B","C"]}'
```

**Expected Output**
```text
Request rejected: courses must be distinct
```

## Test Case 23: Add a Student with an Invalid Course

**cURL**
```bash
curl -i -X POST http://localhost:8080/students \
-H "Content-Type: application/json" \
-d '{"name":"Invalid Course","age":21,"address":"Mumbai","rollNumber":105,"courses":["A","B","C","G"]}'
```

**Expected Output**
```text
Request rejected: invalid course
```

## Test Case 24: Add a Student with a Null Courses List

**cURL**
```bash
curl -i -X POST http://localhost:8080/students \
-H "Content-Type: application/json" \
-d '{"name":"Null Courses","age":21,"address":"Mumbai","rollNumber":105,"courses":null}'
```

**Expected Output**
```text
Request rejected: courses cannot be null
```

## Test Case 25: Delete an Existing Student

**cURL**
```bash
curl -i -X DELETE http://localhost:8080/students/103
```

**Expected Output**
```text
HTTP/1.1 200
Student deleted successfully
```

## Test Case 26: Verify a Deleted Student Is Removed

**cURL**
```bash
curl -i http://localhost:8080/students
```

**Expected Output**

Student with roll number `103` is absent from the returned list.

## Test Case 27: Delete a Student That Does Not Exist

**cURL**
```bash
curl -i -X DELETE http://localhost:8080/students/999
```

**Expected Output**
```text
HTTP/1.1 404
Student with roll number 999 not found
```

## Test Case 28: Display Students After Sorting

**cURL**
```bash
curl -i "http://localhost:8080/students?sortType=NAME&sortOrder=ASC"
```

**Expected Output**
```text
HTTP/1.1 200
Amit, Nishant, Priya
```

## Test Case 29: Display Students After All Operations

**cURL**
```bash
curl -i http://localhost:8080/students
```

**Expected Output**

Only successfully added students that have not been deleted are returned.