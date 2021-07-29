# E-Learning Project

A simple web application using Spring MVC.

## schema_with_data.sql

This is an SQL dump that contains the table definitions along with some sample data to be used in the project. Please note that the database used is MySQL (Server v8.0.25).

To import the data, open cmd and type in:

`mysqld -u <username> -p < schema_with_data.sql`

#### Note:

Importing this dump will delete the "project" databsae, if it exists.

## Screenshots

![Login](/screenshots/login.png?raw=true "Login")

![Login Incorrect](/screenshots/login_incorrect.png?raw=true "Login Incorrect")

![New User](/screenshots/new_user.png?raw=true "New User")


### Logged in as User

![Dashboard](/screenshots/user_dashboard.png?raw=true "Dashboard")

![Profile](/screenshots/user_profile.png?raw=true "Profile")

![Update User](/screenshots/update_user.png?raw=true "Update User")

![Feedbacks](/screenshots/feedbacks_user.png?raw=true "Feedbacks")

![New Feedback](/screenshots/new_feedback.png?raw=true "New Feedback")


### Logged in as Admin

![Dashboard](/screenshots/admin_dashboard.png?raw=true "Dashboard")

![Users](/screenshots/users_list.png?raw=true "Users")

![Feedbacks](/screenshots/feedbacks_admin.png?raw=true "Feedbacks")

![Admins](/screenshots/admins_list.png?raw=true "Admins")


### User/Admin (Pages that doesn't require authentication)

![Course](/screenshots/courses.png?raw=true "Courses")

![Contacts](/screenshots/contacts.png?raw=true "Contacts")
