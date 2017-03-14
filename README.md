### Source code can be found in restful-api-project/src/main/java

## Tech used:
* Java spark
* Maven
* MongoDB
* Morphia
* Gson

## To Run:
Have Mongodb running on localhost:27017
Run restful-api-project/src/main/java/Api.java (I used intellij, I'm not sure if a maven project works cross IDE for dependencies)

## Unit Tests:

### GET ADVISOR MODEL REQUEST (Timothy)
```
curl -X GET -H "Content-Type: application/json" -H "Cache-Control: no-cache" -H "http:### localhost:4567/v1/advisor/Timothy/model"
```
### RESPONSE
null


### PUT ADVISOR REQUEST (Timothy)
```
curl -X PUT -H "Content-Type: application/json" -H "Cache-Control: no-cache" -H -d '' "http:### localhost:4567/v1/advisor/Timothy"
```
### RESPONSE
```
"Advisor added."
```

### PUT ADVISOR REQUEST (Timothy)
```
curl -X PUT -H "Content-Type: application/json" -H "Cache-Control: no-cache" -H -d '' "http:### localhost:4567/v1/advisor/Timothy"
```
### RESPONSE
```
"User already exists"
```


### PUT ADVISOR MODEL REQUEST (Timothy)
```
curl -X PUT -H "Content-Type: application/json" -H "Cache-Control: no-cache" -H -d '{
   "name":"Timothys_Model1",
   "description":"example model with tech stocks",
   "cashHoldingPercentage":20,
   "driftPercentage":5,
   "createdOn":"2017-03-01",
   "modelType":"TAXABLE",
   "rebalanceFrequency":"QUARTERLY",
   "assetAllocations":[
      {
         "symbol":"AAPL",
         "percentage":30
      },
      {
         "symbol":"GOOG",
         "percentage":20
      },
      {
         "symbol":"IBM",
         "percentage":25
      },
      {
         "symbol":"FB",
         "percentage":25
      }
   ]
}' "http:### localhost:4567/v1/advisor/Timothy/model"
```

### RESPONSE
```
"Advisor model successfully added."
```


### PUT ADVISOR MODEL REQUEST (Frank)
```
curl -X PUT -H "Content-Type: application/json" -H "Cache-Control: no-cache" -H -d '{
   "name":"FRANKSTUFF",
   "description":"example model with tech stocks",
   "cashHoldingPercentage":15,
   "driftPercentage":5,
   "createdOn":"2017-03-01",
   "modelType":"TAXABLE",
   "rebalanceFrequency":"QUARTERLY",
   "assetAllocations":[
      {
         "symbol":"AAPL",
         "percentage":100
      }
   ]
}' "http:### localhost:4567/v1/advisor/Frank/model"
```

### RESPONSE
```
"Advisor not found."
```

### PUT ADVISOR MODEL REQUEST WITH BAD ASSET ALLOCATIONS (Timothy)
```
{
   "name":"Timothys_Model2",
   "description":"example model with tech stocks",
   "cashHoldingPercentage":20,
   "driftPercentage":5,
   "createdOn":"2017-03-01",
   "modelType":"TAXABLE",
   "rebalanceFrequency":"QUARTERLY",
   "assetAllocations":[
      {
         "symbol":"AAPL",
         "percentage":30
      },
      {
         "symbol":"GOOG",
         "percentage":20
      },
      {
         "symbol":"IBM",
         "percentage":45
      }
   ]
}
```

### RESPONSE
```
"Advisor model asset allocation errors."
```

### GET ADVISOR MODEL (Timothy)
```
curl -X GET -H "Content-Type: application/json" -H "Cache-Control: no-cache" -H "http:### localhost:4567/v1/advisor/Timothy/model"
```

### RESPONSE
```
[
  {
    "id": "Timothys_Model1Timothy",
    "name": "Timothys_Model1",
    "advisor": "Timothy",
    "description": "example model with tech stocks",
    "cashHoldingPercentage": 20,
    "drifPercentage": 0,
    "createdOn": "Mar 1, 2017 12:00:00 AM",
    "modelType": "TAXABLE",
    "rebalanceFrequency": "QUARTERLY",
    "assetAllocations": [
      {
        "symbol": "AAPL",
        "percentage": 30
      },
      {
        "symbol": "GOOG",
        "percentage": 20
      },
      {
        "symbol": "IBM",
        "percentage": 25
      },
      {
        "symbol": "FB",
        "percentage": 25
      }
    ]
  }
]
```

### PUT ADVISOR REQUEST (Robert)
```
curl -X PUT -H "Content-Type: application/json" -H "Cache-Control: no-cache" -H -d '' "http:### localhost:4567/v1/advisor/Robert"
```

### RESPONSE
```
"Advisor added."
```


### PUT ADVISOR MODEL REQUEST
```
curl -X PUT -H "Content-Type: application/json" -H "Cache-Control: no-cache" -H -d '{
   "name":"ROBBO_1",
   "description":"example model with tech stocks",
   "cashHoldingPercentage":55,
   "driftPercentage":10,
   "createdOn":"2017-03-01",
   "modelType":"TAXABLE",
   "rebalanceFrequency":"YEARLY",
   "assetAllocations":[
      {
         "symbol":"AAPL",
         "percentage":10
      },
      {
         "symbol":"GOOG",
         "percentage":90
      }
   ]
}' "http:### localhost:4567/v1/advisor/Robert/model"
```

### RESPONSE
```
"Advisor model successfully added."
```


### PUT ADVISOR MODEL REQUEST - SAME NAME AS PREVIOUS (ROBBO_1) - (Robert)
```
{
   "name":"ROBBO_1",
   "description":"example model with tech stocks",
   "cashHoldingPercentage":55,
   "driftPercentage":10,
   "createdOn":"2017-03-01",
   "modelType":"TAXABLE",
   "rebalanceFrequency":"YEARLY",
   "assetAllocations":[
      {
         "symbol":"AAPL",
         "percentage":50
      },
      {
         "symbol":"GOOG",
         "percentage":50
      }
   ]
}
```

### RESPONSE
```
"Advisor model successfully added."
```


### GET ADVISOR MODEL REQUEST (Robert)
```
curl -X GET -H "Content-Type: application/json" -H "Cache-Control: no-cache" -H "http:### localhost:4567/v1/advisor/Robert/model"
```

### RESPONSE - (note that there is only the one, and has been updated)
```
[
  {
    "id": "ROBBO_1Robert",
    "name": "ROBBO_1",
    "advisor": "Robert",
    "description": "example model with tech stocks",
    "cashHoldingPercentage": 55,
    "drifPercentage": 0,
    "createdOn": "Mar 1, 2017 12:00:00 AM",
    "modelType": "TAXABLE",
    "rebalanceFrequency": "YEARLY",
    "assetAllocations": [
      {
        "symbol": "AAPL",
        "percentage": 50
      },
      {
        "symbol": "GOOG",
        "percentage": 50
      }
    ]
  }
]
```

### PUT REQUEST (Robert)
```
curl -X PUT -H "Content-Type: application/json" -H "Cache-Control: no-cache" -H -d '{
   "name":"ROBBO_2",
   "description":"example model with tech stocks",
   "cashHoldingPercentage":15,
   "driftPercentage":5,
   "createdOn":"2017-03-01",
   "modelType":"TAXABLE",
   "rebalanceFrequency":"QUARTERLY",
   "assetAllocations":[
      {
         "symbol":"AAPL",
         "percentage":100
      }
   ]
}' "http:### localhost:4567/v1/advisor/Robert/model"
```

### RESPONSE
```
"Advisor model successfully added."
```

REPEAT ABOVE ACTION WITH DIFFERENT NAMES 15 TIMES.


### GET REQUEST(Robert)
```
curl -X GET -H "Content-Type: application/json" -H "Cache-Control: no-cache" -H "http:### localhost:4567/v1/advisor/Robert/mode"
```

### RESPONSE
```
[
  {
    "id": "ROBBO_1Robert",
    "name": "ROBBO_1",
    "advisor": "Robert",
    "description": "example model with tech stocks",
    "cashHoldingPercentage": 55,
    "drifPercentage": 0,
    "createdOn": "Mar 1, 2017 12:00:00 AM",
    "modelType": "TAXABLE",
    "rebalanceFrequency": "YEARLY",
    "assetAllocations": [
      {
        "symbol": "AAPL",
        "percentage": 50
      },
      {
        "symbol": "GOOG",
        "percentage": 50
      }
    ]
  },
  {
    "id": "ROBBO_2Robert",
    "name": "ROBBO_2",
    "advisor": "Robert",
    "description": "example model with tech stocks",
    "cashHoldingPercentage": 15,
    "drifPercentage": 0,
    "createdOn": "Mar 1, 2017 12:00:00 AM",
    "modelType": "TAXABLE",
    "rebalanceFrequency": "QUARTERLY",
    "assetAllocations": [
      {
        "symbol": "AAPL",
        "percentage": 100
      }
    ]
  },
  {
    "id": "ROBBO_3Robert",
    "name": "ROBBO_3",
    "advisor": "Robert",
    "description": "example model with tech stocks",
    "cashHoldingPercentage": 15,
    "drifPercentage": 0,
    "createdOn": "Mar 1, 2017 12:00:00 AM",
    "modelType": "TAXABLE",
    "rebalanceFrequency": "QUARTERLY",
    "assetAllocations": [
      {
        "symbol": "AAPL",
        "percentage": 100
      }
    ]
  },
  {
    "id": "ROBBO_4Robert",
    "name": "ROBBO_4",
    "advisor": "Robert",
    "description": "example model with tech stocks",
    "cashHoldingPercentage": 15,
    "drifPercentage": 0,
    "createdOn": "Mar 1, 2017 12:00:00 AM",
    "modelType": "TAXABLE",
    "rebalanceFrequency": "QUARTERLY",
    "assetAllocations": [
      {
        "symbol": "AAPL",
        "percentage": 100
      }
    ]
  },
  {
    "id": "ROBBO_5Robert",
    "name": "ROBBO_5",
    "advisor": "Robert",
    "description": "example model with tech stocks",
    "cashHoldingPercentage": 15,
    "drifPercentage": 0,
    "createdOn": "Mar 1, 2017 12:00:00 AM",
    "modelType": "TAXABLE",
    "rebalanceFrequency": "QUARTERLY",
    "assetAllocations": [
      {
        "symbol": "AAPL",
        "percentage": 100
      }
    ]
  },
  {
    "id": "ROBBO_6Robert",
    "name": "ROBBO_6",
    "advisor": "Robert",
    "description": "example model with tech stocks",
    "cashHoldingPercentage": 15,
    "drifPercentage": 0,
    "createdOn": "Mar 1, 2017 12:00:00 AM",
    "modelType": "TAXABLE",
    "rebalanceFrequency": "QUARTERLY",
    "assetAllocations": [
      {
        "symbol": "AAPL",
        "percentage": 100
      }
    ]
  },
  {
    "id": "ROBBO_7Robert",
    "name": "ROBBO_7",
    "advisor": "Robert",
    "description": "example model with tech stocks",
    "cashHoldingPercentage": 15,
    "drifPercentage": 0,
    "createdOn": "Mar 1, 2017 12:00:00 AM",
    "modelType": "TAXABLE",
    "rebalanceFrequency": "QUARTERLY",
    "assetAllocations": [
      {
        "symbol": "AAPL",
        "percentage": 100
      }
    ]
  },
  {
    "id": "ROBBO_8Robert",
    "name": "ROBBO_8",
    "advisor": "Robert",
    "description": "example model with tech stocks",
    "cashHoldingPercentage": 15,
    "drifPercentage": 0,
    "createdOn": "Mar 1, 2017 12:00:00 AM",
    "modelType": "TAXABLE",
    "rebalanceFrequency": "QUARTERLY",
    "assetAllocations": [
      {
        "symbol": "AAPL",
        "percentage": 100
      }
    ]
  },
  {
    "id": "ROBBO_9Robert",
    "name": "ROBBO_9",
    "advisor": "Robert",
    "description": "example model with tech stocks",
    "cashHoldingPercentage": 15,
    "drifPercentage": 0,
    "createdOn": "Mar 1, 2017 12:00:00 AM",
    "modelType": "TAXABLE",
    "rebalanceFrequency": "QUARTERLY",
    "assetAllocations": [
      {
        "symbol": "AAPL",
        "percentage": 100
      }
    ]
  },
  {
    "id": "ROBBO_10Robert",
    "name": "ROBBO_10",
    "advisor": "Robert",
    "description": "example model with tech stocks",
    "cashHoldingPercentage": 15,
    "drifPercentage": 0,
    "createdOn": "Mar 1, 2017 12:00:00 AM",
    "modelType": "TAXABLE",
    "rebalanceFrequency": "QUARTERLY",
    "assetAllocations": [
      {
        "symbol": "AAPL",
        "percentage": 100
      }
    ]
  }
]
```
### Default 10 queried


### GET REQUEST FOR PAGE 4, SIZE 3 (Robert)
```
curl -X GET -H "Content-Type: application/json" -H "Cache-Control: no-cache" -H "http:### localhost:4567/v1/advisor/Robert/model?pageNumber=4&pageSize=3"
```

### RESPONSE
```
[
  {
    "id": "ROBBO_5Robert",
    "name": "ROBBO_5",
    "advisor": "Robert",
    "description": "example model with tech stocks",
    "cashHoldingPercentage": 15,
    "drifPercentage": 0,
    "createdOn": "Mar 1, 2017 12:00:00 AM",
    "modelType": "TAXABLE",
    "rebalanceFrequency": "QUARTERLY",
    "assetAllocations": [
      {
        "symbol": "AAPL",
        "percentage": 100
      }
    ]
  },
  {
    "id": "ROBBO_6Robert",
    "name": "ROBBO_6",
    "advisor": "Robert",
    "description": "example model with tech stocks",
    "cashHoldingPercentage": 15,
    "drifPercentage": 0,
    "createdOn": "Mar 1, 2017 12:00:00 AM",
    "modelType": "TAXABLE",
    "rebalanceFrequency": "QUARTERLY",
    "assetAllocations": [
      {
        "symbol": "AAPL",
        "percentage": 100
      }
    ]
  },
  {
    "id": "ROBBO_7Robert",
    "name": "ROBBO_7",
    "advisor": "Robert",
    "description": "example model with tech stocks",
    "cashHoldingPercentage": 15,
    "drifPercentage": 0,
    "createdOn": "Mar 1, 2017 12:00:00 AM",
    "modelType": "TAXABLE",
    "rebalanceFrequency": "QUARTERLY",
    "assetAllocations": [
      {
        "symbol": "AAPL",
        "percentage": 100
      }
    ]
  }
]
```

### GET REQUEST FOR PAGE 14, SIZE 100 (Robert)
```
[
  {
    "id": "ROBBO_15Robert",
    "name": "ROBBO_15",
    "advisor": "Robert",
    "description": "example model with tech stocks",
    "cashHoldingPercentage": 15,
    "drifPercentage": 0,
    "createdOn": "Mar 1, 2017 12:00:00 AM",
    "modelType": "TAXABLE",
    "rebalanceFrequency": "QUARTERLY",
    "assetAllocations": [
      {
        "symbol": "AAPL",
        "percentage": 100
      }
    ]
  }
]
```