

CREATE TABLE maintenance_scheduless
( id BIGINT PRIMARY KEY AUTO_INCREMENT,
  car_id BIGINT NOT NULL,
  description VARCHAR(255),
  scheduled_date DATE );

select * FROM maintenance_scheduless;


CREATE TABLE task
( id BIGINT PRIMARY KEY AUTO_INCREMENT,
  car_id BIGINT NOT NULL,
  description VARCHAR(255),
  scheduled_date DATE );


select * FROM task;