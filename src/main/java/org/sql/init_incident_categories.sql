# These are the categories from GTFS "service alerts"
INSERT INTO incident_categories (category_name)
VALUES ('Unknown cause'),
       ('Other cause'),
       ('Technical problem'),
       ('Strike'),
       ('Demonstration'),
       ('Accident'),
       ('Holiday'),
       ('Weather'),
       ('Maintenance'),
       ('Construction'),
       ('Police activity'),
       ('Medical emergency');
