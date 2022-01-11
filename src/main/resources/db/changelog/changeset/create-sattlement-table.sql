
CREATE TABLE settlements_np (
    id SERIAL,
    ref varchar(36),
    description varchar(50),
    description_ru varchar(50),
    settlement_type_description varchar(36),
    settlement_type_description_ru varchar(36),
    area_description varchar(50),
    area_description_ru varchar(50),
    PRIMARY KEY(id));