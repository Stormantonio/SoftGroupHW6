-- car

DROP SEQUENCE IF EXISTS public.car_car_id_seq;
CREATE SEQUENCE public.car_car_id_seq
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

ALTER SEQUENCE public.car_car_id_seq
OWNER TO postgres;

CREATE TABLE IF NOT EXISTS public.car
(
  car_id    INTEGER                                        NOT NULL DEFAULT nextval('car_car_id_seq' :: REGCLASS),
  model     CHARACTER VARYING COLLATE pg_catalog."default" NOT NULL,
  make      CHARACTER VARYING COLLATE pg_catalog."default" NOT NULL,
  id_engine INTEGER                                        NOT NULL,
  price     INTEGER,
  date      DATE                                           NOT NULL,
  CONSTRAINT pk_car_id PRIMARY KEY (car_id)
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.car
  OWNER TO postgres;

-- mechanic

DROP SEQUENCE IF EXISTS public.mechanic_mechanic_id_seq;
CREATE SEQUENCE public.mechanic_mechanic_id_seq
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

ALTER SEQUENCE public.mechanic_mechanic_id_seq
OWNER TO postgres;


CREATE TABLE IF NOT EXISTS public.mechanic
(
  mechanic_id         INTEGER                                        NOT NULL DEFAULT nextval(
      'mechanic_mechanic_id_seq' :: REGCLASS),
  name                CHARACTER VARYING COLLATE pg_catalog."default" NOT NULL,
  surname             CHARACTER VARYING COLLATE pg_catalog."default" NOT NULL,
  service_stations_id INTEGER,
  CONSTRAINT pk_mechanic_id PRIMARY KEY (mechanic_id),
  CONSTRAINT fk_service_station_id FOREIGN KEY (service_stations_id)
  REFERENCES public.service_stations (service_stations_id) MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.mechanic
  OWNER TO postgres;

-- service_stations

DROP SEQUENCE IF EXISTS public.service_stations_service_stations_id_seq;
CREATE INDEX fki_fk_service_station_id
ON public.mechanic USING BTREE
(service_stations_id)
TABLESPACE pg_default;

CREATE SEQUENCE public.service_stations_service_stations_id_seq
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

ALTER SEQUENCE public.service_stations_service_stations_id_seq
OWNER TO postgres;

CREATE TABLE IF NOT EXISTS public.service_stations
(
  service_stations_id INTEGER                                        NOT NULL DEFAULT nextval(
      'service_stations_service_stations_id_seq' :: REGCLASS),
  address             CHARACTER VARYING COLLATE pg_catalog."default" NOT NULL,
  CONSTRAINT pk_service_stations_id PRIMARY KEY (service_stations_id)
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.service_stations
  OWNER TO postgres;

-- car_service_stations

DROP SEQUENCE IF EXISTS public.car_service_stations_car_service_stations_id_seq;
CREATE SEQUENCE public.car_service_stations_car_service_stations_id_seq
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

ALTER SEQUENCE public.car_service_stations_car_service_stations_id_seq
OWNER TO postgres;

CREATE TABLE IF NOT EXISTS public.car_service_stations
(
  car_service_stations_id INTEGER NOT NULL DEFAULT nextval(
      'car_service_stations_car_service_stations_id_seq' :: REGCLASS),
  car_id                  INTEGER NOT NULL,
  service_stations_id     INTEGER NOT NULL,
  CONSTRAINT pk_car_service_stations_id PRIMARY KEY (car_service_stations_id),
  CONSTRAINT fk_car_id FOREIGN KEY (car_id)
  REFERENCES public.car (car_id) MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION,
  CONSTRAINT fk_service_stations_id FOREIGN KEY (service_stations_id)
  REFERENCES public.service_stations (service_stations_id) MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.car_service_stations
  OWNER TO postgres;

CREATE INDEX fki_fk_car_id
ON public.car_service_stations USING BTREE
(car_id)
TABLESPACE pg_default;

CREATE INDEX fki_fk_service_stations_id
ON public.car_service_stations USING BTREE
(service_stations_id)
TABLESPACE pg_default;

