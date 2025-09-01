-- Create the post table
CREATE TABLE
    post (
        id SERIAL PRIMARY KEY,
        title VARCHAR(255),
        type VARCHAR(50),
        content VARCHAR(2000),
        image_path VARCHAR(255),
        created_at DATE,
        num_likes INT DEFAULT 0,
        num_comments INT DEFAULT 0
    );

-- Create the about_me table
CREATE TABLE
    about_me (
        id INT PRIMARY KEY,
        content VARCHAR(4000),
        image_path VARCHAR(255),
        author VARCHAR(100)
    );

-- Create the social table
CREATE TABLE
    social (
        id SERIAL PRIMARY KEY,
        name VARCHAR(50),
        icon VARCHAR(255)
    );

-- Create the contact_message table
CREATE TABLE
    contact_message (
        id SERIAL PRIMARY KEY,
        name VARCHAR(100),
        email VARCHAR(100),
        message VARCHAR(1000)
    );

-- Create the total_views table
CREATE TABLE
    total_views (id INT PRIMARY KEY, view_count INT);