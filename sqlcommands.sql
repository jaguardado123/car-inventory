-- Create our car inventory table

-- Table should name: Cars
-- Table should have columns: make, model, year
create table Cars (make text, model text, year int);

insert into Cars (make,  model, year) values ('toyota', 'sienna', 2010); 

select count(*) from Cars;
