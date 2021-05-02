# Travel Designer API Specification

## Retrieve Travel Plan Result

```
GET /api/plan?from=<date>&to=<date>&weather=<sel>&covid19=<sel>&fortravel=<sel>&forshopping=<sel>
```

- Options can be modified according to requirements.

On success:

```
200 OK
content-type: application/json
content-length: <len>

<json>
```

- `<json>`: The computed travel plan organised in a JSON object. Example:

```json
{
  "destinations": [
    {
      "rank": 1,
      "name": "London",
      "weather": "Sunny",
      "covid19": "+2849"
    },
    {
      "rank": 2,
      "name": "Glasgow",
      "weather": "Cloudy",
      "covid19": "+439"
    }
  ]
}
```

On failure: any 4xx, 500 status code.

There may be a long poll involved; attention should be paid on the front-end.
