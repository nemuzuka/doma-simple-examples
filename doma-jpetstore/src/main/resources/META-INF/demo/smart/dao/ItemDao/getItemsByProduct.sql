SELECT
  I.ITEMID,
  LISTPRICE,
  UNITCOST,
  SUPPLIER,
  I.PRODUCTID,
  NAME AS productName,
  DESCN AS productDescription,
  CATEGORY AS productCategoryId,
  STATUS,
  ATTR1,
  ATTR2,
  ATTR3,
  ATTR4,
  ATTR5
FROM 
  ITEM I, 
  INVENTORY V, 
  PRODUCT P
WHERE 
  P.PRODUCTID = I.PRODUCTID
  AND 
  I.ITEMID = V.ITEMID
  AND 
  I.PRODUCTID = /*productId*/'FI-FW-02'