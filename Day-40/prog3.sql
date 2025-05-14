/*
 
 Show customers who placed more orders than the average number of orders per 
 customer
 
 Sample Output:
 ==============
 
 CustomerID      Name    NumOrders                                                                                       
 1       Alice Johnson   4                                                                                               
 2       Bob Smith       3                                                                                               
 3       Charlie Davis   3                                                                                                 
 
 
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
USE fs;
SELECT c.CustomerID,
    c.Name,
    COUNT(o.OrderID) AS NumOrders
FROM Customers c
    JOIN Orders o ON c.CustomerID = o.CustomerID
GROUP BY c.CustomerID,
    c.Name
HAVING COUNT(o.OrderID) > (
        SELECT AVG(OrderCount)
        FROM (
                SELECT COUNT(*) AS OrderCount
                FROM Orders
                GROUP BY CustomerID
            ) AS OrderCounts
    );
-- Write your query below.