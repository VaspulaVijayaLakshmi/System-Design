Accounts can be created with a name and type (Guest, Member, Admin, Moderator)

Questions can be created with a title, description, account, view count, vote count, status, closed remarks, answers, comments, tags, photos, and badges.
Tags can be added to questions with details such as name, description, daily frequency, and weekly frequency.
Comments can be added to questions and answers with text, view count, vote count, and flag count.
Answers can be added to a question with details such as text, account, view count, vote count, flag count, and accept the status.

Notifications can be sent to an account.

Accounts can earn reputation points
Badges can be assigned to an account based on reputation


Entities

Account 

Account - name, Type
Account TYpe - (Guest, Member, Admin, Moderator)

Question
Answer
Comment


Question - Title, text, Author, Reputation, Views, Votes, Answers, Comments
Answers - Text, Author, Reputation, Views, Votes, Comments, IsAccepted
Comments - Text, Author, Reputation, Views, Votes


Tag - Name, Description, Frquency

Badge - Badge Type, Description , Points
(Based on badge type we can have 100 points for user if users gets this....reputation kindof)


Notification - Message, List<Accounts> to be Notified




We can use Observer pattern for notiifcation
Singleton Patterm
Factory Pattern for creating objects - Various types of Users


In that only we will be covering inhertiance, polymophism, interfaces.



