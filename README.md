# SpringREST-CRUD
Api's for CRUD operations performed on Employee Management System app built on spring.

> Note : Use Postman for API testing

1. **To view all the employees**
    - API - http://13.59.66.179:8080/springEvalFinal/view
    - Request - GET

2. **To add an employee**
    - API - http://13.59.66.179:8080/springEvalFinal/add
    - Request - POST
    - Request Body -   {
        "id": "employee_id",
        "name": "employee_name",
        "department": "employee_dept",
        "designation": "employee_desig"
    }

3. **To update an employee details**
    - API - http://13.59.66.179:8080/springEvalFinal/employee/{id}
    - Request - PUT
    - Request Body - {
        "id": "employee_id",
        "name": "employee_name",
        "department": "employee_dept",
        "designation": "employee_desig"
    }

4. **To delete an employee**
    - API - http://13.59.66.179:8080/springEvalFinal/employee/delete/{id}
    - Request - DELETE
    
    

