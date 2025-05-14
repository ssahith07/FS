sq/*

Find the customers who placed orders that include more items than any other 
order they’ve placed:
Sample Output:
==============

OrderID Name    ItemCount                                                                                               
1010    Charlie Davis   2                                                                                               
1005    Diana Williams  2                                                                                               
1006    Ethan Brown     2                                                                                               
1007    Fiona Adams     1                                                                                               
1008    George Clark    2                                                                                               
                                                                                             


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

-- Write your query below.
SELECT oi.OrderID, c.Name, COUNT(*) AS ItemCount
FROM OrderItems oi
JOIN Orders o ON oi.OrderID = o.OrderID
JOIN Customers c ON o.CustomerID = c.CustomerID
GROUP BY oi.OrderID, o.CustomerID, c.Name
HAVING COUNT(*) > ALL (
    SELECT COUNT(*)
    FROM OrderItems oi2
    JOIN Orders o2 ON oi2.OrderID = o2.OrderID
    WHERE o2.CustomerID = o.CustomerID
      AND oi2.OrderID != oi.OrderID
    GROUP BY oi2.OrderID
)