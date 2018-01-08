CREATE TABLE usuarios
(
  cd_usuario INT AUTO_INCREMENT PRIMARY KEY,
  nm_usuario VARCHAR(200) NULL,
  nm_senha   VARCHAR(200) NULL
) ENGINE = InnoDB;

create table agenda (
  cd_agenda INT AUTO_INCREMENT,
  nm_agenda varchar(200),
  cd_usuario INT,
  PRIMARY KEY(`cd_agenda`)
) ENGINE = InnoDB;

ALTER TABLE agenda
    ADD FOREIGN KEY(`cd_usuario`) REFERENCES `usuarios`(`cd_usuario`);

create table agenda_compromisso (
  cd_agenda INT,
  dt_agenda datetime,
  ds_compromisso text,
  PRIMARY KEY(`cd_agenda`, `dt_agenda`)
) ENGINE = InnoDB;

alter table agenda_compromisso
    add FOREIGN KEY(`cd_agenda`) REFERENCES `agenda`(`cd_agenda`);
