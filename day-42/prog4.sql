/*
 
 List order IDs where all items in the order are priced above the average product
 price
 
 Sample Output:
 ==============
 
 OrderID                                                                                                                 
 1002                                                                                                                    
 
 
 
 
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
SELECT oi.OrderID
FROM OrderItems oi
    JOIN Products p ON oi.ProductID = p.ProductID
GROUP BY oi.OrderID
HAVING MIN(p.Price) >(
        SELECT AVG(Price)
        FROM Products
    );