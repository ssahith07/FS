/*
 
 Find customers who have placed orders with a total cost greater than the average
 total cost of all orders
 
 Sample Output:
 ==============
 
 Name                                                                                                                    
 Name    Email                                                                                                           
 Alice Johnson   alice.johnson@example.com                                                                               
 Bob Smith       bob.smith@example.com                                                                                   
 Charlie Davis   charlie.davis@example.com                                                                               
 Diana Williams  diana.williams@example.com                                                                              
 Ethan Brown     ethan.brown@example.com                                                                                 
 George Clark    george.clark@example.com                                                                                                          
 
 
 
 Customers:
 ==========
 Field   Type    Null    Key     Default Extra                                                                           
 CustomerID      int     NO      PRI     NULL                                                                            
 Name    varchar(255)    YES             NULL                                                                            
 Email   varchar(255)    YES             NULL                                                                            
 Address varchar(255)    YES             NULL                                                                            
 PhoneNumber     varchar(20)     YES             NULL                                                                    
 
 Orders:
 =======
 Field   Type    Null    Key     Default Extra                                                                           
 OrderID int     NO      PRI     NULL                                                                                    
 CustomerID      int     YES     MUL     NULL                                                                            
 OrderDate       date    YES             NULL                                                                            
 TotalCost       decimal(10,2)   YES             NULL                                                                    
 Status  varchar(20)     YES             NULL                                                                            
 
 OrderItems:
 ============
 Field   Type    Null    Key     Default Extra                                                                           
 OrderItemID     int     NO      PRI     NULL                                                                            
 OrderID int     YES     MUL     NULL                                                                                    
 ProductID       int     YES     MUL     NULL                                                                            
 Quantity        int     YES             NULL                                                                            
 UnitPrice       decimal(10,2)   YES             NULL                                                                    
 
 Products:
 =========
 Field   Type    Null    Key     Default Extra                                                                           
 ProductID       int     NO      PRI     NULL                                                                            
 Name    varchar(255)    YES             NULL                                                                            
 Description     varchar(255)    YES             NULL                                                                    
 Price   decimal(10,2)   YES             NULL  
 
 
 */
use fs;
select c.Name,
    c.Email
from Customers c
    join Orders o on o.CustomerID = c.CustomerID
where o.TotalCost > (
        select avg(o1.TotalCost)
        from Orders o1
    )
order by c.Name