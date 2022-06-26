# WeightTracker

- Add DataBase CFG
```
CREATE TABLE user (
    id serial PRIMARY KEY,
    username VARCHAR (32) NOT NULL UNIQUE,
    password VARCHAR (64) NOT NULL,
    age INTEGER NOT NULL,
    height INTEGER NOT NULL,
    weight INTEGER NOT NULL,
    lifestyle INTEGER NOT NULL  REFERENCES lifestyle (id)
);

CREATE TABLE lifestyle (
    id serial PRIMARY KEY,
    type VARCHAR (32) NOT NULL UNIQUE
);

CREATE TABLE role (
    id serial PRIMARY KEY,
    name VARCHAR (32) NOT NULL UNIQUE
);

CREATE TABLE user_role (
    user_id INTEGER  REFERENCES user (id),
    role_id INTEGER  REFERENCES role (id)
);

CREATE TABLE food (
    id serial PRIMARY KEY,
    name VARCHAR (32) NOT NULL UNIQUE,
    calories INTEGER NOT NULL,
    proteins INTEGER NOT NULL,
    fats INTEGER NOT NULL,    
  carbohydrates INTEGER NOT NULL
);

INSERT INTO role (name) VALUES("admin");
```

- Connect to web app 
```
localhost:8000/app/tracker
```
