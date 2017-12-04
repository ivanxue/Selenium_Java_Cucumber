Feature: MercuryTour Demo Testing

  Scenario Outline: MercuryTour Book Flights
    Given url opened with browser <browser>
    When enter user id as <userName>
    And enter password as <password>
    And click login
    Then select flight form exists
    Examples:
      | userName | password | browser |
      | mercury  | mercury  | chrome  |
      | mercury  | mercury  | firefox |