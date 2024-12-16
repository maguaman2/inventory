CREATE TABLE IF NOT EXISTS category
(
    id          SERIAL,
    description VARCHAR(255)   NOT NULL,
    investment  DECIMAL(10, 2) ,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS product
(
    id          SERIAL,
    description VARCHAR(255)   NOT NULL,
    stock       INT,
    pvp         DECIMAL(10, 2),
    category_id INT            NOT NULL,
    primary key (id),
    foreign key (category_id) references category (id)
);