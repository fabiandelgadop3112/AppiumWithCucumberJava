# TEST PLAN AND TEST PROCESS MONEFY APP ANDROID:

About the general goal of the app and taking some exploratory test charters, the next goals or test cases have been proposed to take a good coverage.

For a good coverage, the app can be seen in three modules or sections:

A principal home module.

Two secondary modules:

A “left module” that allows to the user filter her countability and finances by account or by date.

A “right module” that have some options (like a menu) and have some settings process.

The home view or homepage of a software always will be the “principal face” to the user, whence, the first an principal core of the testing should be about the principal home view.

In this home page we have the next functions:

-	Add income.
-	Add expense.
-	Add expenses individually.
- View balance.

From these functionalities we have another intrinsic process, that will be tested internally with E2E flows of the principal functionalities.

Some additional validations should be tested with this process:

- Validate percentages to the expenses.
- Validate history inside the balance screen or view.

Also, to decrease the high risk of false values, the “transaction process” of the principal functionalities will be validated, so, the integrity and manage of the countability should be tested adding and income or adding an expense. 

To the seconds modules we need to validate the process considering two scenarios:

1. Pro or premium version.
2. Free version.

**About this process que should test that a the payment of the premium version be made on a safe way** (In a real business process this would be a principal test scenario)

Having the free version, we should test the next scenarios:

- Transfers between accounts.
- Admin accounts.
- Admin categories.
- Currencies
- Settings.

So, from this previously test analysis and test plan the next scenarios are proposed:

### **First scenario**


| Home page (Principal page)                 | Priority |
|--------------------------------------------|:--------:|
| Add income                                 | 1        |
| Add expense                                | 1        |
| Add expenses individually                  | 1        |
| Validate Balance                           | 1        |
| Validate labels of percentages in expenses | 2        |
| Validate history balance                   | 2        |


### **Second scenario**


| Left module (filters) | Priority |
|-----------------------|:--------:|
| Change accounts       | 2        |
| Filter by time period | 3        |

### **Third scenario**

| Right module (Menu) | Priority |
|---------------------|:--------:|
| admin categories    | 2        |
| admin accounts      | 2        |
| currencies          | 3        |
| settings            | 2        |

### **Intrinsic tests**

| Intrinsic tests                       | Priority |
|---------------------------------------|:--------:|
| Validate value entry.                 | 1        |
| Validate choose categories.           | 1        |
| Validate values increase or decrease. | 1        |

The priority high or 1, it have been tagged on this way because these functionalities assures the principal flows of the app’s objective.

# TALKING ABOUT AUTOMATION

Having the actual app, that is a final user interface, we can automate process in the level of integration testing, however in the actual process the automation is implemented in the level of GUI tests.

If we would have access to the components of interfaces, we SHOULD automated the process from the integration level to the GUI level. So, we could implement test automation with tools that interacted directly with other interfaces. 

Also, if we would have access to the source code, we could implement automation with frameworks like espresso.