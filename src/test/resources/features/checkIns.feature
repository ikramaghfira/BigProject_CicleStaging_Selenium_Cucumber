@regression @checkinsfeature

  Feature: Check Ins Features

    Background:
      Given user is on the home page
      When user clicks TEAMS CARD
      Then user should be navigated to TEAMS PAGE

      @positive @CI_TC001
      Scenario: user can go to Check Ins Page through Box Menu Container
        Given user is on the TEAMS PAGE
        When user go to Check Ins Page through Box Menu
        Then user should see Create CheckIn button

      @positive @CI_TC002
      Scenario: user can go to Check Ins Page through Overview Menu
        Given user is on the TEAMS PAGE
        When user go to Check Ins Page through Overview Menu
        Then user should see Create CheckIn button

      @positive @CI_TC003
      Scenario: user can go to New Question Page
        Given user is on the CHECK INS PAGE
        When user go to New Question Page through Create CheckIn button
        Then user should see Start collecting answers button

      @positive @CI_TC004
      Scenario: user can set the title on New Question using alphabetic
        Given user is on the NEW QUESTION PAGE
        When user fill the Question title with alphabetic while left other fields as default
        And user create question through Start collecting answers button
        Then user should see success alert: "Create question successful"
        And user should see Question is created with suitable title

      @positive @CI_TC005
      Scenario: user can archive created Question on the Check Ins Page
        Given user is on the CHECK INS PAGE
        When user choose desired question to be archived
        Then user should see success alert: "Archive Question successful"

      @positive @CI_TC006
      Scenario: user can cancel Creating Question through Cancel Button
        Given user is on the NEW QUESTION PAGE
        When user decide to cancel a question
        Then user should go back to Check Ins Page

      @positive @CI_TC007
      Scenario: user can set the title of New Question using non-alphabetic
        Given user is on the NEW QUESTION PAGE
        When user fill the Question title with non-alphabetic
        And user create question through Start collecting answers button
        Then user should see success alert: "Create question successful"
        And the non-alphabetic question is created

      @negative @CI_TC008
      Scenario: user cannot set the title of New Question empty
        Given user is on the NEW QUESTION PAGE
        When user create question through Start collecting answers button
        Then user should stay remain on New Question Page

      @positive @CI_TC009
      Scenario: user can set the title of New Question using emoji
        Given user is on the NEW QUESTION PAGE
        When user fill the Question title with emoji
        And user create question through Start collecting answers button
        Then user should see success alert: "Create question successful"
        And the emoji question is created

      @negative @CI_TC010
      Scenario: user cannot set the title of New Question using URL
        Given user is on the NEW QUESTION PAGE
        When user fill the Question title with URL
        And user create question through Start collecting answers button
        Then user should see success alert: "Create question successful"
        And the URL question is created but inaccessible

      @positive @CI_TC011
      Scenario: user can set multiple days on Schedule section
        Given user is on the NEW QUESTION PAGE
        When user set all days as reminders
        And user create question through Start collecting answers button
        Then user should see success alert: "Create question successful"
        And the everyday reminder question is created

      @positive @CI_TC012
      Scenario: user can set hour on the Timer section
        Given user is on the NEW QUESTION PAGE
        When user set the hour part of the timer
        Then the Time field should be shown the hour accordingly

      @positive @CI_TC013
      Scenario: user can set time format on the Timer section
        Given user is on the NEW QUESTION PAGE
        When user choose time format of the timer
        Then the Time field should be shown time format accordingly

      @positive @CI_TC014
      Scenario: user can get back and forth to hour also minute timer part
        Given user is on the NEW QUESTION PAGE
        When user navigate back and forth to hour or minute part
        Then user should be shown hour or minute accordingly

      @positive @CI_TC015
      Scenario: user can set timer manually by typing on Timer field
        Given user is on the NEW QUESTION PAGE
        When user set timer by typing on Timer field
        Then user should be shown correct time

      @positive @CI_TC016
      Scenario: user can see time set in Question container of Check Ins Page
        Given user is on the NEW QUESTION PAGE
        When user set title also time manually
        And user create question through Start collecting answers button
        Then user should see success alert: "Create question successful"
        And the timer question is created

      @positive @CI_TC017 ##masih gagal
      Scenario: user can select a member from Search field
        Given user is on the NEW QUESTION PAGE
        When user select a member name by Search field
        Then the member icon should be shown on Member section

      @positive @CI_TC018
      Scenario: user can select multiple members to be reminded
        Given user is on the NEW QUESTION PAGE
        When user select members name
        Then selected member's icon should be shown on Member section

      @negative @CI_TC019
      Scenario: user cannot select unlisted member from Search field
        Given user is on the NEW QUESTION PAGE
        When user search unlisted member by Search field
        Then no member icon is shown on the Member list

      @positive @CI_TC020
      Scenario:  user can select all members on the list at once
        Given user is on the NEW QUESTION PAGE
        When user select all members at once
        Then all member's icon should be shown on Member section

      @positive @CI_TC021
      Scenario: user can remove member whose been added
        Given user is on the NEW QUESTION PAGE
        When user select members name
        And user remove the member from Member list
        Then no member icon is shown on the Member list

      @positive @CI_TC022
      Scenario: user can remove all members whose been added at once
        Given user is on the NEW QUESTION PAGE
        When user select all members at once
        And user remove all members at once
        Then no member icon is shown on the Member list

      @positive @CI_TC023
      Scenario:  user can see member's icon on the created question
        Given user is on the NEW QUESTION PAGE
        When user select members name to be notified
        And user create question through Start collecting answers button
        Then user should see success alert: "Create question successful"
        And member's iconshould be shown on the created question

      @positive @CI_TC024
      Scenario: user can set the created question on private mode
        Given user is on the NEW QUESTION PAGE
        When user fill the Question title with alphabetic while left other fields as default
        And user activate private mode question
        Then user should see success alert: "Create question successful"
        And user should see private icon on created question contain alert: "Only members/subscribers can see this"

      @positive @CI_TC025
      Scenario: user can update the created question
        Given user is on the NEW QUESTION PAGE
        When user created a question of notification
        And user update the desired section to be updated
        Then user should see success alert: "Update question successful"
        And user should see updated information on created question








