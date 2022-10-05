@regression @groupchatfeature

  Feature: Group Chat Features

    Background:
      Given user is on the home page
      When user clicks TEAMS CARD
      Then user should be navigated to TEAMS PAGE

      @positive @GC_TC001
      Scenario: user can go to Group Chat Page through Box Menu Container
        Given user is on the TEAMS PAGE
        When user go to Group Chat Page through Box Menu
        Then user should see Send button

      @positive @GC_TC002
      Scenario: user can go to Check Ins Page through Overview Menu
        Given user is on the TEAMS PAGE
        When user go to Group Chat Page through Overview Menu
        Then user should see Send button

      @positive @GC_TC003
      Scenario: user can send an alphabetic message
        Given user is on the GROUP CHAT PAGE
        When user type a message on text field
        And user send the message
        Then user should see the message on the bubble chat

      @positive @GC_TC004
      Scenario: user can see the time description on the bubble chat
        Given user is on the GROUP CHAT PAGE
        When user type a message on text field
        And user send the message
        Then user should see the time description on the bubble chat: "just now"

      @positive @GC_TC005
      Scenario: user can delete a message from chat box
        Given user is on the GROUP CHAT PAGE
        When user delete the desired message
        Then user should see success alert appeared: "Delete group chat message success"
        And user should not see the message on the bubble chat instead: "This message was deleted"

      @positive @GC_TC006
      Scenario Outline: user can send other type message than alphabetic
        Given user is on the GROUP CHAT PAGE
        When user type other kind of <message> ot the type field
        And user send the message
        Then user should see the unique <message> on the bubble chat

        Examples:
        | message |
        | 1234567890`-=[];\',./~!@#$%^&*()_+{}:"<>? |
        | ✋ ☘ |

      @positive @GC_TC007
      Scenario: user can send accessible url as a message
        Given user is on the GROUP CHAT PAGE
        When user type url as a message on the type field
        And user send the message
        Then user should be navigated to the url site when url is accessed

      @positive @GC_TC008
      Scenario: user can send a long message
        Given user is on the GROUP CHAT PAGE
        When user type a long message on the type field
        And user send the message
        Then user should see the long message on the bubble chat

      @negative @GC_TC009
      Scenario: user cannot send a message using ENTER key
        Given user is on the GROUP CHAT PAGE
        When user type a message on text field
        And user send the message through ENTER key
        Then user should see the message remain on the text field

      @positive @GC_TC010
      Scenario: user can mention a member through a message
        Given user is on the GROUP CHAT PAGE
        When user type a message along with mention a member
        And user send the message
        Then user should see the latest message on the bubble chat

      @positive @GC_TC011
      Scenario: user can cancel a message from deleting
        Given user is on the GROUP CHAT PAGE
        When user decide to cancel a message from deleting process
        Then user should see the latest message on the bubble chat

      @positive @GC_TC012
      Scenario: user can see other sender name and icon on above the bubble chat
        Given user is on the GROUP CHAT PAGE
        When user see other sender message
        Then user should be shown sender name and icon

      @positive @GC_TC013
      Scenario: user can see date separator of the chat on the chat box
        Given user is on the GROUP CHAT PAGE
        When user want to see when the message is sent
        Then user should be shown the date separator of the message

      @positive @GC_TC014
      Scenario Outline: user can attach any file on the group chat
        Given user is on the GROUP CHAT PAGE
        When user attach <file> from the local repository
        Then user should see success alert appeared: "Upload attachments is success"
        And user should see the <fileName> is displayed on the bubble chat

        Examples:
        |file| fileName |
        |document |document.zip  |
        |image    |image.png     |
        |video    |video.mp4     |

      @positive @GC_TC015
      Scenario: user can download the file attached on the group chat
        Given user is on the GROUP CHAT PAGE
        When user download the file attached on the group chat: "document"
        Then the file should be downloaded to local repository: "document.zip"

      @negative @GC_TC016
      Scenario Outline: user can chat in any other character language
        Given user is on the GROUP CHAT PAGE
        When user type <message> on japanese, korean, also russian
        Then user should see the <message> on the bubble chat in suitable language

      Examples:
        |message|
        |사랑해요 |
        |愛してます|
        |Я тебя люблю|

