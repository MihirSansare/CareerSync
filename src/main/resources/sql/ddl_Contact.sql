CREATE TABLE contacts
(
    id         BIGINT AUTO_INCREMENT     NOT NULL,
    created_at datetime                  NOT NULL,
    created_by VARCHAR(20)               NOT NULL,
    email      VARCHAR(255)              NOT NULL,
    message    LONGTEXT                  NOT NULL,
    name       VARCHAR(255)              NOT NULL,
    status     VARCHAR(20) DEFAULT 'NEW' NOT NULL,
    subject    VARCHAR(255)              NOT NULL,
    updated_at datetime                  NULL,
    updated_by VARCHAR(20)               NULL,
    user_type  VARCHAR(50)               NOT NULL,
    CONSTRAINT pk_contacts PRIMARY KEY (id)
);