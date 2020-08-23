# e-shopping
e-shopping portal

Approach 1 :
Please tyring running the Test cases by using - mvn test

Approach 2 :
Please run the application first then try with these request from any rest client.

Input 1:
API: http://localhost:8080/placeOrder/receipt
Request Body : 
[
  {
    "quantity":1,
    "name":"B1",
    "price":12.49,
    "productType": "DOMESTIC",
    "category": "FOOD"
  },
  {
    "quantity":1,
    "name":"CD",
    "price":14.99,
    "productType": "DOMESTIC",
    "category": "OTHERS"
  },
  {
    "quantity":1,
    "name":"CHOCO",
    "price":0.85,
    "productType": "DOMESTIC",
    "category": "FOOD"
  }
]

Input 2:
http://localhost:8080/placeOrder/receipt
RequestBody:
[
  {
    "quantity":1,
    "name":"CHOCO BOX",
    "price":10.0,
    "productType": "IMPORTED",
    "category": "FOOD"
  },
  {
    "quantity":1,
    "name":"PERFUME",
    "price":47.50,
    "productType": "IMPORTED",
    "category": "OTHERS"
  }
]
