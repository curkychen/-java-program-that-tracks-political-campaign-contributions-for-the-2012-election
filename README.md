# -java-program-that-tracks-political-campaign-contributions-for-the-2012-election
The user enters the contributor’s name, the amount, and then clicks on which candidate is getting the money. The program keeps track of the contributions for each candidate. Contributions are limited to $10,000,000.
Use integers to keep track of the money contributed for each candidate. Use a list or lists to keep track of the contributions. If you cannot figure out how to use a list (i.e., java.util.ArrayList or java.util.LinkedList), then you may use an array, but the array must have a length of 100.
When the last name, first name and amount fields are filled in and one of the “contribute” buttons is clicked:
• Add the information to the list of contributors,
• Clear the name and amount fields, and
• Display a line in the text window that includes the contributor’s last and first
names, amount, and name of the candidate. The dollar amount must be formatted as an integer amount with a comma between the thousands and hundreds (unless the amount is less than $1,000), and with a dollar sign, as shown.
When the user clicks “List Obama Contributors” or “List Romney Contributors”, clear the text area and display a list of the contributors for that candidate, sorted in descending order of amount. If two contributors have the same contribution amount, then sort by name (last name, then first name). After the list of contributors, give a total.
