DELETE FROM public.car_service_stations;
DELETE FROM public.mechanic;
DELETE FROM public.car;
DELETE FROM public.service_stations;

ALTER SEQUENCE car_car_id_seq RESTART 1;
INSERT INTO car (model, make, id_engine, price, date) VALUES
  ('E_Class', 'Mercedes-Benz', 12345, 30000, '2012-01-10'),
  ('A6', 'Audi', 5467, 3000, '2002-12-24'),
  ('Giulietta', 'Alfa Romeo', 54211, 15000, '2013-04-26'),
  ('Sens', 'Daewoo', 1212, 3500, '2007-07-07'),
  ('X6', 'BMW', 4532, 70000, '2016-11-12'),
  ('Priora', 'Lada', 32141, 4000, '2009-10-25');

ALTER SEQUENCE service_stations_service_stations_id_seq RESTART 1;
INSERT INTO service_stations (address) VALUES
  ('Yatsenko, 4'),
  ('Sakko, 112'),
  ('Pylypa Orlyka, 36A');

ALTER SEQUENCE mechanic_mechanic_id_seq RESTART 1;
INSERT INTO mechanic (name, surname, service_stations_id) VALUES
  ('Ivan', 'Petrov', 1),
  ('Oleg', 'Ivanov', 3),
  ('Stepan', 'Korol', 2),
  ('Ihor', 'Golov', 3),
  ('Evgeniy', 'Chaika', 2),
  ('Anton', 'Pogoreov', 1),
  ('Ivan', 'Golovach', 3),
  ('Sergey', 'Nemchinskiy', 2),
  ('Yuri', 'Tkach', 1),
  ('Key', 'Horstman', 3),
  ('Yakov', 'Fine', 1),
  ('Herbert', 'Schildt', 2),
  ('Katty', 'Sierra', 1),
  ('Josh', 'Bloch', 1),
  ('Thomas', 'Kormen', 2);

ALTER SEQUENCE car_service_stations_car_service_stations_id_seq RESTART 1;
INSERT INTO car_service_stations (car_id, service_stations_id) VALUES
  (1, 1),
  (1, 2),
  (2, 1),
  (3, 1),
  (3, 2),
  (3, 3),
  (6, 1),
  (4, 3),
  (5, 2),
  (5, 3);