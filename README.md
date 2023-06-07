# Spring boot,MySql and Redis Application 
Below are the steps to run the application: 

1. Run MYSQL Docker image

   ```bash
   $ docker run -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 --name mysql -d mysql
   ```

2. Run Redis Docker image :

   ```bash
   $ docker run -d -p 6379:6379 --name myredis redis  
   ```

3. Clean Build and  Run the project:

4. Import the Postman collection from the `postman` folder . 

5. Send request `GetAll` using the Postman collection.
   folder) 
   You can see the 1000 records fetched from DB.
   If try second time, you can see the same 1000 records but those are pulled from redis cache.

6. Connect redis-cli by using below command and verify the keys.

   ```bash
   $ docker exec -it myredis redis-cli 
   $ 127.0.0.1:6379> KEYS *
   127.0.0.1:6379> KEYS *
   //result
       1) "Customers::allCustomers"
   ```
