My personal experience...


Jira board..

We need to maintain the task ststaus....


TO_DO
IN_PROGRESS
DONE
ACCEPTED


Now we cant move the story from TO_DO/IN-PRGRESS STATE to ACCEPTED STSTAE directly...

We need to check...


Now initally...we will write a class...

And if else statement


Like lest say next state we want to transform  is ACCEPTED.


Like if(currState==TO_DO){
    THEN you can move to IN_PROGRESS

    else if user is trying to move to ACDEPTED
     give message likke... you cn tmove from to_DO to Accepted directly



    else if ....DONE
      you cant move to done
}



else if (currState == IN_POROGESS){

.....if-else again
}



......


if we add new state like review...


then we ned to modify all the if-else statements again...



This is violating the open closed principle




It should be open for extension but closed for modification

and also tight cupling



Hence State Patterm


