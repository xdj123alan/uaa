# uaa-ms

# System Design
## Build Project
1. build project in this website: https://start.aliyun.com/

## evn
1. jdk version: 1.8
2. spring Boot version:2.6.13

## 
### AOP function
use @Aspect to handle header basic functionality.

### endpoint design
#### endpoint of add user
**request Header**
```json
{
  "token": "ewoidXNlcklkIjoxMjM0NTYsCiJhY2NvdW50TmFtZSI6IlhYWFgiLAoicm9sZSI6ImFkbWluIgp9"
}
```
**request body**  
url: /admin/addUser  
method: POST  
params:
```json
{
    "userId": 123456,
    "endpoint": [
      "Resource A",
      "Resource B",
      "Resource C"
    ]
}
```
result: 
```json
{
  "status": 200,
  "result": "",
  "errorMsg": "",
}
```

#### endpoint for users
**request Header**
```json
{
  "token": "ewoidXNlcklkIjoxMjM0NTYsCiJhY2NvdW50TmFtZSI6IlhYWFgiLAoicm9sZSI6ImFkbWluIgp9"
}
```
**request body**  
url: /user/{resource}  
method: GET  
params: none  
```json
{
  "status": 200,
  "result": "success",
  "errorMsg": "",
}
```