@regression @notification

  Feature: Notification Features

    @positive @Notif_TC001
    Scenario: user go to Cheers Summary page through notification
      Given user is on the home page
      When user go to Cheers Summary page
      Then user should be navigated to Cheers Summary page

    @positive @Notif_TC002
    Scenario: user can see all notifications on Notification page
      Given user is on the home page
      When user go to Notification page
      Then user should see all notifications

    @positive @Notif_TC003
    Scenario: user can see group chat related notification
      Given user is on the Notification Page
      When user search group chat related notification
      Then user should be navigated to group chat page

    @positive @Notif_TC004
    Scenario: user can see board related notification
      Given user is on the Notification Page
      When user search board related notification
      Then user should be navigated to card on board page



