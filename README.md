<h1>Easylearn E-learning Website</h1>

This is our project including 5 members building this project.

<h1>Technology Using in this project</h1>

<h3>Front End</h3>
- HTML/CSS,Javascript
- JQuery, BootStrap, Thymeleaf, Spring MVC.

<h3>Back End</h3>
- Java, Javascript
- Spring Boot, Apache POI, Swagger, ORM, JPA,  MySQL.

<h3>Usage environment</h3>
- Java 17 or higher.
- MySQL version 8.0.33.

<h1>Propose</h1>

Based on the current situation, many people around the world, in addition to going to work to learn and improve their knowledge, search on Google to find documents. They have too much knowledge to absorb but don't know how to summarize the knowledge enough, learn things to apply to real world... There are many problems happening, so this is the reason why we make this website to help many people in the world.

<h1>Content</h1>

We developed this website using Microservice architecture. 
The website consists of three parts: API, Admin, and Client.
- API: Admin or Client calls commands to retrieve data to return to the user.
- Admin: manages course information, manages trainers and other members of the finance team.
- Client: They can buy and watch videos online courses without going to the library. They can take quizzes in the course to understand the lessons better.


<h1>Describe my work in the project</h1>

I took on the role of leader in the project, assigning tasks to team members, 
dividing tasks, creating code review management on GitHub, providing support when issues arise, 
designing and synthesizing the database, and building API service and Admin service.

- API Service: Writing necessary APIs to connect to the database for usage and reuse.
- Admin Service: Constructing code framework to connect to the API Service, writing and designing the frontend.
- Developing CRUD operations for courses, lessons, and quizzes.
- For lessons: adding videos, images, and quizzes for each lesson. Quizzes can be imported from Excel files and downloaded as Excel templates.

<h1>Result</h1>

After developing this project, I have gained a deeper understanding of how a website operates, from its basic structure to its completion. 
I have applied microservice architecture, gaining insights into building and connecting frontend (FE) and backend (BE) components. 
I have also utilized technologies such as Spring Boot, Spring MVC, Thymeleaf, and Apache POI in practical projects.

<h1>How to run the website</h1>

- After downloading the project, we will run APIService first. Wait a while after finishing running (showing "Spring start"), then we will run the Admin folder and then go to the Client folder.
- This project is run in local so you can change another port to run it if you got the error from port.
- http://localhost:9091/admin (This is the Admin page) user: admin , password: admin.
- http://localhost:9092/student-course (This is the Client page).
- Must ensure that APIService finishes running to display other pages.
