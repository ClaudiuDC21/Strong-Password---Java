# Strong-Password---Java

Hello. This is a Strong password checker program made in Java.

What is required? 
"A password is considered strong if below conditions are all met:
1. It has at least 6 characters and at most 20 characters.
2. It must contain at least one lowercase letter, at least one uppercase letter, and at least one
digit.
3. It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..."
is strong, assuming other conditions are met).
Write an algorithm that takes a string s as input, and return the MINIMUM change required to
make s a strong password. If s is already strong, return 0.
Insertion, deletion or replace of any one character are all considered as one change."

How did I do it?
The minimNumberOfChanges function calculates the minimum number of changes required for the password to be considered strong.

First of all, I checked if the given password has at least one number, one uppercase letter and one lowercase letter, by going through the String and checking each character. If there is none of it, the caseChanging variable increases (it can increase up to 3).

Secondly, the length of the password is checked.

If this is less than 6, the following is done: if the length is less than or equal to 3, the minimum number is the difference between 6 and the length of the password (considering that the user will be able to add an uppercase letter, a lowercase letter and a number among these 3 additions), and otherwise, the minimum number of changes is determined from the maximum between the difference up to 6 and caseChanging (all 3 letter conditions fulfilled).

If the length of the password is greater than 20, the minimum number of changes is equal to the difference up to 20, and the value of caseChanging is also added because letters are replaced so that the 3 conditions are fulfilled.

And if the length is between 6 and 20, the minimum number of changes is equal to caseChanging, that is, all 3 conditions must be met.

If the required length and the appearance of specific characters have been established, check that there are not 3 identical characters in consecutive positions. The string is traversed from position one to the penultimate and the character at the index position and its neighbors are checked (assuming that if found, the replaced character will be the one on the right), moving to the next 3 positions if such a character is found possibility. Otherwise, the index grows normally.

At the end, the minimum number of necessary changes is returned, this being 0 if the password is already strong.

In the main function, the user will add from the keyboard the password he wants to be verified.

Main assumptions:
- if the length of the password <= 3, in adding the minimum 3 characters, an uppercase letter, a lowercase letter and a number will be added
- if 3 < password length < 6, in the addition of characters, the missing character will be added to lengthen the respective condition, or their number, if it is greater than the difference up to 6
- if there are 3 identical characters, the one on the right will be replaced, and the next check is made on the next 3 characters.

Thank you. Have a nice day!


