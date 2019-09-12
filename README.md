# Intern_Demo

Inside demo :
  1. Controller : This package deals with controllers for rest services.
  2. data_access_object : This package contains the interfaces that deals with the database.
  3. entitymodels : This package deals with the entity class models that maps the database table.
  4. jsonmodels : This package java class format to accept the json request.
                  In this QuizWrapper contain {
                        Total_Record;
                        Quiz object contain {
                                Math object;
                                Sport object;
                         }
                   }

My project accept json request in this format :
     {
      "quiz": 
      {
          "sports": 
          {
              "q": [

                     {
                      "question": "Which one is correct team name in NBA?",       
                      "options": [
                          "New York Bulls",
                          "Los Angeles Kings",
                          "Golden State Warriros",
                          "Huston Rocket"
                      ],
                      "answer": "Huston Rocket"
                  }
              ]
          },
          "maths": {
              "q": [
                  {
                      "question": "5 + 7 = ?",
                      "options": [
                          "10",
                          "11",
                          "12",
                          "13"
                      ],
                      "answer": "12"
                  }
              ]
          }
      }
  }
  

After this response will be :
    {
      "math_record_inserted": "2",
      "sport_record_inserted": "1"
    }
