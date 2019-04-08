CREATE SEQUENCE octo.sq_issue_event START WITH 1 INCREMENT by 1 NO CYCLE;

CREATE TABLE octo.issue_event(
    id               NUMERIC(8)   NOT NULL,
    numero           NUMERIC(8)   NOT NULL,
    acao             VARCHAR(15)  NOT NULL,
    dt_criacao       TIMESTAMP    NOT NULL,

    CONSTRAINT pk_isev PRIMARY KEY (id)
);
