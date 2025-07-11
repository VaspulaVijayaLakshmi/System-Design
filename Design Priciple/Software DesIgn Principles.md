https://algomaster.io/learn/lld


1. 𝐊𝐈𝐒𝐒 (𝐊𝐞𝐞𝐩 𝐈𝐭 𝐒𝐢𝐦𝐩𝐥𝐞, 𝐒𝐭𝐮𝐩𝐢𝐝): Design solutions as simply as possible. Avoid unnecessary complexity.

2. 𝐃𝐑𝐘 (𝐃𝐨𝐧'𝐭 𝐑𝐞𝐩𝐞𝐚𝐭 𝐘𝐨𝐮𝐫𝐬𝐞𝐥𝐟): Eliminate duplicate code. Centralize logic to make maintenance easier.

3. 𝐘𝐀𝐆𝐍𝐈 (𝐘𝐨𝐮 𝐀𝐫𝐞𝐧’𝐭 𝐆𝐨𝐧𝐧𝐚 𝐍𝐞𝐞𝐝 𝐈𝐭): Build only what’s needed now, not features you might need “someday.”

4. 𝐒𝐭𝐫𝐢𝐯𝐞 𝐟𝐨𝐫 𝐋𝐨𝐨𝐬𝐞𝐥𝐲 𝐂𝐨𝐮𝐩𝐥𝐞𝐝 𝐃𝐞𝐬𝐢𝐠𝐧𝐬: Reduce interdependencies so changes in one part don’t break others.

5. 𝐅𝐚𝐯𝐨𝐫 𝐂𝐨𝐦𝐩𝐨𝐬𝐢𝐭𝐢𝐨𝐧 𝐎𝐯𝐞𝐫 𝐈𝐧𝐡𝐞𝐫𝐢𝐭𝐚𝐧𝐜𝐞: Combine small, reusable components instead of relying heavily on class hierarchies.
                                Because heirachies gets complicated over time.

6. LOD : Only communicate with direct neighbors. Don’t chain too many calls.
          order.getCustomer().getAddress().getCity();

This is what excapulation is , we need not know the internal details - The internal navigation is hidden
                   

7. SOLID

 S -> 𝐒𝐑𝐏 (𝐒𝐢𝐧𝐠𝐥𝐞 𝐑𝐞𝐬𝐩𝐨𝐧𝐬𝐢𝐛𝐢𝐥𝐢𝐭𝐲 𝐏𝐫𝐢𝐧𝐜𝐢𝐩𝐥𝐞): One class, one job—keep responsibilities clear and focused.

 O ->  𝐎𝐂𝐏 (𝐎𝐩𝐞𝐧/𝐂𝐥𝐨𝐬𝐞𝐝 𝐏𝐫𝐢𝐧𝐜𝐢𝐩𝐥𝐞): Open for extension, closed for modification — add new features without changing core code. - Inhertiance

 L -> 𝐋𝐒𝐏 (𝐋𝐢𝐬𝐤𝐨𝐯 𝐒𝐮𝐛𝐬𝐭𝐢𝐭𝐮𝐭𝐢𝐨𝐧 𝐏𝐫𝐢𝐧𝐜𝐢𝐩𝐥𝐞): Subclasses should seamlessly replace their parents without issues  - override

 In simpler terms: If a class S extends or implements class T, then you should be able to use S anywhere T is expected—without breaking the program’s behavior or logic.
 In other words, subtypes must honor the expectations set by their base types. 
 The client code shouldn’t need to know or care which specific subtype it’s dealing with.
 Everything should “just work.”

 I -> 𝐈𝐒𝐏 (𝐈𝐧𝐭𝐞𝐫𝐟𝐚𝐜𝐞 𝐒𝐞𝐠𝐫𝐞𝐠𝐚𝐭𝐢𝐨𝐧 𝐏𝐫𝐢𝐧𝐜𝐢𝐩𝐥𝐞): Create small, specific interfaces instead of large, general ones  - interfaces

 D -> 𝐃𝐈𝐏 (𝐃𝐞𝐩𝐞𝐧𝐝𝐞𝐧𝐜𝐲 𝐈𝐧𝐯𝐞𝐫𝐬𝐢𝐨𝐧 𝐏𝐫𝐢𝐧𝐜𝐢𝐩𝐥𝐞): Depend on abstractions, not details—high-level modules shouldn’t depend on low-level modules. - abstarctions 



____________

-> Interfaces :
A pure contract — defines what should be done, but not how.



-> Abstraction
Hiding implementation details while exposing only essential features.


Can include:
Both abstract methods (no implementation)
and  concrete methods (with implementation)

