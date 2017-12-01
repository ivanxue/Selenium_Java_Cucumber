Feature: MercuryTour Demo Testing

#  Scenario: MercuryTour Book Flights
#    Given url opened
#    Then enter user id as "mercury"
#    Then enter password as "mercury"
#    And click login
#    Then close browser
#
#  Scenario: MercuryTour Book Flights
#    Given url opened
#    Then enter user id as "abc"
#    Then enter password as "abc"
#    And click login
#    Then close browser

  Scenario Outline: MercuryTour Book Flights
    Given url opened
    Then enter user id as <userName>
    Then enter password as <password>
    And click login
    Then close browser
    Examples:
      | userName | password |
      | mercury  | mercury  |
      | abc      | abc      |
	 