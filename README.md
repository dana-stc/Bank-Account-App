
## BankAccount-aplication---Pentalog

A Bank application with a main menu which contains two options:
- <strong>Login</strong> -> you should login with a username/ password from the console (the username and password being saved into a database). After logging in, you have three options: Account, Transfer money & Logout;
	- <strong>Account</strong> -> there will be shown another menu, containing the following options:
		- <strong>Create Acocount</strong> -> you create a new account with some account details for the current user (account number, current user name, balance, account type);
		- <strong>Display accounts</strong> -> displaying the account informations from the db;
		- <strong>Back to login menu</strong> ->  you turn back to the login menu;
	- <strong>Transfer money</strong> -> payment functionality;  After you logged in with your user account, you should have the option to make a transfer from one of your accounts ;  Once the account was selected user should enter the amount he wants to transfer;  Next, user should enter the account he wants to make the transfer too. The account will be one of the current user’s accounts, with the same currency. You can't make transfers if the current user has only one account or don't have any accounts created.
	- <strong>Logout</strong> -> you turn back to the main menu;
- <strong>Exit</strong> -> for the case when you want to get out of the console.
