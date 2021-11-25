DROP TABLE IF EXISTS userinfo;

CREATE TABLE userinfo (
  id    BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
  name VARCHAR(64)              NOT NULL,
  aadhar VARCHAR(12)              NOT NULL UNIQUE,
  email VARCHAR(128)              NOT NULL,
  mobilenumber VARCHAR(10)              NOT NULL,
  accesslevel SMALLINT NOT NULL
);


DROP TABLE IF EXISTS vaccines;

CREATE TABLE vaccines (
  id    BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
  vaccinename VARCHAR(64)              NOT NULL UNIQUE ,
  disease VARCHAR(64)              NOT NULL
);


DROP TABLE IF EXISTS vaccinationhistory;

CREATE TABLE vaccinationhistory (
  id    BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
  userid BIGINT NOT NULL,
  vaccinename VARCHAR(64)              NOT NULL UNIQUE ,
  dateofadministration TIMESTAMP              NOT NULL,
  CONSTRAINT fk_vaccinationhistoryuserinfo
        FOREIGN KEY(userid)
  	  REFERENCES userinfo(id)
);

DROP TABLE IF EXISTS hcprovider;

CREATE TABLE hcprovider (
  id    BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
  hcprovidername VARCHAR(128) NOT NULL UNIQUE,
  address VARCHAR(256) NOT NULL,
  city VARCHAR(64) NOT NULL
);

DROP TABLE IF EXISTS vaccinationdrive;

CREATE TABLE vaccinationdrive (
  id    BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
  userid BIGINT NOT NULL,
  vaccinename VARCHAR(64)              NOT NULL UNIQUE ,
  startdate TIMESTAMP              NOT NULL,
  enddate TIMESTAMP              NOT NULL,
  hcprovidername VARCHAR(128) NOT NULL,
  CONSTRAINT fk_vaccinationdriveuserinfo
        FOREIGN KEY(userid)
  	  REFERENCES userinfo(id),
  CONSTRAINT fk_vaccinationdrivehcprovider
          FOREIGN KEY(hcprovidername)
    	  REFERENCES hcprovider(hcprovidername)
);




