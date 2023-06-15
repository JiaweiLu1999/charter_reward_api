# Assessment Documentation

## Requirement

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.

A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent
over $50 in each transaction.

(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).

Given a record of every transaction during a three-month period,
calculate the reward points earned for each customer per month and total.

- Solve using Spring Boot
- Create a RESTful endpoint
- Make up a data set to best demonstrate your solution
- Check solution into GitHub

## Solution

### API documentation

#### Get the reward API

- Endpoint: `/reward/{customer_id}`
- Method : `GET`
- Status code : `200 / 4xx / 5xx`
- Sample response:

```
{   
    "JUNE":250.0,
    "MAY":70.0,
    "APRIL":10.0,
    "Total":330.0
}
```

### DataBase Generation

#### MySQL Script

```mysql
create table charter_db.record
(
    id          int auto_increment primary key,
    customer_id int                                 not null,
    total       double                              not null,
    time        timestamp default current_timestamp not null
);
INSERT INTO charter_db.record (customer_id, total, time)
VALUES (1, 120, '2023-05-14 16:29:31');
INSERT INTO charter_db.record (customer_id, total, time)
VALUES (1, 100, '2023-06-03 16:30:02');
INSERT INTO charter_db.record (customer_id, total, time)
VALUES (1, 80, '2023-06-13 18:30:37');
INSERT INTO charter_db.record (customer_id, total, time)
VALUES (2, 40, '2023-06-14 16:31:17');
INSERT INTO charter_db.record (customer_id, total, time)
VALUES (2, 80, '2023-06-03 20:15:43');
INSERT INTO charter_db.record (customer_id, total, time)
VALUES (1, 150, '2023-04-15 09:50:17');
INSERT INTO charter_db.record (customer_id, total, time)
VALUES (1, 75, '2023-04-25 12:51:18');
INSERT INTO charter_db.record (customer_id, total, time)
VALUES (2, 200, '2023-05-03 01:52:29');
INSERT INTO charter_db.record (customer_id, total, time)
VALUES (2, 10, '2023-04-27 22:53:04');
INSERT INTO charter_db.record (customer_id, total, time)
VALUES (3, 60, '2023-04-18 09:54:31');
```

### Test Result

#### Get the reward of customer_id 1

- request: `GET /reward/1`
- response:

```
{   
    "JUNE":80.0,
    "MAY":90.0,
    "Total":345.0,
    "APRIL":175.0
}
```

#### Get the reward of customer_id 2

- request: `GET /reward/2`
- response:

```
{
    "JUNE":30.0,
    "MAY":250.0,
    "Total":280.0,
    "APRIL":0.0
}
```

#### Get the reward of customer_id 3

- request: `GET /reward/3`
- response:

```
{
    "JUNE":250.0,
    "MAY":70.0,
    "Total":330.0,
    "APRIL":10.0
}
```

#### Get the reward of customer_id 4

- request: `GET /reward/4`
- response:

```
Cannot find customer with id = 4
```


