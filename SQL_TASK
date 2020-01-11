1.  Select countries where the total number of inhabitants (population) in all cities is greater
than 400.

SELECT c.Name FROM Country AS c 
WHERE 400 < (SELECT ci.Population FROM City AS ci WHERE c.id_CountryID = ci.CountryID)

2. Select names of the countries that have no buildings at all

SELECT c.Name FROM Country AS c 
JOIN City AS ci ON c.CountryID = ci.CountryID 
JOIN Building AS b ON ci.CityID = b.CityID 
WHERE b.CityID IS NULL
