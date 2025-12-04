Users can create, update, and delete tasks
Each task should support metadata such as title, description, due date, priority, status, and tags
Tasks can have subtasks, supporting a parent-child relationship

Tasks can be grouped under task lists or projects (e.g., "Project Phoenix Bugs," "Q4 Marketing Plan").

Users can assign tasks to themselves or others (single assignee per task)

Users can update the status of a task (e.g., from 'To-Do' to 'In Progress').

Users should be able to view tasks in a list sorted by due date or priority.
Users can search tasks by title and filter tasks using keywords, status, user, etc.
The system should maintain an activity log for each task to track creation, updates, and status changes




User class
Task Class
Project Class - LIst of tasks



TaskManager Class - Create, Update, Delete, View, Search, Filter tasks

# Task Management System

Startegy Pattern - search by title, filter by status, user, etc.
Builder Pattern - Task Class
State Pattern - Task Status
SIngleTon Pattern - taskMaager



Extending - observe rpattern when task is asigned to user,modified



TASK MANAGEMENT - NEED concurrency handling when multiple users are accessing the same task
