
    create table add_fields (
        id int4 not null,
        name varchar(255),
        is_required boolean,
        type varchar(255),
        department_id int4,
        primary key (id)
    );

    create table add_values (
        id int4 not null,
        number_value float8,
        file_value bytea,
        text_value varchar(255),
        addField_id int4,
        application_id int4,
        primary key (id)
    );

    create table appStatuses (
        id int4 not null,
        comment varchar(255),
        date timestamp,
        status varchar(255),
        application_id int4,
        user_id int4,
        primary key (id)
    );

    create table applications (
        id int4 not null,
        cin int4,
        citizenship varchar(255),
        date_of_birth timestamp,
        email varchar(255),
        first_name varchar(255),
        gender varchar(255),
        gpa float8,
        gre_score int4,
        last_name varchar(255),
        phone varchar(255),
        term varchar(255),
        toefl_score int4,
        transcript bytea,
        applicant_id int4,
        department_id int4,
        program_id int4,
        primary key (id)
    );

    create table degrees (
        id int4 not null,
        endyear int4,
        major varchar(255),
        name varchar(255),
        school varchar(255),
        startyear int4,
        application_id int4,
        primary key (id)
    );

    create table departments (
        id int4 not null,
        name varchar(255),
        primary key (id)
    );

    create table programs (
        id int4 not null,
        name varchar(255),
        department_id int4,
        primary key (id)
    );

    create table roles (
        user_id int4 not null,
        role varchar(255)
    );

    create table users (
        id int4 not null,
        email varchar(255) not null,
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255) not null,
        primary key (id)
    );

    alter table users 
        add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email);

    alter table add_fields 
        add constraint FK_n2xq2fpnfncm6actqbi50jh87 
        foreign key (department_id) 
        references departments;

    alter table add_values 
        add constraint FK_e0ji7k1cdh8784h1rg86vkbfp 
        foreign key (addField_id) 
        references add_fields;

    alter table add_values 
        add constraint FK_saranio4fpf9nwj7xpy7h1o88 
        foreign key (application_id) 
        references applications;

    alter table appStatuses 
        add constraint FK_p87ip71wae29edg4pq0p8yfqm 
        foreign key (application_id) 
        references applications;

    alter table appStatuses 
        add constraint FK_tb9oxm2jppf5ewf6v5ihfryad 
        foreign key (user_id) 
        references users;

    alter table applications 
        add constraint FK_lmcomkxa52fc4kw1pgin4ov1i 
        foreign key (applicant_id) 
        references users;

    alter table applications 
        add constraint FK_78su0wnn02817h354falvtovc 
        foreign key (department_id) 
        references departments;

    alter table applications 
        add constraint FK_fvv8mt4q3l0jlgem0374rwfb5 
        foreign key (program_id) 
        references programs;

    alter table degrees 
        add constraint FK_rqi4wrhhtwwk6r9c9hcjyext9 
        foreign key (application_id) 
        references applications;

    alter table programs 
        add constraint FK_t38cee5jtiwtw07papp2rjlca 
        foreign key (department_id) 
        references departments;

    alter table roles 
        add constraint FK_rhrcyw5rkf3db7urabnxic6hk 
        foreign key (user_id) 
        references users;

    create sequence hibernate_sequence;
