select case
    when BIRTHDAY = (select max(BIRTHDAY ) from WORKER) then 'YOUNGEST'
    else 'ELDEST'
end as type, NAME, BIRTHDAY from WORKER where BIRTHDAY = (select max(BIRTHDAY ) from WORKER) or BIRTHDAY = (select min(BIRTHDAY ) from WORKER);
