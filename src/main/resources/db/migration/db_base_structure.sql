-- DB: postgresql
-- USERNAME: root
-- PASSWORD:
-- SCHEMA: eagle_hubs

---------------------------------------------------- average_data --------------------------------------------------------------------------
CREATE TABLE average_data (
  average_data_id  SERIAL       NOT NULL PRIMARY KEY,
  description      TEXT         NOT NULL,
  quantity         BIGINT       NOT NULL,
  measure          VARCHAR(50)  NOT NULL
);

---------------------------------------------------- users --------------------------------------------------------------------------
CREATE TABLE users (
   user_id          BIGSERIAL    NOT NULL PRIMARY KEY,
   name             VARCHAR(50)  NOT NULL,
   user_name        VARCHAR(50)  NOT NULL,
   email_address    VARCHAR(100) NOT NULL,
   password         VARCHAR(250) NOT NULL,
   enabled          BOOLEAN      NOT NULL DEFAULT true,
   created_at       TIMESTAMP    NOT NULL,
   created_by       VARCHAR(30)  NOT NULL,
   updated_at       TIMESTAMP    NOT NULL,
   updated_by       VARCHAR(30)  NOT NULL
);

COMMENT ON TABLE users IS 'This will contain the users information.';
COMMENT ON COLUMN users.enabled IS 'This field indicates whether the user was deleted.';

---------------------------------------------------- type_fuel --------------------------------------------------------------------------
CREATE TABLE type_fuel (
   type_fuel_id   SERIAL            NOT NULL,
   name           VARCHAR(256)      NOT NULL,
   description    VARCHAR(256)      NOT NULL,
   created_at     TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
   created_by     VARCHAR(256)             NOT NULL DEFAULT 'ADMIN',
   updated_at     TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
   updated_by     VARCHAR(256)             NOT NULL DEFAULT 'ADMIN',
   PRIMARY KEY (type_fuel_id)
);

---------------------------------------------------- type_consumption --------------------------------------------------------------------------
CREATE TABLE type_consumption (
  type_consumption_id   SERIAL            NOT NULL,
  name                  VARCHAR(256)      NOT NULL,
  description           VARCHAR(256)      NOT NULL,
  created_at     TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
  created_by     VARCHAR(256)             NOT NULL DEFAULT 'ADMIN',
  updated_at     TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
  updated_by     VARCHAR(256)             NOT NULL DEFAULT 'ADMIN',
  PRIMARY KEY (type_consumption_id)
);

---------------------------------------------------- measure --------------------------------------------------------------------------
CREATE TABLE measure (
 measure_id   	 SERIAL            NOT NULL,
 name           VARCHAR(256)      NOT NULL,
 description    VARCHAR(256)      NOT NULL,
 created_at     TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
 created_by     VARCHAR(256)             NOT NULL DEFAULT 'ADMIN',
 updated_at     TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
 updated_by     VARCHAR(256)             NOT NULL DEFAULT 'ADMIN',
 PRIMARY KEY (measure_id)
);

---------------------------------------------------- type_trip --------------------------------------------------------------------------
CREATE TABLE type_trip (
    type_trip_id   BIGSERIAL         NOT NULL,
    name         	 VARCHAR(256)      NOT NULL,
    description    VARCHAR(256)      NOT NULL,
    created_at     TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
    created_by     VARCHAR(256)             NOT NULL DEFAULT 'ADMIN',
    updated_at     TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
    updated_by     VARCHAR(256)             NOT NULL DEFAULT 'ADMIN',
    PRIMARY KEY (type_trip_id)
);

---------------------------------------------------- type_emission --------------------------------------------------------------------------
CREATE TABLE type_emission (
   type_emission_id   SERIAL        NOT NULL,
   name         	 VARCHAR(256)      NOT NULL,
   description    VARCHAR(256)      NOT NULL,
   created_at     TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
   created_by     VARCHAR(256)             NOT NULL DEFAULT 'ADMIN',
   updated_at     TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
   updated_by     VARCHAR(256)             NOT NULL DEFAULT 'ADMIN',
   PRIMARY KEY (type_emission_id)
);

---------------------------------------------------- consumption --------------------------------------------------------------------------
CREATE TABLE consumption (
     consumption_id          BIGSERIAL            NOT NULL,
     name                    VARCHAR(256)      NOT NULL,
     description             VARCHAR(256)      NOT NULL,
     measure_id              INT4 NOT NULL,
     type_fuel_id            INT4 NOT NULL,
     type_consumption_id     INT4 NOT NULL,
     type_emission_id     INT4 NOT NULL,
     quantity     	 BIGINT NOT NULL,
     created_at     TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
     created_by     VARCHAR(256)             NOT NULL DEFAULT 'ADMIN',
     updated_at     TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
     updated_by     VARCHAR(256)             NOT NULL DEFAULT 'ADMIN',
     PRIMARY KEY (consumption_id),
     CONSTRAINT type_consumption_fk1 FOREIGN KEY(type_consumption_id) REFERENCES type_consumption(type_consumption_id),
     CONSTRAINT type_fuel_fk2 FOREIGN KEY(type_fuel_id) REFERENCES type_fuel(type_fuel_id),
     CONSTRAINT measure_fk3 FOREIGN KEY(measure_id) REFERENCES measure(measure_id),
     CONSTRAINT type_emission_fk4 FOREIGN KEY(type_emission_id) REFERENCES type_emission(type_emission_id)
);

---------------------------------------------------- trips --------------------------------------------------------------------------
CREATE TABLE trips (
   trip_id            BIGSERIAL         NOT NULL,
   name               VARCHAR(256)      NOT NULL,
   description        VARCHAR(256)      NOT NULL,
   type_trip_id       INT4 NOT NULL,
   date_trip      	 DATE NOT NULL,
   consumption_id     BIGINT NOT NULL,
   created_at     TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
   created_by     VARCHAR(256)             NOT NULL DEFAULT 'ADMIN',
   updated_at     TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
   updated_by     VARCHAR(256)             NOT NULL DEFAULT 'ADMIN',
   PRIMARY KEY (trip_id),
   CONSTRAINT type_trip_fk1 FOREIGN KEY(type_trip_id) REFERENCES type_trip(type_trip_id)
);



