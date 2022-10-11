@regression @boardpage

  Feature: Board Page Features

    Background:
      Given user is on the home page
      When user clicks TEAMS CARD
      Then user should be navigated to TEAMS PAGE

      @positive @Board_TC001
      Scenario: user can navigate to BOARD PAGE using board icon
        Given user is on the TEAMS PAGE
        When user clicks BOARD ICON
        Then user should be navigated to BOARD PAGE

      @positive @Board_TC002
      Scenario: user can navigate to BOARD PAGE using overview button
        Given user is on the TEAMS PAGE
        When user clicks BOARD inside OVERVIEW BUTTON
        Then user should be navigated to BOARD PAGE

      @positive @Board_TC003
      Scenario: user can create a List using ADD LIST button
        Given user is on the BOARD PAGE
        When user click Add List button to make a List with certain title
        Then the success alert is appeared: "Creating list is success"
        And the list is successfully created

      @positive @Board_TC004
      Scenario: user can cancel creating a list
        Given  user is on the BOARD PAGE
        When user click Add List Button
        But user click cancel button
        Then the list should not be created

      @positive @Board_TC005
      Scenario: user can move the empty list to Archive
        Given user is on the BOARD PAGE
        When user click navigation button to select Archive This List menu
        Then the success alert is appeared: " list has been moved to archived"
        And the list should be moved to Archived Items

      @positive @Board_TC006
      Scenario: user can restore the list from Archived Items to Board Page
        Given user is on the BOARD PAGE
        When user click Archived Items to restore a list
        Then the success alert is appeared: "Unarchiving list with cards is success"
        And the restored list should be on Board Page

      @positive @Board_TC007
      Scenario: user can restore certain list by search its name on Archived Items
        Given user is on the BOARD PAGE
        When user search a list to be restored
        Then the success alert is appeared: "Unarchiving list with cards is success"
        And the restored list should be on Board Page: "test"

      @positive @Board_TC008
      Scenario: user can set a list as complete by Set as a Complete List menu
        Given user is on the BOARD PAGE
        When user click navigation button to select Set as a Complete List menu
        Then the success alert is appeared: "Set list as Complete is success"
        And the list should be displayed DONE icon that contains:"Done list. Everyone will never receive due date reminders anymore from cards in this list."

      @positive @Board_TC009
      Scenario: user can unset list as complete by Unset Complete List menu
        Given user is on the BOARD PAGE
        When user click navigation button to select Unset Complete List menu
        Then the success alert is appeared: "Unset list from Complete is success"
        And the DONE icon should be disappeared

      @positive @Board_TC010
      Scenario: user can change DONE icon into BLOCKED icon
        Given user is on the BOARD PAGE
        When user click navigation button to select Set as a Complete List menu
        And user changed icon into BLOCKED icon
        Then the list should be displayed BLOCKED icon that contains: "Blocked list. Everyone will never receive due date reminders anymore from cards in this list."

      @positive @Board_TC011
      Scenario: user can update the title of the List
        Given user is on the BOARD PAGE
        When user click List title to update its title
        Then the success alert is appeared: "Update list is success"
        And the List title should be updated

      @positive @Board_TC012
      Scenario: user can create a card using Add Card button
        Given user is on the BOARD PAGE
        When user click Add Card button to create card with certain title
        Then the success alert is appeared: "Creating card is success"
        And the card should be created inside the list

      @positive @Board_TC013
      Scenario: user cannot create a card without title
        Given user is on the BOARD PAGE
        When user create a card without title
        Then the success alert is appeared: "Card name cannot be empty"
        And the card should not be created

      @positive @Board_TC014
      Scenario: user can set a card into private during creating card process
        Given user is on the BOARD PAGE
        When user click Add Card button to create private card
        Then the success alert is appeared: "Creating card is success"
        And the card should be created in private mode

      @positive @Board_TC015
      Scenario: user can move all cards onto Archived Items at once
        Given user is on the BOARD PAGE
        When user archives all cards through Archive All Cards in This List
        Then the success alert is appeared: "All cards on list"
        And all cards on the list should be archived

      @positive @Board_TC016
      Scenario Outline: user can sort cards inside the list
        Given user is on the BOARD PAGE
        When user sort all cards through list navigation <menu>
        Then the <card> should be sorted according to <menu>

        Examples:
          |menu|card|
          |Sort From A to Z               |123    |
          |Sort From Z to A               |TC-001 |
          |Sort By Nearest Created Date   |123    |

      @positive @Board_TC017
      Scenario Outline: user can update card title
        Given user is on CARD DETAIL CONTAINER
        When user update the card <title>
        Then the success alert is appeared: "Update card is success"
        And the card title is updated into <title>

        Examples:
          |title|
          |satu A-1|
          |1234567890`-=[];\',./~!@#$%^&*()_+{}:"<>?     |
          |✋☘     |

      @positive @Board_TC018
      Scenario: user can attach a file on the attachments section
        Given user is on CARD DETAIL CONTAINER
        When user attach a file on the card Attachments section
        Then the success alert is appeared: "Upload attachments is success"
        And the file is attached

      @positive @Board_TC019
      Scenario Outline: user can edit attachment file
        Given user is on CARD DETAIL CONTAINER
        When user <function> the attachment file <title>
        Then the success alert function is appeared: <alert>

        Examples:
          |function| alert | title |
          |edit      | Update attachment is success | document2.zip |
          |delete    | Delete attachment is success |               |

      @positive @Board_TC020
      Scenario Outline: user can create, edit, apply, and delete label on the card
        Given user is on CARD DETAIL CONTAINER
        When user proceed to <function> label on the card: <text>
        Then the success alert function is appeared: <alert>

        Examples:
          |function | alert | text |
          |create  | Creating label for this board is success | DEV  |
          |edit    | toggle label card is success | QA               |
          |apply   | toggle multiple labels card is success |        |
          |delete  | toggle label card is success |                  |

      @positive @Board_TC021
      Scenario Outline: user can set and delete due date on the card
        Given user is on CARD DETAIL CONTAINER
        When user proceed to <function> due date on the card: <date>, <time>
        Then the success alert function is appeared: <alert>

        Examples:
          |function|alert|date|time|
          |set     |Update card is success|2022/10/31|08:00 AM|
          |delete  |Update card is success|    |    |

      @positive @Board_TC022
      Scenario Outline: user can set and delete due date on the card
        Given user is on CARD DETAIL CONTAINER
        When user proceed to <function> the card
        Then the success alert function is appeared: <alert>

        Examples:
          |function|alert|
          |private |Update card is success|
          |public  |Update card is success|












