# State Store Playground
The aim of this repo is to test multiple ways to us a state store for a web form application.

## How to run
- Start the backend via terminal in the folder form-service with 
```mvn spring-boot:run```
- Start the frontend via terminal in the folder form-ui with
```ng serve```

### Generate frontend client with open api specification
- Run this command in the main project folder:
```npx openapi-generator-cli generate -i open-api-specification/open-api-specification.yml -g typescript-angular -o form-ui/src/app/core/modules/openapi --additional-properties fileNaming=kebab-case,withInterfaces=true --generate-alias-as-model```

## Functionality
- The user sees a personal item overview with some item information
- The user is able to open a item to see more details of the item
- The user can create a request to a item
- A request is a three page form with validation on each page

#### Requirements
- Form validation is done in frontend (user friendly) and in backend (script kiddie unfriendly)
- Security is not regarded as it is just a playground/poc
- Backend is a Spring Boot App
- Frontend is Angular

## Concept Variations
### State Store Heavy
All items and requests are loaded in the store

### State Store Light
All data for the item overview, the current loaded item and the current loaded request is loaded in the store

### No State Store
All needed data is fetched from the backend

## Tech Variations
### NGXS
https://www.ngxs.io/

### NGRX
https://ngrx.io/

#### Signal Store
https://ngrx.io/guide/signals

## Implementation
|              | Heavy | Light | No Store |
|------------- | ----- | ----- | -------- |
| NGXS         | TODO1 | TODO4 | TODO7    |
| NGRX         | TODO2 | TODO5 | TODO7    |
| NGRX Signals | TODO3 | TODO6 | TODO7    |

### NGXS Heavy Store
TODO
### NGXS Light Store
TODO
### NGRX Heavy Store
TODO
### NGRX Light Store
TODO
### NGRX Signals Heavy Store
TODO
### NGRX Signals Light Store
TODO
### No Store
TODO

### Backend
TODO

The backend will provide static data.

#### items
- /items
- GET

#### item
- /items/{itemId}
- GET

#### requests
- /requests
- GET

#### request
- /requests/{requestId}
- GET, DELETE, PATCH, POST

#### form1
- /requests/{requestId}/form1
- GET, PATCH

#### form2
- /requests/{requestId}/form2
- GET, PATCH

#### form3
- /requests/{requestId}/form3
- GET, PATCH
