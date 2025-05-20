/*
 
 Find the names of products that are only ordered by customers who live in a
 specific city (e.g., 'New York')
 
 Sample Output:
 ==============
 
 Name                                                                                                                    
 Keyboard                                                                                                          
 
 
 
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
SELECT DISTINCT p.Name
FROM Products p
    JOIN OrderItems oi ON p.ProductID = oi.ProductID
    JOIN Orders o ON oi.OrderID = o.OrderID
    JOIN Customers c ON o.CustomerID = c.CustomerID
WHERE c.Address LIKE '%New York%'
    AND NOT EXISTS (
        SELECT 1
        FROM OrderItems oi2
            JOIN Orders o2 ON oi2.OrderID = o2.OrderID
            JOIN Customers c2 ON o2.CustomerID = c2.CustomerID
        WHERE oi2.ProductID = p.ProductID
            AND c2.Address NOT LIKE '%New York%'
    );