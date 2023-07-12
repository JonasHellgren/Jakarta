# Modules

## CLI

URL reader is candidate name of this module

| Class                  | Description                                                              |
|:-----------------------|:-------------------------------------------------------------------------|
| CourseRetriever        | Runnabla class that reads courses from url and stores them in courses.db |
| CourseRetrievalService | Include methods that reads courses from url                              | 
| CourseStorageService   | Injected with repo and stores list of courses in database                | 
| PluralSightCourse      | Domain object describing a course returned from CourseRetrievalService                         | 

## Repository

| Class                  | Description                                                   |
|:-----------------------|:--------------------------------------------------------------|
| CourseJdbcRepository   | Repo with interface CourseRepocitoryInterace. Stores courses. |
| Course                 | Domain object used by above repo                              | 


## Server

| Class            | Description                                                                    |
|:-----------------|:-------------------------------------------------------------------------------|
| CourseController | Runner class that starts up server at localhost:8080. Using Repocitory module. |
| CourseServer     | Domain object used by above repo                                               | 
