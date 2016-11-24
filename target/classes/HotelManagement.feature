Feature: Hotel Management User Story

  Scenario Outline: Login to Hotel Management Site
    Given I am on <Website>
    When I click Login
    When I enter the <Username> and <Password>
    Then I am logged in

    Examples: 
      | Website                     | Username | Password |
      | http://35.161.122.132:3003/ | admin    | password |

  Scenario Outline: Create an Entry
    Given I am logged in on website
    When I enter <HotelName> and <Address> and <Owner> and <PhoneNumber> and <Email> and Click Create button
    Then New entry is created

    Examples: 
      | HotelName | Address      | Owner     | PhoneNumber | Email        |
      | Start Six | East on Hill | Varun Agg | 07813523165 | hm@yahoo.com |

  Scenario Outline: Delete an Entry
    Given I am logged in as admin
    When I delete the last entry
    Then Entry gets deleted

    Examples: 
      | HotelName | Address | Owner | PhoneNumber | Email |
      |           |         |       |             |       |

  Scenario Outline: Create Multiple Entries
    Given I am logged in on website
    When I enter <HotelName> and <Address> and <Owner> and <PhoneNumber> and <Email> and Click Create button
    Then New entry is created

    Examples: 
      | HotelName   | Address        | Owner      | PhoneNumber | Email         |
      | Start Six   | East on Hill   | Varun Agg  | 07813523165 | hm@yahoo.com  |
      | Start Seven | East on Hill 1 | Varun Agg1 | 07813523165 | hm1@yahoo.com |
      | Start Eight | East on Hill 2 | Varun Agg2 | 07813523165 | hm2@yahoo.com |
