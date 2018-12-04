# Co-op Review Service APIs

## Company APIs
POST:

Add company - /company

GET:

Get all companies - /company/allCompanies

Get all company locations - /company/allCompanyLocations


## Review APIs
DELETE:

Delete review - /review

POST:

Add review - /review

GET:

Average rating for company - /review/avgRatingForCompany/{name}

All ratings for company - /review/ratingsForCompany/{name}

All reviews for company - /review/reviewsForCompany/{name}

All locations - /review/allLocations

All majors - /review/allMajors

All reviews - /review/allReviews


## User APIs
DELETE:

Delete user - /user

Delete a user with the given username - /user/{username}

POST:

Add user - /user

GET:

Get user by username - /user/{username}

Get all users - /user/allUsers