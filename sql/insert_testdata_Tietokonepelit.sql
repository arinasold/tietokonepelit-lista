INSERT INTO game
(name, price, releaseDate, genre, developer)
VALUES
('Dead by Daylight', '19.99', '14 june 2016', 'Action', 'Behaviour Interactive Inc.');

INSERT INTO game
(name, price, releaseDate, genre, developer)
VALUES
('PUBG: BATTLEGROUNDS', '0.00', '21 dec 2017', 'Action', 'KRAFTON, Inc.'),
('Gremlins, Inc.', '14.99', '11 mar 2016', 'Strategy', 'Charlie Oscar Lima Tango Interactive');

UPDATE game
SET price = '14.99'
WHERE id = 3;