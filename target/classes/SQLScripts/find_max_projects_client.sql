select * from(
select name, count(PROJECT.ID) as PROJECT_COUNT
from CLIENT 
join PROJECT on client.id = PROJECT.CLIENT_ID
group by name
) where PROJECT_COUNT = (SELECT MAX(projects_per_client) 
FROM (
    SELECT COUNT(PROJECT.ID) AS projects_per_client
    FROM CLIENT 
    JOIN PROJECT ON client.id = PROJECT.CLIENT_ID
    GROUP BY client.id
))