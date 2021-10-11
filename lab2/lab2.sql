USE labor_sql;
-- 1
-- SELECT model, speed, hd, price from laptop
-- WHERE screen >= 12
-- ORDER BY price DESC;

-- 2
-- SELECT * FROM outcome
-- WHERE date like('2001-03%');

-- 3
-- SELECT pc.model, product.maker FROM product JOIN pc ON product.model=pc.model
-- WHERE pc.price < 600;

-- 4
-- SELECT maker from product
-- WHERE type = 'PC' AND NOT maker != ALL(SELECT maker FROM product WHERE type = 'Laptop');
 
 -- 5
 -- SELECT DISTINCT maker FROM product
--  WHERE maker = ANY(SELECT maker FROM product WHERE type = 'Laptop') AND maker != ALL(SELECT maker From product WHERE type = 'Printer')
 
 -- 6
 -- SELECT CONCAT("Середня ціна - ", avg(laptop.price)) as avg_price FROM laptop;
 
 -- 7
 -- SELECT maker, MIN(printer.price) AS price FROM product JOIN printer ON product.model = printer.model
--  WHERE color = 'n' 
  
-- 8
--  SELECT maker, type, COUNT(*) AS count FROM product
--  GROUP BY maker, type
--  ORDER BY maker

-- 9
-- SELECT income.point, income.date,  income.inc, outcome.out FROM income JOIN outcome ON income.point = outcome.point

 -- 10
 -- SELECT maker, pc.model, product.type, pc.price 
--  FROM pc JOIN product ON product.model=pc.model AND maker = 'B'
--  UNION ALL
--  SELECT maker, laptop.model, product.type, laptop.price 
--  FROM laptop JOIN product ON product.model=laptop.model AND maker = 'B'
--  UNION ALL
--  SELECT maker, printer.model, product.type, printer.price 
--  FROM printer JOIN product ON product.model=printer.model AND maker = 'B'

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 